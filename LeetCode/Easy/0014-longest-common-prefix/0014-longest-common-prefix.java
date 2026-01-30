class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";

        if (strs.length == 1) ans = strs[0];

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i < strs[j].length() && strs[j].charAt(i) == strs[0].charAt(i)) {
                    continue;
                } else {
                    if (i > 0) {
                        ans = strs[0].substring(0, i);
                    }
                    return ans;
                }
            }
            
            if (i == strs[0].length() - 1) {
                ans = strs[0];
            }
        }

        return ans;
    }
}