package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RealizationProblem {
    //이것이 코딩테스트다 p.321 럭키 스트라이크
    public static void lucky(){
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int len = number.length() / 2;

        int front = 0;
        int rear = 0;

        for (int i = 0; i < len; i++){
            front += Integer.parseInt(number.substring(i,i+1));
        }

        for (int i = len; i < len*2 ; i++){
            rear += Integer.parseInt(number.substring(i,i+1));
        }

        if(front == rear){
            System.out.println("LUCKY");
        }else {
            System.out.println("READY");
        }

    }

    //이것이 코딩 테스트다 p.322 문자열 재정렬
    public static void reSort(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<Character> chars = new ArrayList<Character>();
        int ints = 0;
        for (int i = 0; i < str.length(); i++){
            char item = str.charAt(i);
            if ((int)item >= 65){
                chars.add(item);
            }
            else {
                ints += Character.getNumericValue(item);
            }
        }

        Collections.sort(chars);

        for (int i = 0; i < chars.size(); i++){
            System.out.print(chars.get(i));
        }

        System.out.print(ints);

    }
    public static void main(String args[]){
        reSort();
    }
}
