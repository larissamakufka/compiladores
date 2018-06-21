package trabalhofinalcompiladores.Lexico;

import java.util.List;
import trabalhofinalcompiladores.Comum.Constants;
import static trabalhofinalcompiladores.Comum.ScannerConstants.*;
import trabalhofinalcompiladores.Comum.Token;

public class Lexico implements Constants {

    private int position;
    private String input;
    private char nextChar;
    private String actualToken;

    public Lexico() {
        this("");
    }

    public String getNomeClasse(int id) {
        switch (id) {
            case t_identificador:
                return "identificador";

            case t_const_inteira:
                return "constante inteira";

            case t_const_real:
                return "constante real";

            case t_const_caracter:
                return "constante caracter";

            case t_bool:
            case t_consts:
            case t_def:
            case t_end:
            case t_execute:
            case t_false:
            case t_float:
            case t_get:
            case t_ifFalse:
            case t_ifTrue:
            case t_input:
            case t_int:
            case t_print:
            case t_println:
            case t_set:
            case t_str:
            case t_true:
            case t_types:
            case t_var:
            case t_whileFalse:
            case t_whileTrue:
                return "palavra reservada";

            case t_TOKEN_27:
            case t_TOKEN_28:
            case t_TOKEN_29:
            case t_TOKEN_30:
            case t_TOKEN_31:
            case t_TOKEN_32:
            case t_TOKEN_33:
            case t_TOKEN_34:
            case t_TOKEN_35:
            case t_TOKEN_36:
            case t_TOKEN_37:
            case t_TOKEN_38:
            case t_TOKEN_39:
            case t_TOKEN_40:
            case t_TOKEN_41:
            case t_TOKEN_42:
            case t_TOKEN_43:
            case t_TOKEN_44:
                return "símbolo especial";
        }
        return "";
    }

    public String getInput() {
        return this.input;
    }

    public Lexico(String input) {
        setInput(input);
    }

    public void setInput(String input) {
        this.input = input;
        setPosition(0);
    }

    public void setPosition(int pos) {
        position = pos;
    }

    public Token nextToken() throws LexicalError {
        if (!hasInput()) {
            return null;
        }
        setNextChar(' ');

        int start = position;

        int state = 0;
        int lastState = 0;
        int endState = -1;
        int end = -1;
        char nChar = ' ';

        while (hasInput()) {
            lastState = state;
            nChar = nextChar();
            state = nextState(nChar, state);

            if (state < 0) {
                break;
            } else if (tokenForState(state) >= 0) {
                endState = state;
                end = position;
            }
        }
        
        if (endState < 0 || (endState != state && tokenForState(lastState) == -2)) {
            throw new LexicalError(SCANNER_ERROR[lastState], start);
        } else {
            setNextChar(nChar);
        }

        position = end;

        int token = tokenForState(endState);

        if (token == 0) {
            return nextToken();
        } else {
            String lexeme = input.substring(start, end);
            token = lookupToken(token, lexeme);
            return new Token(token, lexeme, start);
        }
    }

    private int nextState(char c, int state) {
        int start = SCANNER_TABLE_INDEXES[state];
        int end = SCANNER_TABLE_INDEXES[state + 1] - 1;

        while (start <= end) {
            int half = (start + end) / 2;

            if (SCANNER_TABLE[half][0] == c) {
                return SCANNER_TABLE[half][1];
            } else if (SCANNER_TABLE[half][0] < c) {
                start = half + 1;
            } else //(SCANNER_TABLE[half][0] > c)
            {
                end = half - 1;
            }
        }

        return -1;
    }

    private int tokenForState(int state) {
        if (state < 0 || state >= TOKEN_STATE.length) {
            return -1;
        }

        return TOKEN_STATE[state];
    }

    public int lookupToken(int base, String key) {
        int start = SPECIAL_CASES_INDEXES[base];
        int end = SPECIAL_CASES_INDEXES[base + 1] - 1;

        while (start <= end) {
            int half = (start + end) / 2;
            int comp = SPECIAL_CASES_KEYS[half].compareTo(key);

            if (comp == 0) {
                return SPECIAL_CASES_VALUES[half];
            } else if (comp < 0) {
                start = half + 1;
            } else //(comp > 0)
            {
                end = half - 1;
            }
        }

        return base;
    }

    private boolean hasInput() {
        return position < input.length();
    }

    private char nextChar() {
        if (hasInput()) {
            return input.charAt(position++);
        } else {
            return (char) -1;
        }
    }

    public int getLinha(List<Integer> linhas, int posicao) {
        int linha = 0;
        for (int i = 0; i < linhas.size(); i++) {
            linha++;
            if (posicao <= linhas.get(i)) {
                return linha;
            }
        }
        return linha;
    }

    public char getNextChar() {
        return nextChar;
    }

    public void setNextChar(char nextChar) {
        if (nextChar != ' ') {
            actualToken += nextChar;
        } else {
            actualToken = "";
        }
    }

    public String getActualToken() {
        return actualToken;
    }
}
