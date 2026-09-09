class Solution {
    public boolean dfs(int[][] edges, List<List<Integer>> adj, int par, int[] vis, int idx) {
        vis[idx] = 1;
        for(int it: adj.get(idx)) {
            if(par == it) continue;
            if(vis[it] != 1) {
                if(!dfs(edges, adj, idx, vis, it)) return false;

            }
            else return false;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        int[] vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
            
        }
        if(!dfs(edges, adj, -1, vis, 0)) return false;
        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
