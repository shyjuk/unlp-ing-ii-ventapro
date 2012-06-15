package unlp.info.ingenieriaii.modelo;

import java.util.ArrayList;
import java.util.List;

public enum MediosDePago {
	EFECTIVO {
		@Override
		public int getId() {
			return 1;
		}

		@Override
		public String getDescripcion() {
			return "Efectivo";
		}
	},
	DEBITO {
		@Override
		public int getId() {
			return 2;
		}

		@Override
		public String getDescripcion() {
			return "Debito";
		}
	},
	CREDITO {
		@Override
		public int getId() {
			return 3;
		}

		@Override
		public String getDescripcion() {
			return "Credito";
		}
	};
	
	public abstract int getId();
	
	public abstract String getDescripcion();
	
	public static String getDescripcionPara (int id) {
		if (EFECTIVO.getId() == id) {
			return EFECTIVO.getDescripcion();
		}else if (DEBITO.getId() == id) {
			return DEBITO.getDescripcion();
		}else if (DEBITO.getId() == id) {
			return DEBITO.getDescripcion();
		}
		return "";
	}
	
	public static List<MediosDePago> todosMediosDePago() {
		List<MediosDePago> todos = new ArrayList<MediosDePago>();
		todos.add(MediosDePago.EFECTIVO);
		todos.add(MediosDePago.DEBITO);
		todos.add(MediosDePago.CREDITO);
		return todos;
	}
}
