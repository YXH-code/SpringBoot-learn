package com.yu66.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

/**
 * @description: 书籍表实体类
 * @author: 俞先浩
 * @create: 2021-02-24 15:52
 **/
@Entity
@Table(name = "book")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name="cid")
    Category category;

    // 封面
    String cover;
    // 书名
    String title;
    // 作者
    String author;
    // 出版日期
    String date;
    // 出版社
    String press;
    // 简介
    String abs;

    public Book() {
    }

    public Book(int id, Category category, String cover, String title, String author, String date, String press, String abs) {
        this.id = id;
        this.category = Book.this.category;
        this.cover = cover;
        this.title = title;
        this.author = author;
        this.date = date;
        this.press = press;
        this.abs = abs;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = Book.this.category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
