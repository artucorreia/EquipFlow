package br.gov.al.saude.locations.adapters.annex.outbound.repository.entity;

import java.time.LocalDateTime;

import br.gov.al.saude.locations.adapters.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "annexes", schema = "locations")
public class AnnexEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, unique = true, nullable = false)
  private String name;

  public AnnexEntity() {
  }

  public AnnexEntity(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy,
      Boolean deleted, Long id, String name) {
    super(createdAt, createdBy, updatedAt, updatedBy, deleted);
    this.id = id;
    this.name = name;
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

}
