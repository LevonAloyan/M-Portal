package mportal.dao;

import mportal.domain.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getCategoryByParentId();

    void addCategory(Category category);

}
