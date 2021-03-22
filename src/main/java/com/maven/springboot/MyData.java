package com.maven.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;




@Entity
@Table(name="mydata")
@NamedQueries({
@NamedQuery(name="findWithName", query="from MyData where name like :fname"),
@NamedQuery(name="findByAge", query="from MyData where age > :min and age < :max")
})
public class MyData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@NotNull
	private long id;
	
	@Column(length = 50, nullable = false)
	@NotEmpty(message="공백 불가")
	private String name;
	
	@Column(length = 200, nullable = true)
	@Email(message="메일 주소만")
	private String mail;
	
	@Column(nullable = true)
	@Min(value=0,message="0이상")
	@Max(value=200,message="200이하")
	private Integer age;
	
	@Column(nullable = true)
	@Phone(onlyNumber=true)
	private String memo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
