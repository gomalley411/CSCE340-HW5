
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
	private static final int RADIX = 256;
	private String sInput;
	private final int sLength; 	//length of sInput
	private final int[] myRank;	// rank of sorted suffix array. Index is index of the said array. Int value is ranking of current d
	private int[] lastRank, suffixArray;
	// lastRank: rank of the last time we sorted d digits. Array index is the index of original suffix array
	// suffixArray: index is order of sorted array, value is original order in array
	private int d; // number of digits sorted
	
	// circular suffix array of s
	public CircularSuffixArray(String s) {
		if (s == null) throw new IllegalArgumentException("s cannot be null");
		this.sInput = s;
		sLength = sInput.length();
		myRank = new int[sLength];
		lastRank = new int[sLength];
		suffixArray = new int[sLength];
		for (int i = 0; i < sLength; i++) {
			suffixArray[i] = i;
		}
		
		KIC(); // sort suffixArray using key indexed counting sort
		// Manber-Myers algorithm goes here if needed - write later
		
		
		print();
	}
	
	// length of s
	public int length() {
		return sLength;
	}
	
	// returns index of ith sorted suffix
	public int index(int i) {
		if (i < 0 || i > sLength-1) throw new IllegalArgumentException("index(): i is outside range");
		return suffixArray[i];
	}
	
	// use key indexed sorting to sort suffixArray
	private void KIC() {
		int[] ct = new int[RADIX + 1];
		
		// count the frequencies
		for (int i = 0; i < sLength; i++)
			ct[sInput.charAt(i)+1]++;
		
		// compute the cumulates
		for (int r = 0; r < RADIX; r++)
			ct[r+1] += ct[r];
		
		// move then copy back
		for (int i = 0; i < sLength; i++) {
			// the rank is temporarily utilized as an auxiliary array to conserve memory
			myRank[ct[sInput.charAt(i)]++] = suffixArray[i];
			suffixArray[i] = myRank[i]; // copy back
		}
	}
	
	private void print() {
		for (int i = 0; i < suffixArray.length; i++) {
			System.out.print(suffixArray[i] + " ");
		}
		System.out.println();
	}
	
	
	
	// unit testing -required
	public static void main(String[] args) {
		CircularSuffixArray csa = new CircularSuffixArray("Fuck this class!");
		
	}
}
