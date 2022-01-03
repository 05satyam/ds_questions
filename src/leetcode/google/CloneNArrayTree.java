/*
* Given a root of an N-ary tree, return a deep copy (clone) of the tree.

Each node in the n-ary tree contains a val (int) and a list (List[Node]) of its children.

class Node {
    public int val;
    public List<Node> children;
}
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
*
*
* Input: root = [1,null,3,2,4,null,5,6]
Output: [1,null,3,2,4,null,5,6]
*
* */

package leetcode.google;


import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }

    public int getVal() {
        return val;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
};



public class CloneNArrayTree {
    boolean newLevel=false;
    Node cloneRoot;
    public Node cloneTree(Node root) {
        if(root == null) return null;

        Node clonedRoot = new Node(root.val);
        for(Node next: root.children)
            clonedRoot.children.add(cloneTree(next));

        return clonedRoot;

    }
}

