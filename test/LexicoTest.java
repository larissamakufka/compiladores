
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import trabalhofinalcompiladores.Compilador;

public class LexicoTest {

    Compilador compilador;

    public LexicoTest() {
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
        String entrada = "\\* isso é um comentário *\\\n\n"
                + "print i_area =\n\n"
                + "\"valor\" 01,0";

        String saida = "linha   classe               lexema\n"
                + "3       palavra reservada    print\n"
                + "3       identificador        i_area\n"
                + "3       símbolo especial     =\n"
                + "5       constante caracter   \"valor\"\n"
                + "5       constante inteira    0\n"
                + "5       constante real       1,0\n"
                + "\n"
                + "programa compilado com sucesso";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    @Test
    public void test2() {
        String entrada = "\\* isso é um comentário *\\\n\n"
                + "print i_area =\n\n"
                + "\"valor 01,0";

        String saida = "Erro na linha 5 - constante caractere inválida ou não finalizada";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    @Test
    public void test3() {
        String entrada = "@";

        String saida = "Erro na linha 1 - @ símbolo inválido";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    @Test
    public void test4() {
        String entrada = "|$";

        String saida = "Erro na linha 1 - |$ símbolo inválido";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    @Test
    public void test5() {
        String entrada = "&a";

        String saida = "Erro na linha 1 - &a símbolo inválido";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    @Test
    public void test6() {
        String entrada = "\"valor";

        String saida = "Erro na linha 1 - constante caractere inválida ou não finalizada";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    @Test
    public void test7() {
        String entrada = "\\**";

        String saida = "Erro na linha 1 - comentário de bloco inválido ou não finalizado";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }
}
