package com.myfinance.personalbudget.contoller;

import com.myfinance.personalbudget.domain.Category;
import com.myfinance.personalbudget.repository.CategoryRepository;
import com.myfinance.personalbudget.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
    }

    @GetMapping("list")
    public String showlist(Model model) {
        model.addAttribute("categories", categoryService.listAllCategories());
        return "category/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category", categoryService.getCategoryByid(id));
        return "category/categoryform";
    }

    @GetMapping("add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/categoryform";
    }

    @PostMapping("update")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/categoryform";
        }
        if ((category.getId() == null) && categoryService.checkForExistsByName(category.getName())) {
            result.addError(new FieldError("category", "name", "Category already exists"));
            return "category/categoryform";
        }
        categoryService.saveOrUpdateCategory(category);
        return "redirect:/category/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        //TODO Exception
        categoryService.deleteCategory(id);
        model.addAttribute("category", categoryService.listAllCategories());
        return "redirect:/category/list";
    }
}
