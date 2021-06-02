package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Problemgreedy {

    //이것이 코딩테스트다 p.311 모험가 길드
    public static void guild(){
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        Integer[] fear = new Integer[people];
        for (int i = 0; i < people; i++){
            fear[i] = sc.nextInt();
        }
        Arrays.sort(fear, Collections.reverseOrder());
        int start = 0;
        int group = 0;
        while(start != people) {
            if (fear[start] <= people - start){
                start += fear[start];
                group++;
            }else {
                start++;

            }

        }
        System.out.println(group);
    }
    
    //이것이 코딩테스트다 p.312 곱하기 혹은 더하기
    public static void multOrPlus(){
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        int start = 0;
        for (int i = 0; i < num.length(); i++){
            int next = Integer.parseInt(num.substring(i, i+1));
            if(start * next > start + next){
                start = start * next;
            }else {
                start = start + next;
            }
        }

        System.out.println(start);
    }

    //이것이 코딩테스트다 p.313 문자열 뒤집기
    public static int reverseString(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int numOfOne = 0;
        int numOfZero = 0;

        ArrayList<Integer> continuousOne = new ArrayList<Integer>();
        ArrayList<Integer> continuousZero = new ArrayList<Integer>();

        String previous = "-";
        int continuous = 0;

        for (int i = 0; i < str.length(); i++){
            if(str.substring(i, i+1).equals("1")){
                numOfOne++;
                if(previous.equals("-") || previous.equals("1"))
                    continuous++;
                else{
                    continuousZero.add(continuous);
                    continuous = 1;
                }
                previous = "1";
                if (i == str.length()-1){
                    continuousOne.add(continuous);
                }
            } else {
                numOfZero++;
                if(previous.equals("-") || previous.equals("0"))
                    continuous++;
                else{
                    continuousOne.add(continuous);
                    continuous = 1;
                }
                previous = "0";
                if (i == str.length()-1){
                    continuousZero.add(continuous);
                }
            }

        }

        Collections.sort(continuousOne, Collections.reverseOrder());
        Collections.sort(continuousZero, Collections.reverseOrder());


        int result = 0;

        if (numOfOne > numOfZero){
            int subtract = numOfOne - numOfZero;
            for (int i = 0; i < continuousOne.size(); i++){
                subtract -= continuousOne.get(i);
                result++;
                if(subtract <= 0){
                    return result;
                }
            }
            return -1;
        } else if (numOfOne < numOfZero){
            int subtract = -numOfOne + numOfZero;
            for (int i = 0; i < continuousZero.size(); i++){
                subtract -= continuousZero.get(i);
                result++;
                if(subtract <= 0){
                    return result;
                }
            }
            return -1;

        }
        return 0;




    }

    //이것이 코딩테스트다 p.314 만들 수 없는 금액
    public static void cantmake(){
        Scanner sc = new Scanner(System.in);
        int numOfCoins = sc.nextInt();
        Integer coins[] = new Integer[numOfCoins];

        for (int i = 0; i < numOfCoins; i++){
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins, Collections.reverseOrder());

        int money = 1;

        while(true) {

            for (int i = 0; i < numOfCoins; i++) {
                if (money < coins[numOfCoins])
                    continue;

            }
        }

    }

    public static void main(String args[]){
        cantmake();
    }
}
