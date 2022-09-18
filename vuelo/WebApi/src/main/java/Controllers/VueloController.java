package Controllers;

import Dto.VueloDto;
import Model.Vuelos.Vuelo;
import UseCases.Command.Vuelos.Crear.CrearVueloCommand;
import UseCases.Command.Vuelos.Editar.EditarVueloCommand;
import UseCases.Command.Vuelos.Eliminar.EliminarVueloCommand;
import UseCases.Queries.Vuelos.GetAll.GetAllVueloQuery;
import UseCases.Queries.Vuelos.GetByKey.GetVueloByKeyQuery;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.DeleteMapping;
import Fourteam.http.annotation.GetMapping;
import Fourteam.http.annotation.PathVariable;
import Fourteam.http.annotation.PostMapping;
import Fourteam.http.annotation.PutMapping;
import Fourteam.http.annotation.RequestBody;
import Fourteam.http.annotation.RequestMapping;
import Fourteam.http.annotation.RestController;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import java.util.List;

@RestController
@RequestMapping("/vuelo")
public class VueloController {

	private Mediator _mediator;

	public VueloController(Mediator mediator) {
		_mediator = mediator;
	}

	@GetMapping("/")
	public List<Vuelo> getAll() throws HttpException {
		try {
			Response<List<Vuelo>> lista = _mediator.send(new GetAllVueloQuery());
			return lista.data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpException(404, "Error " + e.getMessage());
		}
	}

	@PostMapping("/registro")
	public Vuelo register(@RequestBody CrearVueloCommand vuelo)
			throws Exception {
		return (Vuelo) _mediator.send(vuelo).data;
	}

	@GetMapping("/{key}")
	public Response<VueloDto> getByKey(@PathVariable GetVueloByKeyQuery request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}

	@PutMapping("/{key}")
	public Response<Vuelo> edit(
			@RequestBody Vuelo vuelo,
			@PathVariable EditarVueloCommand request) throws HttpException {
		request.vueloDto.setNroVuelo(vuelo.getNroVuelo());
		request.vueloDto.setKeyAeronave(vuelo.getKeyAeronave());
		request.vueloDto.setKeyAeropuertoOrigen(vuelo.getKeyAeropuertoOrigen());
		request.vueloDto.setKeyAeropuertoDestino(vuelo.getKeyAeropuertoDestino());
		request.vueloDto.setFechaSalida(vuelo.getFechaSalida());
		request.vueloDto.setFechaArribe(vuelo.getFechaArribe());
		request.vueloDto.setKeyTripulacion(vuelo.getKeyTripulacion());

		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}

	@DeleteMapping("/{key}")
	public Response<Vuelo> delete(@PathVariable EliminarVueloCommand request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw new HttpException(404, e.getMessage());
		}
	}

}
