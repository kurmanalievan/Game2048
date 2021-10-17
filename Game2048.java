import java.util.Scanner;

public class Game2048 {
    static final int[] GOALS = {16, 32, 64, 128, 256, 512, 1026 ,2048};
    int[][] array = new int[4][4];
    static int score;
    static int maxScore ;
    int goalValue;
    static int goalIndex = GOALS.length - 1;

    public static int getGoal() {
        return GOALS[goalIndex];
    }

    public static void incGoal(){
        if (goalIndex == GOALS.length - 1){
            goalIndex = 0;
        }else {
             ++goalIndex;
        }
    }

    public static void decGoal() {
        if (goalIndex == 0){
            goalIndex = GOALS.length - 1;
        }else {
            --goalIndex;
        }
    }

    public void mergeLeft() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int c = j + 1; c < 4;) {
                    if (array[i][c] == 0) {
                        c++;
                    } else {
                        if (array[i][j] == array[i][c]) {
                            array[i][j] += array[i][c];
                            array[i][c] = 0;
                            score = array[i][j];

                        }
                       break;
                    }
                }
            }
        }
    }

    public void mergeUp() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int c = j + 1; c < 4;) {
                    if (array[c][i] == 0) {
                        c++;
                    } else {
                        if (array[j][i] == array[c][i]) {
                            array[j][i] += array[c][i];
                            array[c][i] = 0;
                            score = array[j][i];

                        }
                        break;
                    }
                }
            }
        }
    }

    public void mergeRight() {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                for (int c = j - 1; c > -1;) {
                    if (array[i][c] == 0) {
                        c--;
                    } else {
                        if (array[i][j] == array[i][c]) {
                            array[i][j] += array[i][c];
                            array[i][c] = 0;
                            score = array[i][j];
                        }
                        break;
                    }
                }

            }

        }

    }

    public void mergeDown() {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > -1; j--) {
                for (int c = j - 1; c > -1;) {
                    if (array[c][i] == 0) {
                        c--;
                    } else {
                        if (array[j][i] == array[c][i]) {
                            array[j][i] += array[c][i];
                            array[c][i] = 0;
                            score = array[j][i];

                        }
                        break;
                    }
                }
            }
        }
    }

    public void moveLeft() {
        int c = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] == 0) {
                    c++;
                } else if (c != 0) {
                    int t = array[i][j];
                    array[i][j] = array[i][j - c];
                    array[i][j - c] = t;
                }
            }
            c = 0;
        }
    }

    public void moveUp() {
        int c = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[j][i] == 0) {
                    c++;
                } else if (c != 0) {
                    int t = array[j][i];
                    array[j][i] = array[j - c][i];
                    array[j - c][i] = t;
                }
            }
            c = 0;
        }
    }

    public void moveRight() {
        int c = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > -1; j--) {
                if (array[i][j] == 0) {
                    c++;
                } else if (c != 0) {
                    int t = array[i][j];
                    array[i][j] = array[i][j + c];
                    array[i][j + c] = t;
                }
            }
            c = 0;
        }

    }

    public void moveDown() {
        int c = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > -1; j--) {
                if (array[j][i] == 0) {
                    c++;
                } else if (c != 0) {
                    int t = array[j][i];
                    array[j][i] = array[j + c][i];
                    array[j + c][i] = t;
                }

            }
            c = 0;
        }
    }

    public void setRandomValue() {
        int x = (int) (Math.random() * 4);
        int y = (int) (Math.random() * 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[x][y] == 0) {
                    array[x][y] = 2;
                }
            }
        }
    }

    public boolean checkWinConditions() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] == 0) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void quitGame() {
        System.exit(0);
    }

    public static int getScore() {
        maxScore += score;
        score = 0;
        return maxScore;
    }

    public static boolean youWon(){
        return getGoal() == getScore();
    }

}

