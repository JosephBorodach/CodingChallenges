package src.main.leatcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class wordSearch {
    public List<String> wordSearch(char[][] board, String[] words) {
        List<String> returnList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            List<List<Integer>> indexesVisited = new ArrayList<>();
            String str = words[i];
            int j = 0;
            while (j < str.length()) {
                // create a method that returns a two d array list containing any indexes of lists where the value appears and where in each list the value appears
                List<List<Integer>> list = whereExists(str.charAt(j), board);
                if (list.isEmpty()) {
                    i++;
                } else {
                    for (int k = 0; k < list.size(); k++) {
                        List<Integer> subList = list.get(k);
                        if (validNext(board, subList.get(0), subList.get(1), str.charAt(j+1))) {
                            indexesVisited.add(subList);
                            j++;
                        }
                    }
                }
            }
        }
        return returnList;
    }

    // track visited letter
    private static boolean validNext(char[][] board, int i, int j, char c) {
        // right
        char[] subBoard = board[i];
        if (j+1 < subBoard.length && subBoard[j+1] == c) {
            return true;
        }
        // left
        else if (j-1 >= 0 && subBoard[j-1] == c) {
            return true;
        }
        // up
        else if (i-1 >= 0 && board[i-1][j] == c) {
            return true;
        }
        // down
        else if (i+1 < board.length && board[i+1][j] == c) {
            return true;
        }
        return false;
    }

    private static List<List<Integer>> whereExists(char c, char[][] board) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            List<char[]> subList = Arrays.asList(board[i]);
            if (subList.contains(c)) {
                list.add(Arrays.asList(i, subList.indexOf(c)));
            }
        }
        return list;
    }
}
