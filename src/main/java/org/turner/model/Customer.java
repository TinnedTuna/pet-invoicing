package org.turner.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author turner
 */
@Entity
@SequenceGenerator(initialValue=1, name="CustomerIdSequence")
@Table(name="customer")
public class Customer implements Serializable, Model {

  public Customer() {
  }

  public Customer(String secondName, String addressLineOne, String postalCode) {
    this.secondName = secondName;
    this.addressLineOne = addressLineOne;
    this.postalCode = postalCode;
  }

  public Customer(
          Title title,
          String firstName,
          String secondName,
          String addressLineOne,
          String addressLineTwo,
          String city, 
          String postalCode,
          String phoneNumber,
          String mobileNumber,
          String notes) {
    this.title = title;
    this.firstName = firstName;
    this.secondName = secondName;
    this.addressLineOne = addressLineOne;
    this.addressLineTwo = addressLineTwo;
    this.city = city;
    this.postalCode = postalCode;
    this.phoneNumber = phoneNumber;
    this.mobileNumber = mobileNumber;
    this.notes = notes;
  }

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY, generator="CustomerIdSequence")
  @Column(name="customer_id", nullable=false, unique=true)
  private Long id;
  
  @ManyToOne
  private Title title;
  
  @Column(name="first_name")
  private String firstName;
  @Column(name="second_name", nullable=false)
  private String secondName;
  
  @Column(name="address_line_one", nullable=false)
  private String addressLineOne;
  @Column(name="address_line_two")
  private String addressLineTwo;
  @Column(name="city")
  private String city;
  @Column(name="post_code", nullable=false)
  private String postalCode;

  private String phoneNumber;
  private String mobileNumber;
  
  private String notes;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAddressLineOne() {
    return addressLineOne;
  }

  public void setAddressLineOne(String addressLineOne) {
    this.addressLineOne = addressLineOne;
  }

  public String getAddressLineTwo() {
    return addressLineTwo;
  }

  public void setAddressLineTwo(String addressLineTwo) {
    this.addressLineTwo = addressLineTwo;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public Title getTitle() {
    return title;
  }

  public void setTitle(Title title) {
    this.title = title;
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Customer other = (Customer) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.id);
    return hash;
  }
}
