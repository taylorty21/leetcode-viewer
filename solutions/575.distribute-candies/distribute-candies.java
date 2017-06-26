public class Solution {
    public int distributeCandies(int[] candies) {
        // There are len(set(candies)) unique candies, and the sister picks only len(candies) / 2 of them, so she can't have more than this amount.
        // For example, if there are 5 unique candies, then if she is picking 4 candies, she will take 4 unique ones. If she is picking 7 candies, then she will only take 5 unique ones.
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
}