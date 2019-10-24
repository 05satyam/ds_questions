/**
 * find the median at given point of time in a running stream of numbers.
 * 
 * here maxHeapOnRootRIght will act as a min heap for the root element and minHeapOnRootLeft will act as a max heap for root element
 * we will have the root at every point of array and we can take the root and find median.
 * 
 * Median is the middle of sorted array element. If array is of odd length and middle element is median else media will be average of two middle elements 
 * */
package mix_questions;

import java.util.*;

public class MedianInRunningStream {

	protected void median(int arr[]) {
		PriorityQueue<Integer> maxHeapOnRootLeft = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeapOnRootRight = new PriorityQueue<>();
		double median = arr[0];

		maxHeapOnRootLeft.add(arr[0]);
		System.out.println(median);

		for (int i = 1; i < arr.length; i++) {
			int x = arr[i];
			if (maxHeapOnRootLeft.size() > minHeapOnRootRight.size()) {
				if (x < median) {
					minHeapOnRootRight.add(maxHeapOnRootLeft.remove());
					maxHeapOnRootLeft.add(x);
				} else {
					minHeapOnRootRight.add(x);
				}
				median = (double) (minHeapOnRootRight.peek() + maxHeapOnRootLeft.peek()) / 2;
			} else if (maxHeapOnRootLeft.size() == minHeapOnRootRight.size()) {
				if (x < median) {
					maxHeapOnRootLeft.add(x);
					median = (double) maxHeapOnRootLeft.peek();
				} else {
					minHeapOnRootRight.add(x);
					median = (double) minHeapOnRootRight.peek();
				}
			} else {
				if (x > median) {
					maxHeapOnRootLeft.add(minHeapOnRootRight.remove());
					minHeapOnRootRight.add(x);
				} else {
					maxHeapOnRootLeft.add(x);
				}
				median = (double) (minHeapOnRootRight.peek() + maxHeapOnRootLeft.peek()) / 2;
			}

			System.out.println(median);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 15, 10, 20, 3 };
		MedianInRunningStream med = new MedianInRunningStream();
		med.median(arr);
	}

}
