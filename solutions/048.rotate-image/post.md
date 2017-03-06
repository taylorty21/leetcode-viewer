## Solution 1:
### clockwise rotate
#### first reverse up to down, then swap the symmetry 
```
  1 2 3     7 8 9     7 4 1
  4 5 6  => 4 5 6  => 8 5 2
  7 8 9     1 2 3     9 6 3
```


### anticlockwise rotate
#### first reverse left to right, then swap the symmetry
```
  1 2 3     3 2 1     3 6 9
  4 5 6  => 6 5 4  => 2 5 8
  7 8 9     9 8 7     1 4 7
  ```

## Solution 2:
旋转的过程中对4个相应的位置发生置换（如图）。对位置(r, c)，按counter-clockwise方向旋转（即输出矩阵位置对应元素在输入矩阵中的位置），相应为：
(r, c) <-(n-1-c, r)<-(n-1-r, n-1-c)<- (c, n-1-r)。
需要遍历的(r, c)如蓝色部分所示，每次行的两端缩减1,第0列的两端为0, n-2.

![]
(https://image.ibb.co/iC0nBF/Leetcode_001_050_Google_Docs.png)
```
public void rotate(int[][] matrix) {
    int wid = matrix.length - 1;
    for (int c = 0, first = 0, last = wid; first < last; ++c, ++first, --last) {
        for (int r = first; r < last; ++r) {
            int tmp = matrix[r][c];
            matrix[r][c] = matrix[wid-c][r];
            matrix[wid-c][r] = matrix[wid-r][wid-c];
            matrix[wid-r][wid-c] = matrix[c][wid-r];
            matrix[c][wid-r] = tmp;
        }
    }
}
```
