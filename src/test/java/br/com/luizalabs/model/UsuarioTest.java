package br.com.luizalabs.model;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class UsuarioTest {

    @Test
    public void testarSeFindByIdOptionalDevolveUsuarioCorreto() {
        /*
        // Mock database
        PanacheMock.mock(Usuario.class);
        Usuario u = new Usuario();
        Optional<PanacheEntityBase> usuario = Optional.of(u);

        // Return user mock
        Mockito.when(Usuario.findByIdOptional(41)).thenReturn(usuario);

        // Verify if is equal
        Assertions.assertSame(u, Usuario.findByIdOptional(41).get());
        */
    }
}