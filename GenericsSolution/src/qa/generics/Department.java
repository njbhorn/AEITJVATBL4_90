package qa.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Department<T> implements Iterable<T> {
	private String departmentName;
	private List<Department<? extends T>> subDepartments;
	private List<Section<? extends T>> sections;

	public Department(String departmentName) {
		this.departmentName = departmentName;
		subDepartments = new ArrayList<Department<? extends T>>();
		sections = new ArrayList<Section<? extends T>>();
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void addSubDepartment(Department<? extends T> department) {
		subDepartments.add(department);
	}

	public void addSection(Section<? extends T> section) {
		sections.add(section);
	}

	public int getCount() {
		return allItems().size();
	}

	private List<T> allItems() {
		List<T> everything = new ArrayList<T>();
		for (Section<? extends T> s : sections) {
			for (T t : s) {
				everything.add(t);
			}
		}
		for (Department<? extends T> d : subDepartments) {
			everything.addAll(d.allItems());
		}
		return everything;
	}

	public Iterator<T> iterator() {
		return allItems().iterator();
	}
	
	@SuppressWarnings("unchecked")
	public <S extends T> List<S> getAll(Class<S> c) {
		List<S> objectsOfTypeS = new ArrayList<S>();
		for (T t : allItems()) {
			if (c.isInstance(t)) {
				objectsOfTypeS.add( (S) t );
			}
		}
		return objectsOfTypeS;
	}

}
