
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import junit.framework.Assert;
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

    //Teste do recortar e colar
    @Test
    public void test1() {
        String entrada = "/* isso é um comentário */";
        String saida = "nenhum programa para compilar";

        compilador.getTaEditor().setText(entrada);
        compilador.getTaEditor().selectAll();
        compilador.getJbRecortar().doClick();
        compilador.getJbColar().doClick();

        compilador.getJbCompilar().doClick();

        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    //Teste do copiar e colar
    @Test
    public void test2() {
        String entrada = "/* isso é um comentário */";
        String saida = "nenhum programa para compilar";

        compilador.getTaEditor().setText(entrada);
        compilador.getTaEditor().selectAll();
        compilador.getJbCopiar().doClick();
        compilador.getTaEditor().setText("");
        compilador.getJbColar().doClick();

        compilador.getJbCompilar().doClick();

        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    @Test
    public void test3() {
        String saida = "nenhum programa para compilar";

        try {
            String executionPath = System.getProperty("user.dir");
            
            FileReader fr = new FileReader(executionPath + "\\test\\Arquivos\\AbrirArquivo.txt");
            BufferedReader br = new BufferedReader(fr);
            String linha = null;
            linha = (String) br.readLine();
            String texto = "";
            while (linha != null) {
                texto += linha + "\n";
                linha = br.readLine();
            }
            compilador.getTaEditor().setText(texto);
            br.close();

            compilador.getJbCompilar().doClick();
            
            Assert.assertEquals(saida, compilador.getTaMensagens().getText());
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
        }
    }
}
