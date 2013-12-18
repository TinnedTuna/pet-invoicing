package org.turner.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author turner
 */
@Entity
@SequenceGenerator(initialValue=1, name="TitleIdSequence")
public class Title implements Serializable, Model {

  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="TitleIdSequence")
  private Integer id;
  private String title;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Title other = (Title) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + Objects.hashCode(this.id);
    return hash;
  }
  
}
