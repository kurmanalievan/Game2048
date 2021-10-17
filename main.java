import processing.core.*;

public class Main extends PApplet {
    int[][] array = new int[4][4];
    static int score = 0;
    static int maxScore = 0;
    int goalValue;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        textSize(100);
        fill(255, 0, 255);
        textAlign(CENTER);
        text("Game2048", 100, 600);
        frameRate(15);

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
    public static int getScore() {
        maxScore += score;
        score = 0;
        return maxScore;
    }
    public static boolean youWon(){
        return Game2048.getGoal() <= getScore();
    }

    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == UP) {
                setRandomValue();
                mergeUp();
                moveUp();
            }
            if (keyCode == LEFT) {
                setRandomValue();
                mergeLeft();
                moveLeft();
            }
            if (keyCode == RIGHT) {
                setRandomValue();
                mergeRight();
                moveRight();
            }
            if (keyCode == DOWN) {
                setRandomValue();
                mergeDown();
                moveDown();
            }
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

    public void draw() {
        background(0, 0, 0);
        if (keyPressed) {
            if (key == '+' ){
                Game2048.incGoal();
            }else if (key == '-') {
                Game2048.decGoal();
            }
        }
        textSize(50);
        fill(0, 100, 255);
        text("Goal", width / 6, height / 3);
        text("Score", 1000, height / 3);
        textSize(20);
        text("Control: Arrows. Change Goal: +, -", 600, 650 );
        textSize(50);
        fill(255);
        text(Game2048.getGoal(), width / 6, height / 2);
        text(getScore(), 1000, height / 2);
        fill(255, 0, 150);
        text("Game 2048", 600, 100);
        fill(57);
        int x = 400;
        int y = 200;
        int z = 100;
        int max = 0;
        int color = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                strokeWeight(10);
                stroke(187);
                square(x, y, z);
                int val = array[i][j];
                if (array[i][j] != 0) {
                    if (array[i][j] > max){
                        max = array[i][j];
                        fill(117 + color);
                        square(x, y, z);
                         color += 20;
                    }else{
                        fill(117);
                        square(x, y, z);
                    }
                    textAlign(CENTER);
                    textSize(50);
                    fill(255);
                    text(val, x + z / 2, y + z /2);

                }
                x += z;
                fill(57);

            }
            x = 400;
            y += z;
            if (youWon()){
                noStroke();
                fill(255, 255);
                rect(250, 300, 700, 200);
                fill(57);
                text("You are a winner!", 600, 400);
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

}
