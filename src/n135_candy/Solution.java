package n135_candy;

import java.util.Arrays;
import java.util.Comparator;

// O(nlogn) Solution
public class Solution {
    public int candy(int[] ratings) {
    	Integer[] ratingIndice = new Integer[ratings.length];
    	for(int i = 0; i < ratings.length; i++)
    		ratingIndice[i] = i;
        Arrays.sort(ratingIndice, new IndiceComparator(ratings));
        int[] candies = new int[ratings.length];
        int totalCandies = 0;
        for(int i = 0; i < ratingIndice.length; i++){
        	int candiesForChildi = 1, index = ratingIndice[i];
        	if(index > 0 && ratings[index] > ratings[index - 1]) 
        		candiesForChildi = candies[index - 1] + 1;
        	if(index < ratingIndice.length - 1){
        		if(ratings[index] > ratings[index + 1] && candies[index + 1] + 1 > candiesForChildi)
        			candiesForChildi = candies[index + 1] + 1;
        	}
        	candies[index] = candiesForChildi;
        	totalCandies += candies[index];
        }
        return totalCandies;
    }
    
    class IndiceComparator implements Comparator<Integer>{
    	private int[] ratings;
    	IndiceComparator(int[] ratings){
    		this.ratings = ratings;
    	}
		@Override
		public int compare(Integer o1, Integer o2) {
			return ratings[o1] - ratings[o2];
		}
    	
    }
}