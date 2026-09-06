/*
Leetcode 3904: https://leetcode.com/problems/smallest-stable-index-ii
*/
class SmallestStableIndex {
  public int firstStableIndex(int[] nums, int k) {
    int n = nums.length;
    int[] smallestInRange = new int[n];
    smallestInRange[n-1] = nums[n-1];
    for (int i=n-2; i>=0; --i) {
        smallestInRange[i] = Math.min(nums[i], smallestInRange[i+1]);
    }
    int maxInRange = -1;
    for (int i=0; i<n; ++i) {
        maxInRange = Math.max(nums[i], maxInRange);
        if (maxInRange - smallestInRange[i] > k) {
            continue;
        }
        return i;
    }
    return -1;
  }
}