
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
    public void test02() {
        String entrada = /*15*/ "def\n"
                + "var lado"/*22*/ + ", area" /*22*/ + ": float\n" /*21 23*/
                + "execute\n"
                + " print(\"digite um valor para lado:" /*20 14*/ + " \")\n"
                + " input(lado" /*22 24*/ + ")\n"
                + " area" /*22*/ + " := lado"/*25*/ + " * lado\n" /*25 3 26*/
                + " print(area"/*25 14*/ + ")"; /*16*/

        String saida = ".assembly extern mscorlib {}\n"
                + ".assembly _codigo_objeto{}\n"
                + ".module _codigo_objeto.exe\n"
                + ".class public _UNICA{\n"
                + ".method static public void _principal() {\n"
                + " .entrypoint\n"
                + " .locals (float64 lado, float64 area)\n"
                + " ldstr \"digite um valor para lado: \"\n"
                + " call void [mscorlib]System.Console::Write(string)\n"
                + " call string [mscorlib]System.Console::ReadLine()\n"
                + " call float64 [mscorlib]System.Double::Parse(string)\n"
                + " stloc lado\n"
                + " ldloc lado\n"
                + " ldloc lado\n"
                + " mul\n"
                + " stloc area\n"
                + " ldloc area\n"
                + " call void [mscorlib]System.Console::Write(float64)\n"
                + " ret\n"
                + " }\n"
                + "}";

        compilador.getTaEditor().setText(entrada);
        compilador.setExecutandoTestesUnitarios(true);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getSemanticText());
    }

    /**
     * Ações a serem executadas: 15 22 22 21 23 22 24 27 25 9 5 10 28 22 25 3 26
     * 30 28 20 14 22 6 26 29 20 14 25 14 16
     */
    @Test
    public void test03() {
        String entrada = /*15*/ "def\n"
                + "var lado" /*22*/ + ", area" /*22*/ + ": float\n" /*21 23*/
                + "execute\n"
                + "input(lado" /*22 24*/ + ")\n" /*27*/
                + "(lado" /*25*/ + " >" /*9*/ + " 0" /*5 10*/ + ") ifTrue" /*28*/ + ":\n"
                + "  area" /*22*/ + " := lado" /*25*/ + " * lado\n" /*25 3 26 30*/
                + "ifFalse:\n"/*28*/
                + "  print(\"erro: valor inválido para lado - \"" /*20 14*/ + ")\n"
                + "  area" /*22*/ + " := 0,0\n" /*6 26*/
                + "end\n" /*29*/
                + " print(\"area: \"" /*20 14*/ + ", area" /*25 14*/ + ")" /*16*/;

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
                + " ldloc lado\n"
                + " ldc.i8 0\n"
                + " conv.r8\n"
                + " cgt\n"
                + " ldloc lado\n"
                + " ldloc lado\n"
                + " mul\n"
                + " stloc area\n"
                + " ldstr \"erro: valor inválido para o lado - \"\n"
                + " call void [mscorlib]System.Console::Write(string)\n"
                + " ldc.r8 0.0\n"
                + " stloc area\n"
                + " ldstr \"área: \"\n"
                + " call void [mscorlib]System.Console::Write(string)\n"
                + " ldloc area\n"
                + " call void [mscorlib]System.Console::Write(float64)\n"
                + " ret\n"
                + " }\n"
                + "}";

        compilador.getTaEditor().setText(entrada);
        compilador.setExecutandoTestesUnitarios(true);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getSemanticText());
    }

    /**
     * Ações a serem executadas: 15 22 21 23 20 14 22 24 27 25 9 5 10 28 20 14
     * 22 24 31 20 14 25 5 4 14 16
     */
    @Test
    public void test04() {
        String entrada = /*22*/ "def\n"
                + "var CH" /*22*/ + ": int\n" /*21 23*/
                + "execute\n"
                + " print(\"qual a CH de compiladores? \"" /*20 14*/ + ")\n"
                + " input(CH" /*22 24*/ + ")\n"
                + /*27*/ " (CH" /*25*/ + " <" /*9*/ + " 18" /*5 10*/ + ") "
                + "whileTrue:\n" /*28*/
                + " print(\"qual a CH de compiladores? \"" /*20 14*/ + ")\n"
                + " input(CH" /*22 24*/ + ")\n"
                + " end\n" /*31*/
                + " print(\"total de créditos: \"" /*20 14*/ + ", CH" /*25*/ + " / 18" /*5 4 14*/ + ")"; /*16*/

        String saida = ".assembly extern mscorlib {}\n"
                + ".assembly _codigo_objeto{}\n"
                + ".module _codigo_objeto.exe\n"
                + ".class public _UNICA{\n"
                + ".method static public void _principal() {\n"
                + " .entrypoint\n"
                + " .locals (int64 CH)\n"
                + " ldstr \"qual a CH de compiladores? \"\n"
                + " call void [mscorlib]System.Console::Write(string)\n"
                + " call string [mscorlib]System.Console::ReadLine()\n"
                + " call int64 [mscorlib]System.Int64::Parse(string)\n"
                + " stloc CH\n"
                + "//início do código gerado pela ação #27\n"
                + " label1:\n"
                + "//fim\n"
                + " ldloc CH\n"
                + " conv.r8\n"
                + " ldc.i8 18\n"
                + " conv.r8\n"
                + " clt\n"
                + "//início do código gerado pela ação #28\n"
                + " brfalse label2\n"
                + "//fim\n"
                + " ldstr \"qual a CH de compiladores? \"\n"
                + " call void [mscorlib]System.Console::Write(string)\n"
                + " call string [mscorlib]System.Console::ReadLine()\n"
                + " call int64 [mscorlib]System.Int64::Parse(string)\n"
                + " stloc CH\n"
                + "//início do código gerado pela ação #31\n"
                + " br label1\n"
                + " label2:\n"
                + "//fim\n"
                + " ldstr \"total de créditos: \"\n"
                + " call void [mscorlib]System.Console::Write(string)\n"
                + " ldloc CH\n"
                + " conv.r8\n"
                + " ldc.i8 18\n"
                + " conv.r8\n"
                + " div\n"
                + " conv.i8\n"
                + " call void [mscorlib]System.Console::Write(int64)\n"
                + " ret\n"
                + " }\n"
                + "} ";

        compilador.getTaEditor().setText(entrada);
        compilador.setExecutandoTestesUnitarios(true);
        compilador.getJbCompilar().doClick();
        Assert.assertEquals(saida, compilador.getSemanticText());
    }
}
