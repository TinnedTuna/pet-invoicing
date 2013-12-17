package org.turner.persistence;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.turner.model.Customer;

/**
 *
 * @author turner
 */
@ContextConfiguration("classpath:org/turner/spring-context.xml")
public class CustomerDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
  
  @Resource(name="customerDAO")
  private CustomerDAO customerDAO;
  
  @Test
  public void basicTest() {
    Customer customer = new Customer();
  }
  
  
}
