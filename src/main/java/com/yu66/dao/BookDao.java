package com.yu66.dao;

import com.yu66.entity.Book;
import com.yu66.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keywordTitle, String keywordAuthor);
}
