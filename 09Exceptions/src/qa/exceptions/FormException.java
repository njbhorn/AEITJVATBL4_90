package qa.exceptions;

import java.util.*;

@SuppressWarnings("serial")
public class FormException extends Exception {

	private List<FormException> causes;

	public FormException(String message) {
		super(message);
	}

	public FormException() {
		super();
	}

	public boolean isEmpty() {
		if (causes == null)
			return true;
		return false;
	}

	public void add(FormException fe) {
		if (causes == null) {
			causes = new LinkedList<FormException>();
		}
		causes.add(fe);
	}

	@Override
	public String getMessage() {
		String message = super.getMessage();
		if (message == null || message.trim().isEmpty()) {
			message = "";
		} else {
			message += "\n";
		}
		if (causes != null) {
			for (FormException fe : causes) {
				message += fe.getMessage() + "\n";
			}
		}
		return message;
	}

}
