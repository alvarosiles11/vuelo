package Controllers;

import java.util.List;

import Dto.TripulanteDto;
import Model.Vuelos.Tripulante;
import UseCases.Queries.Tripulantes.GetAll.GetAllTripulanteQuery;
import UseCases.Queries.Tripulantes.GetByKey.GetTripulanteByKeyQuery;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.GetMapping;
import Fourteam.http.annotation.PathVariable;
import Fourteam.http.annotation.RequestMapping;
import Fourteam.http.annotation.RestController;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;

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

	// @PostMapping("/registro")
	// public Response<Tripulante> register(@RequestBody CrearTripulanteCommand
	// tripulante)
	// throws HttpException {
	// try {
	// return _mediator.send(tripulante);
	// } catch (Exception e) {
	// throw new HttpException(404, e.getMessage());
	// }
	// }

	@GetMapping("/{key}")
	public Response<TripulanteDto> getByKey(@PathVariable GetTripulanteByKeyQuery request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}

	// @PutMapping("/{key}")
	// public Response<Tripulante> edit(
	// @RequestBody Tripulante tripulante,
	// @PathVariable EditarTripulanteCommand request) throws HttpException {
	// request.tripulanteDto.setKeyVuelo(tripulante.getKeyVuelo());
	// request.tripulanteDto.setKeyTripulante(tripulante.getKeyTripulante());
	// request.tripulanteDto.setCargo(tripulante.getCargo());
	// try {
	// return _mediator.send(request);
	// } catch (Exception e) {
	// throw new HttpException(404, e.getMessage());
	// }
	// }

	// @DeleteMapping("/{key}")
	// public Response<Tripulante> delete(@PathVariable EliminarTripulanteCommand
	// request)
	// throws HttpException {
	// try {
	// return _mediator.send(request);
	// } catch (Exception e) {
	// throw new HttpException(404, e.getMessage());
	// }
	// }

}
