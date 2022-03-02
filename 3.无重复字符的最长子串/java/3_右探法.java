class Solution {
    public int lengthOfLongestSubstring(String s) {
        int crtLeft = 0, length = 0, maxLength = 0;
        Map<Character, Integer> dic = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int oldLeft = i - length;
            	// 如果出现重复，找到重复位置，并判断是否有效重复
            if (dic.containsKey(c) && dic.get(c) >= oldLeft) {
                crtLeft = dic.get(c) + 1; 
                if (length > maxLength) {
                    maxLength = length;
                }
                length = i - crtLeft + 1;
                dic.put(c, i);
            } else {.  
                length++;
                dic.put(c, i);
            }
        }
        if (length > maxLength) {
            maxLength = length;
        }
        return maxLength;
    }
}
