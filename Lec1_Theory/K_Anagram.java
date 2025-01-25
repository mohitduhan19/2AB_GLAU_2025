package AB.Lec1_Theory;

public class K_Anagram {
    boolean areKAnagrams(String s1, String s2, int k) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int MAX_CHAR = 26;
        int n = str1.length;
        if (str2.length != n) return false;

        // Creating an array to store frequency of characters in str1
        int[] freq = new int[MAX_CHAR];
        for (int i = 0; i < n; i++){
            freq[str1[i] - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            // If the character is present in str1, decrement the frequency count
            if (freq[str2[i] - 'a'] > 0) freq[str2[i] - 'a']--;
            else
                count++;

            if (count > k) return false;
        }
        return true;
    }
}
