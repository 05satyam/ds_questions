package leetcode;

public class DecodedXorArray {

    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length+1];

        res[0]=first;
        for(int i=0;i<encoded.length;i++){
            int xor = res[i]^encoded[i];
            res[i+1]=xor;
        }
       /* for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }*/
        return res;
    }

    public static void main(String a[]){
        DecodedXorArray dxa = new DecodedXorArray();
        int[] encode = {1,2,3};

        System.out.print(dxa.decode(encode, 1));
    }
}
