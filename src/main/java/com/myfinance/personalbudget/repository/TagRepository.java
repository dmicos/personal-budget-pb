package com.myfinance.personalbudget.repository;

import com.myfinance.personalbudget.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
