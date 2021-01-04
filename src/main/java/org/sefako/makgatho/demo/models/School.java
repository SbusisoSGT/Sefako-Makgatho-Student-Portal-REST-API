package org.sefako.makgatho.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "schools")
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "school")
	@JsonBackReference
	private Set<Course> courses = new HashSet<>();
	
	@ManyToMany()
	@JoinTable(name="school_departments", 
		joinColumns = { @JoinColumn(name="school_id")},
		inverseJoinColumns = {@JoinColumn(name="department_id")}	
	)
	@JsonBackReference
	private Set<Department> departments = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
