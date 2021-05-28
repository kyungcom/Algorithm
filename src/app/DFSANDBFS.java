package app;

import java.util.Queue;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class DFSANDBFS {
    public static void main(String args[]){
        System.out.println(factorial(5));
        System.out.println();

        int[][] graph = {{0, 1, 1, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 1, 0}, {1, 0, 0, 1, 1, 0, 0, 0}, {0, 0, 1, 0, 1, 0, 0, 0},
                         {0, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1, 0}};
        int[] visited = new int[graph.length];

        bfs(graph, 0, visited);
        ArrayList<Integer> newVisited = new ArrayList<Integer>();

        for(int i : visited)
            newVisited.add(i);

        for(int i = 1; i <= graph.length; i++)
            System.out.print(newVisited.indexOf(i)+1 + " ");

       // icecaekky();
        exitMaze();
    }

    //이것이 코딩테스트다 P.132 팩토리얼
    static int factorial(int n){
        if(n < 0){
            System.out.println("잘못 입력하셨습니다.");
            return -1;
        }
        if (n == 1 || n == 0)
            return 1;
        else
            return n * factorial(n-1);
    }

    //이것이 코딩테스트다 p.142 DFS예제
    static void dfs(int[][] graph, int v, int[] visited){
        if (visited[v] == 0){
            int max = 0;
            for (int i = 0; i <visited.length; i++){
                if (max < visited[i]){
                    max = visited[i];
                }
            }

            visited[v] = max+1;

            ArrayList<Integer> childNode = new ArrayList<Integer>();

            for (int i = 0; i < graph[v].length; i++){
                if(graph[v][i] == 1){
                    if (visited[i] == 0){
                        childNode.add(i);
                    }
                }
            }

            for (int i = 0; i < childNode.size(); i++){
                dfs(graph, childNode.get(i), visited);
            }
        }
    }

    //이것이 코딩테스트다 p.147 BFS예제
    static void bfs(int[][] graph, int v, int[] visited){
        if (visited[v] == 0){
            Queue<Integer> queue=new LinkedList<Integer>();

            queue.offer(v);
            int max = 0;
            for (int i = 0; i <visited.length; i++){
                if (max < visited[i]){
                    max = visited[i];
                }
            }
            visited[v] = max+1;

            while (!queue.isEmpty()){
                int x = queue.poll();

                for (int i = 0; i < graph[x].length; i++){
                    if(graph[x][i] == 1){
                        if (visited[i] == 0){
                            queue.offer(i);
                            max = 0;
                            for (int j = 0; j <visited.length; j++){
                                if (max < visited[j]) max = visited[j];
                            }
                            visited[i] = max+1;
                        }
                    }
                }
            }
        }

    }

    //이것이 코딩테스트다 p.149 음료수 얼려먹기
    static void icecaekky(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] iceCreamMold = new int[n][m];

        for (int i = 0; i < n; i++){
            String line = sc.nextLine();
            for (int j = 0; j < m; j++){
                iceCreamMold[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (icedfs(i, j, iceCreamMold))
                    result++;
            }
        }

        System.out.println(result);

    }

    static boolean icedfs(int i, int j, int[][] arr){
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length)
            return false;
        if (arr[i][j] == 0){
            arr[i][j] = 1;
            icedfs(i - 1, j, arr);
            icedfs(i + 1, j, arr);
            icedfs(i, j - 1, arr);
            icedfs(i, j + 1, arr);
            return true;
        }
        return false;
    }
    
    //이것이 코딩 테스트다 p.152 미로탈출
    static void exitMaze(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] iceCreamMold = new int[n][m];

        for (int i = 0; i < n; i++){
            String line = sc.nextLine();
            for (int j = 0; j < m; j++){
                iceCreamMold[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        mazeDFS(0, 0, iceCreamMold);
        System.out.println(iceCreamMold[n-1][m-1]);

    }

    static void mazeDFS(int i, int j, int[][] arr){
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] start = {i, j};
        queue.offer(start);

        while (!queue.isEmpty()){
            int[] location = queue.poll();

            int col = location[0];
            int row = location[1];

            int[][] nextLoc = {{col+1, row}, {col-1, row}, {col, row+1}, {col, row-1}};

            for (int[] next:nextLoc){
                if(next[0] < 0 || next[1] < 0 || next[0] >= arr.length || next[1] >= arr[0].length)
                    continue;
                else {
                    if (arr[next[0]][next[1]] == 1){
                        arr[next[0]][next[1]] = arr[col][row] + 1;
                        queue.offer(next);
                    }
                }
            }
        }
    }

}
