	final UUID keyAeronave = UUID.randomUUID();
	final String matricula = "xyz-1990";
	final List<AsientoDto> listdaAsientos = getListdaAsientos();
	final String estado = "0";

	UUID keyAeronave = UUID.randomUUID();
	UUID keyAsiento = UUID.randomUUID();
	int numero = 1;
	String clase = "comercial";
	Double precio = 20.20;
	int disponibilidad = 1;

	final UUID keyTripulacion = UUID.randomUUID();
	final String descripcion = "Grupo-A";
	final String estado = "0";
	final List<TripulanteDto> tripulantes = getListdaTripulantes();

 	UUID keyTripulacion = UUID.randomUUID();
	UUID keyTripulante = UUID.randomUUID();
	String nombre = "manuel";
	String apellido = "soliz marin";
	String cargo = "Piloto";
	String estado = "0";

	final UUID key = UUID.randomUUID();
	final String nroVuelo = "scz-cba-513184";
	final UUID keyAeronave = UUID.randomUUID();
	final String origen = "Scz-ViruViru";
	final String destino = "CBA-CBA";
	final Date fechaSalida = new Date();
	final Date fechaArribe = new Date();
	final UUID keyTripulacion = UUID.randomUUID();
	final String observacion = "En horario";
	final String estado = "1";
	final List<AsientoDto> asientos = getListAsiento();
	final List<TripulanteDto> tripulantes = getListdaTripulantes();
