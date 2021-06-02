package app;

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
    public static void main(String args[]){
        lucky();
    }
}
