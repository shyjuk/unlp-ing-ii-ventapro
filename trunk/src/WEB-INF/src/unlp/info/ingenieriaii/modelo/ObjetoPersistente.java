package unlp.info.ingenieriaii.modelo;

import java.util.Random;

public abstract class ObjetoPersistente {

	private int id = -1;
	
	public void generarIDAutomatico () {
		this.setId((new Random()).nextInt(100));
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
