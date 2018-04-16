
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import trabalhofinalcompiladores.Compilador;

public class InterfaceTest {

    Compilador compilador;

    public InterfaceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        compilador = new Compilador();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void limparEditorTest() {
        compilador.getTaEditor().setText("Compilador");
        compilador.getJbNovo().doClick();
        assertEquals(null, compilador.getTaEditor().getText(), "");
    }

    @Test
    public void limparAreaMensagensTest() {
        compilador.getTaEditor().setText("Compilador");
        compilador.getJbNovo().doClick();
        assertEquals(null, compilador.getTaMensagens().getText(), "");
    }

    @Test
    public void limparBarraStatusTest() {
        compilador.getTaEditor().setText("Compilador");
        compilador.getJbNovo().doClick();
        assertEquals(null, compilador.getLbBarraStatus().getText(), "");
    }

    @Test
    public void buttonAboutClickTest() {
        compilador.getJbEquipe().doClick();
        assertTrue(compilador.getTaMensagens().getText().equals(" - Douglas Eduardo Bauler; \n - Jefferson do Nascimento Júnior; \n - Larissa Sindy Makufka Schlichting."));
    }
}
