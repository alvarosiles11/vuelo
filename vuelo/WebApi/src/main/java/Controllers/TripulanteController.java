package Controllers;

import Dto.TripulanteDto;
import Model.Vuelos.Tripulante;
import UseCases.Command.Tripulantes.Crear.CrearTripulanteCommand;
import UseCases.Command.Tripulantes.Editar.EditarTripulanteCommand;
import UseCases.Command.Tripulantes.Eliminar.EliminarTripulanteCommand;
import UseCases.Queries.Tripulantes.GetAll.GetAllTripulanteQuery;
import UseCases.Queries.Tripulantes.GetByKey.GetTripulanteByKeyQuery;
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
@RequestMapping("/tripulante")
public class TripulanteController {

  private Mediator _mediator;

  public TripulanteController(Mediator mediator) {
    _mediator = mediator;
  }

  @GetMapping("/")
  public Response<List<Tripulante>> getAll() throws HttpException {
    return _mediator.send(new GetAllTripulanteQuery());
  }

  @PostMapping("/registro")
  public Response<Tripulante> register(
    @RequestBody CrearTripulanteCommand _tripulante
  ) throws HttpException {
    return _mediator.send(_tripulante);
  }

  @GetMapping("/{key}")
  public Response<TripulanteDto> getByKey(
    @PathVariable GetTripulanteByKeyQuery request
  ) throws HttpException {
    return _mediator.send(request);
  }

  @PutMapping("/{key}")
  public Response<Tripulante> edit(
    @RequestBody Tripulante tripulante,
    @PathVariable EditarTripulanteCommand request
  ) throws HttpException {
    request.tripulanteDto.setKeyVuelo(tripulante.getKeyVuelo());
    request.tripulanteDto.setKeyTripulante(tripulante.getKeyTripulante());
    request.tripulanteDto.setCargo(tripulante.getCargo());

    System.out.println("tripulante edit exitoso");
    return _mediator.send(request);
  }

  @DeleteMapping("/{key}")
  public Response<Tripulante> delete(
    @PathVariable EliminarTripulanteCommand request
  ) throws HttpException {
    return _mediator.send(request);
  }
}
