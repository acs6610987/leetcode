package n42_trapping_rain_water;

public class Solution {
    public int trap(int[] height) {
    	if(height.length == 0) return 0;
        int left = 0, right = height.length - 1, barArea = 0, totalArea = 0, curHeight = 0;
        for(int i = 0; i < height.length; i++)
        	barArea += height[i];
        while(left < right){
        	if(height[left] >= height[right]){
        		totalArea += (height[right] - curHeight) * (right - left + 1);
        		curHeight = height[right];
        		while(left < right && height[right] <= curHeight) right--;
        	}
        	else{
        		totalArea += (height[left] - curHeight) * (right - left + 1);
        		curHeight = height[left];
        		while(height[left] <= curHeight) left++;
        	}
        }
        totalArea += (height[left] - curHeight);
        return totalArea - barArea;
    }
}
