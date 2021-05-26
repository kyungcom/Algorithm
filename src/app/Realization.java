package app;

import java.util.Scanner;

public class Realization {

    public static void main(String args[]){
        sight();
    }
    
    //이것이 코딩테스트다 p.110 상하좌우
    static void upDownLeftRight(){
        Scanner sc = new Scanner(System.in);
        int mapSize = Integer.parseInt(sc.nextLine());

        int[] first = {1, 1};

        String[] movement = sc.nextLine().split(" ");

        for (int i = 0; i < movement.length; i++){
            switch (movement[i]){
                case "R":
                    if(first[1] < mapSize)
                        first[1] += 1;
                    break;
                case "L":
                    if (first[1] > 1)
                        first[1] -= 1;
                    break;
                case "U":
                    if (first[0] > 1)
                        first[0] -= 1;
                    break;
                case "D":
                    if (first[0] < mapSize)
                        first[0] +=1;
                    break;
                default:
                    System.out.println(i+"번째 잘못입력하셨습니다.");
                    break;
            }
        }
        System.out.println(first[0]+" "+first[1]);
    }
    
    //이것이 코딩테스트다 P.113 시각
    static void sight(){
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int result = 0;

        for (int i = 0; i <= hour; i ++){
            for (int j = 0; j < 60; j++){
                for (int k = 0; k < 60; k++){
                    String time = Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
                    if (time.indexOf("3") > -1){
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
