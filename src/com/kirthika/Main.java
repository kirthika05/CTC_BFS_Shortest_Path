package com.kirthika;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int t = 0; t < q; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] graph = new int[n][n];
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                graph[u][v] = 1;
                graph[v][u] = 1;
            }

            int startId = scanner.nextInt() - 1;
            printDistances(calculateDistance(graph, startId), startId);
        }
        scanner.close();
    }

    private static int[] calculateDistance(int[][] graph, int startId){
        int[] distances = new int[graph.length];
        for (int i = 0; i < distances.length; i++) distances[i] = -1;
        distances[startId] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startId);

        while (!queue.isEmpty()) {
            int id = queue.poll();
            for (int j = 0; j < graph.length; j++) {
                if (distances[j] >= 0 || graph[id][j] == 0) continue;
                distances[j] = distances[id] + 6;
                queue.offer(j);
            }
        }
        return distances;
    }

    private static void printDistances(int[] distances, int startId) {
        String separator = "";
        for (int i = 0; i < distances.length; i++) {
            if (i == startId) continue;
            System.out.print(separator + distances[i]);
            separator = " ";
        }
        System.out.println();
    }



}
