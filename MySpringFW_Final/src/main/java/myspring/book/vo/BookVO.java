package myspring.book.vo;

import java.sql.Date;

public class BookVO {

    private Long id;
    
    private String author;

    private Date created_at;

    private String genre;

    private String isbn;

    private String title;
    
    public BookVO() {
    	
    }
    
    public BookVO(String author, String genre, String isbn, String title) {
    	this.author = author;
    	this.genre = genre;
    	this.isbn = isbn;
    	this.title = title;
    }
    
    public BookVO(Long id, String author, Date created_at, String genre, String isbn, String title) {
    	this(author, genre, isbn, title);
    	this.id = id;
    	this.created_at = created_at;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
    
    
}
