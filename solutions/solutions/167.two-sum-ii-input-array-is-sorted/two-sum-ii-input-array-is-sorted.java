class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int comp = numbers[i] + numbers[j];
            if (comp == target) {
                return new int[] {i + 1, j + 1};
            } else if (comp > target) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}