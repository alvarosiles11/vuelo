package Dto;

import java.util.UUID;

public class AeronaveDto {

  private UUID keyAeronave;
  private String matricula;

  public UUID getKeyAeronave() {
    return keyAeronave;
  }

  public void setKeyAeronave(UUID keyAeronave) {
    this.keyAeronave = keyAeronave;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }
}
