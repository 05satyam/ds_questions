//steal max wealth with no stealing to consecutive houses 

package mix_questions;

public class ThiefMaxWealth {


	  public int findMaxSteal(int[] wealth) {
	    return findMaxStealRecursive(wealth, 0);
	  }

	  private int findMaxStealRecursive(int[] wealth, int currentIndex) {
	    if( currentIndex >= wealth.length)
	      return 0;

	    int stealCurrent = wealth[currentIndex] + findMaxStealRecursive(wealth, currentIndex + 2);
	    int skipCurrent = findMaxStealRecursive(wealth, currentIndex + 1);

	    return Math.max(stealCurrent, skipCurrent);
	  }

	  public static void main(String[] args) {
		  ThiefMaxWealth ht = new ThiefMaxWealth();
	    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
	    System.out.println(ht.findMaxSteal(wealth));
	    wealth = new int[]{2, 10, 14, 8, 1};
	    System.out.println(ht.findMaxSteal(wealth));
	  }
	}
