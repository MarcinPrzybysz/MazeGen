import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class MazeGen {
    int width, length;
    int currentX = 0;
    int currentY = 0;
    int next;
    public boolean[] neighbours = new boolean[4]; //top, right, bottom, left
    Stack<Cell> path = new Stack();



    public MazeGen(int width, int length) {
        this.width=width;
        this.length=length;

        Cell[][] maze = new Cell[width][length];



        for(int x=0; x<width; x++){
            for(int y=0; y<length; y++){
                maze[x][y] = new Cell(x,y);
            }
        }

        printCells(maze);

        unvisitedNeighbours(maze, currentX, currentY);



        System.out.println("");
        for(int i=0; i<neighbours.length; i++){
            System.out.print(neighbours[i]+ " ");
        }
        System.out.println("");

        System.out.println("ma sąsiadów?: "+hasNeighbour(neighbours));

        maze[currentX][currentY].setVisited();
        unvisitedNeighbours(maze, currentX, currentY);

      while(hasNeighbour(neighbours)) {

          maze[currentX][currentY].setVisited();
          System.out.println("hasNeighbours ?????   "+ hasNeighbour(neighbours));
          next = randomNeighbour();
          if (next == 0) {
              currentX = currentX - 1;
          }
          if (next == 1) {
              currentY = currentY + 1;
          }
          if (next == 2) {
              currentX = currentX + 1;
          }
          if (next == 3) {
              currentY = currentY - 1;
          }
          System.out.println("");
          printCells(maze);
          unvisitedNeighbours(maze, currentX, currentY);
         // System.out.println("hasNeighbours "+ hasNeighbour(neighbours));

      }


        System.out.println("KONIEC");
        printCells(maze);


    }


    private void unvisitedNeighbours(Cell[][] maze, int x, int y) {
        System.out.println("Current Cell :"+x+", "+y+": ");
        neighbours[0]=false;
        neighbours[1]=false;
        neighbours[2]=false;
        neighbours[3]=false;

            if(  !( (x-1<0) || maze[x-1][y].getVisited() ) ){
                neighbours[0]=true;
                System.out.print("top, ");
            }
            if(  !( (y+1>maze.length-1) || maze[x][y+1].getVisited() ) ){
                neighbours[1]=true;
                System.out.print("right, ");
            }
            if(  !( (x+1>maze[0].length-1) || maze[x+1][y].getVisited() ) ){
                neighbours[2]=true;
                System.out.print("bot, ");
            }
            if(  !( (y-1<0) || maze[x][y-1].getVisited() ) ){
                neighbours[3]=true;
                System.out.print("left, ");
            }

        System.out.print("sąsiedzi: ");
        for(int i=0; i<neighbours.length; i++){
            System.out.print(neighbours[i]+ " ");
        }
        System.out.println();

   }



    private int randomNeighbour(){
       int random;
        do{
            random=(int)((Math.random()*100)%4);
        }while(neighbours[random]==false);
        return random;
   }

    private void printCells(Cell[][] maze){
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){

                if(maze[i][j].getVisited()){
                    System.out.print("1 ");
                }else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }


    public boolean hasNeighbour(boolean[] neighbours){
        int sum=0;
        for(int i=0; i<neighbours.length; i++){
            if(neighbours[i]) {
                System.out.println("TUTAJ");
                sum = sum + 1;
            }
        }
        System.out.println("suma: " +sum);
        if(sum==0){
            System.out.println("nie ma sąsiadów");
            return false;
        }else {
            return true;
        }
    }



}
