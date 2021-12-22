package com.interviewBitScaler.Graph.Template;

import java.util.*;

public class GraphRepresentation {

    public static void main(String[] args) {
        GraphRepresentation graph = new GraphRepresentation();
        // Create Graph
        Pair[] arr = graph.getGraph();
        //create adjacencyList
        Map<Integer, ArrayList<Integer>> adjacencyList = graph.generateAdjancencyMatrix(arr);
        //create adjacencyMatrix
        int[][] adjacencyMatrix = graph.generateAdjancencylist(arr);
        //Print graph
        graph.printGraph(adjacencyList);
    }

    Map<Integer, ArrayList<Integer>> generateAdjancencyMatrix(Pair[] arr){
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

    int[][] generateAdjancencylist(Pair[] arr){
        int n = arr.length;
        int[][] adjacencyMatrix = new int[n+1][n+1];
        for(int i=0;i<arr.length;i++){
            Pair pair = arr[i];
            adjacencyMatrix[pair.x][pair.y] =1;
            adjacencyMatrix[pair.y][pair.x] =1;
        }
        return adjacencyMatrix;
    }

    void printGraph(Map<Integer, ArrayList<Integer>> adjacencyList){
        for(Map.Entry<Integer, ArrayList<Integer>> entry : adjacencyList.entrySet()){
            System.out.println(entry);
        }
    }
    public Pair[] getGraph(){
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
        return arr;
    }



}
