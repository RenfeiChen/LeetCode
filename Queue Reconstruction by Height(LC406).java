class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
           public int compare (int[] p1, int[] p2) {
               return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
           } 
        });
        LinkedList<int[]> list = new LinkedList<>(); 
        for (int i = 0; i < people.length; i++)
            list.add(people[i][1], people[i]); 
        return list.toArray(people); 
    }
}