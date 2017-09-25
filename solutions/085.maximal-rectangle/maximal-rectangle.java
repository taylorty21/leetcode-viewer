class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestRectangleArea(height);
        for(int i = 1; i < matrix.length; i ++){
            resetHeight(matrix, height, i);
            result = Math.max(result, largestRectangleArea(height));
        }

        return result;
    }

    private void resetHeight(char[][] matrix, int[] height, int idx){
        for (int i = 0; i < matrix[0].length; i ++) {
            if (matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }
    
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int leftMost = 0, rightMost = 0, index = 0;
        int i = 0;
        while (i <= heights.length) {
            int h = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                index = stack.pop();
                rightMost = i;
                while (!stack.isEmpty() && heights[index] == heights[stack.peek()]) {
                    index = stack.pop();
                }
                leftMost = (stack.isEmpty()) ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (rightMost - leftMost - 1) * heights[index]);
                // Right is the number after right edge, left is the number before left edge. Need to minus one.
            }
        }
        return maxArea;
    }
}