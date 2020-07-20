package hash;

/**
 * @author tongruochen
 * @since 2020/3/15
 */
public class Lc_242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null
                || t == null
                || s.length() != t.length()) {
            return false;
        }

        int[] strACount = new int[65536];
        int[] strBCount = new int[65536];
        for (int i=0; i<s.length(); i++) {
            strACount[s.charAt(i)]++;
            strBCount[t.charAt(i)]++;
        }

        for (int i=0; i<strACount.length; i++) {
            if (strACount[i] != strBCount[i]) {
                return false;
            }
        }

        return true;
    }
}
