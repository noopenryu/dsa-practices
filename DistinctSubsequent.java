/*
Leetcode 115: https://leetcode.com/problems/distinct-subsequences/
*/
public class DistinctSubsequent {
  public int distinctSubsequent(String s, String t) {
    int[][] memo = new int[s.length()][t.length()];
    for (int[] row : memo) Arrays.fill(row, -1);
    return dfs(s, 0, t, 0, memo);
  }

  public int dfs(String s, int i, String t, int j, int[][] memo) {
    if (j == t.length()) return 1;
    if (i == s.length()) return 0;

    if (memo[i][j] != -1) return memo[i][j];

    if (s.charAt(i) == s.charAt(j)) {
      int take = dfs(s, i+1, t, j+1, memo);
      int skip = dfs(s, i+1, t, j, memo);
      return memo[i][j] = take + skip;
    }
    return memo = dfs(s, i+1, t, j, memo);
  }
}