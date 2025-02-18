package br.gov.al.saude.locations.application.usecase.sector;

import java.util.List;

import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.inbound.FindAllSectorsInputPort;
import br.gov.al.saude.locations.application.ports.sector.outbound.FindAllSectorsOutputPort;

public class FindAllSectorsUseCase implements FindAllSectorsInputPort {

  private final FindAllSectorsOutputPort findAllSectorsOutputPort;

  public FindAllSectorsUseCase(FindAllSectorsOutputPort findAllSectorsOutputPort) {
    this.findAllSectorsOutputPort = findAllSectorsOutputPort;
  }

  @Override
  public List<Sector> find() {
    return findAllSectorsOutputPort.find();
  }

  @Override
  public List<Sector> findBySimpleProjection() {
    return findAllSectorsOutputPort.findBySimpleProjection();
  }

}
