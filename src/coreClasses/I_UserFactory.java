package coreClasses;

public interface I_UserFactory {

	public User makeUser(int type, int userID, String firstName, String secondName, String password, String email, String phone);
}
