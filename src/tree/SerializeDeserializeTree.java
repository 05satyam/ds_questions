package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree extends Tree {

	private static final String NULL_SYMBOL = "X";
	  private static final String DELIMITER = ",";

	public String  serialize(Tree root) {
		if(root == null) {
			return NULL_SYMBOL + DELIMITER;
		}
		
		String leftTree = serialize(root.left);
		String rightTree = serialize(root.right);
		return root.data + DELIMITER + leftTree + rightTree;
	}
	
	public static Tree deserialize(String treeSerialized) {
		Queue<String> nodesLeftToDesrialize = new LinkedList<>();
	    nodesLeftToDesrialize.addAll(Arrays.asList(treeSerialized.split(DELIMITER)));
	    return deserializeHelper(nodesLeftToDesrialize);
	}
	
	public static Tree deserializeHelper(Queue<String> nodesLeftToDesrialize) {
		String valueForNode = nodesLeftToDesrialize.poll();

	    if (valueForNode.equals(NULL_SYMBOL)) {
	      return null;
	    }
	    
	    Tree newNode = new Tree(Integer.valueOf(valueForNode));
	    newNode.left = deserializeHelper(nodesLeftToDesrialize);
	    newNode.right = deserializeHelper(nodesLeftToDesrialize);
	    return newNode;
	}

}
