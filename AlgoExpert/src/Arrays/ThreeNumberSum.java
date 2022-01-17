package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    /**
     * Three Number Sum
     *
     * @param array
     * @param targetSum
     * @return List of int triplets whose sum equals the target int
     */
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> triplets = new ArrayList<>();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    triplets.add(new Integer[] {array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }

}
