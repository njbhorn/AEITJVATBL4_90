package qa.library;

import java.util.Comparator;

public class MemberNameSort implements Comparator<Member> {

	public int compare(Member m1, Member m2) {
		return m1.getName().compareTo(m2.getName());
	}

	

}
