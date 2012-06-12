package unlp.info.ingenieriaii.modelo;

public class ParEntero {
	private int primero, segundo;

	@Override
	public String toString() {

		return String.valueOf(this.getPrimero()) + '_'
				+ String.valueOf(this.getSegundo());
	}

	public ParEntero(String par) {
		String valores[] = par.split("_");
		
		this.setPrimero(Integer.valueOf(valores[0]));
		this.setSegundo(Integer.valueOf(valores[1]));
	}

	public ParEntero() {

	}

	public int getPrimero() {
		
		return primero;
	}

	public void setPrimero(int primero) {
		
		this.primero = primero;
	}

	public int getSegundo() {
		
		return segundo;
	}

	public void setSegundo(int segundo) {
		
		this.segundo = segundo;
	}
}
