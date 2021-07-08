package Strings;

import java.util.HashMap;

/**
 * Write a function that takes in a string of lowercase English-alphabet letters and returns the index of the
 * string's first non-repeating character.
 *
 * The first non-repeating character is the first character in a string that occurs only once.
 *
 * If the input string doesn't have any non-repeating characters, your function should return -1.
 */

public class FirstNonRepeatingCharacter {
    public int firstNonRepeatingCharacter(String string) {

        char[] chars = string.toCharArray();
        HashMap<Character,Integer> charMap = new HashMap<>();

        for (char c : chars) {
            if (charMap.containsKey(c)) {
                charMap.put(c,1);
            } else {
                charMap.put(c,0);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (charMap.get(chars[i]) == 0) {
                return i;
            }
        }

        return -1;
    }
}
