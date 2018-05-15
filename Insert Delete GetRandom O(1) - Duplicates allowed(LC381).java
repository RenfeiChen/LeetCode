class RandomizedCollection {
    
    Random rand;
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        rand = new Random(415);
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        if (!res) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean res = map.containsKey(val);
        if (!res) {
            return res;
        }
        Set cur = map.get(val);
        int index = (int)cur.iterator().next();
        boolean contain = false;
        if (index < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last);
            map.get(last).remove(list.size() - 1);
            if (map.get(last).contains(index)) {
                contain = true;
            }
            map.get(last).add(index);
        }
        if (!contain) {
            if (map.get(val).size() > 1) {
                cur.remove(index);
            } else {
                map.remove(val);
            }
        }
        list.remove(list.size() - 1);
        return res;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */