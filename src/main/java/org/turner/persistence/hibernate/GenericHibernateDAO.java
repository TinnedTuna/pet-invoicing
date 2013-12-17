package org.turner.persistence.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author turner
 */
public class GenericHibernateDAO<T> {
  
  private EntityManagerFactory entityManagerFactory;

  public GenericHibernateDAO(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }
  
  public void create(T entity) {
    getEntityManager().persist(entity);
  }
  
  protected EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();
  }
  
}
