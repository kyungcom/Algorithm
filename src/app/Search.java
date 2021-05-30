package app;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Search {
    public static void main(String args[]){
        makeDduk();
    }

    static int sequentialSearch(int[] arr, int x){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int x){
        int start = 0;
        int end = arr.length-1;
        boolean founded = false;
        while (start <= end) {
            int mid = (start + end)/2;
            if(arr[mid] == x){
                return mid;
            } else if (arr[mid] < x){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    //이것이 코딩테스트다 p.197 부품찾기
    static void findPart(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] parts = new int[n];
        for (int i = 0; i < n; i++){
            parts[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        Arrays.sort(parts);
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < m; i++){
            if(binarySearch(parts, sc.nextInt()) == -1){
                System.out.print("no ");
            }else{
                System.out.print("yes ");
            }
        }
    }
    
    //이것이 코딩 테스트다 p.201 떡볶이 떡 만들기
    static void makeDduk(){
        Scanner sc= new Scanner(System.in);
        int numOfDduk = sc.nextInt();
        int needAmount = sc.nextInt();

        int [] dduks = new int[numOfDduk];

        for (int i = 0; i < numOfDduk; i++){
            dduks[i] = sc.nextInt();
        }
        Arrays.sort(dduks);
        int start = 0;
        int end = dduks[numOfDduk-1];
        while(start <= end){
            int result = 0;
            int mid = (start + end)/2;
            for (int i = 0; i < numOfDduk; i++){
                if (dduks[i] > mid){
                    result += dduks[i] - mid;
                }
            }

            if (result == needAmount){
                System.out.println(mid);
                break;
            } else if (result < needAmount){
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
    }
}
