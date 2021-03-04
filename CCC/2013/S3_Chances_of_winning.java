import java.util.*;

public class Main {
    public static int fTeam = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        fTeam = scan.nextInt();
        int[] points = new int[]{0,0,0,0};
        int gamesPlayed = scan.nextInt();
        int[][] games = new int[][]{{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}};
        for (int i = 0; i < gamesPlayed; i++) {
            int[] cGame = new int[4];
            for (int j = 0; j < 4; j++) {
                cGame[j] = scan.nextInt();
            }
            if (cGame[2] == cGame[3]) {
                points[cGame[0]-1]++;
                points[cGame[1]-1]++;
            }
            points[cGame[0]-1]+=(cGame[2] > cGame[3]) ? 3: 0;
            points[cGame[1]-1]+=(cGame[3] > cGame[2]) ? 3: 0;
            if (cGame[0] > cGame[1]) {
                int temp = cGame[0];
                cGame[0] = cGame[1];
                cGame[1] = temp;
            }
            for (int j = 0; j < games.length; j++) {
                if (games[j][0] == cGame[0] && games[j][1] == cGame[1])
                    games[j] = new int[]{0,0};
            }
        }
        int[][] remainingGames = new int[6-gamesPlayed][2];
        int index = 0;
        for (int i = 0; i < 6; i++) {
            if (0 != games[i][0] && 0 != games[i][1]) {
                remainingGames[index][0] = games[i][0];
                remainingGames[index][1] = games[i][1];
                index++;
            }
        }
        System.out.println(winCount(remainingGames, points, remainingGames.length-1));
    }
    public static int winCount(int[][] games, int[] scores, int depth) {
        int out = 0;
        if (depth < 0) {
            int max = 0;
            for (int i = 0; i < 4; i++) {
                if (scores[max] == scores[i] && max == fTeam-1 && i != 0)
                    return 0;
                if (scores[max] < scores[i])
                    max = i;
            }
            if (max + 1 == fTeam)
                return 1;
            return 0;
        }
        int[] temp = new int[4];
        System.arraycopy(scores, 0, temp, 0, scores.length);
        temp[games[depth][1]-1]+=3;
        out += winCount(games, temp, depth-1);
        temp[games[depth][1]-1]-=3;

        temp[games[depth][0]-1]+=3;
        out += winCount(games, temp, depth-1);
        temp[games[depth][0]-1]-=3;

        temp[games[depth][0]-1]+=1;
        temp[games[depth][1]-1]+=1;
        out += winCount(games, temp, depth-1);

        return out;
    }
}