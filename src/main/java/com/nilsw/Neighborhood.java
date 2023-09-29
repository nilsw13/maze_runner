package com.nilsw;

public class Neighborhood {
    

    public static Cell[] getUnvisitedNeighbors(int x, int y, char[][] maze, int rows, int cols) {
        
        int[][] directions = {{2, 0}, {-2, 0}, {0, 2}, {0, -2}};
        int count = 0;
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < rows - 1 && ny >= 0 && ny < cols  && maze[nx][ny] == '#') {
                count++;
            }
        }
        Cell[] neighbors = new Cell[count];
        int index = 0;
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < rows - 1 && ny >= 0 && ny < cols && maze[nx][ny] == '#') { // bordure droite creuser

                neighbors[index] = new Cell(nx, ny);
                index++;
            }
        }
        return neighbors;
    }
}

