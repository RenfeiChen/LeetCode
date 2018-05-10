/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {
    
    
    TreeMap<Integer, Interval> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        Integer l = map.lowerKey(val), r = map.higherKey(val);
        if (l != null && val <= map.get(l).end) {
            return;
        }
        if (l != null && r != null && map.get(l).end + 1 == val && val + 1 == r) {
            map.get(l).end = map.get(r).end;
            map.remove(r);
        } else if (l != null && map.get(l).end + 1 == val) {
            map.get(l).end++;
        } else if (r != null && val + 1 == r) {
            map.put(val, new Interval(val, map.get(r).end));
            map.remove(r);   
        } else {
            map.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}