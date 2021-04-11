package br.com.luizalabs.repository;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class OrdemRepositoryTest {

    /*
    @InjectMock
    OrdemRepository ordemRepository;

    @Test
    public void testarSeListAllRetornaOrdensCorretas() {
        Ordem primeiraOrdem = new Ordem();
        Ordem segundaOrdem = new Ordem();

        List<Ordem> ordens = new ArrayList<Ordem>();
        ordens.add(primeiraOrdem);
        ordens.add(segundaOrdem);

        Mockito.when(ordemRepository.listAll()).thenReturn(ordens);

        Assertions.assertSame(segundaOrdem, ordemRepository.listAll().get(1));
    }
    */
}
