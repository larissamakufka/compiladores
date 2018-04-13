
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
    
    @Test
    public void test8() {
        String entrada = "\\* isso é um comentário + ! ? #4%%$ *\\\n\n" +
                         "bool teste = true \n" +
                         "if teste \n" +
                           "int x = 10 * 5 \n" +
                         "end";

        String saida = "linha   classe               lexema \n" +
                       "1       palavra reservada    bool \n" +
                       "1       identificador        teste \n" +
                       "1       símbolo especial     = \n" +
                       "1       palavra reservada    true \n" +
                       "3       identificador        if \n" +
                       "3       identificador        teste \n" +
                       "4       identificador        begin \n" +
                       "5       palavra reservada    int \n" +
                       "5       identificador        x \n" +
                       "5       símbolo especial     = \n" +
                       "5       constante inteira    10 \n" +
                       "5       símbolo especial     * \n" +
                       "5       constante inteira    5 \n" +
                       "6       palavra reservada    end \n" +
                       "7       identificador        else \n" +
                       "8       palavra reservada    int \n" +
                       "8       identificador        x \n" +
                       "8       símbolo especial     = \n" +
                       "8       constante inteira    10 \n" + 
                       "8       símbolo especial     * \n" +
                       "8       símbolo especial     - \n" +
                       "8       constante inteira    2 \n" +
                       "9       palavra reservada    end \n" +
                       "\n" +
                       "programa compilado com sucesso";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }
 
    @Test
    public void test9() {
        String entrada = "\\* isso é um comentário + ! ? #4%%$ *\\\n\n" +
                         "int i := 3 / 5 (10 * 90 * ((15 / 10) * (20 * 50)) + 1000 * (20 * 9) * (9 * 100))\n";

        String saida = "linha   classe               lexema \n" +
                       "1       palavra reservada    int \n" +
                       "1       identificador        i \n" +
                       "1       símbolo especial     := \n" +
                       "1       constante inteira    3 \n" +
                       "1       símbolo especial     / \n" +
                       "1       constante inteira    5 \n" + 
                       "1       símbolo especial     ( \n" +
                       "1       constante inteira    10 \n" +
                       "3       símbolo especial     * \n" +
                       "3       constante inteira    90 \n" +
                       "3       símbolo especial     * \n" +
                       "3       símbolo especial     ( \n" +
                       "4       símbolo especial     ( \n" +
                       "4       constante inteira    15 \n" +
                       "4       símbolo especial     / \n" +
                       "5       constante inteira    10 \n" +
                       "5       símbolo especial     ) \n" +
                       "5       símbolo especial     * \n" +
                       "5       símbolo especial     ( \n" +
                       "5       constante inteira    20 \n" +
                       "5       símbolo especial     * \n" +
                       "5       constante inteira    50 \n" +
                       "5       símbolo especial     ) \n" +
                       "5       símbolo especial     ) \n" +
                       "6       símbolo especial     + \n" +
                       "6       constante inteira    1000 \n" +
                       "7       símbolo especial     * \n" +
                       "8       símbolo especial     ( \n" +
                       "8       constante inteira    20 \n" +
                       "8       símbolo especial     * \n" +
                       "8       constante inteira    9 \n" +
                       "8       símbolo especial     ) \n" +
                       "8       símbolo especial     * \n" +
                       "8       símbolo especial     ( \n" +
                       "8       constante inteira    9 \n" +
                       "8       símbolo especial     * \n" +
                       "8       constante inteira    100 \n" +
                       "9       símbolo especial     ) \n" +
                       "9       símbolo especial     ) \n" +
                       "\n" +
                       "programa compilado com sucesso";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    @Test
    public void test10() {
        String entrada = "\\* isso é um comentário + ! ? #4%%$ *\\\n\n" +
                         "bool teste\n" +
                         "int teste2\n" +
                         "float L21\n" +
                         "print teste\n" +
                         "ifTrue\n" +
                         "teste := teste2 > L21\n" +
                         "whileFalse\n" +
                         "teste := L21";

        String saida = "linha   classe               lexema \n" +
                       "1       palavra reservada    bool \n" +
                       "1       identificador        teste \n" +
                       "1       palavra reservada    int \n" +
                       "1       identificador        teste2 \n" +
                       "3       palavra reservada    float \n" +
                       "4       identificador        L21 \n" +
                       "4       palavra reservada    print \n" +
                       "5       identificador        teste \n" +
                       "5       palavra reservada    ifTrue \n" +
                       "7       identificador        teste \n" +
                       "8       símbolo especial     := \n" +
                       "8       identificador        teste2 \n" +
                       "8       símbolo especial     > \n" +
                       "8       identificador        L21 \n" +
                       "34      identificador        teste \n" +
                       "35      símbolo especial     := \n" +
                       "93      identificador        L21 \n" +
                       "\n" +
                       "programa compilado com sucesso";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    
}
