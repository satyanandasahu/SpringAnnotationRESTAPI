package com.example.satya.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

	public Person() {
		super();
	}

	public Person(String personId, String firstName, String lastName, String middleName, Integer age, String gender) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.age = age;
		this.gender = gender;
	}

	// @GeneratedValue(generator = "stringIdGenerator")
//	@IdGeneratorType(com.example.satya.util.StringIdGenerator.class)
//	@GenericGenerator(name = "stringIdGenerator", strategy = "com.example.satya.util.StringIdGenerator")

	@Id
	@UserId
	@Column(name = "PersonId")
	private String personId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "MiddleName")
	private String middleName;

	@Column(name = "age")
	private Integer age;

	@Column(name = "gender")
	private String gender;

	/**
	 * @return the id
	 */
	public String getPersonId() {
		return personId;
	}

	/**
	 * @param id the id to set
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", age=" + age + ", gender=" + gender + "]";
	}

}