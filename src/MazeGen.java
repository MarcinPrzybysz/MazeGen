import java.util.*;

class MazeGen {
    private int width, height;
    private boolean[] neighbours = new boolean[4]; //top, right, bottom, left
    private boolean[][] mazeBorders;
    private Cords c = new Cords(0,0);
    private Stack<Cords> path = new Stack();
    private Cell[][] maze;


    MazeGen(int width, int height) {
        this.width = width;
        this.height = height;
        maze = new Cell[width][height];
        mazeBorders = new boolean[2 * width + 1][2 * height + 1];
    }

    void generate(){
        ImgGen img = new ImgGen(width, height);
        path.push(c);

        for(int x=0; x<mazeBorders.length; x=x+2){
            for(int y=0; y<mazeBorders[0].length; y++){
                mazeBorders[x][y] = true;
            }
        }
        for(int x=1; x<mazeBorders.length; x=x+2){
            for(int y=0; y<mazeBorders[0].length; y=y+2){
                mazeBorders[x][y] = true;
            }
        }

        for(int x=0; x<width; x++){
            for(int y=0; y<height; y++){
                maze[x][y] = new Cell();
            }
        }

        unvisitedNeighbours(maze, c.getX(), c.getY());

        maze[c.getX()][c.getY()].setVisited();
        unvisitedNeighbours(maze, c.getX(), c.getY());

        while(!path.isEmpty()) {
            unvisitedNeighbours(maze, c.getX(), c.getY());
            while (hasNeighbour(neighbours)) {
                c = new Cords(c.getX(), c.getY());

                int next = randomNeighbour();
                if (next == 0) {
                    mazeBorders[c.getX() * 2][c.getY() * 2 + 1] = false;
                    c.setX(c.getX() - 1);
                }
                if (next == 1) {
                    mazeBorders[c.getX() * 2 + 1][c.getY() * 2 + 2] = false;
                    c.setY(c.getY() + 1);
                }
                if (next == 2) {
                    mazeBorders[c.getX() * 2 + 2][c.getY() * 2 + 1] = false;
                    c.setX(c.getX() + 1);
                }
                if (next == 3) {
                    mazeBorders[c.getX() * 2 + 1][c.getY() * 2] = false;
                    c.setY(c.getY() - 1);

                }
                maze[c.getX()][c.getY()].setVisited();
                path.push(c);
                unvisitedNeighbours(maze, c.getX(), c.getY());
            }
            c.setX(path.peek().getX());
            c.setY(path.peek().getY());

            path.pop();
        }

        img.editImg(mazeBorders);
        img.saveImg();
    }


    private void unvisitedNeighbours(Cell[][] maze, int x, int y) {
        neighbours[0]=false;
        neighbours[1]=false;
        neighbours[2]=false;
        neighbours[3]=false;

            if(  !( (x-1<0) || maze[x-1][y].getVisited() ) ){
                neighbours[0]=true;
            }
            if(  !( (y+1>maze.length-1) || maze[x][y+1].getVisited() ) ){
                neighbours[1]=true;
            }
            if(  !( (x+1>maze[0].length-1) || maze[x+1][y].getVisited() ) ){
                neighbours[2]=true;
            }
            if(  !( (y-1<0) || maze[x][y-1].getVisited() ) ){
                neighbours[3]=true;
            }
   }

    private int randomNeighbour(){
       int random;
        do{
            random=(int)((Math.random()*100)%4);
        }while(!neighbours[random]);
        return random;
   }

    private boolean hasNeighbour(boolean[] neighbours){
        int sum=0;
        for (boolean neighbour : neighbours) {
            if (neighbour) {
                sum++;
            }
        }
        return sum != 0;
    }

}
