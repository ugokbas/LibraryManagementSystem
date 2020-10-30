package com.library.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "book")
public class Book {

    //	@Id
//	@Column(name="id")
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "book_name", length = 50, nullable = true)
    private String bookName;

    @Column(name = "book_sub_name", length = 50, nullable = true)
    private String bookSubName;

    @Column(name = "book_series_name", nullable = true)
    private String bookSeriesName;

    @Column(name = "aut_name", nullable = true)
    private String autName;

    @Column(name = "pub_name", nullable = true)
    private String pubName;

    @Column(name = "isbn", nullable = true)
    private String isbn;

    @Column(name = "explanation", nullable = true)
    private String explanation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookSubName() {
        return bookSubName;
    }

    public void setBookSubName(String bookSubName) {
        this.bookSubName = bookSubName;
    }

    public String getBookSeriesName() {
        return bookSeriesName;
    }

    public void setBookSeriesName(String bookSeriesName) {
        this.bookSeriesName = bookSeriesName;
    }

    public String getAutName() {
        return autName;
    }

    public void setAutName(String autName) {
        this.autName = autName;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
