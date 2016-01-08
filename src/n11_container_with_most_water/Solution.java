package n11_container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0, left = 0, n = height.length, right = n-1;
        while(left < right){
        	int area = (right - left) * (height[left] < height[right]? height[left] : height[right]);
        	if(max < area) max = area;
        	if(height[left] < height[right])
        		left++;
        	else if(height[left] > height[right])
        		right--;
        	else{
        		left++;
        		right--;
        	}
        }
        return max;
    }
}