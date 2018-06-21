
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import trabalhofinalcompiladores.Compilador;

/**
 * @author larissa.makufka
 */
public class SintáticoTest {

    Compilador compilador;

    public SintáticoTest() {
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
    public void test1() {
        String entrada = "def\n"
                + "execute\n"
                + " input (lado)\n"
                + " área lado * lado\n"
                + " print (area)";

        String saida = "Erro na linha 4 - á símbolo inválido";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    @Test
    public void test2() {
        String entrada = "def\n"
                + "execute\n"
                + " input (lado)\n"
                + " area lado * lado\n"
                + " print (area)";

        String saida = "Erro na linha 4 - encontrado lado esperado set, :=";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    @Test
    public void test3() {
        String entrada = "def\n"
                + "execute\n"
                + " input (lado)\n"
                + " area := lado * lado\n"
                + " print (area)";

        String saida = "programa compilado com sucesso";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }
}
