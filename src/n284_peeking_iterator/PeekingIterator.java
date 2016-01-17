package n284_peeking_iterator;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> internalIterator;
	private int bufferedNext = 0;
	private boolean isBuffered = false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    internalIterator = iterator;
	    if(internalIterator.hasNext()){
	    	bufferedNext = internalIterator.next();
	    	isBuffered = true;
	    }
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return bufferedNext;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!isBuffered) internalIterator.next();
	    int tmp = bufferedNext;
	    if(internalIterator.hasNext())
	    	bufferedNext = internalIterator.next();
	    else
	    	isBuffered = false;
	    return tmp;
	}

	@Override
	public boolean hasNext() {
	    return isBuffered;
	}
}