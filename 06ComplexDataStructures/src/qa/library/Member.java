package qa.library;

import java.util.Comparator;

public class Member implements Comparable<Member>
{
    private String name;
    private int age, idNum;

    private static int nextIDNumber = 1000;

	public Member(String mName, int mAge)
	{
    	name = mName;
        age = mAge;
        idNum = ++nextIDNumber;
	}

    public String getName()
    {
    	return name;
    }

    public String getDetails()
    {
    	StringBuffer details = new StringBuffer(idNum + "\t" + name);
        details.append((name.length() > 7)? "\t": "\t\t");
        details.append("" + age);
    	return details.toString();
    }

    public int compareTo(Member m) {
		
		return age - m.age;
    }

//    public static final Comparator<Member> NameSort = new MemberNameSort();
    // Enahancements as a result of completing the optional portion of the Inner
	// classes practical
	public static final Comparator<Member> NameSort = new NameSorter();
	
	private static class NameSorter implements Comparator<Member> {

		public int compare(Member m1, Member m2) {
			return m1.getName().compareTo(m2.getName());
		}
    }
}
