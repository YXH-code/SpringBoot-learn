package com.yu66.service.Impl;

import com.yu66.dao.BookDao;
import com.yu66.entity.Book;
import com.yu66.entity.Category;
import com.yu66.service.BookService;
import com.yu66.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 书籍业务逻辑层实现类
 * @author: 俞先浩
 * @create: 2021-02-24 16:16
 **/
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private CategoryService categoryService;

    /**
    * @Description: 降序显示书籍列表
    * @Param: []
    * @return: java.util.List<com.yu66.entity.Book>
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return bookDao.findAll(sort);
    }

    /**
    * @Description: 新增或修改书籍
    * @Param: [book]
    * @return: void
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    public void addOrUpdate(Book book) {
        bookDao.save(book);
    }

    /**
    * @Description: 通过id删除书籍
    * @Param: [id]
    * @return: void
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    /**
    * @Description: 通过书籍分类显示书籍
    * @Param: [cid]
    * @return: java.util.List<com.yu66.entity.Book>
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }

    /**
    * @Description: 根据书籍标题和作者模糊查询书籍
    * @Param: [keywords]
    * @return: java.util.List<com.yu66.entity.Book>
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    public List<Book> Search(String keywords) {
        return bookDao.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }
}
