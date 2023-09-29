package com.nilsw;
import com.nilsw.Neighborhood;
import java.util.Random;
import java.util.Stack;



public class MazeGenerator {
    private int rows, cols;
    private char[][] maze;
    private Random random = new Random();

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        maze = new char[rows][cols];
    }
 // -----------------------------------------------------------------------------------------------------------
    public void generateMaze() {
        

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = '#';
                
                
            }
            
        } // ___________FIN DE BOUCLE-For__________





        // CREATION DE LA PILE
        Stack<Cell> stack = new Stack<>();
        int startX = 1;
        int startY = 1;
        int endX = rows - 1;
        int endY = cols - 2; // !!!!!!!!!!!!!!!!!!!!!!! 

        maze[startX][startY] = '.';
        maze[endX][endY] = '.';

        
        

        stack.push(new Cell(startX, startY));

        while (!stack.isEmpty()) {
            Cell currentCell = stack.peek();
            int x = currentCell .x;
            int y = currentCell.y;

            // RECUPERER VOISINS NON VISITES
            Cell[] neighbors = Neighborhood.getUnvisitedNeighbors(x, y, maze, rows, cols);

            if (neighbors.length > 0) {
                // CHOISIR VOISIN NON VISITER AU HASARD
                Cell randomNeighbor = neighbors[random.nextInt(neighbors.length)];

                int nx = randomNeighbor.x;
                int ny = randomNeighbor.y;

                // DETRUIRE MUR ENTRE CELLULE COURANTE ET VOISIN CHOISIS
                maze[(x + nx) / 2][(y + ny) / 2] = '.';
                maze[nx][ny] = '.';

                // MARQUER LE VOISIN CHOISIS COMME VISITER ET PUSH DANS LA PILE
                stack.push(randomNeighbor);
            } else {
                // SI PAS DE VOISINS NON VISITER, RETOUR EN ARRIERE
                stack.pop();
            }
        } // --------------------------------------------FIN PUBLIC VOID generateMaze()---------------------------------------------------------------





        
    }  


        

       
        
        
         


    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }// --------------------------------------------FIN PUBLIC VOID printMaze()---------------------------------------------------------------

}

