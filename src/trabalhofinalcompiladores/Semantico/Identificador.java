package trabalhofinalcompiladores.Semantico;

/**
 *
 * @author Douglas E Bauler
 * @author Jefferson do Nascimento Júnior
 * @author Larissa
 */
public class Identificador {
    public char classe;
    public String tipo;
    public String valor;

    public Identificador(char classe, String tipo, String valor) {
        this.classe = classe;
        this.tipo = tipo;
        this.valor = valor;
    }
}
