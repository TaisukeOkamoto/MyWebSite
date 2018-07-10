package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class UserInfoBeans implements Serializable {
 private int id;
 private String familyName;
 private String firstName;
 private int address;
 private String prefecture;
 private String city;
 private String street;
 private int phoneNumber;
 private Date birthDate;
 private String birthYear;
 private String birthMonth;
 private String birthDay;
 private String mail;
 private String gender;
 private String password;
 private Date userCreateDate;
 private Date userUpdateDate;
 private int userPoint;
 private ArrayList<UserInfoBeans> userList;


	public UserInfoBeans(String familyName,String firstName,int address,String prefecture,String city,String street,int phoneNumber,String birthYear,String birthMonth,String birthDay,String mail,String gender,String password,int userPoint){
		this.familyName = familyName;
		this.firstName = firstName;
		this.address = address;
		this.prefecture = prefecture;
		this.city = city;
		this.street = street;
		this.phoneNumber = phoneNumber;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.mail = mail;
		this.gender = gender;
		this.password = password;
		this.userPoint = userPoint;
	}

	public UserInfoBeans() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getUserCreateDate() {
		return userCreateDate;
	}
	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
	public Date getUserUpdateDate() {
		return userUpdateDate;
	}
	public void setUserUpdateDate(Date userUpdateDate) {
		this.userUpdateDate = userUpdateDate;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public ArrayList<UserInfoBeans> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserInfoBeans> userList) {
		this.userList = userList;
	}

}
