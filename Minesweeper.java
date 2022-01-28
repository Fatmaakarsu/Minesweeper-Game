import java.util.Random;
import java.util.Scanner;

/**
 * Minesweeper
 */
public class Minesweeper {

    int row;
    int col;
    int numberOfMine;
    int[][] map;
    int[][] board;
    boolean game = true;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    Minesweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.map = new int[row][col];
        this.board = new int[row][col];
        this.numberOfMine = (row * col) / 4;
    }

    public void run() {
        int roW, coL, success=0;
        prepareGame();
        print(map);
        System.out.println("Oyun Başladı !");

        // mayın bulana kadar oyun calıssın.
        while (game) {
            print(board);
            System.out.print("Row : ");
            roW = scan.nextInt();
            System.out.print("Col : ");
            coL = scan.nextInt();
            if (map[roW][coL] != -1) {
                checkMine(roW, coL);
                success++;
                if(success == row*col - numberOfMine){
                    System.out.println("You made it ! ");
                    break;
                }
            } else {
                game = false;
                System.out.println("Game Over !");
            }
        }
    }

    public void checkMine(int r, int c) {
        if (map[r][c] == 0) {
            if ((c<col-1)&&(map[r][c + 1] == -1)) {
                board[r][c]++;
            }
            if ((c>0)&&(map[r][c - 1] == -1)) {
                board[r][c]++;
            }
            if ((r>0)&&(map[r - 1][c] == -1)) {
                board[r][c]++;
            }
            if ((r<row-1)&&(map[r + 1][c] == -1)) {
                board[r][c]++;
            }

            if(board[r][c]==0){
                board[r][c]=-2;
            }
        }

    }

    public void prepareGame() {
        int randRow, randCol, count = 0;
        while (count != numberOfMine) {
            randRow = rand.nextInt(row);
            randCol = rand.nextInt(col);
            if (map[randRow][randRow] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}