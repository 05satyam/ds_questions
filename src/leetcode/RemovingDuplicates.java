package leetcode;

public class RemovingDuplicates {
    public static int removeDuplicates(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        int k=0, count=1;
        res[k]=arr[k];

        for(int i=1;i<n;i++){

            if(arr[k]==arr[i] && count<2){
                k++;
                arr[k]=arr[i];
                count++;
            }else if(count>=2 && arr[k]==arr[i]){
                continue;
            }else if(count<=2 && arr[k]!=arr[i]){
                k++;
                arr[k]=arr[i];
                count=1;
            }
        }


        System.out.println("k "+ k);
        return k;
    }

    public static void main(String[] a){
        int[] arr = {1,1,1,2,2,3};
        int k= removeDuplicates(arr);
        System.out.println("output");
        for(int i=0;i<=k;i++){
            System.out.print(arr[i] + "  ");
        }
    }
}
