package product;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable {
 private String uname,password,email;
 private int amount;
 public UserBean() {}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
 
}
