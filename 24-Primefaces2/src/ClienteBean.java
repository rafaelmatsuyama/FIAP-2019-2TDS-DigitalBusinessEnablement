import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClienteBean {
	public List<Cliente> getLista() {
			List<Cliente> lista = new ArrayList<Cliente>();
			lista.add(new Cliente("Fulano", "11.111.111-11", new Date()));
			lista.add(new Cliente("Beltrano", "22.222.222-22", new Date()));
			lista.add(new Cliente("Ciclano", "99.999.999-99", new Date()));
			return lista;
	}
}
