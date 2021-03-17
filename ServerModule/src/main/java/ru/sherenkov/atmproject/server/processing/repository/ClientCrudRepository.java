package ru.sherenkov.atmproject.server.processing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sherenkov.atmproject.server.processing.entity.Client;

@Repository
public interface ClientCrudRepository extends CrudRepository<Client, Long> {
}
