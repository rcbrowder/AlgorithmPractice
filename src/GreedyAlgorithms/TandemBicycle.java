package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        int sum = 0;
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if (!fastest) {
            reverseArray(redShirtSpeeds);
        }

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            int speed = Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            sum += speed;
        }

        return sum;
    }

    public void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
