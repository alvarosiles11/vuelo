package Controllers;

import java.util.List;

import Dto.TripulacionDto;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.GetMapping;
import Fourteam.http.annotation.PathVariable;
import Fourteam.http.annotation.RequestMapping;
import Fourteam.http.annotation.RestController;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import UseCases.Queries.Aeronave.GetByKey.GetAeronaveByKeyQuery;
import UseCases.Queries.Tripulacion.GetAll.GetAllTripulacionQuery;
import UseCases.Queries.Tripulacion.GetByKey.GetTripulacionByKeyQuery;

@RestController
@RequestMapping("/tripulacion")
public class TripulacionController {

	private Mediator _mediator;

	public TripulacionController(Mediator mediator) {
		_mediator = mediator;
	}

	@GetMapping("/")
	public List<TripulacionDto> getAll() throws HttpException {
		try {
			Response<List<TripulacionDto>> lista = _mediator.send(new GetAllTripulacionQuery());
			return lista.data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpException(404, "Error " + e.getMessage());
		}
	}

	@GetMapping("/{key}")
	public Response<TripulacionDto> getByKey(@PathVariable GetAeronaveByKeyQuery request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}

	public void getByKey(GetTripulacionByKeyQuery getTripulacionByKeyQuery) {
	}

	// @PutMapping("/{key}")
	// public TripulacionDto edit(
	// @RequestBody Tripulacion tripulacion,
	// @PathVariable EditarTripulacionCommand request) throws HttpException {
	// request.tripulacionDto.setEstado(tripulacion.getEstado());
	// try {
	// return (TripulacionDto) _mediator.send(request).data;
	// } catch (Exception e) {
	// throw (HttpException) e.getCause();
	// }
	// }
}