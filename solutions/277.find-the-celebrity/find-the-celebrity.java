/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // Similar to two pointer solution for the sorted two sum problem
        if (n < 0) return 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (knows(l, r)) l++;
            else r--; // l does not know r, so r cannot be celebrity
        }
        // Here we get to the place where l == r
        int i = 0;
        while (i < n) {
            // Iterate to the end of n (array) see 
            // Case 1: if l does not know the rest of the people and the rest of people know l
            // Case 2: if i knows l
            // If not return -1
            if (i != l && (knows(l, i) || !knows(i, l))) return -1;
            i++;
        }
        return l;
    }
}