class Solution {
    // Linear scan and then look back => use stack
    // Use a stack to store all the indices of the columns that form an ascending order
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int leftMost = 0, rightMost = 0, index = 0;
        int i = 0;
        while (i <= heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
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
        rightMost = stack.peek() + 1;
        while (!stack.isEmpty()) {
            index = stack.pop();
            leftMost = (stack.isEmpty()) ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (rightMost - leftMost - 1) * heights[index]);
        }
        return maxArea;
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