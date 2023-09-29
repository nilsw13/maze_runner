package com.example;

import java.util.Random;
import java.util.Stack;

public class MazeGenerator {
    private int rows, cols;
    private char[][] maze;
    private Random random = new Random();

    public MazeGenerator(int rows, int cols) {          // A METTRE DANS L4INTERFACE
        this.rows = rows ;
        this.cols = cols;
        maze = new char[rows][cols];
    }

    public void generateMaze() {
        // Initialize maze with walls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = '#';
            }
        }

        // Create a stack for DFS
        Stack<Cell> stack = new Stack<>();
        int startX = 1;
        int startY = 1;

        // Mark the starting cell as visited
        maze[startX][startY] = ' ';

        stack.push(new Cell(startX, startY));

        while (!stack.isEmpty()) {
            Cell currentCell = stack.peek();
            int x = currentCell.x;
            int y = currentCell.y;

            // Get unvisited neighbors
            Cell[] neighbors = getUnvisitedNeighbors(x, y);

            if (neighbors.length > 0) {
                // Choose a random unvisited neighbor
                Cell randomNeighbor = neighbors[random.nextInt(neighbors.length)];

                int nx = randomNeighbor.x;
                int ny = randomNeighbor.y;

                // Remove the wall between the current cell and the chosen neighbor
                maze[(x + nx) / 2][(y + ny) / 2] = ' ';
                maze[nx][ny] = ' ';

                // Mark the chosen neighbor as visited and push it to the stack
                stack.push(randomNeighbor);
            } else {
                // If no unvisited neighbors, backtrack
                stack.pop();
            }
        }

        // Set entrance and exit
        
        maze[0][1] = 'E';
        maze[rows - 1][cols - 2] = '.';
    }

    private Cell[] getUnvisitedNeighbors(int x, int y) {
        int[][] directions = {{2, 0}, {-2, 0}, {0, 2}, {0, -2}};
        int count = 0;
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && maze[nx][ny] == '#') {
                count++;
            }
        }
        Cell[] neighbors = new Cell[count];
        int index = 0;
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && maze[nx][ny] == '#') {
                neighbors[index] = new Cell(nx, ny);
                index++;
            }
        }
        return neighbors;
    }

    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int r = 15;
        int c = 15;

        int rows = r * 3;
        int cols = r * 3;


        MazeGenerator mazeGenerator = new MazeGenerator(rows, cols);
        mazeGenerator.generateMaze();
        mazeGenerator.printMaze();
    }

    private class Cell {
        int x, y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

