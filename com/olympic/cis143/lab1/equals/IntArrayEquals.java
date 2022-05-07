package com.olympic.cis143.lab1.equals;

import java.util.Arrays;

public class IntArrayEquals {

    private int[] data;

    public IntArrayEquals(int[] values) {
        if (values == null) {
            throw new RuntimeException("Values passed cannot be null");
        }
        this.data = values;
    }

    /**
     * This method will return false is the array:
     * 1. is null
     * 2. Arrays have different lengths
     * 3. Data within the array is not the same and in the same order
     *
     * If the above conditions are true, the method returns true.
     * @param compareMe The integer array to compare the internal array with.
     * @return True if equal else false.
     */
    
    public boolean equals(int[] compareMe) 
    {
		return Arrays.equals(compareMe, data);
    }
    // assuming importing common utilities is allowed, did not find anything that says otherwise
    // if not, can rewrite as a multiple-condition if statement with a loop to validate equality
    
}
