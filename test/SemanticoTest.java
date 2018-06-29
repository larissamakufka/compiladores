
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

    /**
     * Ações a serem executadas: 15 22 22 21 23 20 14 22 24 22 25 25 3 26 25 14
     * 16
     */
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

    @Test
    public void test03() {
        String entrada = "def\n"
                + "var lado, area: float\n"
                + "execute\n"
                + "input(lado)\n"
                + "(lado > 0) ifTrue:\n"
                + "ifFalse:\n"
                + "  print(\"erro: valor inválido para lado - \")\n"
                + "  area:= 0,0\n"
                + "end\n"
                + " print(\"area: \", area)";

        String saida = ".assembly extern mscorlib {}\n"
                + ".assembly _codigo_objeto{}\n"
                + ".module _codigo_objeto.exe\n"
                + ".class public _UNICA{\n"
                + ".method static public void _principal() {\n"
                + " .entrypoint\n"
                + " .locals (float64 lado, float64 area)\n"
                + " call string [mscorlib]System.Console::ReadLine()\n"
                + " call float64 [mscorlib]System.Double::Parse(string)\n"
                + " stloc lado\n"
                // implementar #27
                + " ldloc lado\n"
                + " ldc.i8 0\n"
                + " conv.r8\n"
                + " cgt\n"
                // implementar #28
                + " ldloc lado\n"
                + " ldloc lado\n"
                + " mul\n"
                + " stloc area\n"
                // implementar #30
                + " ldstr \"erro: valor inválido para o lado - \"\n"
                + " call void [mscorlib]System.Console::Write(string)\n"
                + " ldc.r8 0.0\n"
                + " stloc area\n"
                // implementar #29
                + " ldstr \"área: \"\n"
                + " call void [mscorlib]System.Console::Write(string)\n"
                + " ldloc area\n"
                + " call void [mscorlib]System.Console::Write(float64)\n"
                + " ret\n"
                + " }\n"
                + "}";

        compilador.getTaEditor().setText(entrada);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getTaMensagens().getText());
    }
}
