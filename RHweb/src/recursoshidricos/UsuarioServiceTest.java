package recursoshidricos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities.Usuario;
import br.edu.ifpb.esperanca.daw2.RecursosHidricos.services.UsuarioService;

class UsuarioServiceTest {

	@Test
	void gerenciarUsuario() {
		UsuarioService service = new UsuarioService();
		Usuario u = new Usuario();
		u.setNome("nome");
		u.setCidade("Esperan�a");
		u.setEmail("email");
		u.setEstado("Para�ba");		
		service.save(u);
		assertNotNull(u.getId());
		Usuario outro = service.getByID(u.getId());
		assertEquals(u.getNome(), outro.getNome());
		
		
	}

}
