
public class Driver{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data2.dat");//true animates the maze.
        
        f.setAnimate(false);
        f.solve();

        System.out.println(f);
    }
}
