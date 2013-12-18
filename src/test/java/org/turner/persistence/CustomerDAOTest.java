package org.turner.persistence;

import java.util.Collection;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@ContextConfiguration("classpath:org/turner/spring-context.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class CustomerDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
  
  @Resource(name="customerDAO")
  private CustomerDAO customerDAO;
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Test
  @Rollback(true)
  public void basicTest() {
    Customer customer = new Customer("Second Name", "Address Line One", "PO57 CO3");
    customerDAO.save(customer);
  }
  
  @Test
  @Transactional
  public void testFindAllCustomers() {
    Collection<Customer> findAllCustomers = customerDAO.findAllCustomers();
    Assert.assertNotNull(findAllCustomers);
    Assert.assertTrue(findAllCustomers.isEmpty());
  }
  
  @Test
  @Rollback(true)
  public void testFindAllCustomersOneCustomer() {
    Customer customer = new Customer("Second Name", "Address Line One", "PO57 CO3");
    customerDAO.save(customer);
    entityManager.flush();
    Collection<Customer> findAllCustomers = customerDAO.findAllCustomers();
    Assert.assertNotNull(findAllCustomers);
    Assert.assertEquals(1, findAllCustomers.size());
  }
}

