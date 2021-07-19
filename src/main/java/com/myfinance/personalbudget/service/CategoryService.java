package com.myfinance.personalbudget.service;

import com.myfinance.personalbudget.domain.Category;
import com.myfinance.personalbudget.domain.Subcategory;
import com.myfinance.personalbudget.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public boolean checkForExistsByName(String name) {
        return categoryRepository.existsCategoriesByName(name);
    }

    public void saveOrUpdateCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    //    public HashMap<Category, List<Subcategory>> getAllSubcategoiesGroupByCategories() {
//        return new HashMap<Category, List<Subcategory>>() {{
//            categoryRepository
//                    .findAll()
//                    .forEach(category ->
//                            put(category, category.getSubcategories()));
//        }};
//    }
    public TreeMap<Category, List<Subcategory>> getAllSubcategoiesGroupByCategories() {
        return new TreeMap<Category, List<Subcategory>>() {{
            categoryRepository
                    .findAll()
                    .forEach(category ->
                            put(category, category.getSubcategories()));
        }};
    }


    public Category getCategoryByid(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
