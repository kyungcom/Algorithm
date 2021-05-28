package app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DFSANDBFS {
    public static void main(String args[]){
        System.out.println(factorial(5));
        System.out.println();

        int[][] graph = {{0, 1, 1, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 1, 0}, {1, 0, 0, 1, 1, 0, 0, 0}, {0, 0, 1, 0, 1, 0, 0, 0},
                         {0, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1, 0}};
        int[] visited = new int[graph.length];

        dfs(graph, 0, visited);
        ArrayList<Integer> newVisited = new ArrayList<Integer>();

        for(int i : visited)
            newVisited.add(i);

        for(int i = 1; i <= graph.length; i++)
            System.out.print(newVisited.indexOf(i)+1 + " ");



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
}
