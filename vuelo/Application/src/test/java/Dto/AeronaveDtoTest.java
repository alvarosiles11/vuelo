package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class AeronaveDtoTest {

  @Test
  public void CheckPropertiesValid() {

    UUID keyAeronave = UUID.randomUUID();
    String matricula = "xyz-1990";
    List<AsientoDto> listdaAsientos = new ArrayList<>();
    String estado = "0";

    AeronaveDto aeronaveDto = new AeronaveDto();

    Assert.assertEquals(null, aeronaveDto.getKeyAeronave());
    Assert.assertEquals(null, aeronaveDto.getMatricula());
    Assert.assertEquals(null, aeronaveDto.getListaAsientos());
    Assert.assertEquals(null, aeronaveDto.getEstado());

    aeronaveDto.setKeyAeronave(keyAeronave);
    aeronaveDto.setMatricula(matricula);
    aeronaveDto.setListaAsientos(listdaAsientos);
    aeronaveDto.setEstado(estado);

    Assert.assertEquals(keyAeronave, aeronaveDto.getKeyAeronave());
    Assert.assertEquals(matricula, aeronaveDto.getMatricula());
    Assert.assertEquals(listdaAsientos, aeronaveDto.getListaAsientos());
    Assert.assertEquals(estado, aeronaveDto.getEstado());
  }
}
