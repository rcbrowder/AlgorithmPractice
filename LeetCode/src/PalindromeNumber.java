public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 10) {
            return true;
        }
        String str = String.valueOf(x);
        for (int i = 0; i < str.length()/2; i++) {
            if (!(str.charAt(i) == (str.charAt(str.length() - 1)))) {
                return false;
            }
        }
        return true;
    }
}
