package com.interviewBitScaler.Graph;

import java.util.*;

public class FindPath {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(1,2)));
        B.add(new ArrayList<>(Arrays.asList(4,1)));
        B.add(new ArrayList<>(Arrays.asList(2,4)));
        B.add(new ArrayList<>(Arrays.asList(3,4)));
        B.add(new ArrayList<>(Arrays.asList(5,2)));
        B.add(new ArrayList<>(Arrays.asList(1,3)));

        System.out.println(solve(5,B));
    }



    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {

        int[] visited = new int[A+1];

        Map<Integer, LinkedList<Integer>> adjList = new HashMap<>();

        for(int i=0;i<B.size();i++){
            if(!adjList.containsKey(B.get(i).get(0))){
                adjList.put(B.get(i).get(0),new LinkedList<>());
            }
            adjList.get(B.get(i).get(0)).add(B.get(i).get(1));
        }

        return isValidPath(1, A, adjList ,  visited) ? 1:0;

    }


    public static boolean isValidPath(int sourceNode , int destinationNode, Map<Integer, LinkedList<Integer>> adjList , int[] visited){
        // 1. Create queue and add first element
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(sourceNode);

        // 2. iterate through queue until queue is empty
        while( !queue.isEmpty() ){
            // iterate through the all elements in the queue
            int n = queue.size();
            for(int i=0;i<n;i++){
                // fetch the element from the queue
                int peek = queue.poll();
                //Process the element in the queue
                if(peek == destinationNode) return true;
                // check if already processed by checking visited array if not then process it
                if(visited[peek] != 1){
                    visited[peek] =1;
                    if(adjList.containsKey(peek)){
                        LinkedList<Integer> neighbours =  adjList.get(peek);
                        for(Integer elemnt : neighbours) {
                            queue.offer(elemnt);
                        }
                    }
                }
            }
        }
        // for loop to add neighbour element
        return false;
    }
//    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
//
//        List<Integer> adjList[] = new ArrayList[A+1];
//
//        for(int i=0;i<adjList.length;i++){
//            adjList[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < B.size(); i++) {
//            adjList[B.get(i).get(0)].add(B.get(i).get(1));
//        }
//
//        int[] visited = new int[A+1];
//
//        return dfs(1,A,visited,adjList) ? 1:0;
//    }
//
//    public static boolean dfs(int current, int destination,int[] visited,List<Integer> adjList[] ){
//        if(current == destination) return true;
//        visited[current]=1;
//        boolean reached = false;
//
//        for( int i=1;i<adjList.length;i++){
//            List<Integer> list = adjList[i];
//            for(Integer val : list)
//            {
//                if(reached)
//                    return reached;
//                else if(visited[val+1] == 0){
//                    reached = dfs(val+1,destination,visited,adjList);
//                }
//            }
//        }
//        return reached;
//    }


//BFS

//    static int maxn = 100009;
//    static int[] visited = new int[maxn];
//    static ArrayList < ArrayList < Integer > > adj;
//
//    public int solve1(int A, ArrayList<ArrayList<Integer>> B) {
//
//        adj = new ArrayList < ArrayList < Integer > > (maxn);
//
//        for (int i = 0; i < maxn; i++) {
//            visited[i] = 0;
//            adj.add(new ArrayList < Integer > ());
//        }
//
//        for (ArrayList<Integer> edge: B)
//            adj.get(edge.get(0)).add(edge.get(1));
//
//        return isReachable(1, A) ? 1 :0;
//
//    }
//    public static boolean isReachable(int s, int d) {
//        if (s == d) return true; //base conditions
//
//        Queue< Integer > q = new ArrayDeque< >();
//        q.offer(s);
//
//        visited[s] = 1;
//
//        while (q.size() != 0) {
//            s = q.poll();
//
//            for (int v: adj.get(s)) {
//                if (v == d) return true;
//                if (visited[v] == 0) {
//                    visited[v] = 1;
//                    q.offer(v);
//                }
//            }
//        }
//        return false;
//    }


}
