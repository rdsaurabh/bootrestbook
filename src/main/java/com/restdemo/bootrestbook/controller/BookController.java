package com.restdemo.bootrestbook.controller;




import java.util.List;
import java.util.Optional;

import com.restdemo.bootrestbook.entities.Book;
import com.restdemo.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    //@RequestMapping(value = "/books", method = RequestMethod.GET)
    @GetMapping("/books")
    @ResponseBody
    public Book getBooks(){
    	
        Book book = new Book();
        book.setId(1);
        book.setTitle("Rich Dad Poor Dad");
        book.setAuthor("Robert T Kiyosaki");
        //after using rest controller spring boot automatically converts 
        //a java object to json response
        //this happens with jackson dependency which is configured automatically within spring boot
        return book;
    }

    @GetMapping("/allbooks")
    @ResponseBody
    public List<Book> getAllBooks() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        return this.bookService.getAllBooks();
    }
    
    @GetMapping("/getBookById/{id}")
    @ResponseBody
    public ResponseEntity<Book> getBookById(@PathVariable("id")int id) {
    	List<Book> list = this.bookService.getAllBooks();
    	for(Book book : list) {
    		if(book.getId() == id) return ResponseEntity.of(Optional.of(book));
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book) {
    	System.out.println("Called");
    	
    }
    
	    @DeleteMapping("/deleteBook/{id}")
	    public Book deleteBook(@PathVariable("id") int id) {
	    	System.out.println("working");
	    	Book book = this.bookService.deleteBook(id);
	    	return book;
	    }
	   
}
