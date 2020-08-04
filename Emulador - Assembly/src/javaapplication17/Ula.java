package javaapplication17;

public class Ula{
    // flag compare ZERO:
    static boolean compZero = false;
    // flag compare SINAL:
    static boolean compSinal = false;
    
    static boolean autorizaJump = false;

    //registradores da ULA
    static int a = 0;
    static int b = 0;
    static int resultado = 0;
    
    static void setA (String entrada){
        a = Integer.parseInt(entrada, 2);
        autorizaJump = false;
    }
    static void setB (String entrada){
        b = Integer.parseInt(entrada, 2);
        autorizaJump = false;
    }
    public static String getResultado (){        
        
        String retorno = "";
        if (resultado < 0){
            retorno = "1";
            retorno += Integer.toBinaryString(resultado * -1);
        }
        else {
            retorno = "0";
            retorno += Integer.toBinaryString(resultado);
        }
            return(retorno);
    }
    static boolean getFlagZero (){
        return (compZero);
    }
    static boolean getFlagSinal (){
        return (compSinal);
    }
    public static void recebeOperacao (String comando){
        // 0000  
        // 0001  adicao
        // 0010  subtracao
        // 0011  multiplicacao
        // 0100  divisao
        // 0101  mod
        // 0110  jmp
        // 0111  je
        // 1000  jne
        // 1001  jg
        // 1010  jge
        // 1011  jl
        // 1100  jle
        // 1101  compare
        // 1110 
        // 1111
        switch (comando){
            case "0000":
                break;
            case "0001":
                resultado = add();
                break;
            case "0010":
                resultado = sub();
                break;
            case "0011":
                resultado = mult();
                break;
            case "0100":
                resultado = div();
                break;
            case "0101":
                resultado = mod();
                break;
                
            case "0110"://jmp
                autorizaJump = true;
                resultado = b;
                break;
            case "0111"://je
                autorizaJump = false;
                if (compZero == true) {
                    autorizaJump = true;
                    resultado = b;
                } else {
                    resultado = a;
                }
                System.out.println(resultado);
                break;
            case "1000"://jne
                autorizaJump = false;
                if(getFlagZero() == false) {
                    autorizaJump = true;
                    resultado = b;
                } else {
                    resultado = a;
                }
                break;
            case "1001":///jg
                autorizaJump = false;
                if(getFlagSinal() == true && getFlagZero() == false) {
                    autorizaJump = true;
                    resultado = b;
                } else {
                    resultado = a;
                }
                break;
            case "1010"://jge
                autorizaJump = false;
                if(getFlagSinal() == true || getFlagZero() == true) {
                    autorizaJump = true;
                    resultado = b;
                } else {
                    resultado = a;
                } 
                break;
            case "1011"://jl
                autorizaJump = false;
                if(getFlagSinal() == false && getFlagZero() == false) {
                    autorizaJump = true;
                    resultado = b;
                } else {
                    resultado = a;
                }
                break;
            case "1100"://jle
                autorizaJump = false;
                if(getFlagSinal() == false || getFlagZero() == true) {  
                    autorizaJump = true;
                    resultado = b;
                } else {
                    resultado = a;
                }
                break;
            case "1101":
                compare();
                break;
        }
    }


    static void compare (){
        int res = sub();
        if (res == 0){
            compZero = true;
        }
        if(res < 0){
            compSinal = false;
        }
        if(res > 0){
            compSinal = true;
        }
    }
    static int add (){
        int res = a + b;
        return(res);
    }
    static int sub (){
        int res = a - b;
        return(res);
    }
    static int mult (){
        int res = a * b;
        return(res);
    }
    static int div (){
        int res = a / b;
        return(res);
    }
    static int mod (){
        int res = 0;
        if(a > b)
            res = a % b;
        return(res);
    }
}


