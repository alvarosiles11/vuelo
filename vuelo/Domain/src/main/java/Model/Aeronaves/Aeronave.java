package Model.Aeronaves;

import core.Entity;

import java.util.List;
import java.util.UUID;

public class Aeronave extends Entity<UUID> {

  public String matricula;
	public List<Asiento> asientos;

  public Aeronave() {}

  public Aeronave(String matricula) {
    this.key = UUID.randomUUID();
    this.matricula = matricula;
  }



}
