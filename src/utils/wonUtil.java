package utils;

public class wonUtil {
    public Boolean won = false;
    public int winningTriplets[] = new int[3];

    public wonUtil(Boolean won){
        this.won = won;
    }

    public wonUtil(Boolean won, int winningTriplets[]){
        this.won = won;
        for (int i = 0; i < winningTriplets.length; i++) {
            this.winningTriplets[i] = winningTriplets[i];
        }
    }
}
