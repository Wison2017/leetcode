import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Character END_OF_WORD = '*';
    HashSet<String> result = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0 || words == null) {
            return new ArrayList<>(result);
        }
        HashMap<Character, HashMap> root = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            HashMap<Character, HashMap> node = root;
            for (int i = 0; i < length; i++) {
                if (node.containsKey(word.charAt(i))) {
                    node = node.get(word.charAt(i));
                } else {
                    HashMap<Character, HashMap> next = new HashMap<>();
                    node.put(word.charAt(i), next);
                    node = next;
                }
            }
            node.put(END_OF_WORD, null);
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (root.containsKey(board[x][y])) {
                    dfs(board, new String(""), x, y, flag, root);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, String cur_word, int cur_x, int cur_y, boolean[][] flag, HashMap<Character, HashMap> root) {
        cur_word = cur_word + board[cur_x][cur_y];
        HashMap<Character, HashMap> cur_map = root.get(board[cur_x][cur_y]);
        flag[cur_x][cur_y] = true;
        if (cur_map.containsKey(END_OF_WORD)) {
            result.add(cur_word);
        }
        for (int i = 0; i < directions.length; i++) {
            int x = cur_x + directions[i][0];
            int y = cur_y + directions[i][1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                    && flag[x][y] == false && cur_map.containsKey(board[x][y])) {
                dfs(board, cur_word, x, y, flag, cur_map);
            }
        }
        flag[cur_x][cur_y] = false;
    }
}
