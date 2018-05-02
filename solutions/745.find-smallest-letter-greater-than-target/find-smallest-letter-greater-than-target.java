class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        //hi starts at 'n' rather than the usual 'n - 1'. 
        //It is because the terminal condition is 'lo < hi' and if hi starts from 'n - 1', 
        //we can never consider value at index 'n - 1'
        int lo = 0, hi = n;

        //Terminal condition is 'lo < hi', to avoid infinite loop when target is smaller than the first element
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] > target)     hi = mid;
            else    lo = mid + 1;                 //letters[mid] <= target
        }
 
        //Because lo can end up pointing to index 'n', in which case we return the first element
        return letters[lo % n];
    }
    
    public char nextGreatestLetter2(char[] a, char x) {
        int n = a.length;
       
        if (x >= a[n - 1])   x = a[0];
        else    x++;
        
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == x)    return a[mid];
            if (a[mid] < x)     lo = mid + 1;
            else    hi = mid;
        }
        return a[hi];
    }
}