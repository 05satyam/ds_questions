/**
 * this program convert sorted array to balanced binary search tree
 * there can be more than one answer to the result printed
 */
package tree;

/**
 * @author satyam
 *
 */

public class SortedArrayToBst extends Tree{
	public void convertSortedArrayToBst(int arr[], Tree root, int size) {
		root = convertSortedArrayToBstUtil(arr,0,size-1);
		printInOrder(root);
	}
	
	public static Tree convertSortedArrayToBstUtil(int arr[], int start, int end) {
		if(start>end) {
			return null;
		}
		int mid = (start+end)/2;
		Tree newNode =  new Tree();
		newNode.createNewNode(arr[mid]);
		
		newNode.left = convertSortedArrayToBstUtil(arr,start,mid-1);
		newNode.right = convertSortedArrayToBstUtil(arr,mid+1,end);
		return newNode;
	}
	
	public static void main(String[] args) {
	
		int arr[] = {3,6,8,9,10,13,15,18,21};
		Tree root = new Tree();
		SortedArrayToBst obj = new SortedArrayToBst();
		obj.convertSortedArrayToBst(arr,root,arr.length);
		System.out.println(root.heightOfTree(root));
	}

}
