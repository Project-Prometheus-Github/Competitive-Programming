import java.util.*;

/*
 *  CCC: 15/15
 *  DMOJ: 80/80 (1.187s, 59.08 MB)
 *  Problem Type: Graph Theory, 2D Array Manipulation
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(solve());
    }
    public static int solve() {
        Scanner scan = new Scanner(System.in);
        int[][] board = new int[8][8];
        int[][] pMoves = {{2,-1},{2,1},{-2,-1},{-2,1},{1,-2},{1,2},{-1,-2},{-1,2}};
        for (int i = 0; i < 8; i++) {
            for (int I = 0; I < 8; I++) {
                board[i][I] = 0;
            }
        }
        int x = scan.nextInt()-1, y = scan.nextInt()-1;
        board[x][y] = 1;
        int gx = scan.nextInt()-1, gy = scan.nextInt()-1;
        if (gx == x && gy == y) {
            return 0;
        }
        board[gx][gy] = 2;
        int moves = 0;
        while (true) {
            moves++;
            for (int i = 0; i < 8; i++) {
                for (int I = 0; I < 8; I++) {
                    if (board[i][I] == 1) {
                        //System.out.println(i + " " + I);
                        for(int p = 0; p < 8; p++) {
                            if (i+pMoves[p][0]<8 && i+pMoves[p][0]>=0 && I+pMoves[p][1]<8 && I+pMoves[p][1]>=0) {
                                //System.out.println("huh");
                                if (board[i+pMoves[p][0]][I+pMoves[p][1]] == 2) {
                                    return moves;
                                }
                                if (board[i+pMoves[p][0]][I+pMoves[p][1]] == 0) {
                                    board[i + pMoves[p][0]][I + pMoves[p][1]] = 3;
                                }
                            }
                        }
                        board[i][I] = 4;
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int I = 0; I < 8; I++) {
                    if (board[i][I] == 3) {
                        board[i][I] = 1;
                    }

                    //System.out.print(board[i][I]+" ");
                }
                //System.out.println();
            }
            //System.out.println();
        }
    }
}
