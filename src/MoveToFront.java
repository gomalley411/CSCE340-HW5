import java.util.LinkedList;

public class MoveToFront {
	private static final int R = 256; // extended ASCII character amount
	
	// apply move-to-front encoding, reading from StdIn and writing to StdOut
	public static void encode () {
		LinkedList<Character> ASCII = getASCII();
		while (!BinaryStdIn.isEmpty()) {
			char c = BinaryStdIn.readChar();
			int pos = ASCII.indexOf(c);
			if (pos == -1) throw new IllegalArgumentException();
			BinaryStdOut.write(pos, 8);
			
			// move c from current pos. to front
			ASCII.remove(pos);
			ASCII.addFirst(c);
		}
		BinaryStdOut.close();
	}
	
	// apply move-to-front decoding, reading from StdIn and writing to StdOut
	public static void decode() {
		LinkedList<Character> ASCII = getASCII();
		while (!BinaryStdIn.isEmpty()) {
			int pos = (int) BinaryStdIn.readChar(); // read character
			if (pos < 0 || pos >= 256) throw new IllegalArgumentException();
			char c = ASCII.get(pos);
			BinaryStdOut.write(c);
			
			// move c from current pos. to front
			ASCII.remove(pos);
			ASCII.addFirst(c);
		}
		BinaryStdOut.close();
	}
	
	//if args[0] is "-" apply move-to-front encoding
	//if args[0] is "+" apply move-to-front decoding
	public static void main(String[] args) {
		if (args.length != 1) throw new IllegalArgumentException("Must be either a plus or minus symbol");
		String firstArg = args[0];
		if (firstArg.equals("-")) encode();
		else if (firstArg.equals("+")) decode();
		else throw new IllegalArgumentException("Unknown argument in MoveToFront main: " + firstArg + "\n");
	}
	
	private static LinkedList<Character> getASCII() {
		LinkedList<Character> ASCII = new LinkedList<>();
		for (char c = 0; c < 256; c++) ASCII.add(c);
		return ASCII;
	}
}
