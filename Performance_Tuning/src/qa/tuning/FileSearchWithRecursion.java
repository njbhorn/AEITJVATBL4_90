package qa.tuning;

import java.io.File;

public class FileSearchWithRecursion {
	public static final String SEP = System.getProperty("file.separator");
	
	public static void main(String args[]) {
		FileSearchWithRecursion fs = new FileSearchWithRecursion();
		fs.printFilesWithSuffix(new File("C:\\labs"), ".java");
	}
	
	public void printFilesWithSuffix(File root, String suffix) {
		String[] fileList = root.list();
		if (fileList==null) {
			return;
		}
		
		for (String file : fileList) {
			File f = new File(root.getAbsolutePath()+ SEP + file);
			if (f.isDirectory()) {
				printFilesWithSuffix(f, suffix);
			} else if (file.endsWith(suffix)) {
				System.out.println(file);
			} 
		}
	}

}
