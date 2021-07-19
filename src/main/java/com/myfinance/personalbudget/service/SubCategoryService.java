package com.myfinance.personalbudget.service;

import com.myfinance.personalbudget.domain.Subcategory;
import com.myfinance.personalbudget.repository.SubcategoryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SubCategoryService {
    private final SubcategoryRepository subcategoryRepository;

    public SubCategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }


    public List<Subcategory> listAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public boolean checkForExistsByName(String name) {
        return subcategoryRepository.existsSubategoriesByName(name);
    }

    public void saveOrUpdateSubcategory(Subcategory subcategory) {
        subcategoryRepository.save(subcategory);
    }

    public void delete(Long id) {
        subcategoryRepository.deleteById(id);
    }

    public Subcategory getSubcateoryById(Long id) {
        return subcategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subcategory with id  " + id + " was not found"));
    }

}
