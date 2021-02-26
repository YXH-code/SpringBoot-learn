package com.yu66.service;

import com.yu66.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> list();
    public Optional<Category> get(int id);
}
