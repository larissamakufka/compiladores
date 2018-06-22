package trabalhofinalcompiladores.Semantico;

import java.util.Stack;
import trabalhofinalcompiladores.Comum.Constants;
import trabalhofinalcompiladores.Comum.Token;

public class Semantico implements Constants {

    private String operador;
    private StringBuilder codigo;
    private Stack<String> pilhaTipos;
    
    public void executeAction(int action, Token token) throws SemanticError {
        switch(action)
        {
            case 1: this.Acao_1();
            case 2: this.Acao_2();
            case 3: this.Acao_3();
            case 4: this.Acao_4(token);
            case 5: this.Acao_5(token);
            case 6: this.Acao_6(token);
            case 7: this.Acao_7(token);
            case 8: this.Acao_8(token);
            case 9: this.Acao_9(token);
            case 10: this.Acao_10(token);
            case 11: this.Acao_11();
            case 12: this.Acao_12();
            case 13: this.Acao_13(token);
            case 14: this.Acao_14();
            case 15: this.Acao_15();
            case 16: this.Acao_16();            
            default: throw new SemanticError("Ação semântica não reconhecida #" + action, token.getPosition());
        }
    }
    
    public void Acao_1()
    {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();
        
        if (tipo1.equals("float64") || tipo2.equals("float64"))
        {
            this.pilhaTipos.push("float64");
        }
        else
        {
            this.pilhaTipos.push("int64");
        }
        
        this.codigo.append("add");
    }
    
    public void Acao_2()
    {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();
        
        if (tipo1.equals("float64") || tipo2.equals("float64"))
        {
            this.pilhaTipos.push("float64");
        }
        else
        {
            this.pilhaTipos.push("int64");
        }
        
        this.codigo.append("sub");
    }

    public void Acao_3()
    {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();
        
        if (tipo1.equals("float64") || tipo2.equals("float64"))
        {
            this.pilhaTipos.push("float64");
        }
        else
        {
            this.pilhaTipos.push("int64");
        }
        
        this.codigo.append("mul");
    }

    public void Acao_4(Token token) throws SemanticError
    {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals(tipo2))
        {
            this.pilhaTipos.push(tipo1);
        }
        else
        {
            throw new SemanticError("Erro semântico encontrado na ação #4", token.getPosition());
        }
        
        this.codigo.append("div");
    }
    
    public void Acao_5(Token token)
    {
        this.pilhaTipos.push("int64");
        this.codigo.append("ldc.i8 " + token.getLexeme() + "\n");
        this.codigo.append("conv.r8 \n");
    }
    
    public void Acao_6(Token token)
    {
        this.pilhaTipos.push("float64");
        this.codigo.append("ldc.r8" + token.getLexeme() + "\n");
    }
    
    public void Acao_7(Token token) throws SemanticError
    {
        String tipo = this.pilhaTipos.pop();
        
        if (tipo.equals("float64") || tipo.equals("int64"))
        {
            this.pilhaTipos.push(tipo);
        }
        else
        {
            throw new SemanticError("Erro semântico encontrado na ação #7", token.getPosition());
        }
    }
    
    public void Acao_8(Token token) throws SemanticError
    {
        String tipo = this.pilhaTipos.pop();
        
        if (tipo.equals("float64") || tipo.equals("int64"))
        {
            this.pilhaTipos.push(tipo);
        }
        else
        {
            throw new SemanticError("Erro semântico encontrado na ação #8", token.getPosition());
        }
    }
    
    public void Acao_9(Token token)
    {
        this.operador = token.getLexeme();
    }
    
    public void Acao_10(Token token) throws SemanticError
    {
        String tipo1 = this.pilhaTipos.pop();
        String tipo2 = this.pilhaTipos.pop();

        if (tipo1.equals(tipo2))
        {
            this.pilhaTipos.push("bool");
        }
        else
        {
            throw new SemanticError("Erro semântico encontrado na ação #10", token.getPosition());
        }
        
        switch(this.operador)
        {
            case ">": this.codigo.append("cgt \n");
            case "<": this.codigo.append("clt \n");
            case "=": this.codigo.append("ceq \n");
        }
    }
    
    public void Acao_11()
    {
        this.pilhaTipos.push("bool");
        this.codigo.append("ldc.r4.1 \n");
    }
    
    public void Acao_12()
    {
        this.pilhaTipos.push("bool");
        this.codigo.append("ldc.r4.0 \n");
    }
    
    public void Acao_13(Token token) throws SemanticError
    {
        String tipo = this.pilhaTipos.pop();
        
        if (tipo.equals("bool"))
        {
            this.pilhaTipos.push("bool");
        }
        else
        {
            throw new SemanticError("Erro semântico encontrado na ação #13", token.getPosition());
        }
        
        this.codigo.append("ldc.i4.1 \n");
        this.codigo.append("xor \n");
    }
    
    public void Acao_14()
    {
        String tipo = this.pilhaTipos.pop();
        
        if (tipo.equals("int64"))
        {
            this.codigo.append("conv.i8 \n");                    
        }
        
        this.codigo.append("call void [mscorlib]System.Console::Write(" + tipo + ") \n");
    }
    
    public void Acao_15()
    {
        this.codigo.append(
            ".assembly extern mscorlib {} \n" +
            ".assembly _codigo_objeto{} \n" +
            ".module _codigo_objeto.exe \n" +
            ".class public _UNICA{ \n" +
            ".method static public void _principal() { \n" +
            ".entrypoint \n"
        );
    }
    
    public void Acao_16()
    {
        this.codigo.append(
            "ret \n" +
            "} \n" +
         "}" 
        );
    }
}
