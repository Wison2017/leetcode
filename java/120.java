import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        List<Integer> result = new ArrayList<>(triangle.get(triangle.size() - 1));
        for (int row = (triangle.size() - 2); row >= 0; row--) {
            for (int col = 0; col <= (triangle.get(row).size() - 1); col++) {
                int min = triangle.get(row).get(col) + Math.min(result.get(col), result.get(col + 1));
                result.set(col, min);
            }
        }
        return result.get(0);
    }
}