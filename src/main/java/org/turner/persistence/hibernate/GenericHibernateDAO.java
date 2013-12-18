package org.turner.persistence.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.turner.model.Model;

/**
 *
 * @author turner
 */
public abstract class GenericHibernateDAO<T extends Model> {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Transactional
  public void save(T entity) {
    if (entity.getId() != null) {
      getEntityManager().merge(entity);
    } else {
      getEntityManager().persist(entity);
    }
  }
  
  protected EntityManager getEntityManager() {
    assert entityManager != null;
    return entityManager;
  }
  
}
