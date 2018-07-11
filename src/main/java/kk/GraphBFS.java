package kk;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphBFS {
    LinkedList[] vertices;
    final int WEIGHT = 6;
    public static void main(String[] args) {
        GraphBFS t = new GraphBFS();
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        for (int j = 0; j < q; j++) {
            int v = s.nextInt();
            int e = s.nextInt();

            t.vertices = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                t.vertices[i] = new LinkedList<Integer>();
            }

            for (int i = 0; i < e; i++) {
                t.vertices[s.nextInt() - 1].add(s.nextInt() - 1);
            }

            //t.traverse(s.nextInt());
            //System.out.println(Arrays.toString(t.shortestReach(s.nextInt())));
            int[] arr = t.shortestReach(s.nextInt());
            for (int i : arr) {
                if (i != 0)
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    private int[] shortestReach(int startv) {
        startv--;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] distances = new int[vertices.length];
        Arrays.fill(distances,-1);
        queue.add(startv);
        distances[startv] = 0;

        while (!queue.isEmpty()){
            int s = queue.poll();

            Iterator<Integer> itr = vertices[s].listIterator();
            while (itr.hasNext()){
                int n = itr.next();
                if(distances[n]==-1) {
                    queue.add(n);
                    distances[n] = distances[s] + WEIGHT;
                }
            }
        }
        return distances;
    }

    private void traverse(int startv) {
        startv--;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[vertices.length];
        queue.add(startv);
        visited[startv] = true;

        while (!queue.isEmpty()){
            int s = queue.poll();
            System.out.print(s+1 + " ");
            Iterator<Integer> itr = vertices[s].listIterator();
            while (itr.hasNext()){
                int n = itr.next();
                if(visited[n]!=true) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }
}
