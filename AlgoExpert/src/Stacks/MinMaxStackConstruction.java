package Stacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a MinMaxStack class for a Min Max Stack. The class should support:
 *  - Pushing and popping values on and off the stack.
 *  - Peeking at the value at the top of the stack.
 *  - Getting both the minimum and the maximum values in the stack at any given point in time.
 *
 * All class methods, when considered independently, should run in constant time and with constant space.
 */

public class MinMaxStackConstruction {

    static class MinMaxStack {
        List<Integer> stack = new ArrayList<>();
        List<Integer> minValues = new ArrayList<>();
        List<Integer> maxValues = new ArrayList<>();

        public int peek() {
            if (stack.isEmpty()) {
                return -1;
            } else {
                int lastIndex = stack.size() - 1;
                return stack.get(lastIndex);
            }
        }

        public int pop() {
            int lastIndex = maxValues.size()-1;
            int lastValue;
            if (stack.isEmpty()) {
                return -1;
            } else {
                lastValue = stack.get(lastIndex);
                stack.remove(lastIndex);
                minValues.remove(lastIndex);
                maxValues.remove(lastIndex);
                return lastValue;
            }
        }

        public void push(Integer number) {
            stack.add(number);
            addMinValueToList(number);
            addMaxValueToList(number);
        }

        private void addMaxValueToList(Integer number) {
            int lastIndex = maxValues.size()-1;
            if (maxValues.isEmpty()) {
                maxValues.add(number);
            } else {
                if (number > maxValues.get(lastIndex)) {
                    maxValues.add(number);
                } else {
                    maxValues.add(maxValues.get(lastIndex));
                }
            }
        }

        private void addMinValueToList(Integer number) {
            int lastIndex = minValues.size()-1;
            if (minValues.isEmpty()) {
                minValues.add(number);
            } else {
                if (number < minValues.get(lastIndex)) {
                    minValues.add(number);
                } else {
                    minValues.add(minValues.get(lastIndex));
                }
            }
        }

        public int getMin() {
            if (minValues.isEmpty()) {
                return -1;
            } else {
                int lastIndex = minValues.size() - 1;
                return minValues.get(lastIndex);
            }
        }

        public int getMax() {
            if (maxValues.isEmpty()) {
                return -1;
            } else {
                int lastIndex = maxValues.size() - 1;
                return maxValues.get(lastIndex);
            }
        }
    }
}
