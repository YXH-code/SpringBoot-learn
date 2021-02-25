package com.yu66.service.Impl;

import com.yu66.dao.CategoryDao;
import com.yu66.entity.Category;
import com.yu66.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @description: 书籍分类业务逻辑层实现类
 * @author: 俞先浩
 * @create: 2021-02-24 16:03‘
 *
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    /**
    * @Description: 降序显示书籍分类列表
    * @Param: []
    * @return: java.util.List<com.yu66.entity.Category>
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    @Override
    public List<Category> list() {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return categoryDao.findAll(sort);
    }

    /**
    * @Description: 根据id查询书籍分类
    * @Param: [id]
    * @return: com.yu66.entity.Category
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    @Override
    public Category get(int id) {
        Category category= categoryDao.findById(id).orElse(null);
        return category;
    }
}
