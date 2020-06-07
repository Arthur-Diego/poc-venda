package com.poc.venda.repository;

import com.poc.venda.domain.VendaEventIds;
import org.springframework.data.repository.CrudRepository;

public interface LibraryEventsRepository extends CrudRepository<VendaEventIds,Integer> {
}
