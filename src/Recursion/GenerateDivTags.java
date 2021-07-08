package Recursion;

import java.util.ArrayList;

public class GenerateDivTags {
    /**
     * Write a function that takes in a positive integer numberOfTags and returns a list of all the valid strings
     * that you can generate with that number of matched <div></div> tags.
     *
     * A string is valid and contains matched <div></div> tags if for every opening tag <div>, there is a closing tag
     * </div> that comes after the opening tag and that isn't used as a closing tag for another opening tag. Each
     * output string should contain exactly numberOfTags opening tags and numberOfTags closing tags.
     *
     * Note that the output strings don't need to be in any particular order.
     */

    public static final String OPEN_TAG = "<div>";
    public static final String CLOSE_TAG = "</div>";

    public ArrayList<String> generateDivTags(int numberOfTags) {
        ArrayList<String> result = new ArrayList<>();
        generateDivTagsFromPrefix("", numberOfTags, numberOfTags, result);
        return result;
    }

    public void generateDivTagsFromPrefix(String prefix, int openTags, int closeTags, ArrayList<String> result) {
        if (openTags > 0) {
            String newPrefix = prefix + OPEN_TAG;
            generateDivTagsFromPrefix(newPrefix, openTags - 1, closeTags, result);
        }
        if (openTags < closeTags) {
            String newPrefix = prefix + CLOSE_TAG;
            generateDivTagsFromPrefix(newPrefix, openTags, closeTags - 1, result);
        }
        if (closeTags == 0) {
            result.add(prefix);
        }
    }


}
