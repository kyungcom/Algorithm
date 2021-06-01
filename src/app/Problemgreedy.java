package app;

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

    public static void main(String args[]){
        guild();
    }
}
