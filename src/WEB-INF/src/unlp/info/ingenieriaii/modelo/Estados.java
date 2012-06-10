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
	};
	
	public abstract int getId();
	
	public abstract String getDescripcion();
	
	public static List<Estados> todosLosEstados () {
		List<Estados> todos = new ArrayList<Estados>();
		todos.add(Estados.PENDIENTE);
		todos.add(Estados.ANULADA);
		todos.add(Estados.PAGADA);
		return todos;
	}
}
