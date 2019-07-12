package qa.tuning;

import java.io.File;
import java.util.Stack;

public class FileSearchWithStack {
	public static final String SEP = System.getProperty("file.separator");
	
	public static void main(String args[]) {
		FileSearchWithStack fs = new FileSearchWithStack();
		fs.printFilesWithSuffix(new File("C:\\labs"), ".java");
	}
	
	public void printFilesWithSuffix(File root, String suffix) {
		Stack<File> dirs = new Stack<File>();
		dirs.push(root);
		
		while (!dirs.empty()) {
			root = dirs.pop();
			String[] fileList = root.list();
			if (fileList==null) {
				continue;
			}	
			for (String file : fileList) {
				File f = new File(root.getAbsolutePath()+ SEP + file);
				if (f.isDirectory()) {
					dirs.push(f);
				} else if (file.endsWith(suffix)) {
					System.out.println(file);
				} 
			}
			
		}
		
		

	}

}
