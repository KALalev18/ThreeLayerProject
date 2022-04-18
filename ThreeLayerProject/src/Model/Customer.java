package Model;

public class Customer {
	int User_ID;
	int Registration_ID;
	String User_Email;
	String User_Password;
	String First_Name;
	String Last_Name;
	String Phone_Number;

	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public int getRegistration_ID() {
		return Registration_ID;
	}

	public void setRegistration_ID(int registration_ID) {
		Registration_ID = registration_ID;
	}

	public String getUser_Email() {
		return User_Email;
	}

	public void setUser_Email(String user_Email) {
		User_Email = user_Email;
	}

	public String getUser_Password() {
		return User_Password;
	}

	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}
}
