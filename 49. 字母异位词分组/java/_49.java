package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*import java.util.*;
import org.junit.Assert;*/
public class _49 {

    static class _1st {
        public static void main(String[] args) {
            _1st handler = new _1st();


        }

        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) return new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] ca = new char[26];
                for (char c : s.toCharArray()) ca[c - 'a']++;
                String keyStr = String.valueOf(ca);
                if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
                map.get(keyStr).add(s);
            }
            return new ArrayList<>(map.values());
        }

    }

}
