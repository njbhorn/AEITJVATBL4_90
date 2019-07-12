package qa.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Section<T> implements Iterable<T> {
	private String sectionName;
	private Department<? super T> department;
	private List<T> items;
	
	public Section(String sectionName, Department<? super T> department) {
		this.sectionName = sectionName;
		items = new ArrayList<T>();
		this.department = department;
		department.addSection(this);
	}
	
	public String getSectionName() {
		return sectionName;
	}

	public void addItem(T t) {
		items.add(t);
	}
	
	public int getCount() {
		return items.size();
	}
	
	public boolean contains(T t) {
		return items.contains(t);
	}

	public Iterator<T> iterator() {
		return items.iterator();
	}

	public Department<? super T> getDepartment() {
		return department;
	}
	


}
