package qa.tuning;

public class CharConverter {
	private static final char[] lookup;
	
	static {
		lookup = new char[256];
		for (int i=0; i<256; i++) {
			lookup[i] = (char) i;
		}
	}
	
	public static void main(String[] args) throws Exception {
		final int N = 100;
		
		CharConverter cc = new CharConverter();
		byte[] bs = new byte[N];
		char[] cs = new char[N];
		for (int i=0; i<N; i++) {
			bs[i] = (byte) ((Math.random() * 256) -128);
			//bs[i] = (byte) (i+65);
		}
		int x = cc.convertWithBitwiseOperationAndOptimisation(bs, 0, N, cs, 0, N);
		System.out.println(new String(cs));
		
	}
	
	public int convertWithLookup(byte[] input, int bStart, int bEnd, char[] output, int cStart, int cEnd) throws Exception {
		
		int cOff = cStart;
		
		for (int bOff = bStart; bOff < bEnd; ) {
			if (cOff > cEnd) throw new Exception("Not enough space...");
	
			output[cOff++] = lookup[input[bOff++]+128];
		
		}
		
		return cOff = cStart;
	}
	
	public int convertWithBitwiseOperation(byte[] input, int bStart, int bEnd, char[] output, int cStart, int cEnd) throws Exception {
		
		int cOff = cStart;
		
		for (int bOff = bStart; bOff < bEnd; ) {
			if (cOff > cEnd) throw new Exception("Not enough space...");
	
			output[cOff++] = (char) (input[bOff++] & 0xFF);
		
		}
		
		return cOff = cStart;
	}
	
	public int convertWithBitwiseOperationAndOptimisation(byte[] input, int bStart, int bEnd, char[] output, int cStart, int cEnd) throws Exception {
		
		int cOff = cStart;
		int max = bEnd;
		if (bEnd-bStart > cEnd-cStart) {
			max = bStart + cEnd - cStart;
		}
		
		for (int bOff = bStart; bOff < max; ) {
			output[cOff++] = (char) (input[bOff++] & 0xFF);
		}
		
		if (max != bEnd) throw new Exception("Not enough space...");  // hasn't filled it
		
		return cOff = cStart;
	}
	
	
	public int convert(byte[] input, int bStart, int bEnd, char[] output, int cStart, int cEnd) throws Exception {
		
		int cOff = cStart;
		
		for (int bOff = bStart; bOff < bEnd; ) {
			if (cOff > cEnd) throw new Exception("Not enough space...");
			
			int i = input[bOff];
			bOff++;
			
			if (i >= 0) {
				output[cOff] = (char) i;
			} else {
				output[cOff] = (char) (i+256);  // i.e. negative byte
			}
			cOff++;
			
		}
		
		return cOff = cStart;
	}
	

}
