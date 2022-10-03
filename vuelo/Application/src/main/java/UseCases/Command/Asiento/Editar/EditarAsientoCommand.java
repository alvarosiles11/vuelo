package UseCases.Command.Asiento.Editar;

import java.util.UUID;

import Dto.AsientoDto;
import Dto.VueloDto;
import Fourteam.mediator.Request;

public class EditarAsientoCommand implements Request<VueloDto> {

	public VueloDto vueloDto;
	public AsientoDto asientoDto;
	public String clase;
	public Double precio;

	public EditarAsientoCommand(UUID key) {
		this.vueloDto = new VueloDto();
		this.vueloDto.setKey(key);
		this.asientoDto = new AsientoDto();
		this.asientoDto.setClase(clase);
		this.asientoDto.setPrecio(precio);
	}
}
