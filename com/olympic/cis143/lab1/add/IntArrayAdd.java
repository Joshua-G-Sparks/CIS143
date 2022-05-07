package com.olympic.cis143.lab1.add;

import java.util.ArrayList;

public class IntArrayAdd {

    private int[] data;

    public IntArrayAdd() {
        this.data = new int[0];
    }

    public int[] getData() {
        return this.data;
    }

    /**
     * This method will need to add an element to the end of an array.
     *
     * @param value The value to be added.
     */
    public void add(int value) 
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int grab : data)
        {
        	list.add(grab);
        }
        list.add(value);
        // this.data = list.toArray();  // does not work, see comment below
        
        // I was pretty confident this would work with the above line, but it does not. Would be nice.
        // .toArray returns an Object array, which is incompatible with a primitive int array.
        // Casting to an int[] from an Object[] does not work. Alternate .toArray methods also don't seem to work.
        
        int[] stored = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
        	//System.out.println(i); //debug printer
        	stored[i] = list.get(i);
        }
        this.data = stored;
        
        // I could have probably scrapped the Array List and put everything into the above loop. But this works.
        // Any ideas on how to get .toArray to play nice with primitive int arrays?
    }
}
