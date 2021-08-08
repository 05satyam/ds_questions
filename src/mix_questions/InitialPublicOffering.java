/**
 * /**
 *  * A company registers an IPO on a website sellshares.com.
 *  * All the shares on this website are available for bidding for a particular time frame called the bidding window.
 *  * At the end of the bidding window an auction logic is used to decide how many of the available shares go to which bidder until all the shares that are available have been allotted,
 *  * or all the bidders have received the shares they bid for, whichever comes earlier.
 *  *
 *  * The bids arrive from the users in the form of <user Id, number of shares, bidding price, timestamp> until the bidding window is closed.
 *  *
 *  * The auction logic assigns shares to the bidders as follows:
 *  * 1. The bidder with the highest price gets the number of shares they bid for
 *  * 2. If multiple bidders have bid at the same price, the bidders are assigned shares as follows:
 *  *      Each bidder in the same price group gets assigned one share each consecutively, with each bidder being arranged inside the group based on their timestamp.
 *  *      Once a bidder gets the number of shares they bid for, they will be removed from the above iterative process and the process
 *  *      which then continues until all bidders are removed or the shares get exhausted, whichever comes first.
 *  *
 *  * List the user Id's of all users who did not get even one share after the shares have been allocated.
 *
 */
package mix_questions;

import java.util.*;

public class InitialPublicOffering {
    public static List<Integer> getUnallottedUsers(List<List<Integer>> biddersList, int totalShares) {
        // Write your code here
        //map K - bp, V - set of biddersByTheirBP sorted by TS
        TreeMap<Integer, PriorityQueue<List<Integer>>> biddersByTheirBP = new TreeMap<>(Comparator.comparingInt(bp -> -bp));
        //Worst: Time O(N * log N)
        for (List<Integer> bidder : biddersList) {
            int BP = bidder.get(2);
            PriorityQueue<List<Integer>> qSortedByTs =
                    biddersByTheirBP.computeIfAbsent(BP, bp ->
                            new PriorityQueue<List<Integer>>(Comparator.comparing(bidder2 -> bidder2.get(3)))
                    );
            qSortedByTs.add(bidder);
        }

        Set<Integer> biddersWithShares = new HashSet<>();

        final int[] totalShares1 = {totalShares}; //prevent lambda issue

        for (PriorityQueue<List<Integer>> queueBiddersByTs : biddersByTheirBP.values()) {
            if (totalShares1[0] <= 0) break; //finished

            if (queueBiddersByTs.size() == 1) {
                List<Integer> bidder = queueBiddersByTs.remove();
                totalShares1[0] -= bidder.get(1); //subtract count of bids
                biddersWithShares.add(bidder.get(0));
            } else if (queueBiddersByTs.size() > 1) { //multiple bidders with SAME bp
                Queue<List<Integer>> q = new LinkedList<>(queueBiddersByTs); //queue bidders in a line

                while (totalShares1[0] > 0 && !q.isEmpty()) { //shares still available AND bidders still wanting
                    List<Integer> bidder = q.remove(); //get next in line

                    totalShares1[0] -= 1; //give out 1 bid
                    bidder.set(1, bidder.get(1) - 1); //decrement bidder's count of wanted bids
                    biddersWithShares.add(bidder.get(0)); //mark that bidder has received
                    if (bidder.get(1) != 0) q.add(bidder); //if wants more bits, add to end of line
                }
            }
        };

        //get the ids of the bidders that aren't marked
        List<Integer> unluckyIds = new ArrayList<>();
        for (List<Integer> bidder : biddersList) {
            if (!biddersWithShares.contains(bidder.get(0)))
                unluckyIds.add(bidder.get(0));
        }
        return unluckyIds;
    }

}
}
