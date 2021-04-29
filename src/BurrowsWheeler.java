
public class BurrowsWheeler {
	private static final int RADIX = 256;
	
	// apply BW transform, reading from input and writing to output
	public static void transform() throws Exception {
		if (BinaryStdIn.isEmpty()) 
			throw new Exception("transform(): input cannot be empty");
		
		// now read the string from input
		String input = BinaryStdIn.readString(), output = "";
		// length of input
		int len = input.length(), first = 0;
		
		CircularSuffixArray csa = new CircularSuffixArray(input);
		
		// iterate sorted suffixed stuff
		for (int i = 0; i < len; i++) {
			// find row of index(i) = 0
			int prev = csa.index(i)-1;
			if (prev == -1) {
				first = i;
				prev += len;
			}
			
			// now calculate index in orig. suffixes for row i
			output += input.charAt(prev);
		}
		
		// now write output
		BinaryStdOut.write(first);
		BinaryStdOut.write(output);
		BinaryStdOut.close();
	}
	
	// apply BW inverse transform, reading from input and writing to output
	public static void inverseTransform() {
		int firstDigit = BinaryStdIn.readInt();
		String input = BinaryStdIn.readString();
		int sLen = input.length();
		
		int[] ct = new int[RADIX + 1], next = new int[sLen];
		char[] sorted = new char[sLen];
		
		for (int i = 0; i < sLen; i++) {
			char c = input.charAt(i);
			ct[(int) c + 1]++;
		}
		for (int i = 0; i < RADIX; i++) {
			ct[i+1] += ct[i];
		}
		for (int i = 0; i < sLen; i++) {
			char c = input.charAt(i);
			// c in first col is at row ct[(int) c]
			// c at last col is at row i
			// at row ct[(int) c], last col is previous element of c
			next[ct[(int) c]] = i;
			sorted[ct[(int) c]] = c;
			ct[(int) c]++;
		}
		
		int r = firstDigit; // r for row
		for (int i = 0; i < sLen; i++) {
			BinaryStdOut.write(sorted[r]);
			r = next[r];
		}
		BinaryStdOut.close();
		
	}
	
	// if args[0] is "-" apply BW transform
	// if args[0] is "+" apply BW inverse transform
	public static void main(String[] args) throws Exception {
		if (args == null || args.length == 0)
			throw new IllegalArgumentException("args length is 0");
		if (args[0].equals("-")) transform();
		else if (args[0].equals("+")) inverseTransform();
		else throw new IllegalArgumentException();
		
	}

}
