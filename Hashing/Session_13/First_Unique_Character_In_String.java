package Hashing.Session_13;

import java.util.HashMap;

public class First_Unique_Character_In_String {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int firstUnique = firstUniqChar(s);
        System.out.println(firstUnique);
    }

    /**
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     */
    public static int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (hm.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
