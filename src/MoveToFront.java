
public class MoveToFront {
	private static final int R = 256; // extended ASCII character amount
	
	// apply move-to-front encoding, reading from StdIn and writing to StdOut
	public static void encode () {
		char[] mychars = getChArray();
		do {
			char ch = BinaryStdIn.readChar(), tin, count, tout;
			for (count = 0, tout = mychars[0]; ch != mychars[count]; count++) {
				tin = mychars[tout];
				mychars[count] = tout;
				tout = tin;
			}
			mychars[count] = tout;
			BinaryStdOut.write(count);
			mychars[0] = ch;
		}while(!BinaryStdIn.isEmpty());
		BinaryStdOut.close();
	}
	
	// apply move-to-front decoding, reading from StdIn and writing to StdOut
	public static void decode() {
		char[] mychars = getChArray();
		do {
			char c = BinaryStdIn.readChar();
			BinaryStdOut.write(mychars[c], 8);
			char index = mychars[c];
			while (c > 0) mychars[c] = mychars[--c];
			mychars[0] = index;
		}while(!BinaryStdIn.isEmpty());
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
	
	private static char[] getChArray() {
		char[] chars = new char[R];
		for (char i = 0; i < R; i++) {
			chars[i] = i;
		}
		return chars;
	}
}
