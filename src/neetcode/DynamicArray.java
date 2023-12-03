package neetcode;

/**
 * Design Dynamic Array (Resizable Array)
 * Design a Dynamic Array (aka a resizable array) class, such as an ArrayList in Java or a vector in C++.
 *
 * Your DynamicArray class should support the following operations:
 *
 * DynamicArray(int capacity) will initialize an empty array with a capacity of capacity, where capacity > 0.
 * int get(int i) will return the element at index i. Assume that index i is valid.
 * void set(int i, int n) will set the element at index i to n. Assume that index i is valid.
 * void pushback(int n) will push the element n to the end of the array.
 * int popback() will pop and return the element at the end of the array. Assume that the array is non-empty.
 * void resize() will double the capacity of the array.
 * int getSize() will return the number of elements in the array.
 * int getCapacity() will return the capacity of the array.
 * If we call void pushback(int n) but the array is full, we should resize the array first.
 *
 * Example 1:
 *
 * Input:
 * ["Array", 1, "getSize", "getCapacity"]
 *
 * Output:
 * [null, 0, 1]
 *
 *
 * Example 3:
 *
 * Input:
 * ["Array", 1, "getSize", "getCapacity", "pushback", 1, "getSize", "getCapacity", "pushback", 2, "getSize", "getCapacity", "get", 1, "set", 1, 3, "get", 1, "popback", "getSize", "getCapacity"]
 *
 * Output:
 * [null, 0, 1, null, 1, 1, null, 2, 2, 2, null, 3, 3, 1, 2]
 * Note:
 *
 * The index i provided to get(int i) and set(int i) is guranteed to be greater than or equal to 0 and less than the number of elements in the array.
 */
class DynamicArray {
    int[] obj =null;
    int currSize=0;
    int currCapacity=0;
    public final int[] elmptyObj ={};
    //O(n) n = capacity
    public DynamicArray(int capacity) {
        if(capacity>0){
            obj = new int[capacity];
            currCapacity = capacity;
        }else if(capacity==0){
            obj=elmptyObj;
        }
    }
    //O(1)
    public int get(int i) {
        return (int)obj[i];
    }

    //O(1)
    public void set(int i, int n) {
        try{
            obj[(int)i]=(int)n;

        }catch(Exception e){
            System.out.println(e);
        }

    }
    //O(n) n = capacity---word case
    //O(1) = average case
    public void pushback(int n) {
        try{
            if(currCapacity-currSize>0){
                obj[currSize]=n;
                currSize++;
            }else{
                resize();
                obj[currSize]=n;
                currSize++;
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //O(1) ....soft delete
    public int popback() {
        try{
            int ele = (int)obj[currSize-1];
            currSize--;
            return ele;
        }catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
    //O(n) n = capacity
    private void resize() {
        try{
            obj = Arrays.copyOf(obj, currCapacity*2);
            currCapacity *=2;
        }catch(Exception e){
            System.out.println(e);
        }

    }
    //O(1)
    public int getSize() {
        return currSize;
    }
    //O(1)
    public int getCapacity() {
        return currCapacity;
    }
}
