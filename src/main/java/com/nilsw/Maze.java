package com.nilsw;



public class Maze {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar mazerunner-1.0-SNAPSHOT.jar [largeur > 5] [hauteur > 5]");
            System.exit(0);
        }
        int r = Integer.parseInt(args[0]);
        int c = Integer.parseInt(args[1]);

        if ( r < 5 || c <5){
            System.out.println("Erreur : Veuillez fournir une largeur et une hauteur valides supérieurs à 5.");
            System.out.println("Usage: java -jar mazerunner-1.0-SNAPSHOT.jar [largeur >= 5] [hauteur >= 5]");
            System.exit(0);
        }
        
        

        int rows = r * 3;
        int cols = r * 3;


        MazeGenerator mazeGenerator = new MazeGenerator(rows, cols);
        mazeGenerator.generateMaze();
        mazeGenerator.printMaze();
    }
       
        

        

    }
    
         

        

        
    
    
