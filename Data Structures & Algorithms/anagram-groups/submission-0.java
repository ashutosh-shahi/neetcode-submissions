class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(strs[i]);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String list : map.keySet()) {
            ans.add(map.get(list));
        }
        return ans;
    }
}