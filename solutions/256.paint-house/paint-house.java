class Solution {
    public int minCost(int[][] costs) {
        // if (costs == null || costs.length == 0) return 0;
        // int[][] dp = new int[costs.length + 1][costs[0].length];
        // dp[0][0] = 0; 
        // dp[0][1] = 0; 
        // dp[0][2] = 0;
        // for (int row = 1; row <= costs.length; row++) {
        //     dp[row][0] = dp[row - 1][0] + Math.min(costs[row - 1][1], costs[row - 1][2]);
        //     dp[row][1] = dp[row - 1][1] + Math.min(costs[row - 1][0], costs[row - 1][2]);
        //     dp[row][2] = dp[row - 1][2] + Math.min(costs[row - 1][0], costs[row - 1][1]);
        // }
        // int numRow = costs.length;
        // return Math.min(dp[numRow][0], Math.min(dp[numRow][1], dp[numRow][2]));
        
//         if(costs.length==0) return 0;
//         int lastR = costs[0][0];
//         int lastG = costs[0][1];
//         int lastB = costs[0][2];
//         for(int i=1; i<costs.length; i++){
//             int curR = Math.min(lastG,lastB)+costs[i][0];
//             int curG = Math.min(lastR,lastB)+costs[i][1];
//             int curB = Math.min(lastR,lastG)+costs[i][2];
//             lastR = curR;
//             lastG = curG;
//             lastB = curB;
//         }
//         return Math.min(Math.min(lastR,lastG),lastB);
        
        if(costs==null||costs.length==0){
            return 0;
        }
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}