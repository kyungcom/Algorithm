package app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sort {
    public static void main(String args[]){
        int[] S={3, 5, 2, 9, 10, 14, 4, 8};

        countSort(S);

        System.out.println(Arrays.toString(S));
        change();

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

    static void quickSort(int low, int high, int[] arr){
        int pivotPoint;
        if (high > low) {
            pivotPoint = partition(low, high, arr);
            quickSort(low, pivotPoint - 1, arr);
            quickSort(pivotPoint + 1, high, arr);
        }
    }

    static int partition(int low, int high, int[] arr){
        int pivotItem = arr[low];
        int j = low;
        for (int i = low + 1; i <=high; i++){
            if (arr[i] < pivotItem){
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++){
            int smallest = i;
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[smallest])
                    smallest = j;
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

        }

    }

    static void insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++){
            int j = i-1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    static void countSort(int[] arr){

        int max = -100000;

        for (int i : arr){
            if (max < i )
                max = i;
        }

        int[] count = new int[max+1];

        for(int i : arr){
            count[i] += 1;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < count.length; i++){
            for (int j = 0; j < count[i]; j++){
                result.add(i);
            }
        }
        for (int i = 0; i < arr.length; i++){
            arr[i] = result.get(i);
        }

    }
    //이것이 코딩테스트다 p.178 위에서 아래로
    static void upToDown(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }


    }

    //이것이 코딩테스트다 p.180 성적이 낮은 순서로 학생 출력하기
    static void grade(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Student> arr= new ArrayList<Student>();
        for (int i = 0; i < n; i++){
            String name = sc.next();
            int grade = sc.nextInt();

            Student std = new Student(name, grade);
            arr.add(std);
        }

        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i).getName() + " ");
        }


    }

    //이것이 코딩테스트다 p.183 두 배열의 원소 교체
    static void change(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < k; i++){
            if (arr1[i] < arr2[n-1-i]){
                int temp = arr1[i];
                arr1[i] = arr2[n-1-i];
                arr2[n-1-i] = temp;
            } else {
                break;
            }
        }

        int result = 0;
        for(int i = 0; i < arr1.length; i++){
            result += arr1[i];
        }

        System.out.println(result);


    }

}
