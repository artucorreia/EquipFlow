package br.gov.al.saude.locations.adapters.annex.inbound;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.al.saude.locations.adapters.annex.inbound.constant.AnnexConstant;
import br.gov.al.saude.locations.adapters.annex.inbound.mapper.AnnexMapperInbound;
import br.gov.al.saude.locations.adapters.annex.inbound.request.CreateAnnexDTO;
import br.gov.al.saude.locations.adapters.annex.inbound.request.UpdateAnnexDTO;
import br.gov.al.saude.locations.adapters.annex.inbound.response.AnnexDTO;
import br.gov.al.saude.locations.adapters.annex.inbound.response.ResponseDTO;
import br.gov.al.saude.locations.application.domain.Annex;
import br.gov.al.saude.locations.application.ports.annex.inbound.DeleteAnnexByIdInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.FindAnnexByIdInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.InsertAnnexInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.UpdateAnnexInputPort;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/annexes")
public class AnnexController {

  private final FindAnnexByIdInputPort findAnnexByIdInputPort;
  private final InsertAnnexInputPort insertAnnexInputPort;
  private final UpdateAnnexInputPort updateAnnexInputPort;
  private final DeleteAnnexByIdInputPort deleteAnnexByIdInputPort;
  private final AnnexMapperInbound annexMapperInbound;

  @Autowired
  public AnnexController(FindAnnexByIdInputPort findAnnexByIdInputPort, InsertAnnexInputPort insertAnnexInputPort,
      UpdateAnnexInputPort updateAnnexInputPort, DeleteAnnexByIdInputPort deleteAnnexByIdInputPort,
      AnnexMapperInbound annexMapperInbound) {
    this.findAnnexByIdInputPort = findAnnexByIdInputPort;
    this.insertAnnexInputPort = insertAnnexInputPort;
    this.updateAnnexInputPort = updateAnnexInputPort;
    this.deleteAnnexByIdInputPort = deleteAnnexByIdInputPort;
    this.annexMapperInbound = annexMapperInbound;
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AnnexDTO> findById(@PathVariable Long id) {
    Annex annex = findAnnexByIdInputPort.find(id);
    AnnexDTO annexDTO = annexMapperInbound.toDTO(annex);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(annexDTO);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> insert(@Valid @RequestBody CreateAnnexDTO createAnnexDTO) {
    Annex annex = annexMapperInbound.toDomain(createAnnexDTO);
    insertAnnexInputPort.insert(annex);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(new ResponseDTO(AnnexConstant.MESSAGE_201, AnnexConstant.STATUS_201, LocalDateTime.now()));
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @Valid @RequestBody UpdateAnnexDTO updateAnnexDTO) {
    Annex updatedAnnex = annexMapperInbound.toDomain(updateAnnexDTO);
    updateAnnexInputPort.update(id, updatedAnnex);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(new ResponseDTO(AnnexConstant.MESSAGE_200, AnnexConstant.STATUS_200, LocalDateTime.now()));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
    deleteAnnexByIdInputPort.delete(id);
    return ResponseEntity
        .status(HttpStatus.NO_CONTENT)
        .body(new ResponseDTO(AnnexConstant.MESSAGE_204, AnnexConstant.STATUS_204, LocalDateTime.now()));
  }

}
