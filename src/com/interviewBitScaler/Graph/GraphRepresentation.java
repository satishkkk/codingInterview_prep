package com.interviewBitScaler.Graph;

import java.util.*;

public class GraphRepresentation {

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) {

//                1 - 2- 3 - 4
//                 \    / \
//                   5      6
//                     \     \
//                      7     8

        Pair[] arr = {
                new Pair(1,2), new Pair(2,3),
                new Pair(3,4), new Pair(1,5),
                new Pair(3,5), new Pair(3,6),
                new Pair(5,7), new Pair(6,8)
        };
        int[][] adjacencyMatrix = generateAdjancencylist(arr);
        Map<Integer, ArrayList<Integer> > adjacencyList = generateAdjancencyMatrix(arr);
        System.out.println("------DFS------");
        int[] visitedDfs = new int[arr.length+1];
        traverseDFS(adjacencyList,visitedDfs,arr[0].x);
        System.out.println("------BFS------");
        int[] visitedBfs = new int[arr.length+1];
        traverseBFS(adjacencyList,visitedBfs,arr[0].x);
    }

    static int[][] generateAdjancencylist(Pair[] arr){
        int n = arr.length;
        int[][] adjacencyMatrix = new int[n+1][n+1];
        for(int i=0;i<arr.length;i++){
            Pair pair = arr[i];
            adjacencyMatrix[pair.x][pair.y] =1;
            adjacencyMatrix[pair.y][pair.x] =1;
        }
        return adjacencyMatrix;
    }

    static Map<Integer, ArrayList<Integer>> generateAdjancencyMatrix(Pair[] arr){
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            Pair pair = arr[i];
            if(!map.containsKey(pair.x)){
                map.put(pair.x,new ArrayList<>());
            }
            if(!map.containsKey(pair.y)){
                map.put(pair.y,new ArrayList<>());
            }
            map.get(pair.x).add(pair.y);
            map.get(pair.y).add(pair.x);
        }
        return map;
    }

    static void traverseDFS(Map<Integer, ArrayList<Integer>> adjancencyMatrix,int[] visited,int node){
        if(visited[node] != 1){
            visited[node] = 1;
            System.out.println(node);
            for( Integer element : adjancencyMatrix.get(node)){
//                System.out.println("Element"+element);
                traverseDFS(adjancencyMatrix,visited,element);
            }
        }

    }

    static void traverseBFS(Map<Integer, ArrayList<Integer>> adjancencyList,int[] visited,int node){

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int peek = queue.poll();
                if(visited[peek] != 1){
                    visited[peek] = 1;
                    System.out.println(peek);
                    ArrayList<Integer> arr = adjancencyList.get(peek);
                    arr.forEach(ele -> queue.offer(ele));
                }

            }
        }

    }


}
