package org.turner.persistence;

import javax.persistence.EntityManagerFactory;
import org.turner.model.Customer;
import org.turner.persistence.hibernate.GenericHibernateDAO;

public class CustomerDAO extends GenericHibernateDAO<Customer> {

  public CustomerDAO(EntityManagerFactory entityManagerFactory) {
    super(entityManagerFactory);
  }

}