package qa.profile;

/**
 * consumes 1KByte per allocation
 * @author QA
 */
public class Consumer {

	public static final int MEMORY_BLOCK = 1024;
	public byte[] memoryBlock;

	public Consumer() {
		memoryBlock = new byte[MEMORY_BLOCK];
	}
} 
