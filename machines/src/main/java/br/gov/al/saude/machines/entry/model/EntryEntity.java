package br.gov.al.saude.machines.entry.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.gov.al.saude.machines.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entries", schema = "machines")
public class EntryEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false)
  private String equipment;

  @Column(name = "sector_id", nullable = false)
  private Long sectorId;

  @Column(name = "problem_description", length = 255, nullable = false)
  private String problemDescription;

  @Column(length = 100, nullable = false)
  private String technician;

  @Column(name = "calling_id", length = 15)
  private String callingId;

  @Column(name = "serial_number", length = 20)
  private String serialNumber;

  @Column(name = "heritage_number", length = 20)
  private String heritageNumber;

  @Column(name = "entry_at", nullable = false)
  private LocalDate entryAt;

  public EntryEntity() {
  }

  public EntryEntity(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy,
      Boolean deleted, Long id, String equipment, Long sectorId, String problemDescription, String technician,
      String callingId, String serialNumber, String heritageNumber, LocalDate entryAt) {
    super(createdAt, createdBy, updatedAt, updatedBy, deleted);
    this.id = id;
    this.equipment = equipment;
    this.sectorId = sectorId;
    this.problemDescription = problemDescription;
    this.technician = technician;
    this.callingId = callingId;
    this.serialNumber = serialNumber;
    this.heritageNumber = heritageNumber;
    this.entryAt = entryAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEquipment() {
    return equipment;
  }

  public void setEquipment(String equipment) {
    this.equipment = equipment;
  }

  public Long getSectorId() {
    return sectorId;
  }

  public void setSectorId(Long sectorId) {
    this.sectorId = sectorId;
  }

  public String getProblemDescription() {
    return problemDescription;
  }

  public void setProblemDescription(String problemDescription) {
    this.problemDescription = problemDescription;
  }

  public String getTechnician() {
    return technician;
  }

  public void setTechnician(String technician) {
    this.technician = technician;
  }

  public String getCallingId() {
    return callingId;
  }

  public void setCallingId(String callingId) {
    this.callingId = callingId;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public String getHeritageNumber() {
    return heritageNumber;
  }

  public void setHeritageNumber(String heritageNumber) {
    this.heritageNumber = heritageNumber;
  }

  public LocalDate getEntryAt() {
    return entryAt;
  }

  public void setEntryAt(LocalDate entryAt) {
    this.entryAt = entryAt;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    MachineEntry other = (MachineEntry) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }

}
