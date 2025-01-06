package com.sbpsystems.art2d2.vizsgaremek.model.dto;

import java.util.Date;

public class UserDto {

	private Long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private Date lastPracticeDate;
	private Long numberOfConsecutiveDays;
	private Long numberOfPracticeDays;
	private String iconImgName;
	private Long score;
	private boolean isAdmin;

	public UserDto() {
	}

	public UserDto(Long id, String userName, String firstName, String lastName, String password, Date lastPracticeDate, Long numberOfConsecutiveDays, Long numberOfPracticeDays, String iconImgName, Long score) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.lastPracticeDate = lastPracticeDate;
		this.numberOfConsecutiveDays = numberOfConsecutiveDays;
		this.numberOfPracticeDays = numberOfPracticeDays;
		this.iconImgName = iconImgName;
		this.score = score;
	}

	public UserDto(Long id, String userName, String firstName, String lastName, String password, Date lastPracticeDate, Long numberOfConsecutiveDays, Long numberOfPracticeDays, String iconImgName, Long score, boolean isAdmin) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.lastPracticeDate = lastPracticeDate;
		this.numberOfConsecutiveDays = numberOfConsecutiveDays;
		this.numberOfPracticeDays = numberOfPracticeDays;
		this.iconImgName = iconImgName;
		this.score = score;
		this.isAdmin = isAdmin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastPracticeDate() {
		return lastPracticeDate;
	}

	public void setLastPracticeDate(Date lastPracticeDate) {
		this.lastPracticeDate = lastPracticeDate;
	}

	public Long getNumberOfConsecutiveDays() {
		return numberOfConsecutiveDays;
	}

	public void setNumberOfConsecutiveDays(Long numberOfConsecutiveDays) {
		this.numberOfConsecutiveDays = numberOfConsecutiveDays;
	}

	public Long getNumberOfPracticeDays() {
		return numberOfPracticeDays;
	}

	public void setNumberOfPracticeDays(Long numberOfPracticeDays) {
		this.numberOfPracticeDays = numberOfPracticeDays;
	}

	public String getIconImgName() {
		return iconImgName;
	}

	public void setIconImgName(String iconImgName) {
		this.iconImgName = iconImgName;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}
}
