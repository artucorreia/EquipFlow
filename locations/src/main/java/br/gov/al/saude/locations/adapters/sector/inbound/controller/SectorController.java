package br.gov.al.saude.locations.adapters.sector.inbound.controller;

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

import br.gov.al.saude.locations.adapters.common.response.ResponseDTO;
import br.gov.al.saude.locations.adapters.sector.inbound.controller.constant.SectorConstant;
import br.gov.al.saude.locations.adapters.sector.inbound.controller.mapper.SectorMapperInbound;
import br.gov.al.saude.locations.adapters.sector.inbound.controller.request.CreateSectorDTO;
import br.gov.al.saude.locations.adapters.sector.inbound.controller.request.UpdateSectorDTO;
import br.gov.al.saude.locations.adapters.sector.inbound.controller.response.SectorDTO;
import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.inbound.DeleteSectorInputPort;
import br.gov.al.saude.locations.application.ports.sector.inbound.FindSectorByIdInputPort;
import br.gov.al.saude.locations.application.ports.sector.inbound.InsertSectorInputPort;
import br.gov.al.saude.locations.application.ports.sector.inbound.UpdateSectorInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/sectors")
@Tag(name = "Sectors", description = "Endpoints to manager sectors")
public class SectorController {

  private final FindSectorByIdInputPort findSectorByIdInputPort;
  private final InsertSectorInputPort insertSectorInputPort;
  private final UpdateSectorInputPort updateSectorInputPort;
  private final DeleteSectorInputPort deleteSectorInputPort;
  private final SectorMapperInbound sectorMapperInbound;

  @Autowired
  public SectorController(FindSectorByIdInputPort findSectorByIdInputPort, InsertSectorInputPort insertSectorInputPort,
      UpdateSectorInputPort updateSectorInputPort, DeleteSectorInputPort deleteSectorInputPort,
      SectorMapperInbound sectorMapperInbound) {
    this.findSectorByIdInputPort = findSectorByIdInputPort;
    this.insertSectorInputPort = insertSectorInputPort;
    this.updateSectorInputPort = updateSectorInputPort;
    this.deleteSectorInputPort = deleteSectorInputPort;
    this.sectorMapperInbound = sectorMapperInbound;
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

  @Operation(summary = "Find a sector by id", description = "Find a sector by id", tags = { "Sectors" }, method = "GET")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = SectorDTO.class))),
      @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
  })
  public ResponseEntity<SectorDTO> findById(@PathVariable Long id) {
    Sector sector = findSectorByIdInputPort.find(id);
    SectorDTO sectorDTO = sectorMapperInbound.toDTO(sector);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(sectorDTO);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create a new sector", description = "Create a new sector", tags = {
      "Sectors" }, method = "POST", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
            { "name": "string", "acronym": "string", "annexId": "Long" }
          """))))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
      @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
      @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
  })
  public ResponseEntity<ResponseDTO> insert(@Valid @RequestBody CreateSectorDTO createSectorDTO) {
    Sector sector = sectorMapperInbound.toDomain(createSectorDTO);
    insertSectorInputPort.insert(sector);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(new ResponseDTO(SectorConstant.MESSAGE_201, SectorConstant.STATUS_201, LocalDateTime.now()));
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update a sector", description = "Update a sector", tags = {
      "Sectors" }, method = "PUT", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
            { "name": "string", "acronym": "string", "annexId": "long" }
          """))))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
      @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
      @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
  })
  public ResponseEntity<ResponseDTO> update(@PathVariable Long id,
      @Valid @RequestBody UpdateSectorDTO updateSectorDTO) {
    Sector sector = sectorMapperInbound.toDomain(updateSectorDTO);
    updateSectorInputPort.update(id, sector);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(new ResponseDTO(SectorConstant.MESSAGE_200, SectorConstant.STATUS_200, LocalDateTime.now()));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

  @Operation(summary = "Delete a sector by id", description = "Delete a sector by id", tags = {
      "Sectors" }, method = "DELETE")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
      @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
  })
  public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
    deleteSectorInputPort.delete(id);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(new ResponseDTO(SectorConstant.MESSAGE_204, SectorConstant.STATUS_204, LocalDateTime.now()));
  }
}
