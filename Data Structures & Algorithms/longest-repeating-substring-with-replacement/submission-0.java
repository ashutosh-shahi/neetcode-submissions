class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int len = 0;
        while(r < n) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            if(((r - l + 1) - maxFreq) <= k) len = Math.max(len, (r - l + 1) );
            if(((r- l + 1) - maxFreq) > k) {
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
            
            r++;
        }
        return len;
    }
}