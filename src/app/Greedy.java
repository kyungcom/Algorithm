package app;

import java.util.Scanner;


public class Greedy {

    //이것이 코딩테스트다 교재 P.92 큰 정수 알고리즘
    public static void bigInt(){
        int result = 0;
        Scanner sc = new Scanner(System.in);
        String inputNums = sc.nextLine();
        String[] arrNum = inputNums.split(" ");

        int n = Integer.parseInt(arrNum[0]);
        int m = Integer.parseInt(arrNum[1]);
        int k = Integer.parseInt(arrNum[2]);

        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }

        Sort.mergeSort(n, arr);

        for(int j = 0; j < m; j++){
            if (j % k == 0){
                result += arr[n-2];
                k+=4;
            } else {
                result += arr[n-1];
            }
        }

        System.out.println(result);
    }

    //이것이 코딩테스트다 교재 P.96 숫자 카드 게임
    public static void numCard(){
        Scanner sc = new Scanner(System.in);
        String inputNums = sc.nextLine();
        String[] arrNum = inputNums.split(" ");

        int n = Integer.parseInt(arrNum[0]);
        int m = Integer.parseInt(arrNum[1]);

        int arr[][] = new int[n][m];

        int result=0;

        for (int i = 0; i < n; i++){
            int colsMin=10000;
            String[] cols = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                colsMin = Math.min(colsMin , Integer.parseInt(cols[j]));
            }
            result = Math.max(result, colsMin);
        }

        System.out.println(result);



    }


    public static void main(String args[]) {

        numCard();

    }





}
