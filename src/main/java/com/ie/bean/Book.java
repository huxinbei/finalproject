/*功能：实体类；作者：施淇*/
package com.ie.bean;

public class Book {

	public static final int PAGE_SIZE=5;
	private int bookid;
	private String bookname;
	private int number;
	private String author;
	private String publisher;
	private String category;
	
	public static int getPageSize() {
		return PAGE_SIZE;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
