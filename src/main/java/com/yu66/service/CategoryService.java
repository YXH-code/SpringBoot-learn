package com.yu66.service;

import com.yu66.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> list();
    public Category get(int id);
}
