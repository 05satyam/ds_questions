package mix_questions;

import java.util.ArrayList;
import java.util.List;

public class AmazonWheelsFleetQuestion {
    public static int countCurrency(int amount)
    {
        if(amount%2!=0)
            return 0;

        int[] notes = new int[]{2,4 };
        int[] noteCounter = new int[9];

10
        for (int i = 0; i < 2; i++) {
            if (amount >= notes[i]) {
                noteCounter[i] = amount / notes[i];
                amount = amount - noteCounter[i] * notes[i];
            }
        }

        // Print notes
       int count=0;
        for (int i = 0; i < 9; i++) {
            if (noteCounter[i] != 0) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> test(int[] amount){
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<amount.length;i++){
            res.add(countCurrency(amount[i]));
        }
        return res;
    }
}
