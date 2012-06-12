package unlp.info.ingenieriaii.modelo;

import java.util.ArrayList;
import java.util.List;

public enum Estados {
	PENDIENTE {
		@Override
		public int getId() {
			return 1;
		}

		@Override
		public String getDescripcion() {
			return "Pendiente";
		}
	},
	ANULADA {
		@Override
		public int getId() {
			return 2;
		}

		@Override
		public String getDescripcion() {
			return "Anulada";
		}
	},
	PAGADA {
		@Override
		public int getId() {
			return 3;
		}

		@Override
		public String getDescripcion() {
			return "Pagada";
		}
	},
	ARMANDOSE {
		@Override
		public int getId() {
			return 4;
		}

		@Override
		public String getDescripcion() {
			return "-";
		}
	};

	public abstract int getId();

	public abstract String getDescripcion();

	// Estoy excluyendo "ARMANDOSE" a propósito porque es una cosa interna.
	public static List<Estados> todosLosEstados() {
		List<Estados> todos = new ArrayList<Estados>();
		todos.add(Estados.PENDIENTE);
		todos.add(Estados.ANULADA);
		todos.add(Estados.PAGADA);
		return todos;
	}

	public static String getDescripcionPara(int id) {
		if (PENDIENTE.getId() == id) {
			return PENDIENTE.getDescripcion();
		} else if (ANULADA.getId() == id) {
			return ANULADA.getDescripcion();
		} else if (PAGADA.getId() == id) {
			return PAGADA.getDescripcion();
		}
		return "";
	}
}
