package com.example;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

	private final BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	@GetMapping("/year/{lower}/{higher}")
	public List<Book> findByPublicationYearBetween(@PathVariable Integer lower, @PathVariable Integer higher) {
		return bookRepository.findByPublicationYearBetween(lower, higher);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id) {
		try {
			bookRepository.deleteById(id);
		}
		catch (Exception e) {
			throw new MissingBookException();
		}
	}

	@PostMapping("/suffix/{name}/{suffix}")
	public Iterable<Book> addSuffixToMatching(@PathVariable String name, @PathVariable String suffix) {
		bookRepository.addSuffixToMatching(name, suffix);
		return bookRepository.findAll();
	}
}
