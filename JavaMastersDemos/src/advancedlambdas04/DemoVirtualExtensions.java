package advancedlambdas04;

public class DemoVirtualExtensions  {
	
	public static void main(String[] args) {
		WritingApp wa = new WritingApp();
		wa.doWriting();		
		PrettyWritingApp pwa = new PrettyWritingApp();
		pwa.doWriting();
		PrettyWritingFileApp pwfa = new PrettyWritingFileApp();
		pwfa.write("Hello World");
	}
}

interface Writer {
	public default void write ( String msg ) {
		System.out.println(msg);
	}
}

interface PrettyWriter extends Writer {
	@Override
	public default void write(String msg) {
		System.out.println("****" + msg + "****");
	}
}

interface FileOutputter {
	public default void write ( String msg ) {
		System.out.println("File : " + msg + ".txt");
	}
}

class WritingApp implements Writer {
	public void doWriting(){
		write("Hello World");
	}
}

class PrettyWritingApp extends WritingApp implements PrettyWriter {
	public void doWriting(){
		write("Hello World");
	}
}

class PrettyWritingFileApp extends WritingApp implements PrettyWriter, FileOutputter {
	@Override
	public void write(String msg) {
		FileOutputter.super.write("Hello World");
	}
}

