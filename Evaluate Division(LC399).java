class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String from = equations[i][0], to = equations[i][1];
            if (!graph.containsKey(from)) {
                graph.put(from, new HashMap<>());
            }
            if (!graph.containsKey(to)) {
                graph.put(to, new HashMap<>());
            }
            graph.get(from).put(from, 1.0);
            graph.get(to).put(to, 1.0);
            graph.get(from).put(to, values[i]);
            graph.get(to).put(from, 1 / values[i]);
        }
        for (String mid : graph.keySet()) {
            for (String from : graph.get(mid).keySet()) {
                for (String to : graph.get(mid).keySet()) {
                    double val = graph.get(from).get(mid) * graph.get(mid).get(to);
                    graph.get(from).put(to, val);
                }
            }
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < result.length; i++) {
            if (!graph.containsKey(queries[i][0])) {
                result[i] = -1;
            } else {
                result[i] = graph.get(queries[i][0]).getOrDefault(queries[i][1], -1.0);
            }
        }
        return result;
    }
}