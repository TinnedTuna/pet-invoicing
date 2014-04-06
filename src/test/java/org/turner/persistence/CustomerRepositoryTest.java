package org.turner.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.turner.model.Customer;

/**
 *
 * @author turner
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:org/turner/test-spring-context.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class CustomerRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
  
  @Autowired
  private CustomerRepository customerRepository;
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Test
  public void basicTest() {
    Customer customer = new Customer("Second Name", "Address Line One", "PO57 CO3");
    customerRepository.save(customer);
  }
  
  @Test
  public void testFindAllCustomers() {
    Iterable<Customer> findAllCustomers = customerRepository.findAll();
    Assert.assertNotNull(findAllCustomers);
    Iterator<Customer> customersIterator = findAllCustomers.iterator();
    Assert.assertNotNull(customersIterator);
    Assert.assertFalse(customersIterator.hasNext());
  }
  
  @Test
  public void testCountOneCustomer() {
    Customer customer = new Customer("Second Name", "Address Line One", "PO57 CO3");
    customerRepository.save(customer);
    entityManager.flush();
    long count = customerRepository.count();
    Assert.assertEquals(1, count);
  }
}

