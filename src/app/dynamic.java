package app;

import java.util.Scanner;

public class dynamic {
    public static void main(String args[]){
        System.out.println(pibonacci2(10));
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
    static void makeOne(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
    }
}
