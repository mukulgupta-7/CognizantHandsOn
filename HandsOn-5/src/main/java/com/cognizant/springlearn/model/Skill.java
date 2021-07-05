package com.cognizant.springlearn.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Skill {
	@NotNull(message="Should not be null")
	@Pattern(regexp="[0-9]+",message="id must be a number")
	private long id;
	
	@NotNull(message="Should not be null")
	@NotBlank(message="should not be blank")
	@Size(min=1,max=30,message="Name length 1<=length<=30")
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Skill(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Skill() {
		super();
	}
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
