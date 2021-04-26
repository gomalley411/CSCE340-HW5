
public class CircularSuffixArray {
	/**
	 * The circular suffix array describes the abstraction
	 * of a sorted array of the n circular suffixes of a string
	 * of length n. As an example, consider the string "ABRACADABRA!"
	 * You can find a table showing its 12 circular suffixes, one
	 * per character, on page 3 of the assignment, as well as the 
	 * result of sorting them.
	 * 
	 * We define index[i] to be the index of the original suffix that
	 * appears ith in the sorted array. For instance, index[11]=2
	 * means that the 2nd original suffix appears 11th in the sorted
	 * order (ie, last alphabetically).
	 * 
	 * Your job is to implement the circular suffix array API, which
	 * provides the client to the index[] values.
	 */
	private int length;
	private String s;
	private int[] index;
	
	// circular suffix array of s
	public CircularSuffixArray(String s1) {
		if (s == null) throw new IllegalArgumentException("s cannot be null");
		s = s1;
		length = s1.length();
		index = new int[length];
		
	}
	
	// length of s
	public int length() {
		return length;
	}
	
	// returns index of ith sorted suffix
	public int index(int i) {
		if (i < 0 || i > length-1) throw new IllegalArgumentException("index(): i is outside range");
		return index[i];
	}
	
	// unit testing -required
	public static void main(String[] args) {
		
	}
}
