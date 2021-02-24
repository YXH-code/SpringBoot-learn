package com.yu66.service.Impl;

import com.yu66.dao.CategoryDao;
import com.yu66.entity.Category;
import com.yu66.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 书籍种类
 * @author: 俞先浩
 * @create: 2021-02-24 16:03
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> list() {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return categoryDao.findAll(sort);
    }

    @Override
    public Category get(int id) {
        Category c= categoryDao.findById(id).orElse(null);
        return c;
    }
}
