/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    // Creating new intervals and add them to the List, not adding the input one
    // take the first interval and compare its end with the next intervals starts. As long as they overlap, we update the end to be the max end of the overlapping intervals. 
    // Once find a non overlapping interval, add the previous "extended" interval and start over (reset the start and end bounds).
    // Sorting takes O(n log(n)) and merging the intervals takes O(n) => O(n log(n)).
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        // Sort based on start
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });
        
        List<Interval> res = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval: intervals) {
            // Overlapping
            if (interval.start <= end) {
                // Update the end to be the max end of the overlapping intervals
                // [[1,4],[2,3]] the previous end might be larger than the current end
                end = Math.max(interval.end, end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}