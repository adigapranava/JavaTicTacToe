package utils;

public class MinMaxUtil {
    private int score;
    private int index;

    public MinMaxUtil(){
        score = 0;
        index = -1;
    }

    // constructor
    public MinMaxUtil(int score, int index) {
        this.score = score;
        this.index = index;
    }

    // getter
    public int getScore() { return score; }
    public int getIndex() { return index; }
    // setter

    public void setScore(int score) { this.score = score; }
    public void setIndex(int index) { this.index = index; }

    @Override
    public String toString() {
        return "Index: "+ getIndex()+" Score: "+ getScore();
    }
}
