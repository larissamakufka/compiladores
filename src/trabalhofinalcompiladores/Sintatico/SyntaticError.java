package trabalhofinalcompiladores.Sintatico;

import trabalhofinalcompiladores.Comum.AnalysisError;

public class SyntaticError extends AnalysisError {

    public SyntaticError(String msg, int position) {
        super(msg, position);
    }

    public SyntaticError(String msg) {
        super(msg);
    }
}
