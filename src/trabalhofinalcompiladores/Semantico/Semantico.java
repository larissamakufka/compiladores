package trabalhofinalcompiladores.Semantico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import trabalhofinalcompiladores.Comum.Constants;
import trabalhofinalcompiladores.Comum.Token;

public class Semantico implements Constants {

    private String operador;
    private StringBuilder codigo;
    private Stack<String> pilhaTipos;
    private HashMap<String, String> TabSimb;
    private String tipoVar;
    private ArrayList<Token> listaId;

    public Semantico() {
        this.operador = "";
        this.codigo = new StringBuilder();
        this.pilhaTipos = new Stack<>();
        this.TabSimb = new HashMap<>();
        this.tipoVar = "";
        this.listaId = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo.toString();
    }

    public void executeAction(int action, Token token) throws SemanticError {
        switch (action) {
            /*case 1: {
                this.Acao_1();
                break;
            }
            case 2: {
                this.Acao_2();
                break;
            }*/
            case 3: {
                this.Acao_3();
                break;
            }
            /*case 4: {
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
            }*/
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
            /*case 17: {
                this.Acao_17();
                break;
            }*/
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
                this.Acao_23(token);
                break;
            }
            case 24: {
                this.Acao_24(token);
                break;
            }
            case 25: {
                this.Acao_25(token);
                break;
            }
            case 26: {
                this.Acao_26(token);
                break;
            }

            default:
                throw new SemanticError("Ação semântica não reconhecida #" + action, token.getPosition());
        }
    }

    public void Acao_1() {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals("float64") || tipo2.equals("float64")) {
            this.pilhaTipos.push("float64");
        } else {
            this.pilhaTipos.push("int64");
        }

        this.codigo.append("add");
    }

    public void Acao_2() {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals("float64") || tipo2.equals("float64")) {
            this.pilhaTipos.push("float64");
        } else {
            this.pilhaTipos.push("int64");
        }

        this.codigo.append("sub");
    }

    public void Acao_3() {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals("float64") || tipo2.equals("float64")) {
            this.pilhaTipos.push("float64");
        } else {
            this.pilhaTipos.push("int64");
        }

        this.codigo.append(" mul\n");
    }

    public void Acao_4(Token token) throws SemanticError {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals(tipo2)) {
            this.pilhaTipos.push(tipo1);
        } else {
            throw new SemanticError("", token.getPosition());
        }

        this.codigo.append("div");
    }

    public void Acao_5(Token token) {
        this.pilhaTipos.push("int64");
        this.codigo.append("ldc.i8 " + token.getLexeme() + "\n");
        this.codigo.append("conv.r8 \n");
    }

    public void Acao_6(Token token) {
        this.pilhaTipos.push("float64");
        this.codigo.append("ldc.r8 " + token.getLexeme() + "\n");
    }

    public void Acao_7(Token token) throws SemanticError {
        String tipo = this.pilhaTipos.pop();

        if (tipo.equals("float64") || tipo.equals("int64")) {
            this.pilhaTipos.push(tipo);
        } else {
            throw new SemanticError("Tipo imcompátivel de operação unária \"" + tipo + "\".", token.getPosition());
        }
    }

    public void Acao_8(Token token) throws SemanticError {
        String tipo = this.pilhaTipos.pop();

        if (tipo.equals("float64") || tipo.equals("int64")) {
            this.pilhaTipos.push(tipo);
        } else {
            throw new SemanticError("Tipo imcompátivel de operação unária \"" + tipo + "\".", token.getPosition());
        }
    }

    public void Acao_9(Token token) {
        this.operador = token.getLexeme();
    }

    public void Acao_10(Token token) throws SemanticError {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals(tipo2)) {
            this.pilhaTipos.push("bool");
        } else {
            throw new SemanticError("Tipos incompátiveis em operação relacional \"" + tipo1 + "\" e \"" + tipo2 + "\".", token.getPosition());
        }

        switch (this.operador) {
            case ">":
                this.codigo.append("cgt \n");
            case "<":
                this.codigo.append("clt \n");
            case "=":
                this.codigo.append("ceq \n");
        }
    }

    public void Acao_11() {
        this.pilhaTipos.push("bool");
        this.codigo.append("ldc.r4.1 \n");
    }

    public void Acao_12() {
        this.pilhaTipos.push("bool");
        this.codigo.append("ldc.r4.0 \n");
    }

    public void Acao_13(Token token) throws SemanticError {
        String tipo = this.pilhaTipos.pop();

        if (tipo.equals("bool")) {
            this.pilhaTipos.push("bool");
        } else {
            throw new SemanticError("Erro semântico encontrado na ação #13", token.getPosition());
        }

        this.codigo.append("ldc.i4.1 \n");
        this.codigo.append("xor \n");
    }

    public void Acao_14() {
        String tipo = this.pilhaTipos.pop();

        if (tipo.equals("int64")) {
            this.codigo.append("conv.i8 \n");
        }

        this.codigo.append(" call void [mscorlib]System.Console::Write(" + tipo + ")\n");
    }

    public void Acao_15() {
        this.codigo.append(
                ".assembly extern mscorlib {}\n"
                + ".assembly _codigo_objeto{}\n"
                + ".module _codigo_objeto.exe\n"
                + ".class public _UNICA{\n"
                + ".method static public void _principal() {\n"
                + " .entrypoint\n"
        );
    }

    public void Acao_16() {
        this.codigo.append(
                " ret\n"
                + " }\n"
                + "}"
        );
    }

    public void Acao_17() {
        String quebraLinha = "\n";

        this.codigo.append("ldstr " + quebraLinha);
        this.codigo.append("call void [mscorlib]System.Console::Write(string) \n");
    }

    public void Acao_18(Token token) {

    }

    public void Acao_19(Token token) {

    }

    public void Acao_20(Token token) {
        this.pilhaTipos.push("string");
        this.codigo.append(" ldstr " + token.getLexeme() + "\n");
    }

    public void Acao_21(Token token) {
        switch (token.getLexeme()) {
            case "int": {
                this.tipoVar = "int64";
                break;
            }

            case "float": {
                this.tipoVar = "float64";
                break;
            }
        }
    }

    public void Acao_22(Token token) {
        this.listaId.add(token);
    }

    public void Acao_23(Token token) throws SemanticError {
        boolean localsJaEscrito = false;
        for (Token id : listaId) {
            String lexeme = id.getLexeme();
            if (TabSimb.containsKey(lexeme)) {
                throw new SemanticError("Erro semântico encontrado na ação #23", token.getPosition());
            }
<<<<<<< HEAD
            TabSimb.put(id, tipoVar);
=======
<<<<<<< HEAD
            TabSimb.put(id, new Identificador('v', this.tipoVar, ""));
=======
            TabSimb.put(lexeme, tipoVar);
>>>>>>> bf9ef8e73dc6059778f18c8ae80d5a03547e7948
>>>>>>> parent of b5f46e2... Revert "Merge branch 'master' of https://github.com/larissamakufka/compiladores"
            if (localsJaEscrito) {
                this.codigo.append(", ").append(tipoVar).append(" ").append(lexeme);
            } else {
                this.codigo.append(" .locals (").append(tipoVar).append(" ").append(lexeme);
                localsJaEscrito = true;
            }
        }
        this.codigo.append(")\n");
        listaId.clear();
    }

    public void Acao_24(Token token) throws SemanticError {
        for (Token id : listaId) {
            String lexeme = id.getLexeme();
            if (!TabSimb.containsKey(lexeme)) {
                throw new SemanticError("Erro semântico encontrado na ação #24", token.getPosition());
            }
<<<<<<< HEAD
            String tipoId = TabSimb.get(id);
=======
<<<<<<< HEAD
            Identificador tipoId = TabSimb.get(id);
=======
            String tipoId = TabSimb.get(lexeme);
>>>>>>> bf9ef8e73dc6059778f18c8ae80d5a03547e7948
>>>>>>> parent of b5f46e2... Revert "Merge branch 'master' of https://github.com/larissamakufka/compiladores"
            String classe = "";
            switch (tipoId) {
                case "int64":
                    classe = "Int64";
                    break;
                case "float64":
                    classe = "Double";
                    break;
            }
            this.codigo.append(" call string [mscorlib]System.Console::ReadLine()\n");
            this.codigo.append(" call ").append(tipoId).append(" [mscorlib]System.").append(classe).append("::Parse(string)\n");
            this.codigo.append(" stloc ").append(lexeme).append("\n");
        }
        listaId.clear();
    }

    public void Acao_25(Token token) throws SemanticError {
        String id = token.getLexeme();
        if (!TabSimb.containsKey(id)) {
            throw new SemanticError("Identificador " + id + "não declarado.", token.getPosition());
        }

        String tipoId = TabSimb.get(id);

        this.pilhaTipos.push(tipoId);
        this.codigo.append(" ldloc " + id + "\n");

        if (tipoId.equals("int64")) {
            this.codigo.append("conv.r8 \n");
        }
    }

    public void Acao_26(Token token) throws SemanticError {
        Token id = listaId.remove(0);
        String lexeme = id.getLexeme();

        if (!this.TabSimb.containsKey(lexeme)) {
            throw new SemanticError("Identificador " + lexeme + "não declarado.", id.getPosition());
        }

<<<<<<< HEAD
        String tipoId = this.TabSimb.get(id);
=======
<<<<<<< HEAD
        Identificador identificador = this.TabSimb.get(id);
=======
        String tipoId = this.TabSimb.get(lexeme);
>>>>>>> bf9ef8e73dc6059778f18c8ae80d5a03547e7948
>>>>>>> parent of b5f46e2... Revert "Merge branch 'master' of https://github.com/larissamakufka/compiladores"
        String tipoExp = this.pilhaTipos.pop();

        if (!tipoId.equals(tipoExp)) {
            throw new SemanticError("Tipos incompátiveis no comando de atribuição " + tipoId + " e " + tipoExp, token.getPosition());
        }

        if (tipoId.equals("int64")) {
            this.codigo.append("conv.i8");
        }

        this.codigo.append(" stloc ").append(lexeme).append("\n");
    }

    public void Acao_27() {

    }

    public void Acao_28() {

    }

    public void Acao_29() {

    }

    public void Acao_30() {

    }

    public void Acao_31() {

    }

    public void Acao_32() {

    }
}
