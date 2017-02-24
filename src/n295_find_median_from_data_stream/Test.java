package n295_find_median_from_data_stream;

public class Test {
	public static void main(String[] args){
		MedianFinder obj = new MedianFinder();
		obj.addNum(1);
		obj.addNum(2);
		System.out.println(obj.findMedian());
		obj.addNum(3);
		System.out.println(obj.findMedian());
		
		obj = new MedianFinder();
		obj.addNum(-1);
		System.out.println(obj.findMedian());
		obj.addNum(-2);
		System.out.println(obj.findMedian());
		obj.addNum(-3);
		System.out.println(obj.findMedian());

	}
}
