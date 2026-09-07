class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int l = 0, r = 0;
        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (r < n) {

            while (map.containsKey(s.charAt(r))) {
                map.remove(s.charAt(l));
                l++;
            }

            map.put(s.charAt(r), 1);

            max = Math.max(max, r - l + 1);

            r++;
        }

        return max;
    }
}