package com.interviewBitScaler.Graph.Template;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class GraphRepresentation {

    static int maxNode = 9;
    public static void main(String[] args) {
        GraphRepresentation graph = new GraphRepresentation();
        // Create Graph
        Pair[] arr = graph.getGraph();

        // LIST OF LIST ->  create adjacencyList
        LinkedList<LinkedList<Integer>> adjacencyList_ListOfList = graph.generateAdjancencylist_ListOfList(arr);
        System.out.println("Print graph : list of List");
        graph.printGraph(adjacencyList_ListOfList);

        // Array Of Linked List -> create adjacencyList
        LinkedList<Integer>[] adjacencyList_ListOfArray = graph.generateAdjancencylist_ArrayOfLinkedList(arr);
        System.out.println("Print graph : Array of List");
        graph.printGraph(adjacencyList_ListOfArray);

        //Map of Integer and List -> create adjacencyList
        System.out.println("Print graph : list of map");
        Map<Integer, ArrayList<Integer>> adjancencyList_of_map = graph.generateAdjancencyList_Of_Map(arr);
        graph.printGraph(adjancencyList_of_map);


        //create adjacencyMatrix
        System.out.println("Print graph : matrix of 2D Array");
        int[][] adjacencyMatrix = graph.generateAdjancencyMatrix_Array(arr);
        graph.printGraph(adjacencyMatrix);

    }

    //List of LinkedList
    LinkedList<LinkedList<Integer>> generateAdjancencylist_ListOfList(Pair[] arr){
        LinkedList<LinkedList<Integer>> adj = new LinkedList<LinkedList<Integer>>();

        for (int i = 0; i < maxNode; i++) {
            adj.add(new LinkedList < Integer > ());
        }

        for(int i=0;i<arr.length;i++){
            Pair pair = arr[i];
            adj.get(pair.x).add(pair.y);
            adj.get(pair.y).add(pair.x);
        }

        return adj;
    }


    //Array of linkedlist
    LinkedList<Integer>[] generateAdjancencylist_ArrayOfLinkedList(Pair[] arr){
        LinkedList<Integer>[] adj = new LinkedList[maxNode];

        for (int i = 0; i < maxNode; i++) {
            adj[i] = new LinkedList<>();
        }

        for(int i=0;i<arr.length;i++){
            Pair pair = arr[i];
            adj[pair.x].add(pair.y);
            adj[pair.y].add(pair.x);
        }

        return adj;
    }

    //MAP <Integer, ArrayList>
    Map<Integer, ArrayList<Integer>> generateAdjancencyList_Of_Map(Pair[] arr){
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

    //2D Array
    int[][] generateAdjancencyMatrix_Array(Pair[] arr){
        int n = maxNode;
        int[][] adjacencyMatrix = new int[n+1][n+1];
        for(int i=0;i<arr.length;i++){
            Pair pair = arr[i];
            adjacencyMatrix[pair.x][pair.y] =1;
            adjacencyMatrix[pair.y][pair.x] =1;
        }
        return adjacencyMatrix;
    }


    void printGraph( LinkedList<LinkedList<Integer>>  adjacencyList){
        int i=0;
        for(LinkedList<Integer> list : adjacencyList){
            System.out.print(i++ + " = ");
            System.out.println(list);
        }
    }

    void printGraph( LinkedList<Integer>[] adjacencyList){
        int i=0;
        for(LinkedList<Integer> list : adjacencyList){
            System.out.print(i++ + " = ");
            System.out.println(list);
        }
    }


    void printGraph(Map<Integer, ArrayList<Integer>> adjacencyList){
        for(Map.Entry<Integer, ArrayList<Integer>> entry : adjacencyList.entrySet()){
            System.out.println(entry);
        }
    }

    void printGraph(int[][] adjacencyList){
        for (int i=0;i<adjacencyList.length;i++){
            System.out.print("[");
            for(int j=0;j<adjacencyList[0].length;j++){
                    System.out.print(adjacencyList[i][j] + ", ");
            }
            System.out.println("]");
        }
    }

    public Pair[] getGraph(){
//                1 - 2- 3 - 4
//                 \    / \
//                   5      6
//                     \     \
//                      7     8
        Pair[] arr = {
                new Pair(1,2),
                new Pair(2,3),
                new Pair(3,4),
                new Pair(1,5),
                new Pair(3,5),
                new Pair(3,6),
                new Pair(5,7),
                new Pair(6,8)
        };
        return arr;
    }



}
