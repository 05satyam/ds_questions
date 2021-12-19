package mix_questions;

public class NumLimitFIndPairs {
    static int solution(int[] a, int[] b, int lower, int upper) {
        int count=0;
            for(int i=0;i<a.length;i++){
                int sum=0;
                for(int j=0;j<b.length;j++){
                    sum += (a[i]*a[i])+ (b[j]*b[j]);
                    System.out.println(sum);
                    if(lower<=sum && sum<=upper)
                        count++;
                    sum=0;
                }
            }
            return count;
    }

    public static void main(String[] a){
        int[] arr=new int[3];
        int[] arr1=new int[3];
        arr[0]=3;
        arr[1]=-1;
                arr[2]=9;
        arr1[0]=100;
        arr1[1]=5;
        arr1[2]=-2;

        System.out.println(solution(arr, arr1, 7,99));
    }
}
