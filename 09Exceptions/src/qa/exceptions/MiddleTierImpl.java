package qa.exceptions;

import java.util.*;

public class MiddleTierImpl implements MiddleTier {
	private static final String phoneRegExp = "^(\\+44\\s?7\\d{3}|\\(?07\\d{3}\\)?)\\s?\\d{3}\\s?\\d{3}$";

	private Collection<Map<String, String>> entries;

	public MiddleTierImpl() {
		entries = new LinkedList<Map<String,String>>();
	}

	@Override
	public boolean submit(String name, String email, String phone) throws FormException {
		FormException fe = new FormException();
		if (name.length() < 2) {
			fe.add(new FormException("Name is too short"));
		}
		if (!email.contains("@")) {
			fe.add(new FormException("E-mail address must contain a @ symbol"));
		}
		if (!phone.matches(phoneRegExp)) {
			fe.add(new FormException("Phone number not correctly formatted"));
		}
		
		if (!fe.isEmpty()) throw fe;
		return true;
	}

}
