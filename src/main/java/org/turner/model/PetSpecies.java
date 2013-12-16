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
@SequenceGenerator(initialValue=1, name="PetSpeciesIdSequence")
public class PetSpecies implements Serializable {
  
  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PetSpeciesIdSequence")
  private Integer id;
  private String species;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final PetSpecies other = (PetSpecies) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + Objects.hashCode(this.id);
    return hash;
  }
}
