package br.gov.al.saude.machines.exit.model;

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
@Table(name = "exits", schema = "machines")
public class ExitEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "sector_id", nullable = false)
  private Long sectorId;

  @Column(length = 100, nullable = false)
  private String technician;

  @Column(name = "solution_description", length = 255, nullable = false)
  private String solutionDescription;

  @Column(name = "entry_id", nullable = false)
  private Long entryId;

  @Column(name = "exit_at", nullable = false)
  private LocalDate exitAt;

  public ExitEntity() {
  }

  public ExitEntity(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy,
      Boolean deleted, Long id, Long sectorId, String technician, String solutionDescription, Long entryId,
      LocalDate exitAt) {
    super(createdAt, createdBy, updatedAt, updatedBy, deleted);
    this.id = id;
    this.sectorId = sectorId;
    this.technician = technician;
    this.solutionDescription = solutionDescription;
    this.entryId = entryId;
    this.exitAt = exitAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSectorId() {
    return sectorId;
  }

  public void setSectorId(Long sectorId) {
    this.sectorId = sectorId;
  }

  public String getTechnician() {
    return technician;
  }

  public void setTechnician(String technician) {
    this.technician = technician;
  }

  public String getSolutionDescription() {
    return solutionDescription;
  }

  public void setSolutionDescription(String solutionDescription) {
    this.solutionDescription = solutionDescription;
  }

  public Long getEntryId() {
    return entryId;
  }

  public void setEntryId(Long entryId) {
    this.entryId = entryId;
  }

  public LocalDate getExitAt() {
    return exitAt;
  }

  public void setExitAt(LocalDate exitAt) {
    this.exitAt = exitAt;
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
    ExitEntity other = (ExitEntity) obj;
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
