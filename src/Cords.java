public class Cords {
    private int x,y;

    public Cords(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void setX(int x){
        this.x=x;
        System.out.println("X set to" + x);
    }

    public void setY(int y){
        this.y=y;
        System.out.println("Y set to" + y);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
