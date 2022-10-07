package UseCases.Command.Vuelos.Crear;

import java.util.ArrayList;
import java.util.List;

import Factories.IVueloFactory;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulacion;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IAeronaveRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import Repositories.IVueloRepository;

public class CrearVueloHandler
		implements RequestHandler<CrearVueloCommand, Vuelo> {

	private IVueloFactory iVueloFactory;
	private IVueloRepository iVueloRepository;
	private IAeronaveRepository iAeronaveRepository;
	private ITripulacionRepository iTripulacionRepository;

	private IUnitOfWork unitOfWor;

	public CrearVueloHandler(
			IVueloFactory iVueloFactory,
			IVueloRepository iVueloRepository,
			IAeronaveRepository iAeronaveRepository,
			ITripulacionRepository iTripulacionRepository,
			IUnitOfWork unitOfWork) {
		this.iVueloFactory = iVueloFactory;
		this.iVueloRepository = iVueloRepository;
		this.iAeronaveRepository = iAeronaveRepository;
		this.iTripulacionRepository = iTripulacionRepository;
		this.unitOfWor = unitOfWork;
	}

	@Override
	public Vuelo handle(CrearVueloCommand arg0) throws Exception {

		// ✅ verifico nro aeronave si existe en la BD
		// Vuelo vueloNro = iVueloRepository.findNroVuelo(arg0.data.nroVuelo);
		// if (vueloNro != null)
		// throw new HttpException(404, "el numero de vuelo existe, otro ingresar");

		// ✅ verifico aeropuerto el origen y destino
		// if (arg0.data.origen == arg0.data.destino)
		// throw new HttpException(404, "son iguales origen y destino, ingresar otro ");

		// ✅ verifico aeronave si existe en la BD
		Aeronave aeronave = iAeronaveRepository.FindByKey(arg0.data.keyAeronave);
		// if (aeronave == null)
		// throw new HttpException(404, "no existe la eronave");

		// ⚠️ verifico si la tripulacion, ya esta en vuelo
		// if (aeronave.estado.equals("2"))
		// throw new HttpException(404, "aeronave esta en vuelo, usar otra");

		// ✅ validar la fecha distinto
		// if (arg0.data.fechaArribe.before(arg0.data.fechaSalida))
		// throw new HttpException(404, "debe ingresar otra hora");

		// ⚠️ verifico si la aeronave, ya esta en vuelo

		// ✅ verifico tripulacion si existe en la BD
		Tripulacion tripulacion = iTripulacionRepository.FindByKey(arg0.data.keyTripulacion);
		// if (tripulacion == null)
		// throw new HttpException(404, "no existe la tripulacion");

		// ⚠️ verifico si la tripulacion, ya esta en vuelo
		// if (tripulacion.estado.equals("2"))
		// throw new HttpException(404, "la tripulacion esta en vuelo, usar otra");

		List<Asiento> asientos = new ArrayList<>();
		for (Asiento asientoDto : aeronave.asientos) {
			asientos.add(new Asiento(asientoDto.key, asientoDto.keyAeronave, asientoDto.numero, asientoDto.clase,
					200.00, 0));
		}

		List<Tripulante> tripulantes = new ArrayList<>();
		for (Tripulante tripulante : tripulacion.tripulantes) {
			tripulantes.add(
					new Tripulante(tripulante.key, tripulante.keyTripulacion, tripulante.nombre, tripulante.apellido,
							tripulante.cargo, tripulante.estado));
		}

		Vuelo vuelo = iVueloFactory.Create(arg0.data.nroVuelo, arg0.data.keyAeronave, arg0.data.origen,
				arg0.data.destino, arg0.data.fechaSalida, arg0.data.fechaArribe, arg0.data.keyTripulacion, asientos,
				tripulantes);

		tripulacion.setEstado("2");
		Tripulacion tripulacion2 = iTripulacionRepository.Update(tripulacion);
		aeronave.setEstado("2");
		Aeronave aeronave2 = iAeronaveRepository.Update(aeronave);

		vuelo.eventCreado();
		iVueloRepository.Create(vuelo);
		unitOfWor.commit();
		return vuelo;
	}
}
