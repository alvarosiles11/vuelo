package Controllers;

import Dto.VueloDto;
import Model.Vuelos.Vuelo;
import UseCases.Command.Vuelos.Crear.CrearVueloCommand;
import UseCases.Command.Vuelos.Editar.EditarVueloCommand;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloCommand;
import UseCases.Queries.Vuelos.GetAll.GetAllVueloQuery;
import UseCases.Queries.Vuelos.GetByKey.GetVueloByKeyQuery;
import fourteam.http.Exception.HttpException;
import fourteam.http.annotation.DeleteMapping;
import fourteam.http.annotation.GetMapping;
import fourteam.http.annotation.PathVariable;
import fourteam.http.annotation.PostMapping;
import fourteam.http.annotation.PutMapping;
import fourteam.http.annotation.RequestBody;
import fourteam.http.annotation.RequestMapping;
import fourteam.http.annotation.RestController;
import fourteam.mediator.Mediator;
import fourteam.mediator.Response;
import java.util.List;

@RestController
@RequestMapping("/vuelo")
public class VueloController {

  private Mediator _mediator;

  public VueloController(Mediator mediator) {
    _mediator = mediator;
  }

  @GetMapping("/")
  public Response<List<Vuelo>> getAll() throws HttpException {
    System.out.println("vuelo getAll exitoso");
    return _mediator.send(new GetAllVueloQuery());
  }

  @PostMapping("/registro")
  public Response<Vuelo> register(@RequestBody CrearVueloCommand _vuelo)
    throws HttpException {
    System.out.println("vuelo register exitoso");
    return _mediator.send(_vuelo);
  }

  @GetMapping("/{key}")
  public Response<VueloDto> getByKey(@PathVariable GetVueloByKeyQuery request)
    throws HttpException {
    System.out.println("vuelo getByKey exitoso");
    return _mediator.send(request);
  }

  @PutMapping("/{key}")
  public Response<Vuelo> edit(
    @RequestBody Vuelo vuelo,
    @PathVariable EditarVueloCommand request
  ) throws HttpException {
    request.vueloDto.setNroVuelo(vuelo.getNroVuelo());
    request.vueloDto.setKeyAeronave(vuelo.getKeyAeronave());
    request.vueloDto.setKeyAeropuertoOrigen(vuelo.getKeyAeropuertoOrigen());
    request.vueloDto.setKeyAeropuertoDestino(vuelo.getKeyAeropuertoDestino());
    request.vueloDto.setfechaSalida(vuelo.getfechaSalida());
    request.vueloDto.setfechaArribe(vuelo.getfechaArribe());

    System.out.println("vuelo edit exitoso");
    return _mediator.send(request);
  }

  @DeleteMapping("/{key}")
  public Response<Vuelo> delete(@PathVariable EliminarVueloCommand request)
    throws HttpException {
    System.out.println("vuelo delete exitoso");
    return _mediator.send(request);
  }
}
