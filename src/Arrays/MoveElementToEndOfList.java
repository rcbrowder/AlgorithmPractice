package Arrays;

import java.util.List;

public class MoveElementToEndOfList {
    /**
     * You're given an array of integers and an integer. Write a function that moves all instances of that integer in
     * the array to the end of the array and returns the array.
     *
     * The function should perform this in place (i.e., it should mutate the input array) and doesn't need to
     * maintain the order of the other integers.
     */

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        if (array.size() == 0) {
            return array;
        }

        int endOfSubArray = array.size() - 1;
        for (int i = 0; i < endOfSubArray; i++) {
            while (array.get(endOfSubArray) == toMove && i < endOfSubArray) {
                endOfSubArray--;
                if (endOfSubArray == 0) {
                    return array;
                }
            }
            if (array.get(i) == toMove) {
                array.set(i, array.get(endOfSubArray));
                array.set(endOfSubArray, toMove);
                endOfSubArray--;
            }
        }

        return array;
    }
}
