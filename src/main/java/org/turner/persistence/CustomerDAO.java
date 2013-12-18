package org.turner.persistence;

import java.util.Collection;
import org.springframework.stereotype.Repository;
import org.turner.model.Customer;
import org.turner.persistence.hibernate.GenericHibernateDAO;

@Repository
public class CustomerDAO extends GenericHibernateDAO<Customer> {

  public Collection<Customer> findAllCustomers() {
    return (Collection<Customer>) getEntityManager().createQuery("SELECT c FROM Customer c").getResultList();
  }
}