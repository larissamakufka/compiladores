
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
                         "bool teste = true" +
                         "if teste \n" +
                           "int x = 10 * 5 \n" +
                         "end";

        String saida = "linha   classe               lexema" +
                       "1       palavra reservada    bool" +
                       "1       identificador        teste" +
                       "1       símbolo especial     =" +
                       "1       palavra reservada    true" +
                       "3       identificador        if" +
                       "3       identificador        teste" +
                       "4       identificador        begin" +
                       "5       palavra reservada    int" +
                       "5       identificador        x" +
                       "5       símbolo especial     =" +
                       "5       constante inteira    10" +
                       "5       símbolo especial     *" +
                       "5       constante inteira    5" +
                       "6       palavra reservada    end" +
                       "7       identificador        else" +
                       "8       palavra reservada    int" +
                       "8       identificador        x" +
                       "8       símbolo especial     =" +
                       "8       constante inteira    10" + 
                       "8       símbolo especial     *" +
                       "8       símbolo especial     -" +
                       "8       constante inteira    2" +
                       "9       palavra reservada    end" +
                       "programa compilado com sucesso";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }
 
    @Test
    public void test9() {
        String entrada = "\\* isso é um comentário + ! ? #4%%$ *\\\n\n" +
                         "int i := 3 / 5 (10 * 90 * ((15 / 10) * (20 * 50)) + 1000 * (20 * 9) * (9 * 100))\n";

        String saida = "linha   classe               lexema" +
                       "1       palavra reservada    int" +
                       "1       identificador        i" +
                       "1       símbolo especial     :=" +
                       "1       constante inteira    3" +
                       "1       símbolo especial     /" +
                       "1       constante inteira    5" + 
                       "1       símbolo especial     (" +
                       "1       constante inteira    10" +
                       "3       símbolo especial     *" +
                       "3       constante inteira    90" +
                       "3       símbolo especial     *" +
                       "3       símbolo especial     (" +
                       "4       símbolo especial     (" +
                       "4       constante inteira    15" +
                       "4       símbolo especial     /" +
                       "5       constante inteira    10" +
                       "5       símbolo especial     )" +
                       "5       símbolo especial     *" +
                       "5       símbolo especial     (" +
                       "5       constante inteira    20" +
                       "5       símbolo especial     *" +
                       "5       constante inteira    50" +
                       "5       símbolo especial     )" +
                       "5       símbolo especial     )" +
                       "6       símbolo especial     +" +
                       "6       constante inteira    1000" +
                       "7       símbolo especial     *" +
                       "8       símbolo especial     (" +
                       "8       constante inteira    20" +
                       "8       símbolo especial     *" +
                       "8       constante inteira    9" +
                       "8       símbolo especial     )" +
                       "8       símbolo especial     *" +
                       "8       símbolo especial     (" +
                       "8       constante inteira    9" +
                       "8       símbolo especial     *" +
                       "8       constante inteira    100" +
                       "9       símbolo especial     )" +
                       "9       símbolo especial     )" +
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
                         "float L21\n\n" +
                         "print teste\n\n" +
                         "ifTrue\n" +
                         "teste := teste2 > L21\n\n" +
                         "whileFalse\n" +
                         "teste := L21";

        String saida = "linha   classe               lexema" +
                       "1       palavra reservada    bool" +
                       "1       identificador        teste" +
                       "1       palavra reservada    int" +
                       "1       identificador        teste2" +
                       "3       palavra reservada    float" +
                       "4       identificador        L21" +
                       "4       palavra reservada    print" +
                       "5       identificador        teste" +
                       "5       palavra reservada    ifTrue" +
                       "7       identificador        teste" +
                       "8       símbolo especial     :=" +
                       "8       identificador        teste2" +
                       "8       símbolo especial     >" +
                       "8       identificador        L21" +
                       "34      identificador        teste" +
                       "35      símbolo especial     :=" +
                       "93      identificador        L21" +
                       "programa compilado com sucesso";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

    
}
