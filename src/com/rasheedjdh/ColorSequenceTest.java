package com.rasheedjdh;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.rasheedjdh.Color.*;
import java.util.*;


public class ColorSequenceTest {

    /**
     * generate a list of the unlimited strings passed
     **/
    List<Color> getColorList(String... args){
        List<Color> colors = new ArrayList<>();
        for(String arg : args){
            colors.add(new Color(arg));
        }
        return  colors;
    }

    /**
     * generate a list of the unlimited capacity rules passed
     **/
    List<CapacityRule> getCapacityRules(CapacityRule... args){
        return Arrays.asList(args);
    }

    /**
     * The algorithm that is responsible for generating a list of the integers
     * indicating whether the maximal capacity in a moving sized window  is satisfied
     * for a given sequence of colors
     **/
    List<Integer> getColorAppearanceOutput(List<Color> colors, CapacityRule cr ){
        // prune illegal capacity and window width
        if (cr.getMaxCapacity() < 0 || cr.getWindowWidth() <= 0){
            return Arrays.asList(1,1,1,1);
        }

        List<Integer> outputResult = new ArrayList<>();
        int index = 0;
        for(int row = 0; row < colors.size(); row++){

            int colorOccurrence = 0;
            // calculate the slice of the array that i want to iterate
            int rowLength = Math.min((cr.getWindowWidth() + index), colors.size());
            // iterate through the slice of the array to sum the target color occurrence
            for (int col = index; col < rowLength  ; col++){
                colorOccurrence +=  cr.getColor().getCode() == colors.get(col).getCode() ? 1 : 0;
            }
            // add the result to the output array
            outputResult.add(colorOccurrence > cr.getMaxCapacity() ? 1 : 0);
            index++;
        }
        return outputResult;
    }

    /**
     * return the hardcoded capacity rules for a specific color
     */
    List<CapacityRule> getAllCapacityRules(Color withColor){
        return getCapacityRules(
                new CapacityRule(-1, withColor, -1),
                new CapacityRule(-1, withColor, 0),
                new CapacityRule(-1, withColor, 2),
                new CapacityRule(-1, withColor, 10)
                ,
                new CapacityRule(0, withColor, -1),
                new CapacityRule(0, withColor, 0),
                new CapacityRule(0, withColor, 2),
                new CapacityRule(0, withColor, 10),

                new CapacityRule(1, withColor, -1),
                new CapacityRule(1, withColor, 0),
                new CapacityRule(1, withColor, 2),
                new CapacityRule(1, withColor, 10),

                new CapacityRule(3, withColor, -1),
                new CapacityRule(3, withColor, 0),
                new CapacityRule(3, withColor, 2),
                new CapacityRule(3, withColor, 10),

                new CapacityRule(10, withColor, -1),
                new CapacityRule(10, withColor, 0),
                new CapacityRule(10, withColor, 2),
                new CapacityRule(10, withColor, 10)
        );
    }

    /**
     * generate a list of the unlimited array of integer passed
     */
    List<List<Integer>> getAllExpectedResults(Integer[]... args){
        List<List<Integer>> expectedResults = new ArrayList<>();
        for (Integer[] arg : args){
            expectedResults.add(Arrays.asList(arg));
        }
        return expectedResults;
    }

    @Test
    void TestAllRedsWithRedCapacityRules(){
        List<Color> colorList = getColorList(RED, RED, RED, RED);
        List<List<Integer>> outputResults = new ArrayList<>();
        List<List<Integer>> expectedResults = getAllExpectedResults(
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1, 1, 0, 0},
                new Integer[]{0, 0, 0, 0},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1, 1, 0, 0},
                new Integer[]{0, 0, 0, 0}
        );
        int counter = 1;
        for (CapacityRule capacityRule : getAllCapacityRules(new Color(RED))){
            System.out.println(capacityRule.toString());
            System.out.print(Integer.toString(counter) + ") ");
            counter++;
            List<Integer> output = getColorAppearanceOutput(colorList, capacityRule);
            outputResults.add(output);
            System.out.println(output);
            System.out.println("___________________");
        }
        assertEquals(expectedResults, outputResults);
    }

    @Test
    void TestAllRedsWithGreenCapacityRules(){
        List<Color> colorList = getColorList(RED, RED, RED, RED);
        List<List<Integer>> outputResults = new ArrayList<>();
        List<List<Integer>> expectedResults = getAllExpectedResults(
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},

                new Integer[]{1,1,1,1},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0},

                new Integer[]{1,1,1,1},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0},

                new Integer[]{1,1,1,1},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0}
        );
        for (CapacityRule capacityRule : getAllCapacityRules(new Color(GREEN))){
            System.out.println(capacityRule.toString());
            List<Integer> output = getColorAppearanceOutput(colorList, capacityRule);
            outputResults.add(output);
            System.out.println(output);
            System.out.println("___________________");
        }
        assertEquals(expectedResults, outputResults);
    }

    @Test
    void TestMixedColorsWithRedCapacityRules(){
        List<Color> colorList = getColorList(RED, GREEN, RED, GREEN);
        List<List<Integer>> outputResults = new ArrayList<>();
        List<List<Integer>> expectedResults = getAllExpectedResults(
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},

                new Integer[]{1,1,1,1},
                new Integer[]{1,0,1,0},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,0},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,0},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0}
        );
        int counter = 1;
        for (CapacityRule capacityRule : getAllCapacityRules(new Color(RED))){
            System.out.println(capacityRule.toString());
            System.out.print(Integer.toString(counter) + ") ");
            counter++;
            List<Integer> output = getColorAppearanceOutput(colorList, capacityRule);
            outputResults.add(output);
            System.out.println(output);
            System.out.println("___________________");
        }
        assertEquals(expectedResults, outputResults);
    }

    @Test
    void TestMixedColorsWithGreenCapacityRules(){
        List<Color> colorList = getColorList(RED, GREEN, RED, GREEN);
        List<List<Integer>> outputResults = new ArrayList<>();
        List<List<Integer>> expectedResults = getAllExpectedResults(
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},

                new Integer[]{1,1,1,1},
                new Integer[]{0,1,0,1},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0},

                new Integer[]{1,1,1,1},
                new Integer[]{1,1,1,1},
                new Integer[]{0,0,0,0},
                new Integer[]{0,0,0,0}
        );
        int counter = 1;
        for (CapacityRule capacityRule : getAllCapacityRules(new Color(GREEN))){
            System.out.println(capacityRule.toString());
            System.out.print(Integer.toString(counter) + ") ");
            counter++;
            List<Integer> output = getColorAppearanceOutput(colorList, capacityRule);
            outputResults.add(output);
            System.out.println(output);
            System.out.println("___________________");
        }
        assertEquals(expectedResults, outputResults);
    }

}
