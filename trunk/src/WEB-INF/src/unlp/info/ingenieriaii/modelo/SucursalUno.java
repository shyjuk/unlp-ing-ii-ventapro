package unlp.info.ingenieriaii.modelo;

public class SucursalUno {
	
	private static SucursalUno instance;
	
	private String nombre;
	
	public static final SucursalUno getSingleInstance () {
		if (instance == null) {
			SucursalUno.setInstance(new SucursalUno());
		}
		return instance;
	}

	public static SucursalUno getInstance() {
		return instance;
	}

	public static void setInstance(SucursalUno instance) {
		SucursalUno.instance = instance;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
