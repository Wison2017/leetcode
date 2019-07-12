class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] box = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            box[i] = new HashMap<Integer, Integer>();
        }
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                char num = board[x][y];
                if (num != '.') {
                    int index_of_box = x/3*3 + y/3;
                    int n = (int)num;
                    if (!isValid(rows[x], n)) return false;
                    if (!isValid(cols[y], n)) return false;
                    if (!isValid(box[index_of_box], n)) return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(HashMap<Integer, Integer> map, int n) {
        if (map.containsKey(n))
            return false;
        map.put(n, 1);
        return true;
    }
}

