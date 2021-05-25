package app;

import java.util.Arrays;

public class functionTime {
    public static void main(String args[]){
        int[] arr={110,8,4,8,9,3,4};
        long start = System.nanoTime();
        Sort.mergeSort(arr.length, arr);
        System.out.println(Arrays.toString(arr));
        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " ns");
    }
}
