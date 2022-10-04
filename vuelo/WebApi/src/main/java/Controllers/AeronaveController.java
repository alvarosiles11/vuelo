package Controllers;

import java.util.List;

import Dto.AeronaveDto;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.GetMapping;
import Fourteam.http.annotation.PathVariable;
import Fourteam.http.annotation.RequestMapping;
import Fourteam.http.annotation.RestController;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import UseCases.Queries.Aeronave.GetAll.GetAllAeronaveQuery;
import UseCases.Queries.Aeronave.GetByKey.GetAeronaveByKeyQuery;

@RestController
@RequestMapping("/aeronave")
public class AeronaveController {

	private Mediator _mediator;

	public AeronaveController(Mediator mediator) {
		_mediator = mediator;
	}

	@GetMapping("/")
	public List<AeronaveDto> getAll() throws HttpException {
		try {
			Response<List<AeronaveDto>> lista = _mediator.send(new GetAllAeronaveQuery());
			return lista.data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpException(404, "Error " + e.getMessage());
		}
	}

	@GetMapping("/{key}")
	public Response<AeronaveDto> getByKey(@PathVariable GetAeronaveByKeyQuery request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}

	// @PutMapping("/{key}")
	// public AeronaveDto edit(
	// @RequestBody Aeronave aeronave,
	// @PathVariable EditarAeronaveCommand request) throws HttpException {
	// request.aeronaveDto.setEstado(aeronave.getEstado());
	// try {
	// return (AeronaveDto) _mediator.send(request).data;
	// } catch (Exception e) {
	// throw (HttpException) e.getCause();
	// }
	// }
}