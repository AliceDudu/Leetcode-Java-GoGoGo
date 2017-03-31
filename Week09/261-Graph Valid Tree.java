

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) return n == 1;
        if (edges.length >= n) return false;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        dfs(edges[0][0], visited, map);
        return visited.size() == n;
    }
    private void dfs(int curr, Set<Integer> visited, Map<Integer, Set<Integer>> map) {
        if (!visited.add(curr)) return;
        for (int child : map.get(curr)) {
            dfs(child, visited, map);
        }
    }
}



public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}