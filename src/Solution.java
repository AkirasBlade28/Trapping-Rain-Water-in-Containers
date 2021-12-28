/*<Taken from leetcode.com>
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1 
 * compute how much water it can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 */
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class Solution {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] n = {0,1,2,0,4,0,4,9,8};
		int [] n1 = {3,0,1,2,3,4,3,2,1,7,1};
		int [] n2 = {4,2,0,3,2,5};
		int [] n3 = {0,1,0,2,1,0,1,3,2,1,2,1};
		int [] n4 = {0,1,2,3,4,0,6,9,8};
		
		System.out.println(fillingWater(n4));
	}
	public static int fillingWater (int[] nums) {
		int countWaterDrops = 0;
		int leftPillar = 0;
		int rightPillar = 0;
		int nextNumber = 0;
		
		for(int i=0; i<nums.length; ++i) {
			int isItLeftPillar = nums[i];
			for(int p=i+1; p<nums.length;) { // number next to LP, element +1
				nextNumber = nums[p];
				break;
			}
			if(isItLeftPillar>nextNumber) {
				for(int p=i+2; p<nums.length; ++p) { 
					int isItRightPillar = nums[p];
					if(isItRightPillar >= isItLeftPillar) {
						leftPillar = isItLeftPillar;
						rightPillar = isItRightPillar;
						//now we should have Pillars that can hold water
						for(int q=i+1; nums[q] < rightPillar; ++q) {
							int measureWater = nums[q];
							while(measureWater < leftPillar) {
								++measureWater;
								++countWaterDrops;
							}
							nums[q] = measureWater;
						}		
					}
				}	
			}
		}
		
		return countWaterDrops;
	}
}
