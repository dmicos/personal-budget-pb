package com.myfinance.personalbudget.repository;

import com.myfinance.personalbudget.domain.Counterparty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounterpartyRepository extends JpaRepository<Counterparty, Long> {

    Counterparty findOneByName(String name);

    @Query("Select c from Counterparty c where c.name like %:search%")
    List<Counterparty> findAllByNameLike(String search);
}
