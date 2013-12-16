package org.turner.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author turner
 */
@Entity
@SequenceGenerator(initialValue=1, name="InvoiceIdSequence")
public class Invoice implements Serializable {
  
  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="InvoiceIdSequence")
  private Integer id;
  @ManyToOne
  private Customer customer;
  @ManyToOne
  private Pet pet;
  
  private String notes;
  
  @OneToMany
  private List<InvoiceService> invoiceServices; 
  
  @OneToMany
  private List<Reminder> remindersSent;

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<InvoiceService> getInvoiceServices() {
    return invoiceServices;
  }

  public void setInvoiceServices(List<InvoiceService> invoiceServices) {
    this.invoiceServices = invoiceServices;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public List<Reminder> getRemindersSent() {
    return remindersSent;
  }

  public void setRemindersSent(List<Reminder> remindersSent) {
    this.remindersSent = remindersSent;
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Invoice other = (Invoice) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  public int hashCode() {
    int hash = 3;
    hash = 31 * hash + Objects.hashCode(this.id);
    return hash;
  }
}
