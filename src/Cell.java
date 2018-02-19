public class Cell {
    public int x,y;
    boolean visited;

    public Cell(int x, int y){
        this.x=x;
        this.y=y;
        visited = false;
    }

    public void setVisited(){
        visited=true;
    }

    public boolean getVisited(){
        return visited;
    }


}
