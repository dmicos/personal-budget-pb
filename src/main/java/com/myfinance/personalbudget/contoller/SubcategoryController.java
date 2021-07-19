package com.myfinance.personalbudget.contoller;

import com.myfinance.personalbudget.domain.Subcategory;
import com.myfinance.personalbudget.service.CategoryService;
import com.myfinance.personalbudget.service.SubCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("subcategory")
public class SubcategoryController {

    private final SubCategoryService subCategoryService;
    private final CategoryService categoryService;

    public SubcategoryController(SubCategoryService subCategoryService, CategoryService categoryService) {
        this.subCategoryService = subCategoryService;
        this.categoryService = categoryService;
    }

    @ModelAttribute
    public void addCategoriesList(Model model) {
        model.addAttribute("categories", categoryService.listAllCategories());
    }

    @GetMapping("list")
    public String showlist(Model model) {
        model.addAttribute("subcategories", subCategoryService.listAllSubcategories());
        return "subcategory/list";
    }

    @GetMapping("add")
    public String showAddForm(Model model) {
        model.addAttribute("subcategory", new Subcategory());
        return "subcategory/subcategoryform";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("subcategory", subCategoryService.getSubcateoryById(id));
        return "subcategory/subcategoryform";
    }

    @PostMapping("update")
    public String saveOrUpdate(@Valid @ModelAttribute("subcategory") Subcategory subcategory, BindingResult result) {
        if (result.hasErrors()) {
            return "/subcategory/subcategoryform";
        }

        boolean existsSubcategory = subCategoryService.checkForExistsByName(subcategory.getName());
        if ((subcategory.getId() == null) && existsSubcategory) {
            result.addError(new FieldError("subcategory", "name", "Subcategory already exists"));
            return "/subcategory/subcategoryform";
        }

        subCategoryService.saveOrUpdateSubcategory(subcategory);
        return "redirect:/subcategory/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        //TODO Exception
        subCategoryService.delete(id);
        return "redirect:/subcategory/list";
    }
}
