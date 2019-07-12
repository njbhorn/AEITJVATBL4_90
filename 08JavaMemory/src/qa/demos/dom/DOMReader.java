package qa.demos.dom;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class DOMReader {

	public static void main(String[] args) throws Exception {
		String folderName = ".";
		if (args.length > 0) {
			folderName = args[0];
		}
		
		File folder = new File(folderName);
		String[] availableFiles = folder.list(new FilenameFilter() {
			@Override
			public boolean accept(File f, String s) {
				return s.endsWith(".xml");
			}
		});
		
		System.out.println("Using files:");
		for (String fn : availableFiles) {
			System.out.println("\t" + fn);
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		List<Document> docs = new LinkedList<Document>();
		for (int i=0; i<1000; i++) {
			String fileName = availableFiles[(int) Math.random() * availableFiles.length];
			int pos = (int) (Math.random() * docs.size());
			docs.add(pos, builder.parse(fileName));
			Thread.sleep(10);
			
		}
		System.gc();
		
		System.out.println("Done. Press ENTER to quit.");
		System.in.read();
		
	}

}
