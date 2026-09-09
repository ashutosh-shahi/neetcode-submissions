class Solution {
    public boolean canFinish(int num, int[][] nums) {
        int n = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < num; i++ ) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++) {
            int a = nums[i][0];
            int b = nums[i][1];
            adj.get(b).add(a);
        }
        int[] indegree = new int[num];
        for(int i = 0; i < num; i++) {
            for(int it: adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < num; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int tmp = q.poll();
            for(int it: adj.get(tmp)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        for(int i = 0; i < num; i++) {
            if(indegree[i] != 0) return false;
        }
        return true;
    }
}
