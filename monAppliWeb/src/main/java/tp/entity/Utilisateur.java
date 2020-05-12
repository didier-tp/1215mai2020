package tp.entity;

public class Utilisateur {
	private String username;
	private String password;
	private String role;//"admin" ou "user" ou "..."
	private Boolean fou; //true or false
	
	public Utilisateur() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "Utilisateur [username=" + username + ", password=" + password + ", role=" + role + ", fou=" + fou + "]";
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getFou() {
		return fou;
	}

	public void setFou(Boolean fou) {
		this.fou = fou;
	}
	
	
}
