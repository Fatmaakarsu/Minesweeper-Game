public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Game !");
        System.out.println("Please enter the dimensions you want to play !");
        Minesweeper mineSweeper = new Minesweeper(3,3);
        mineSweeper.run();
    }
}
