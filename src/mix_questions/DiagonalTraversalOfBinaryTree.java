/**
 * geeks for geeks
 * Consider lines with a slope of -1 that cross through nodes. Print all diagonal elements in a binary tree that belong to the same line, given a binary tree.
 *
 * Input : Root of below tree
 *Output :
 * Diagonal Traversal of binary tree:
 *  8 10 14
 *  3 6 7 13
 *  1 4
 */
package mix_questions;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class DiagonalTraversalOfBinaryTree {
    static class Node
    {
        int data;
        Node left;
        Node right;

        //constructor
        Node(int data)
        {
            this.data=data;
            left = null;
            right =null;
        }
    }

    public  static void diagonalPrint(Node root, TreeMap<Integer, Vector<Node>> diagonal, int level){
        if(root==null)
            return ;

        Vector<Node> levelElem = diagonal.get(level);
        if(levelElem==null){
            levelElem  = new Vector<>();
            levelElem.add(root);


        }else{
            levelElem.add(root);
        }

        diagonal.put(level, levelElem);

        diagonalPrint(root.left, diagonal, level+1);
        diagonalPrint(root.right, diagonal, level);


    }
    public static void printDiagonally(Node root){
        TreeMap<Integer, Vector<Node>> diagonal = new TreeMap<>();

        diagonalPrint(root, diagonal, 0);

        for(Map.Entry<Integer, Vector<Node>> node : diagonal.entrySet()){
            System.out.println(node.getValue());

        }
    }
    public static void main(String[] a){
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        printDiagonally(root);
    }
}
