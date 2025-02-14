package br.gov.al.saude.locations.adapters.sector.outbound.repository.entity;

import java.time.LocalDateTime;

import br.gov.al.saude.locations.adapters.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sectors", schema = "locations")
public class SectorEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 150, nullable = false)
  private String name;

  @Column(length = 30)
  private String acronym;

  @Column(name = "annex_id")
  private Long annexId;

  public SectorEntity() {
  }

  public SectorEntity(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy,
      Boolean deleted, Long id, String name, String acronym, Long annexId) {
    super(createdAt, createdBy, updatedAt, updatedBy, deleted);
    this.id = id;
    this.name = name;
    this.acronym = acronym;
    this.annexId = annexId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAcronym() {
    return acronym;
  }

  public void setAcronym(String acronym) {
    this.acronym = acronym;
  }

  public Long getAnnexId() {
    return annexId;
  }

  public void setAnnexId(Long annexId) {
    this.annexId = annexId;
  }

}
