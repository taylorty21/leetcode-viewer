## Solution 1:
Using Min Heap and Dijkstra idea. Expending from 0, 0 to i + 1, j and i, j + 1
```
public class Solution {
    public class Cell {
        int row;
        int col;
        int val;

        public Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Cell) {
                Cell p = (Cell) o;
                return p.row == row && p.col == col;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return new Integer(row).hashCode() * 31 + new Integer(col).hashCode();
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        // Min Heap
        Queue<Cell> pq = new PriorityQueue<>(k, new Comparator<Cell>() {
                                         @Override
                                         public int compare(Cell c1, Cell c2) {
                                             if (c1.val == c2.val) {
                                                 return 0;
                                             }
                                             return c1.val < c2.val ? -1 : 1;
                                         }
                                     });
        pq.add(new Cell(0, 0, matrix[0][0]));
        int i = 0, j = 0;
        HashSet<Cell> hs = new HashSet<>();
        for (int l = 0; l < k - 1; l++) {
            Cell curr = pq.poll();
            i = curr.row;
            j = curr.col;
            if (i + 1 < m) {
                Cell tmp = new Cell(i + 1, j, matrix[i + 1][j]);
                if (!hs.contains(tmp)) {
                    hs.add(tmp);
                    pq.offer(tmp);
                }
            }
            if (j + 1 < n) {
                Cell tmp = new Cell(i, j + 1, matrix[i][j + 1]);
                if (!hs.contains(tmp)) {
                    hs.add(tmp);
                    pq.offer(tmp);
                }
            }
        }
        return pq.peek().val;
    }
}
```

## Solution 2: Binary Search (From https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code)
The key point for any binary search is to figure out the "Search Space". For me, I think there are two kind of "Search Space" -- index and range(the range from the smallest number to the biggest number). Most usually, when the array is sorted in one direction, we can use index as "search space", when the array is unsorted and we are going to find a specific number, we can use "range".

Let me give you two examples of these two "search space"

    index -- A bunch of examples -- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ ( the array is sorted)
    range -- https://leetcode.com/problems/find-the-duplicate-number/ (Unsorted Array)

The reason why we did not use index as "search space" for this problem is the matrix is sorted in two directions, we can not find a linear way to map the number and its index.