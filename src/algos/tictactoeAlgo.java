package algos;

import utils.*;
import java.util.ArrayList;
import java.util.Random;

public class tictactoeAlgo {
    public static Character PLAYER = 'X';
    public static Character BOT = 'O';
    // int noOfComparision=0;

    public static wonUtil checkHorizontal(ArrayList<Character> origBoard, Character player) {
        Boolean chek = true;
        for (int i = 0; i < 3; i++) {
            int winningPairs[] = new int[3];
            int k = 0;
            chek =true;
            for (int j = 0; j < 3; j++) {
                if (origBoard.get(i*3 +j) != player) {
                    chek = false;
                    break;
                }
                winningPairs[k++]= i*3 +j;
            }
            if(chek){
                // displayWinningTripplets(winningPairs);
                wonUtil obj = new wonUtil(true, winningPairs);
                return obj;
            }
        }
        wonUtil obj = new wonUtil(false);
        return obj;
    }

    public static wonUtil checkVertical(ArrayList<Character> origBoard, Character player) {
        Boolean chek = true;
        for (int i = 0; i < 3; i++) {
            int winningPairs[] = new int[3];
            int k = 0;
            chek =true;
            for (int j = 0; j < 3; j++) {
                if (origBoard.get(j * 3 + i) != player) {
                    chek = false;
                    break;
                }
                winningPairs[k++]= j*3 +i;
            }
            if(chek){
                wonUtil obj = new wonUtil(true, winningPairs);
                return obj;
            }
        }
        wonUtil obj = new wonUtil(false);
        return obj;
    }

    public static wonUtil checkDiagnol(ArrayList<Character> origBoard, Character player) {
        Boolean chek =true;
        int winningPairs[] = new int[3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            if (origBoard.get(i * 3 + i) != player) {
                chek = false;
                break;
            }
            winningPairs[k++]= i*3 +i;
        }
        if(chek){
            wonUtil obj = new wonUtil(true, winningPairs);
            // System.out.println(winningPairs);
            return obj;
        }
        chek = true;
        k=0;
        for (int i = 0; i < 3; i++) {
            if (origBoard.get(i * 3 + (2 - i)) != player) {
                chek = false;
                break;
            }
            winningPairs[k++]= i * 3 + (2 - i);
        }
        if(chek){
            wonUtil obj = new wonUtil(true, winningPairs);
            return obj;
        }
        wonUtil obj = new wonUtil(false);
        return obj;
    }

    public static wonUtil checkWin(ArrayList<Character> origBoard, Character player) {
        wonUtil hori  =  checkHorizontal(origBoard, player);
        if (hori.won) {
            return hori;
        }
        wonUtil verti =  checkVertical(origBoard, player);
        if(verti.won){
            return verti;
        }
        wonUtil diag  =  checkDiagnol(origBoard, player);
        return diag;
    }

    public static ArrayList<Integer> emptyCells(ArrayList<Character> origBoard) {
        ArrayList<Integer> empCells = new ArrayList<Integer>();
        for (int i = 0; i < origBoard.size(); i++) {
            if (origBoard.get(i) == ' ') {
                empCells.add(i);
            }
        }   
        return empCells;
    }

    public static Boolean checkTie(ArrayList<Character> origBoard) {
        if(emptyCells(origBoard).size() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    /* public static MinMaxUtil miniMax(ArrayList<Character> dummy, Boolean isMaximizer) {
        // noOfComparision += 1;
        ArrayList<Integer> empList = emptyCells(dummy);

        MinMaxUtil score = new MinMaxUtil(0, -1);
        if (checkWin(dummy, PLAYER).won) {
            score.setScore(-10);
            return score;
        }else if (checkWin(dummy, BOT).won) {
            score.setScore(20);
            return score;
        }else if(empList.size() == 0){
            return score;
        }

        ArrayList<MinMaxUtil> moves = new ArrayList<MinMaxUtil>();

        for (int i = 0; i < empList.size(); i++) {
            MinMaxUtil move = new MinMaxUtil();
            move.setIndex(empList.get(i));

            if (isMaximizer) {
                // dummy.set(empList.get(i), BOT);
                dummy.set(empList.get(i), BOT);
                MinMaxUtil sc = miniMax(dummy, false);
                move.setScore(sc.getScore());
            }else{
                dummy.set(empList.get(i), PLAYER);
                // dummy.get(i).setText(PLAYER);
                MinMaxUtil sc = miniMax(dummy, true);
                move.setScore(sc.getScore());
            }

            dummy.set(empList.get(i), ' ');
            // dummy.get(i).setText("");
            moves.add(move);
        }

        int bestMove = -1;
        if (isMaximizer) {
            int bestScore = Integer.MIN_VALUE;
            for (int j = 0; j < moves.size(); j++) {
                if (moves.get(j).getScore() > bestScore) {
                    bestScore = moves.get(j).getScore();
                    bestMove = j;
                }
            }
        }else{
            int bestScore = Integer.MAX_VALUE;
            for (int j = 0; j < moves.size(); j++) {
                if (moves.get(j).getScore() < bestScore) {
                    bestScore = moves.get(j).getScore();
                    bestMove = j;
                }
            }
        }

        return moves.get(bestMove);
    }
 */
    
    public static MinMaxUtil miniMax(ArrayList<Character> dummy, Boolean isMaximizer) {
        // noOfComparision += 1;

        // System.out.print(isMaximizer);        ////
        MinMaxUtil score = new MinMaxUtil(0, -1);
        if (checkWin(dummy, PLAYER).won) {
            score.setScore(-10);
            return score;
        }else if (checkWin(dummy, BOT).won) {
            score.setScore(20);
            return score;
        }

        ArrayList<Integer> empList = emptyCells(dummy);
        if(empList.size() == 0){
            return score;
        }

        int bestMove = -1;
        int bestScore = 0;

        if(isMaximizer){
            bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < empList.size(); i++) {
                dummy.set(empList.get(i), BOT);
                MinMaxUtil sc = miniMax(dummy,false);
                
                if(sc.getScore() > bestScore){
                    bestScore = sc.getScore();
                    bestMove = empList.get(i);
                }
                dummy.set(empList.get(i), ' ');
            }
        }else{
            bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < empList.size(); i++) {
                dummy.set(empList.get(i), PLAYER);
                MinMaxUtil sc = miniMax(dummy,true);

                if(sc.getScore() < bestScore){
                    bestScore = sc.getScore();
                    bestMove = empList.get(i);
                }
                dummy.set(empList.get(i), ' ');
            }
        }
        // System.out.println();
        return new MinMaxUtil(bestScore, bestMove);
    }

    public static MinMaxUtil EasyAlgo(ArrayList<Character> dummy, Boolean isMaximizer) {
        ArrayList<Integer> empList = emptyCells(dummy);
        Random rand = new Random();
        Integer randomIndex = rand.nextInt(empList.size());
        
        if(empList.size()>0)
            return new MinMaxUtil(0, empList.get(randomIndex));
        else
            return new MinMaxUtil(0, -1);
    }
}
