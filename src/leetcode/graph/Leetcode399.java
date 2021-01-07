package leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 399. 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 * 示例 1：
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 *  
 *
 * 提示：
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            Map<String, Double> x = graph.computeIfAbsent(a, k -> new HashMap<>());
            x.put(b, values[i]);
            Map<String, Double> y = graph.computeIfAbsent(b, k -> new HashMap<>());
            y.put(a, 1 / values[i]);
        }
        double[] ans = new double[queries.size()];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            if (!graph.containsKey(c) || !graph.containsKey(d)) {
                ans[i] = -1.0;
                continue;
            }
            if (c.equals(d)) {
                ans[i] = 1.0;
                continue;
            }
            set.add(c);
            Double r = dfs(graph, set, c, d);
            ans[i] = r != null ? r : -1.0;
            set.clear();
        }
        return ans;
    }
    public Double dfs(Map<String, Map<String, Double>> graph, Set<String> set, String start, String end) {
        Map<String, Double> stringDoubleMap = graph.get(start);
        for (Map.Entry<String, Double> e: stringDoubleMap.entrySet()) {

            if (set.contains(e.getKey())) {
                continue;
            }
            if (e.getKey().equals(end)) {
                return e.getValue();
            }
            set.add(e.getKey());
            Double r = dfs(graph, set, e.getKey(), end);
            if (r != null) {
                return r * e.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Leetcode399 l = new Leetcode399();

        List<String> e1 = Stream.of("a", "b").collect(Collectors.toList());
        List<String> e2 = Stream.of("b", "c").collect(Collectors.toList());
        List<List<String>> equations = Stream.of(e1, e2).collect(Collectors.toList());
        double[] values = new double[]{2.0, 3.0};

        List<String> q1 = Stream.of("a", "c").collect(Collectors.toList());
        List<String> q2 = Stream.of("b", "a").collect(Collectors.toList());
        List<String> q3 = Stream.of("a", "e").collect(Collectors.toList());
        List<String> q4 = Stream.of("a", "a").collect(Collectors.toList());
        List<String> q5 = Stream.of("x", "x").collect(Collectors.toList());
        List<List<String>> queries = Stream.of(q1, q2,q3,q4,q5).collect(Collectors.toList());
        double[] doubles = l.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(doubles));
    }
}
