package com.interviewBitScaler.LectureXX_Graph1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    int vertex;
    LinkedList<Integer> list[];

    public Graph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i <vertex ; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){

        //add edge
        list[source].addFirst(destination);

        //add back edge ((for undirected)
        list[destination].addFirst(source);
    }

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            if(list[i].size()>0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
    }


    static int[] visited;
    static LinkedList<Integer> list1[];

//    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
//        int n = B.size();
//        list1 = new LinkedList[n];
//        visited = new int[n];
//
//        for(int i=0;i<maxn;i++){
//            adj.get(i).add(new ArrayList<Integer>());
//        }
//
//        for(ArrayList<Integer> pair : B){
//            adj.get(pair.get(0)).add(pair.get(1));
//        }
//        if(isRechable(1,A))
//            return true;
//        return false;
//    }
}