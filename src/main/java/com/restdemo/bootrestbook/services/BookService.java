package com.restdemo.bootrestbook.services;

import java.util.List;
import java.util.Arrays;

import com.restdemo.bootrestbook.entities.Book;


import org.springframework.stereotype.Component;

@Component
public class BookService {

    private List<Book> list = Arrays.asList( new Book(1,"Half Girlfriend","Chetan Bhagat"),
    		new Book(2,"Brief History Of Time","Stepehen Hawking"),
    		new Book(3,"Time Management","Brian Tracy"),
    		new Book(4,"The Subtle Art Of Not Giving A F*CK","Mark Manson"),
    		new Book(5,"Rich Dad Poor Dad","Robert T Kiyosaki"));

    public List<Book> getAllBooks(){
        
        return list;
    }
    
    public void addBook(Book book) {
    	this.list.add(book);
    }

	public Book deleteBook(int id) {
		
		for(int i = 0;i < list.size(); i++) {
			if(this.list.get(i).getId() == id) {
				return this.list.get(i);
			}
		}
		return null;
	}


    
}
