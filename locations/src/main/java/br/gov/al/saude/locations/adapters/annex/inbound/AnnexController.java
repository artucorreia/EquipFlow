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
import br.gov.al.saude.locations.adapters.common.response.ResponseDTO;
import br.gov.al.saude.locations.application.domain.Annex;
import br.gov.al.saude.locations.application.ports.annex.inbound.DeleteAnnexInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.FindAnnexByIdInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.InsertAnnexInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.UpdateAnnexInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/annexes")
@Tag(name = "Annexes", description = "Endpoints to manager annexes")
public class AnnexController {

  private final FindAnnexByIdInputPort findAnnexByIdInputPort;
  private final InsertAnnexInputPort insertAnnexInputPort;
  private final UpdateAnnexInputPort updateAnnexInputPort;
  private final DeleteAnnexInputPort deleteAnnexInputPort;
  private final AnnexMapperInbound annexMapperInbound;

  @Autowired
  public AnnexController(FindAnnexByIdInputPort findAnnexByIdInputPort, InsertAnnexInputPort insertAnnexInputPort,
      UpdateAnnexInputPort updateAnnexInputPort, DeleteAnnexInputPort deleteAnnexInputPort,
      AnnexMapperInbound annexMapperInbound) {
    this.findAnnexByIdInputPort = findAnnexByIdInputPort;
    this.insertAnnexInputPort = insertAnnexInputPort;
    this.updateAnnexInputPort = updateAnnexInputPort;
    this.deleteAnnexInputPort = deleteAnnexInputPort;
    this.annexMapperInbound = annexMapperInbound;
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Find an annex by id", description = "Find an annex by id", tags = { "Annexes" }, method = "GET")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = AnnexDTO.class))),
      @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
  })
  public ResponseEntity<AnnexDTO> findById(@PathVariable Long id) {
    Annex annex = findAnnexByIdInputPort.find(id);
    AnnexDTO annexDTO = annexMapperInbound.toDTO(annex);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(annexDTO);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create a new annex", description = "Create a new annex", tags = {
      "Annexes" }, method = "POST", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
            { "name": "string" }
          """))))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
      @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
      @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
  })
  public ResponseEntity<ResponseDTO> insert(@Valid @RequestBody CreateAnnexDTO createAnnexDTO) {
    Annex annex = annexMapperInbound.toDomain(createAnnexDTO);
    insertAnnexInputPort.insert(annex);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(new ResponseDTO(AnnexConstant.MESSAGE_201, AnnexConstant.STATUS_201, LocalDateTime.now()));
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update an annex", description = "Update an annex", tags = {
      "Annexes" }, method = "PUT", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", examples = @ExampleObject(value = """
            { "name": "string" }
          """))))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
      @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
      @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
  })
  public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @Valid @RequestBody UpdateAnnexDTO updateAnnexDTO) {
    Annex updatedAnnex = annexMapperInbound.toDomain(updateAnnexDTO);
    updateAnnexInputPort.update(id, updatedAnnex);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(new ResponseDTO(AnnexConstant.MESSAGE_200, AnnexConstant.STATUS_200, LocalDateTime.now()));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Delete an annex by id", description = "Delete an annex by id", tags = {
      "Annexes" }, method = "DELETE")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = ResponseDTO.class))),
      @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
      @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content)
  })
  public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
    deleteAnnexInputPort.delete(id);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(new ResponseDTO(AnnexConstant.MESSAGE_204, AnnexConstant.STATUS_204, LocalDateTime.now()));
  }

}
