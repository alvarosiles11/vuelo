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
	public List<Tripulante> getAll() throws HttpException {
		try {
			Response<List<Tripulante>> lista = _mediator.send(new GetAllTripulanteQuery());
			return lista.data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpException(404, "Error " + e.getMessage());
		}
	}

	@PostMapping("/registro")
	public Response<Tripulante> register(@RequestBody CrearTripulanteCommand tripulante)
			throws HttpException {
		try {
			return _mediator.send(tripulante);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}

	@GetMapping("/{key}")
	public Response<TripulanteDto> getByKey(@PathVariable GetTripulanteByKeyQuery request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}

	@PutMapping("/{key}")
	public Response<Tripulante> edit(
			@RequestBody Tripulante tripulante,
			@PathVariable EditarTripulanteCommand request) throws HttpException {
		request.tripulanteDto.setKeyVuelo(tripulante.getKeyVuelo());
		request.tripulanteDto.setKeyTripulante(tripulante.getKeyTripulante());
		request.tripulanteDto.setCargo(tripulante.getCargo());
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}


  @DeleteMapping("/{key}")
  public Response<Tripulante> delete(@PathVariable EliminarTripulanteCommand request)
    throws HttpException {
    try {
      return _mediator.send(request);
    } catch (Exception e) {
      throw new HttpException(404, e.getMessage());
    }
  }


}
