package com.PatkarSir_core.javapassbyvalue;

import java.util.ArrayList;
import java.util.List;


/*
*  When defining an Arraylist or any collection in java, a reference is created inside the stack which
*  points to multiple objects inside the heap memory,
 * when calling modifyList(), a copy of the reference is created and passed to the method,
 * so that the actual object data is referenced by 2 references and any change done by one reference is reflected
  * on the other.
* */
public class ExploreCollectionArgs {

    public static void main(String[] args) {
        List<Integer> lstNums = new ArrayList<Integer>();
        lstNums.add(1);
        System.out.println("Size of list before List modification = " + lstNums.size());
        modifyList(lstNums);
        System.out.println("Size of list after List modification = " + lstNums.size());
    }

    private static void modifyList(List<Integer> lstParam)
    {
        lstParam.add(2);
    }

}
