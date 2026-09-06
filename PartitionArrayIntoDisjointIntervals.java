/*
Leetcode 915: https://leetcode.com/problems/partition-array-into-disjoint-intervals/
*/
public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] nums) {
        int currentMax = nums[0];
        int possibleMax = nums[0];
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (currentMax > nums[i]) {
                length = i + 1;
                currentMax = Math.max(currentMax, possibleMax);
            } else {
                possibleMax = Math.max(possibleMax, nums[i]);
            }
        }
        return length;
    }
}