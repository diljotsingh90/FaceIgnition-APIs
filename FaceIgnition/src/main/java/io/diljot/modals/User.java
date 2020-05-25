package io.diljot.modals;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Inheritance
@DiscriminatorColumn(name = "user_type")
@Table(name = "users")
public abstract class User {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@NotNull
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
}
