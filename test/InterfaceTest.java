
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    public void buttonCompileClickTest() {
        compilador.getJbCompilar().doClick();
        assertTrue(compilador.getTaMensagens().getText().equals("compilação de programas ainda não foi implementada"));
    }

    @Test
    public void buttonAboutClickTest() {
        compilador.getJbCompilar().doClick();
        assertTrue(compilador.getTaMensagens().getText().equals(" - Douglas Eduardo Bauler; \n - Jefferson do Nascimento Júnior; \n - Larissa Sindy Makufka Schlichting."));
    }
}
