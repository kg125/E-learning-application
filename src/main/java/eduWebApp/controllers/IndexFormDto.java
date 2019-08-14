package eduWebApp.controllers;

public class IndexFormDto {

	private String password = "";
	private String username;
	private String role;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsernameEmpty() {
		this.username = "";
	}
}
