package com.myfinance.personalbudget.repository;

import com.myfinance.personalbudget.domain.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    boolean existsSubategoriesByName(String name);
    List<Subcategory> findAll();
}
