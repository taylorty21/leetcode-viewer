public class Solution {
    //              1, 2, 3
    //      1, (2, 3)    2, (1, 3)   3, (2, 1)
    //      1, 3, 2       2, 3, 1     3, 1, 2
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }
    
    public void permute(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            // int[] to ArrayList<Integer>
            List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
            res.add(list);
            return;

        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permute(nums, index + 1, res);
            swap(nums, i, index);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}