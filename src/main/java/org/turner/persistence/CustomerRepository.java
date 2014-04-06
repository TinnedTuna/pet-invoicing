package org.turner.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.turner.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}