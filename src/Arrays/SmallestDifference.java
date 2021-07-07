package Arrays;

import java.util.Arrays;

public class SmallestDifference {

    /**
     *  Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each
     *  array) whose absolute difference is closest to zero, and returns an array containing these two numbers, with
     *  the number from the first array in the first position.
     *
     *  Note that the absolute difference of two integers is the distance between them on the real number line. For
     *  example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.
     *
     *  You can assume that there will only be one pair of numbers with the smallest difference.
     */

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int smallest = Integer.MAX_VALUE;
        int current;

        System.out.println(Arrays.toString(arrayOne));
        System.out.println(Arrays.toString(arrayTwo));

        int i = 0;
        int j = 0;

        int[] smallestPair = new int[2];
        while (i < arrayOne.length && j < arrayTwo.length) {
            int firstNum = arrayOne[i];
            int secondNum = arrayTwo[j];
            if (firstNum < secondNum) {
                current = secondNum - firstNum;
                i++;
            } else if (secondNum < firstNum) {
                current = firstNum - secondNum;
                j++;
            } else {
                return new int[] {firstNum, secondNum};
            }
            if (smallest > current) {
                smallest = current;
                smallestPair = new int[] {firstNum, secondNum};
            }
        }

        return smallestPair;
    }

}
