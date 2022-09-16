package IntegrationEvents;

import core.IntegrationEvent;
import java.util.UUID;

public class AeronaveCreado extends IntegrationEvent {

  public UUID keyAeronave;
  public String matricula;

  public UUID getKeyAeronave() {
    return keyAeronave;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setKeyAeronave(UUID keyAeronave) {
    this.keyAeronave = keyAeronave;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }
}
