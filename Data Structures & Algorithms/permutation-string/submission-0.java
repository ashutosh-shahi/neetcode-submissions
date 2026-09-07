class Solution {
    public boolean check(String str, HashMap<Character, Integer> map) {
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            map2.put(str.charAt(i), map2.getOrDefault(str.charAt(i), 0) + 1);
        }
        for(int i = 0; i < str.length(); i++) {
            if(map2.get(str.charAt(i)) != map.getOrDefault(str.charAt(i), 0)) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = s1.length() - 1;
        if(s2.length() < s1.length()) return false;
        while(r < s2.length()) {
            if(check(s2.substring(l, r+1), map)) return true;
            r++;
            l++;
        }
        return false;
    }
}
