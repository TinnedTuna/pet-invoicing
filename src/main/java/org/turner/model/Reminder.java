package org.turner.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author turner
 */
@Entity
@SequenceGenerator(initialValue=1, name="ReminderIdSequence")
public class Reminder implements Serializable {
  
  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ReminderIdSequence")
  private Integer id;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateSent;
  private boolean finalReminder;

  public Date getDateSent() {
    return dateSent;
  }

  public void setDateSent(Date dateSent) {
    this.dateSent = dateSent;
  }

  public boolean isFinalReminder() {
    return finalReminder;
  }

  public void setFinalReminder(boolean finalReminder) {
    this.finalReminder = finalReminder;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Reminder other = (Reminder) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(this.id);
    return hash;
  }
  
}
