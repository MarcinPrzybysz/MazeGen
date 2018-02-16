import java.util.*;

public class MazeGen {
    int width, length;
    boolean[] neighbours = new boolean[4]; //top, right, bottom, left
    Stack<Cell> path = new Stack();


    public MazeGen(int width, int length) {
        this.width=width;
        this.length=length;

        Cell[][] maze = new Cell[width][length];
        boolean[] neighbours = new boolean[4]; //top, right, bottom, left




        for(int i=0; i<width; i++){
            for(int j=0; j<length; j++){
                maze[i][j] = new Cell(i,j);
            }
        }

        maze[0][9].setVisited();
        maze[2][2].setVisited();

        printCells(maze);



        for(int i=1; i<2; i++){
            for(int j=0; j<maze[0].length; j++){
                unvisitedNeighbours(maze,i,j);
                System.out.print(i+ ", "+ j+ ": " );
                for(int x=0; x<neighbours.length; x++){
                   // System.out.print(neighbours[x]+ " ");
                }
                System.out.println();
            }
        }





    }


    private void unvisitedNeighbours(Cell[][] maze, int i, int j) {
        System.out.print("sąsiedzi :"+i+", "+j+": ");
        neighbours[0]=false;
        neighbours[1]=false;
        neighbours[2]=false;
        neighbours[3]=false;

            if(  !( (i-1<0) || !maze[i-1][j].getVisited() ) ){
                neighbours[0]=true;
                System.out.print("top, ");
            }
            if(  !( (j+1>maze.length-1) || !maze[i][j+1].getVisited() ) ){
                neighbours[1]=true;
                System.out.print("right, ");
            }
            if(  !( (i+1>maze[0].length-1) || !maze[i+1][j].getVisited() ) ){
                neighbours[2]=true;
                System.out.print("bot, ");
            }
            if(  !( (j-1<0) || !maze[i][j-1].getVisited() ) ){
                neighbours[3]=true;
                System.out.print("left, ");
            }
        System.out.println();
        for(int x=0; x<neighbours.length; x++){
            System.out.print(neighbours[x]+ " ");
        }
   }


    private void printCells(Cell[][] maze){
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                System.out.print(maze[i][j].getVisited() + "\t");
            }
            System.out.println();
        }
    }


}
