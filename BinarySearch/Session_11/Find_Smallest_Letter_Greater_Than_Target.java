package BinarySearch.Session_11;

public class Find_Smallest_Letter_Greater_Than_Target {
    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'c';
        char nextGreatestChar = nextGreatestLetter(letters, target);
        System.out.println(nextGreatestChar);
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    private static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int low = 0;
        int high = n - 1;
        int k = target - 'a';
        if (letters[n - 1] - 'a' <= k) {
            return letters[0];
        }
        int pos = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int index = letters[mid] - 'a';
            if (index > k) {
                pos = Math.min(pos, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return letters[pos];
    }
}
