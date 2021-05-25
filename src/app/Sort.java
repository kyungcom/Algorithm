package app;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {
    public static void main(String args[]){
        int[] S={3, 5, 2, 9, 10, 14, 4, 8};

        mergeSort(8, S);

        System.out.println(Arrays.toString(S));

    }

    static void mergeSort(int n, int[] arr){
        int numOfItemsFirstArr = n/2;
        int numOfItemsSecondArr = n - numOfItemsFirstArr;

        if (n > 1){
            int[] firstArr = Arrays.copyOfRange(arr,0,numOfItemsFirstArr);
            int[] secondArr = Arrays.copyOfRange(arr, numOfItemsFirstArr, numOfItemsSecondArr+numOfItemsFirstArr);
            mergeSort(numOfItemsFirstArr, firstArr);
            mergeSort(numOfItemsSecondArr, secondArr);
            merge(numOfItemsFirstArr, numOfItemsSecondArr, firstArr, secondArr, arr);

        }
    }

    static void merge(int numOfItemsFirstArr, int numOfItemsSecondArr, int[] firstArr, int[] secondArr, int[] arr){
        int i, j, k;
        i=0;
        j=0;
        k=0;
        while (i < numOfItemsFirstArr && j < numOfItemsSecondArr){
            if(firstArr[i] < secondArr[j]){
                arr[k] = firstArr[i];
                i++;
            } else {
                arr[k] = secondArr[j];
                j++;
            }
            k++;
        }

        if (i >= numOfItemsFirstArr){
            for (int x = j; x < numOfItemsSecondArr; x++){
                arr[k] = secondArr[x];
                k++;
            }
        } else {
            for (int x = i; x < numOfItemsFirstArr; x++){
                arr[k] = firstArr[x];
                k++;
            }
        }
    }

    static void mergeSort2(int low, int high, int[] arr){

        if (high > low){
            int midIndex = (low + high) / 2;
            mergeSort2(low, midIndex, arr);
            mergeSort2(midIndex+1, high, arr);
            merge2(low, midIndex, high, arr);

        }
    }

    static void merge2(int low, int mid, int high, int[] arr){
        int i=low, k=0, j=mid+1;
        int[] mergedArr = new int[high - low + 1];

        while (i < mid+1 && j < high+1) {
                if (arr[i] < arr[j]) {
                    mergedArr[k] = arr[i];
                    i++;
                } else {
                    mergedArr[k] = arr[j];
                    j++;
                }
                k++;
        }

        if (i > mid){
            while (j < high+1){
                mergedArr[k] = arr[j];
                j++;
                k++;
            }
        } else {
            while (i < mid+1){
                mergedArr[k] = arr[i];
                i++;
                k++;
            }
        }

        for (int x = low; x <= high; x++){
            arr[x] = mergedArr[x-low];
        }

    }

}
