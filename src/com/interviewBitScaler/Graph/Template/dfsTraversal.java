package com.interviewBitScaler.Graph.Template;

import java.util.ArrayList;
import java.util.Map;

public class dfsTraversal {

    static void traverseDFS(Map<Integer, ArrayList<Integer>> adjancencyMatrix, int[] visited, int node){
        if(visited[node] != 1){
            visited[node] = 1;
            System.out.println(node);
            for( Integer element : adjancencyMatrix.get(node)){
//                System.out.println("Element"+element);
                traverseDFS(adjancencyMatrix,visited,element);
            }
        }
    }

    public static void main(String[] args) {
//                1 - 2- 3 - 4
//                 \    / \
//                   5      6
//                     \     \
//                      7     8
        GraphRepresentation graph = new GraphRepresentation();
        Pair[] arr = graph.getGraph();
        Map<Integer, ArrayList<Integer> > adjacencyList = graph.generateAdjancencyMatrix(arr);

        System.out.println("------DFS------");
        int[] visitedDfs = new int[arr.length+1];
        traverseDFS(adjacencyList,visitedDfs,arr[0].x);

    }

}
