package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {
	public List<Integer> spiralOrder(int[][] a) {
		int i, k = 0, l = 0;
		List<Integer> res = new ArrayList<Integer>();
		if (a == null || a.length == 0 || a[0].length == 0)
			return res;
		int n = a[0].length;
		int m = a.length;
		while (k < m && l < n) {
			for (i = l; i < n; ++i) {
				res.add(a[k][i]);
			}
			k++;
			for (i = k; i < m; ++i) {
				res.add(a[i][n - 1]);
			}
			n--;
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					res.add(a[m - 1][i]);
				}
				m--;
			}
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					res.add(a[i][l]);
				}
				l++;
			}
		}
		return res;
	}
}
