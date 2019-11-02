package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	private Integer bid;

	private String name;

	private Integer publicationYear;

	public Integer getBid() {
		return bid;
	}

	public String getName() {
		return name;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}
}
