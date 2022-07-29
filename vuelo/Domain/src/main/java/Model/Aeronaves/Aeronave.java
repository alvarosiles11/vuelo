package Model.Aeronaves;

import core.Entity;
import java.util.UUID;

public class Aeronave extends Entity<UUID> {

  public String matricula;

  public Aeronave() {}

  public Aeronave(String matricula) {
    this.key = UUID.randomUUID();
    this.matricula = matricula;
  }
}
