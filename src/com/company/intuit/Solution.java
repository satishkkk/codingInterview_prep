package com.company.intuit;

// Do not remove these imports. You may add others if you wish.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    // If you need extra classes, you can define them privately here within class Solution
  /*
    Args:
      weaknesses: a String, one character for each cookie weakness.
      grid: a char[][] describing the map layout, one char per room

    Returns:
      An int, how many time units it will take the Cookie Monster to reach you.
  */
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int timeToEscape(String weaknesses, char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        Set<Character> weaknessSet = new HashSet<>();
        for (int i = 0; i < weaknesses.length(); i++) {
            weaknessSet.add(weaknesses.charAt(i));
        }

        int[][] costMatrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '.') {
                    costMatrix[i][j] = 1;
                } else if (grid[i][j] == 'M') {
                    costMatrix[i][j] = 0;
                } else if (grid[i][j] == 'Y') {
                    costMatrix[i][j] = 1;
                } else if (weaknessSet.contains(grid[i][j])) {
                    costMatrix[i][j] = 5;
                } else {
                    costMatrix[i][j] = 2;
                }
            }
        }
        return shortestPath(costMatrix, row, col);
    }

    static boolean isInsideGrid(int i, int j, int ROW_MAX, int COL_MAX) {
        return (i >= 0 && i < ROW_MAX &&
                j >= 0 && j < COL_MAX);
    }

    static class Cell {
        int x;
        int y;
        int distance;

        Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    // Custom comparator for inserting cells
// into Priority Queue
    static class distanceComparator
            implements Comparator<Cell> {
        public int compare(Cell a, Cell b) {
            if (a.distance < b.distance) {
                return -1;
            } else if (a.distance > b.distance) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    // top-corner to bottom-corner in 2D grid
    static int shortestPath(int[][] grid, int maxRow,
                            int maxCol) {
        int[][] dist = new int[maxRow][maxCol];

        // Initializing distance array by INT_MAX
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // Initialized source distance as
        // initial grid position value
        dist[0][0] = grid[0][0];

        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(
                maxRow * maxCol, new distanceComparator());

        // Insert source cell to priority queue
        pq.add(new Cell(0, 0, dist[0][0]));
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            for (int i = 0; i < 4; i++) {
                int rows = curr.x + dx[i];
                int cols = curr.y + dy[i];

                if (isInsideGrid(rows, cols, maxRow, maxCol)) {
                    if (dist[rows][cols] >
                            dist[curr.x][curr.y] +
                                    grid[rows][cols]) {

                        // If Cell is already been reached once,
                        // remove it from priority queue
                        if (dist[rows][cols] != Integer.MAX_VALUE) {
                            Cell adj = new Cell(rows, cols,
                                    dist[rows][cols]);

                            pq.remove(adj);
                        }

                        // Insert cell with updated distance
                        dist[rows][cols] = dist[curr.x][curr.y] +
                                grid[rows][cols];

                        pq.add(new Cell(rows, cols,
                                dist[rows][cols]));
                    }
                }
            }
        }
        return dist[maxRow - 1][maxCol - 1];
    }

    // DO NOT MODIFY MAIN()
    public static void main(String[] args) {
        String arg0 = "";
        List<String> input_strings = new ArrayList<String>();

        String line;
        boolean first_arg = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }

                if (first_arg) {
                    arg0 = line;
                    first_arg = false;
                } else {
                    input_strings.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        char[][] grid = new char[input_strings.size()][input_strings.get(0).length()];
        for (int i = 0; i < input_strings.size(); i++) {
            grid[i] = input_strings.get(i).toCharArray();
        }

        System.out.println(timeToEscape(arg0, grid));

    }
}

