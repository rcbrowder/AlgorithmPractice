package Arrays;

import java.util.List;

public class ValidateSubsequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int subSequenceIndex = 0;
        for (Integer integer : array) {
            if (integer.equals(sequence.get(subSequenceIndex))) {
                subSequenceIndex++;
                if (subSequenceIndex == sequence.size()) {
                    return true;
                }
            }
        }
        return false;
    }
}
