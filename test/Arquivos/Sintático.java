
package Arquivos;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import trabalhofinalcompiladores.Compilador;

/**
 * @author larissa.makufka
 */
public class Sintático {
    
    Compilador compilador;
    
    public Sintático() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1() {
        String entrada = "/* isso é um comentário */\n\n"
                + "print i_area =\n\n"
                + "\"valor\" 01,0";

        String saida = "Erro na linha 3 - encontrado print esperado def";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }
}
