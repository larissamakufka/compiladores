package trabalhofinalcompiladores.Semantico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import trabalhofinalcompiladores.Comum.Constants;
import trabalhofinalcompiladores.Comum.Token;

public class Semantico implements Constants {

    final String INT64 = "int64";
    final String FLOAT64 = "float64";
    final String STRING = "string";
    final String BOOL = "bool";

    private String operador;
    private StringBuilder codigo;
    private Stack<String> pilhaTipos;
    private HashMap<String, Identificador> TabSimb;
    private String tipoVar;
    private ArrayList<Token> listaId;
    private Stack<String> pilhaRotulos;
    private int numRotulo;

    public Semantico() {
        this.operador = "";
        this.codigo = new StringBuilder();
        this.pilhaTipos = new Stack<>();
        this.TabSimb = new HashMap<>();
        this.tipoVar = "";
        this.listaId = new ArrayList<>();
        this.pilhaRotulos = new Stack<>();
        this.numRotulo = 0;
    }

    public String getCodigo() {
        return codigo.toString();
    }

    private String novoRotulo() {
        this.numRotulo++;
        return "label" + this.numRotulo;
    }

    public void executeAction(int action, Token token) throws SemanticError {
        switch (action) {
            case 1: {
                this.Acao_1(token);
                break;
            }
            case 2: {
                this.Acao_2(token);
                break;
            }
            case 3: {
                this.Acao_3(token);
                break;
            }
            case 4: {
                this.Acao_4(token);
                break;
            }
            case 5: {
                this.Acao_5(token);
                break;
            }
            case 6: {
                this.Acao_6(token);
                break;
            }
            case 7: {
                this.Acao_7(token);
                break;
            }
            case 8: {
                this.Acao_8(token);
                break;
            }
            case 9: {
                this.Acao_9(token);
                break;
            }
            case 10: {
                this.Acao_10(token);
                break;
            }
            case 11: {
                this.Acao_11();
                break;
            }
            case 12: {
                this.Acao_12();
                break;
            }
            case 13: {
                this.Acao_13(token);
                break;
            }
            case 14: {
                this.Acao_14();
                break;
            }
            case 15: {
                this.Acao_15();
                break;
            }
            case 16: {
                this.Acao_16();
                break;
            }
            case 17: {
                this.Acao_17();
                break;
            }
            case 18: {
                this.Acao_18(token);
                break;
            }
            case 19: {
                this.Acao_19(token);
                break;
            }
            case 20: {
                this.Acao_20(token);
                break;
            }
            case 21: {
                this.Acao_21(token);
                break;
            }
            case 22: {
                this.Acao_22(token);
                break;
            }
            case 23: {
                this.Acao_23();
                break;
            }
            case 24: {
                this.Acao_24();
                break;
            }
            case 25: {
                this.Acao_25(token);
                break;
            }
            case 26: {
                this.Acao_26();
                break;
            }
            case 27: {
                this.Acao_27();
                break;
            }
            case 28: {
                this.Acao_28();
                break;
            }
            case 29: {
                this.Acao_29();
                break;
            }
            case 30: {
                this.Acao_30();
                break;
            }
            case 31: {
                this.Acao_31();
                break;
            }
            case 32: {
                this.Acao_32(token);
                break;
            }

            default:
                throw new SemanticError("Ação semântica não reconhecida #" + action, token.getPosition());
        }
    }

    private void Acao_1(Token token) throws SemanticError {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals(STRING) || tipo2.equals(STRING)) {
            throw new SemanticError("Tipos incompatíveis em operação aritmética binária.", token.getPosition());
        }

        if (tipo1.equals(FLOAT64) || tipo2.equals(FLOAT64)) {
            this.pilhaTipos.push(FLOAT64);
        } else {
            this.pilhaTipos.push(INT64);
        }

        this.codigo.append(" add \n");
    }

    private void Acao_2(Token token) throws SemanticError {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals(STRING) || tipo2.equals(STRING)) {
            throw new SemanticError("Tipos incompatíveis em operação aritmética binária.", token.getPosition());
        }

        if (tipo1.equals(FLOAT64) || tipo2.equals(FLOAT64)) {
            this.pilhaTipos.push(FLOAT64);
        } else {
            this.pilhaTipos.push(INT64);
        }

        this.codigo.append(" sub \n");
    }

    private void Acao_3(Token token) throws SemanticError {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals(STRING) || tipo2.equals(STRING)) {
            throw new SemanticError("Tipos incompatíveis em operação aritmética binária.", token.getPosition());
        }

        if (tipo1.equals(FLOAT64) || tipo2.equals(FLOAT64)) {
            this.pilhaTipos.push(FLOAT64);
        } else {
            this.pilhaTipos.push(INT64);
        }

        this.codigo.append(" mul \n");
    }

    private void Acao_4(Token token) throws SemanticError {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals(tipo2)) {
            this.pilhaTipos.push(tipo1);
        } else {
            throw new SemanticError("Tipos incompatíveis em operação aritmética binária.", token.getPosition());
        }

        this.codigo.append("div \n");
    }

    private void Acao_5(Token token) {
        this.pilhaTipos.push(INT64);
        this.codigo.append(" ldc.i8 ").append(token.getLexeme()).append(" \n");
        this.codigo.append(" conv.r8 \n");
    }

    private void Acao_6(Token token) {
        this.pilhaTipos.push(FLOAT64);
        this.codigo.append(" ldc.r8 ").append(token.getLexeme().replace(',','.')).append(" \n");
    }

    private void Acao_7(Token token) throws SemanticError {
        String tipo = this.pilhaTipos.pop();

        if (tipo.equals(FLOAT64) || tipo.equals(INT64)) {
            this.pilhaTipos.push(tipo);
        } else {
            throw new SemanticError("Tipo imcompátivel de operação unária.", token.getPosition());
        }
    }

    private void Acao_8(Token token) throws SemanticError {
        String tipo = this.pilhaTipos.pop();

        if (tipo.equals(FLOAT64) || tipo.equals(INT64)) {
            this.pilhaTipos.push(tipo);
        } else {
            throw new SemanticError("Tipo imcompátivel de operação unária.", token.getPosition());
        }
    }

    private void Acao_9(Token token) {
        this.operador = token.getLexeme();
    }

    private void Acao_10(Token token) throws SemanticError {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals(tipo2) || ((tipo1.equals(INT64) || tipo1.equals(FLOAT64)) && (tipo2.equals(INT64) || tipo2.equals(FLOAT64)))) {
            this.pilhaTipos.push(BOOL);
        } else {
            throw new SemanticError("Tipos incompátiveis em operação relacional.", token.getPosition());
        }

        switch (this.operador) {
            case ">":
                this.codigo.append(" cgt \n");
                break;
            case "<":
                this.codigo.append(" clt \n");
                break;
            case "=":
                this.codigo.append(" ceq \n");
                break;
        }
    }

    private void Acao_11() {
        this.pilhaTipos.push(BOOL);
        this.codigo.append(" ldc.r4.1 \n");
    }

    private void Acao_12() {
        this.pilhaTipos.push(BOOL);
        this.codigo.append(" ldc.r4.0 \n");
    }

    private void Acao_13(Token token) throws SemanticError {
        String tipo = this.pilhaTipos.pop();

        if (tipo.equals(BOOL)) {
            this.pilhaTipos.push(BOOL);
        } else {
            throw new SemanticError("Tipo incompatível em expressão lógica unária.", token.getPosition());
        }

        this.codigo.append(" ldc.i4.1 \n");
        this.codigo.append(" xor \n");
    }

    private void Acao_14() {
        String tipo = this.pilhaTipos.pop();

        if (tipo.equals(INT64)) {
            this.codigo.append(" conv.i8 \n");
        }

        this.codigo.append(" call void [mscorlib]System.Console::Write(").append(tipo).append(") \n");
    }

    private void Acao_15() {
        this.codigo.append(
                ".assembly extern mscorlib {}\n"
                + ".assembly _codigo_objeto{}\n"
                + ".module _codigo_objeto.exe\n"
                + ".class public _UNICA{\n"
                + ".method static public void _principal() {\n"
                + " .entrypoint\n"
        );
    }

    private void Acao_16() {
        this.codigo.append(
                " ret\n"
                + " }\n"
                + "}"
        );
    }

    private void Acao_17() {
        this.codigo.append(" ldstr \n");
        this.codigo.append(" call void [mscorlib]System.Console::Write(string) \n");
    }

    private void Acao_18(Token token) throws SemanticError {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (!tipo1.equals(tipo2)) {
            throw new SemanticError("Tipos incompatíveis em expressão lógica binária.", token.getPosition());
        }

        this.codigo.append(" and \n");
    }

    private void Acao_19(Token token) throws SemanticError {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (!tipo1.equals(tipo2)) {
            throw new SemanticError("Tipos incompatíveis em expressão lógica binária.", token.getPosition());
        }

        this.codigo.append(" or \n");
    }

    private void Acao_20(Token token) {
        this.pilhaTipos.push(STRING);
        this.codigo.append(" ldstr ").append(token.getLexeme()).append(" \n");
    }

    private void Acao_21(Token token) {
        switch (token.getLexeme()) {
            case "int": {
                this.tipoVar = INT64;
                break;
            }

            case "float": {
                this.tipoVar = FLOAT64;
                break;
            }
        }
    }

    private void Acao_22(Token token) {
        this.listaId.add(token);
    }

    private void Acao_23() throws SemanticError {
        boolean localsJaEscrito = false;
        for (Token id : listaId) {
            String lexeme = id.getLexeme();
            if (TabSimb.containsKey(lexeme)) {
                throw new SemanticError("Identificador " + lexeme + " já declarado.", id.getPosition());
            }
            this.TabSimb.put(lexeme, new Identificador('v', tipoVar, ""));
            if (localsJaEscrito) {
                this.codigo.append(", ").append(tipoVar).append(" ").append(lexeme);
            } else {
                this.codigo.append(" .locals (").append(tipoVar).append(" ").append(lexeme);
                localsJaEscrito = true;
            }
        }
        this.codigo.append(") \n");
        listaId.clear();
    }

    private void Acao_24() throws SemanticError {
        for (Token id : listaId) {
            String lexeme = id.getLexeme();
            if (!TabSimb.containsKey(lexeme)) {
                throw new SemanticError("Identificador " + lexeme + " não declarado.", id.getPosition());
            }
            Identificador identificador = this.TabSimb.get(lexeme);
            String classe = "";
            switch (identificador.tipo) {
                case INT64:
                    classe = "Int64";
                    break;
                case FLOAT64:
                    classe = "Double";
                    break;
            }
            this.codigo.append(" call string [mscorlib]System.Console::ReadLine() \n");
            this.codigo.append(" call ").append(identificador.tipo).append(" [mscorlib]System.").append(classe).append("::Parse(string) \n");
            this.codigo.append(" stloc ").append(lexeme).append(" \n");
        }
        listaId.clear();
    }

    private void Acao_25(Token token) throws SemanticError {
        String lexeme = token.getLexeme();
        if (!TabSimb.containsKey(lexeme)) {
            throw new SemanticError("Identificador " + lexeme + " não declarado.", token.getPosition());
        }

        Identificador identificador = TabSimb.get(lexeme);

        this.pilhaTipos.push(identificador.tipo);

        switch (identificador.classe) {
            case 'v': {
                this.codigo.append(" ldloc ").append(lexeme).append(" \n");
                break;
            }
            case 'c': {
                switch (identificador.tipo) {
                    case INT64: {
                        this.codigo.append(" ldc.i8 ").append(identificador.valor).append(" \n");
                        break;
                    }
                    case FLOAT64: {
                        this.codigo.append(" ldc.r8 ").append(identificador.valor.replace(',', '.')).append(" \n");
                        break;
                    }
                    case STRING: {
                        this.codigo.append(" ldstr ").append(identificador.valor).append(" \n");
                        break;
                    }
                }
                break;
            }
        }

        if (identificador.tipo.equals(INT64)) {
            this.codigo.append(" conv.r8 \n");
        }
    }

    private void Acao_26() throws SemanticError {
        Token id = listaId.get(0);
        String lexeme = id.getLexeme();

        if (!this.TabSimb.containsKey(lexeme)) {
            throw new SemanticError("Identificador " + lexeme + " não declarado.", id.getPosition());
        }

        Identificador identificador = this.TabSimb.get(lexeme);
        String tipoExp = this.pilhaTipos.pop();

        if (!identificador.tipo.equals(tipoExp)) {
            throw new SemanticError("Tipos incompatíveis no comando de atribuição.", id.getPosition());
        }

        if (identificador.tipo.equals(INT64)) {
            this.codigo.append(" conv.i8 \n");
        }

        this.codigo.append(" stloc ").append(lexeme).append(" \n");
    }

    private void Acao_27() {
        String rotulo = this.novoRotulo();

        this.pilhaRotulos.push(rotulo);

        this.codigo.append(" ").append(rotulo).append(": \n");
    }

    private void Acao_28() {
        String rotulo = this.novoRotulo();

        this.pilhaRotulos.push(rotulo);

        this.codigo.append(" brfalse ").append(rotulo).append(" \n");
    }

    private void Acao_29() {
        String rotulo = this.pilhaRotulos.pop();

        this.codigo.append(rotulo).append(": \n");
    }

    private void Acao_30() {
        String rotulo = this.pilhaRotulos.pop();
        String newRotulo = novoRotulo();
        
        this.pilhaRotulos.push(newRotulo);

        this.codigo.append(" br ").append(newRotulo).append(" \n");
        this.codigo.append(" ").append(rotulo).append(": \n");
    }

    private void Acao_31() {
        String rotulo = this.pilhaRotulos.pop();
        String rotulo1 = this.pilhaRotulos.pop();

        this.codigo.append(" br ").append(rotulo1).append(" \n");
        this.codigo.append(rotulo).append(": \n");
    }

    private void Acao_32(Token token) throws SemanticError {
        for (Token identificador : listaId) {
            String lexeme = identificador.getLexeme();
            if (TabSimb.containsKey(lexeme)) {
                throw new SemanticError("Constante " + lexeme + " já declarado.", identificador.getPosition());
            }
            this.TabSimb.put(lexeme, new Identificador('c', tipoVar, token.getLexeme()));
        }
        listaId.clear();
    }
}
