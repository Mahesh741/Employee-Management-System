package com.gl.ems.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 int id;
	 @Column(nullable=false)
	 String firstName;
	 @Column
	 String lastName;
	 @Column(unique=true,nullable=false)
	 String email;
	 @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	 @JoinColumn(name="departmentid")
	 Department department;
	 

}