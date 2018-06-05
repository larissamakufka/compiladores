package trabalhofinalcompiladores.Semantico;

import trabalhofinalcompiladores.Comum.Constants;
import trabalhofinalcompiladores.Comum.Token;

public class Semantico implements Constants {

    public void executeAction(int action, Token token) throws SemanticError {
        System.out.println("Ação #" + action + ", Token: " + token);
    }
}
