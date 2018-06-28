
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
public class SemanticoTest {

    public SemanticoTest() {
    }

    Compilador compilador;

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

    @Test
    public void test1() {
        String entrada = "def\n"
                + "var lado, area: float\n"
                + "execute\n"
                + " print(\"digite um valor para lado: \")\n"
                + " input(lado)\n"
                + " area:= lado * lado\n"
                + " print(area)";

        String saida = ".assembly extern mscorlib {}\n"
                + ".assembly _codigo_objeto{}\n"
                + ".module _codigo_objeto.exe\n"
                + ".class public _UNICA{\n"
                + ".method static public void _principal() {\n"
                + " .entrypoint\n"
                + " .locals (float64 lado, float64 area)\n"
                + " ldstr \"digite um valor para lado: \"\n"
                + " call void\n"
                + "[mscorlib]System.Console::Write(string)\n"
                + " call string [mscorlib]System.Console::ReadLine()\n"
                + " call float64\n"
                + "[mscorlib]System.Double::Parse(string)\n"
                + " stloc lado\n"
                + " ldloc lado\n"
                + " ldloc lado\n"
                + " mul\n"
                + " stloc area\n"
                + " ldloc area\n"
                + " call void\n"
                + "[mscorlib]System.Console::Write(float64)\n"
                + " ret\n"
                + " }\n"
                + "}";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }

}
