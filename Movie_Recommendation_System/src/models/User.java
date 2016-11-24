package models;

public class User {
	
int userId;
String userName;
String userSurname;
int userAge;
char userGender;
String userOccupation;



	public User(int userID, String userName, String userSurname, int userAge, String userGender, String userOccupation) {
		// TODO Auto-generated constructor stub
		setUserId(userID);
		setUserAge(userAge);
		setUserGender(userGender);
		this.userName = userName;
		this.userSurname = userSurname;
		this.userOccupation = userOccupation;
	
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		if(userId < 0){
			throw new IllegalArgumentException();
		}
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserSurname() {
		return userSurname;
	}



	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}



	public int getUserAge() {
		return userAge;
	}



	public void setUserAge(int userAge) {
		if(userAge < 0 && userAge > 120){
			throw new IllegalArgumentException();
		}
		else this.userAge = 0;
	}



	public char getUserGender() {
		return userGender;
	}



	public void setUserGender(String userGender) {
		if(userGender.toUpperCase().trim().charAt(0) == 'F' || userGender.toUpperCase().trim().charAt(0) == 'M'){
			this.userGender = userGender.charAt(0);
		}
		else 
			throw new IllegalArgumentException();
	}



	public String getUserOccupation() {
		return userOccupation;
	}



	public void setUserOccupation(String userOccupation) {
		this.userOccupation = userOccupation;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSurname=" + userSurname + ", userAge="
				+ userAge + ", userGender=" + userGender + ", userOccupation=" + userOccupation + "]";
	}
	
	

}
