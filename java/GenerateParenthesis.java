class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0, 0, n, "", result);
        return result;
    }
    public void helper(int left, int right, int n, String sublist, List<String> result) {
        if (left == n && right ==n)
            result.add(sublist);
        if (left < n) {
            helper(left + 1, right, n, sublist + "(", result);
        }
        if (right < n && right < left) {
            helper(left, right + 1, n, sublist + ")", result);
        }
    } 
}
