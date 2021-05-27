package app;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

public class Realization {

    public static void main(String args[]){
        gameDevelop();
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

    //이것이 코딩테스트다 p.115 왕실의 나이트
    static void knightOfKingdom(){
        Scanner sc = new Scanner(System.in);
        String start = sc.nextLine();
        int col = Character.getNumericValue(start.charAt(0)) - Character.getNumericValue('a') + 1;
        int row = Integer.parseInt(start.substring(1));

        int[][] steps={{-2, -1}, {-2, 1}, {2, -1}, {2, 1} ,{1, -2}, {-1, -2}, {1, 2}, {-1, 2}};

        int result = 0;

        for (int[] arr : steps){
            int movedStatusX;
            int movedStatusY;

            movedStatusX = col + arr[1];
            movedStatusY = row + arr[0];

            if (movedStatusX < 1 || movedStatusY < 1 || movedStatusY > 8 || movedStatusX > 8){
                continue;
            } else {
                result++;
            }

        }
        System.out.println(result);

    }

    //이것이 코딩 테스트다 p.119 게임 개발
    static void gameDevelop(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];

        int nowCol = sc.nextInt();
        int nowRow = sc.nextInt();
        int lookForward = sc.nextInt();
        int[][] forward = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        map[nowCol][nowRow] = 0;

        int cantMove = 0;
        int move = 1;

        while (true) {
            lookForward = (lookForward + 3) % 4;
            int col = nowCol + forward[lookForward][1];
            int row = nowRow + forward[lookForward][0];
            if (col >= 0 && col < n && row >= 0 && row < m) {
                if (map[col][row] == 1) {
                    cantMove++;
                    if (cantMove == 3) {
                        break;
                    }
                    continue;
                } else {
                    map[nowCol][nowRow] = 1;
                    nowCol = col;
                    nowRow = row;
                    cantMove = 0;
                    move++;
                }
            }else {
                cantMove++;
                if (cantMove == 3) {
                    break;
                }
            }

        }


        System.out.println(move);


    }
}
