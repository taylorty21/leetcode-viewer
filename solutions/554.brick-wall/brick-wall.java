class Solution {
    // One pass: optimized version
    public int leastBricks(List<List<Integer>> wall) {
        int row = wall.size();
        if (row == 0) return 0;
        // Most frequent edge
        int count = 0;
        // edge to count map
        Map<Integer, Integer> map = new HashMap<>();
        
        for(List<Integer> level : wall){
            int sum = 0;
            for(int i = 0; i < level.size() - 1; i++){
                sum += level.get(i);
                // Slower
                // map.put(sum, map.getOrDefault(sum, 0) + 1);
                // count = Math.max(count, map.get(sum));
                
                int val = map.get(sum) == null ? 1 : map.get(sum) + 1;
                map.put(sum,val);
                count = count < val ? val : count;
            }
        }
        return row - count;
    }
    
    // Two pass: initial idea, could be changed to one pass
    public int leastBricks2(List<List<Integer>> wall) {
        int sum = 0;
        int maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> level: wall) {
            for (int num: level) {
                sum += num;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
            maxSum = sum;
            sum = 0;
        }
        int max = 0;
        for (int key: map.keySet()) {
           if (map.get(key) > max && (key != 0 && key != maxSum)) {
               max = map.get(key);
           } 
        }
        return wall.size() - max;
    }
}