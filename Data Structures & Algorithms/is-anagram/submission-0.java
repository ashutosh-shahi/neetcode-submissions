class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        }
        int[] arr = new int[26];    
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            arr[ch - 'a']++;
            
        }
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) != arr[s.charAt(i) - 'a']) return false;
        }
        return true;
    }
}
