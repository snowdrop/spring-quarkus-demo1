package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, Integer> {

	List<Book> findByPublicationYearBetween(Integer lower, Integer higher);

	@Modifying
	@Query("update Book b set b.name = concat(b.name, :suffix) where b.name like concat('%', :name, '%') ")
	void addSuffixToMatching(@Param("name") String name, @Param("suffix") String suffix);
}
