package com.springboot.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "users")
@Entity
@NamedQuery(name = "finduser", query = "SELECT u FROM UserEntity u WHERE u.id=:userId")
public class UserEntity {

	@Id
	private int id;
	private String name;

	public UserEntity() {}

	public UserEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + "]";
	}
}