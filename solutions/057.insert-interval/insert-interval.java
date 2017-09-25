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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // Add intervals before the new Interval
        List<Interval> res = new ArrayList<>();
        for (Interval interval: intervals) {
            if (newInterval == null || interval.end < newInterval.start) {
                // Add intervals before the new Interval
                res.add(interval);
            } else if (interval.start > newInterval.end) {
                // Add interval after the newInterval
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                // Merge newInterval with other intervals
                newInterval = new Interval(Math.min(newInterval.start, interval.start), Math.max(newInterval.end, interval.end));
            
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res;
    }
}