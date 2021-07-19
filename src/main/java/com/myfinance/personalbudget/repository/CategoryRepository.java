package com.myfinance.personalbudget.repository;

import com.myfinance.personalbudget.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
 boolean existsCategoriesByName(String name);
}
