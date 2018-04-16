package javabean;

public class Manager {
  private int id;    //保存管理员ID
  private String name;//保存管理员名称
  private String pwd;///保存管理员密码
  private int sysset;//保存管理员系统设置权限
  private int readerset;//保存管理员读者管理权限
  private int bookset;//保存图书管理权限
  private int borrowback;//保存图书借还权限
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public int getSysset() {
	return sysset;
}
public void setSysset(int sysset) {
	this.sysset = sysset;
}
public int getReaderset() {
	return readerset;
}
public void setReaderset(int readerset) {
	this.readerset = readerset;
}
public int getBookset() {
	return bookset;
}
public void setBookset(int bookset) {
	this.bookset = bookset;
}
public int getBorrowback() {
	return borrowback;
}
public void setBorrowback(int borrowback) {
	this.borrowback = borrowback;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
  
}
