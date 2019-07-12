package qa.exceptions;

public interface MiddleTier {

	public abstract boolean submit(String name, String email, String phone) throws FormException;

}