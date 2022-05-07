package com.test;

import com.beans.Product;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        int array[] = {-25, 13, 67, 56, 0, 10, 12, 56, -10, 90, 70};
        int count = 0;
        int max = Integer.MIN_VALUE;
        boolean increse = false;
        boolean down = false;
        if (array.length > 0) {
            if (array[0] < array[1])
                increse = true;
            else
                down = false;

            for (int i = 1; i < array.length - 1; i++) {
                if (array[i] > array[i + 1] && increse) {
                    max = array[i];
                    System.out.println(max+ "index= "+i);
                    count++;
                    down = true;
                    increse=false;
                }
                if (array[i] < array[i + 1] && down) {
                    max = array[i];
                    System.out.println(max+ "index= "+i);
                    count++;
                    down = false;
                    increse=true;
                }
                else {
                    increse = true;
                    down = false;
                }
            }
        }


        List<Product>  list= new ArrayList<>();
//        for()
        System.out.println(count);
    }
}
