package UseCases.Queries.Vuelos.GetAll;

import java.util.ArrayList;
import java.util.List;

import Dto.AsientoDto;
import Dto.TripulanteDto;
import Dto.VueloDto;
import Fourteam.mediator.RequestHandler;
import Model.Aeronaves.Asiento;
import Model.Tripulacion.Tripulante;
import Model.Vuelos.Vuelo;
import Repositories.IVueloRepository;

public class GetAllVueloHandler implements RequestHandler<GetAllVueloQuery, List<VueloDto>> {

	private IVueloRepository iVueloRepository;

	public GetAllVueloHandler(IVueloRepository iVueloRepository) {
		this.iVueloRepository = iVueloRepository;
	}

	@Override
	public List<VueloDto> handle(GetAllVueloQuery request) throws Exception {

		List<Vuelo> lista = iVueloRepository.GetAll();
		List<VueloDto> resp = new ArrayList<>();

		for (Vuelo vuelo : lista) {
			VueloDto vueloDto= new VueloDto();
			vueloDto.setKey(vuelo.getKey());
			vueloDto.setNroVuelo(vuelo.getNroVuelo());
			vueloDto.setKeyAeronave(vuelo.getKeyAeronave());
			vueloDto.setOrigen(vuelo.getOrigen());
			vueloDto.setDestino(vuelo.getDestino());
			vueloDto.setFechaSalida(vuelo.getFechaSalida());
			vueloDto.setFechaArribe(vuelo.getFechaArribe());
			vueloDto.setKeyTripulacion(vuelo.getKeyTripulacion());

			resp.add(vueloDto);

			List<AsientoDto> asientosDtos = new ArrayList<>();
			for (Asiento asiento : vuelo.asientos) {
        asientosDtos.add(new AsientoDto(asiento.keyAeronave, asiento.numero, asiento.clase, asiento.precio));
      }
			vueloDto.setAsientoDtos(asientosDtos);

			List<TripulanteDto> tripulanteDtos= new ArrayList<>();
			for (Tripulante tripulante: vuelo.tripulantes) {
        tripulanteDtos.add(new TripulanteDto(tripulante.keyTripulacion, tripulante.key, tripulante.nombre, tripulante.apellido, tripulante.cargo, tripulante.estado));
      }
			vueloDto.setTripulanteDtos(tripulanteDtos);
		}

		return resp;
	}
}