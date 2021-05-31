package app;

import java.util.Arrays;
import java.util.Scanner;

public class dynamic {
    public static void main(String args[]){
        System.out.println(giveMoney());
    }



    //이것이 코딩테스트다 p.212 재귀적 피보나치 수열
    static int pibonacci(int x){
        int[] arr = new int[1000];
        if (x ==1 || x ==2)
            return 1;
        else if (arr[x] != 0){
            return arr[x];
        }else {
            arr[x] = pibonacci(x - 1) + pibonacci(x - 2);
            return arr[x];
        }
    }


    //이것이 코딩테스트다 p.215 반복적 피보나치 수열
    static int pibonacci2(int x){
        int[] arr = new int[1000];
        arr[1] = 1;
        arr[2] = 1;
        if (x == 1 || x == 2)
            return 1;
        for (int i = 3; i <= x; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[x];
    }

    //이것이 코딩테스트다 p.217 1로 만들기
    static int makeOne(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] arr = new int[x+1];

        if (x == 1){
            return 0;
        }

        for (int i = 2; i <= x; i++){
            arr[i] = arr[i-1] + 1;
            if (i % 2 == 0){
                arr[i] = Math.min(arr[i],arr[i/2] + 1);
            }
            if (i % 3 == 0){
                arr[i] = Math.min(arr[i], arr[i/3] + 1);
            }
            if (i % 5 == 0){
                arr[i] = Math.min(arr[i], arr[i/5] + 1);
            }

        }
        return arr[x];

    }

    //이것이 코딩테스트다 p.220 개미 전사
    static int warriorAnt(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] foods = new int[n];
        for (int i = 0; i < n; i++){
            foods[i] = sc.nextInt();
        }

        int[] maxFood = new int[n];
        maxFood[0] = foods[0];
        maxFood[1] = foods[1];
        for (int i = 2; i < n; i++){
            maxFood[i] = Math.max(maxFood[i - 1] , maxFood[i - 2] + foods[i]);
        }

        return Math.max(maxFood[n-1], maxFood[n-2]);
    }
    //이것이 코딩테스트다 p.223 바닥 공사
    static int floorWork(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int [n + 1];
        arr[1] = 1;
        arr[2] = 3;
        for (int i = 3; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2] *2;
        }

        return arr[n] % 796796;
    }
    //이것이 코딩테스트다 p.226 효율적인 화폐 구성
    static int giveMoney(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int minMoney[] = new int[m+1];

        Arrays.sort(arr);

        for (int i = 1; i < arr[0]; i++){
            minMoney[i] = -1;
        }
        for (int i = arr[0]; i <= m; i++){
            minMoney[i] = 10000000;
            for (int x : arr) {
                if (x == i){
                    minMoney[i] = 1;
                }
                else{
                    if((i - x) >= 0) {
                        if (minMoney[i - x] != -1) {
                            minMoney[i] = Math.min(minMoney[i], minMoney[i - x] + 1);
                        }
                    }
                }
            }
            if (minMoney[i] == 10000000){
                minMoney[i] = -1;
            }
        }
        return minMoney[m];


    }
}
