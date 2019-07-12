package qa.library;

import java.util.*;

public class Library
{
    private Collection<Member> theMembers;

    public Library()
    {
    	  //theMembers = new LinkedList();
    	theMembers = new TreeSet<Member>(Member.NameSort);
    }

    public void addMember(String name, int age)
    {
    	Member m = new Member(name, age);
        theMembers.add(m);
    }

    public String getMembers()
    {
    	StringBuffer sb = new StringBuffer(200);
    	for (Member m : theMembers	) {
			sb.append(m.getDetails()+ "\n");
		}
        /*Iterator<Member> iter = theMembers.iterator();
        while (iter.hasNext())
        {
        	Member nextMember = iter.next();
            sb.append(nextMember.getDetails() + "\n");
        }*/

        return sb.toString();
    }

    public boolean removeMember(String name)
    {
    	boolean result = false;
    	for (Member m : theMembers) {
			if(m.getName().equals(name))
			{
				theMembers.remove(m);
				result = true;
				break;
			}
		}
    	
    	/*Iterator iter = theMembers.iterator();
        while (iter.hasNext())
        {
        	Member nextMember = (Member)iter.next();
        	String memName = nextMember.getName();
        	if (name.equals(memName))
        	{
        		iter.remove();
                result = true;
            	break;
        	}
        }*/
        return result;
    }
}