package com.interviewBitScaler.Graph.Template;

import java.util.ArrayList;
import java.util.Map;

public class dfsTraversal {

    static void traverseDFS(Map<Integer, ArrayList<Integer>> adjancencyList, int[] visited, int node){
        if(visited[node] != 1){
            visited[node] = 1;
            System.out.println(node);
            for( Integer element : adjancencyList.get(node)){
//                System.out.println("Element"+element);
                traverseDFS(adjancencyList,visited,element);
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
        Map<Integer, ArrayList<Integer> > adjacencyList = graph.generateAdjancencyList_Of_Map(arr);

        System.out.println("------DFS------");
        int[] visitedDfs = new int[arr.length+1];
        traverseDFS(adjacencyList,visitedDfs,arr[0].x);

    }

}
