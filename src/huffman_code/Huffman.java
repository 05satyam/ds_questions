package huffman_code;

import java.util.PriorityQueue;

public class Huffman {
    int freq;
    char c;
    Huffman left;
    Huffman right;
    Huffman(){

    }
    Huffman(int freq, char ch){
        this.freq=freq;
        this.c=ch;
        left=right=null;
    }

    Huffman(int freq, char ch, Huffman hfLeft, Huffman hfRight){
        this.freq=freq;
        this.c=ch;
        left= hfLeft; right=hfRight;
    }
}

class Huffman_Tree {

    static PriorityQueue<Huffman> createHeapOfHFNodes(char[] charArray, int[] charfreq){
        PriorityQueue<Huffman> pq = new PriorityQueue<Huffman>(6, (Huffman a,Huffman b)->{
            return a.freq-b.freq;
        });

        for(int i=0;i<6;i++){
            Huffman hf = new Huffman(charfreq[i], charArray[i]);
            pq.add(hf);
        }
        System.out.println("pq size "+ pq.size());
        return pq;
    }
    static Huffman createHfTree(PriorityQueue<Huffman> pq){
        Huffman root = null;
        while(pq.size()>1){
            Huffman hf1 = pq.poll();
            Huffman hf2 = pq.poll();

            Huffman hf3 = new Huffman(hf1.freq + hf2.freq, '-', hf1, hf2);
            pq.add(hf3);
            root=hf3;
        }
        return root;
    }

    public static void printCode(Huffman root, String s)
    {

       if (root.left == null && root.right == null
                && Character.isLetter(root.c)) {

            System.out.println(root.c + ":" + s);

            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] s) {
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<Huffman> pq = createHeapOfHFNodes(charArray,charfreq);
        Huffman root = createHfTree(pq);
        printCode(root,"");

    }
}
//nlogn-- n is number of words