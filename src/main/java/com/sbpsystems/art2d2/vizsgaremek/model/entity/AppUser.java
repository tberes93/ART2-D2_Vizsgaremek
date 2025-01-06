package com.sbpsystems.art2d2.vizsgaremek.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "appuser")
public class AppUser extends PersistentObjectWithId {

	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private Date lastPracticeDate;
	private Long numberOfConsecutiveDays;
	private Long numberOfPracticeDays;
	private String iconImgName;
	private Set<Reward> rewardSet;
	private Long score;

	@NotNull
	@Column(name = "username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@NotNull
	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@NotNull
	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@NotNull
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "lastpracticedate")
	public Date getLastPracticeDate() {
		return lastPracticeDate;
	}

	public void setLastPracticeDate(Date lastPracticeDate) {
		this.lastPracticeDate = lastPracticeDate;
	}

	@Column(name = "numberofconsecutivedays")
	public Long getNumberOfConsecutiveDays() {
		return numberOfConsecutiveDays;
	}

	public void setNumberOfConsecutiveDays(Long numberOfConsecutiveDays) {
		this.numberOfConsecutiveDays = numberOfConsecutiveDays;
	}

	@Column(name = "numberofpracticedays")
	public Long getNumberOfPracticeDays() {
		return numberOfPracticeDays;
	}

	public void setNumberOfPracticeDays(Long numberOfPracticeDays) {
		this.numberOfPracticeDays = numberOfPracticeDays;
	}

	@Column(name = "iconimgname")
	public String getIconImgName() {
		return iconImgName;
	}

	public void setIconImgName(String iconImgName) {
		this.iconImgName = iconImgName;
	}

	@ManyToMany
	@JoinTable(name = "appuser_reward",
		joinColumns = { @JoinColumn(name = "appuser_id") },
		inverseJoinColumns = @JoinColumn(name = "reward_id"))
	public Set<Reward> getRewardSet() {
		return rewardSet;
	}

	public void setRewardSet(Set<Reward> rewardSet) {
		this.rewardSet = rewardSet;
	}

	@Transient
	public Long getScore() {
		Long numOfPrDays = this.getNumberOfPracticeDays() == null ? 0L : this.getNumberOfPracticeDays();
		Long numOfConstDays = this.getNumberOfConsecutiveDays() == null ? 0L : this.getNumberOfConsecutiveDays();
		return numOfPrDays + (numOfConstDays * 10);
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AppUser appUser = (AppUser) o;
		return Objects.equals(userName, appUser.userName);
	}

	@Override public int hashCode() {
		return Objects.hashCode(userName);
	}
}
