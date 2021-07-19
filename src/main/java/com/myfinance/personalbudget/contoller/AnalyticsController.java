package com.myfinance.personalbudget.contoller;

import com.myfinance.personalbudget.domain.Category;
import com.myfinance.personalbudget.domain.Pager;
import com.myfinance.personalbudget.domain.Subcategory;
import com.myfinance.personalbudget.dto.TransactionDto;
import com.myfinance.personalbudget.service.CategoryService;
import com.myfinance.personalbudget.service.PageService;
import com.myfinance.personalbudget.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@Controller
@SessionAttributes(value = "addAttributes", types = {HashMap.class})
@RequestMapping(value = {"/analytics", "/"})
public class AnalyticsController {
    //todo add values to properties
    private static final int DEFAULT_BUTTONS_TO_SHOW = 5;
    private static final String DEFAULT_PAGE = "0";
    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final int[] PAGE_SIZES = {10, 30, 50, 100};

    private final TransactionService transactionService;
    private final CategoryService categoryService;
    private final PageService pageService;

    public AnalyticsController(TransactionService transactionService, PageService pageService, CategoryService categoryService) {
        this.transactionService = transactionService;
        this.categoryService = categoryService;
        this.pageService = pageService;
    }

    @ModelAttribute
    public void getAllSubcategoiesGroupByCategories(Model model) {
        TreeMap<Category, List<Subcategory>> categoriesMap = categoryService.getAllSubcategoiesGroupByCategories();
        model.addAttribute("categoriesMap", categoriesMap);
    }

    @GetMapping
    public String showAnalyticsPage(@RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize,
                                    @RequestParam(value = "page", defaultValue = DEFAULT_PAGE) Integer page,
                                    @RequestParam(value = "subcategory", required = false) Long subcategoryId,
                                    @RequestParam(value = "category", required = false) Long categoryId,
                                    @RequestParam(value = "dateStart", required = false)
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateStart,
                                    @RequestParam(value = "dateEnd", required = false)
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd,
                                    @RequestParam(value = "search", required = false) String search,
                                    Model model) {
        if (page != 0) {
            --page;
        }
        Page<TransactionDto> transactionDtos;
        List<TransactionDto> transactionDtosList = new ArrayList<>();
        if ((search == null) || (search.isEmpty())) {
            transactionDtos = transactionService.getAllPageable(PageRequest.of(page, pageSize), categoryId, subcategoryId, dateStart, dateEnd);
        } else {
            transactionDtos = transactionService.getAllPageable(PageRequest.of(page, pageSize), search);
        }
        Pager pager = pageService.getPeges(transactionDtos.getTotalPages(), transactionDtos.getNumber(), DEFAULT_BUTTONS_TO_SHOW);

        List<Category> categories = categoryService.listAllCategories();

        model.addAttribute("transactions", transactionDtos);
        model.addAttribute("categories", categories);
        model.addAttribute("selectedPageSize", pageSize);
        model.addAttribute("pager", pager);
        model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("dateStart", dateStart);
        model.addAttribute("dateEnd", dateEnd);
        model.addAttribute("search", search);
        model.addAttribute("incomeExpenses", transactionService.getIncomeExpenses());
        return "analytics";
    }

    @GetMapping("/details")
    public String showDetailsTransactionPage(@RequestParam(value = "transactionNumber") Long number, Model model) {
        model.addAttribute("transactionInfo", transactionService.getByNumber(number));
        return "transaction/show";
    }


    @GetMapping("/edit-subcategory")
    public String showEditTransactionSubcategory(
            @RequestParam(value = "transactionNumber") Long number,
            Model model) {
        model.addAttribute("transactionNumber", number);
        model.addAttribute("subcategory", transactionService.getByNumber(number).getSubcategory());
        return "transaction/edit-subcategory";
    }

    @PostMapping("/edit-subcategory")
    public String editTransactionSubcategory(@RequestParam(value = "transactionNumber") Long number,
                                             @ModelAttribute Subcategory subcategory) {
        transactionService.setSubcategoryForTransaction(number, subcategory);
        return "redirect:/analytics";
    }

    @GetMapping("/add-subcategory")
    public String showAddTransactionSubcategory(
            @RequestParam(value = "transactionNumber") Long number,
            Subcategory subcategory,
            Model model) {
        model.addAttribute("transactionNumber", number);
        model.addAttribute("subcategory", subcategory);
        return "transaction/edit-subcategory";
    }

    @PostMapping("/add-subcategory")
    public String addTransactionSubcategory(@RequestParam(value = "transactionNumber") Long number,
                                            @ModelAttribute Subcategory subcategory) {
        transactionService.setSubcategoryForTransaction(number, subcategory);
        return "redirect:/analytics";
    }
}
