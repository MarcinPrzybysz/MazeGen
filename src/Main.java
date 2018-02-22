public class Main {

    public static void main(String[] args) {
        int width = 70;
        int length =70;

        MazeGen maze = new MazeGen(width, length);
        maze.generate();
    }
}
