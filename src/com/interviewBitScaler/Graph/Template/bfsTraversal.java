package com.interviewBitScaler.Graph.Template;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;


public class bfsTraversal {


    static void traverseBFS(Map<Integer, ArrayList<Integer>> adjancencyList, int[] visited, int node){

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int peek = queue.poll();

                if(visited[peek] != 1){
                    visited[peek] = 1;
                    System.out.println(peek);
                    ArrayList<Integer> neighnourList = adjancencyList.get(peek);
                    for(int index=0;index<neighnourList.size();index++){
                        queue.offer(neighnourList.get(index));
                    }
//                    neighnourList.forEach(element -> queue.offer(element));
                }

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

        System.out.println("------BFS------");
        int[] visitedBfs = new int[arr.length+1];
        traverseBFS(adjacencyList,visitedBfs,arr[0].x);
    }
}
