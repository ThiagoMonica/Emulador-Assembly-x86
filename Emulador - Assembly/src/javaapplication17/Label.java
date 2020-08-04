package javaapplication17;

import java.util.ArrayList;
class Label{

    static ArrayList<String> label = new ArrayList<String>();
    static ArrayList<Integer> linhaLabel = new ArrayList<Integer>();

    public static boolean adicionaLabel (String palavra, int linha){
        if (palavra.contains(":") && palavra.indexOf(":") == palavra.length()-1 && label.contains(palavra) == false){
        	 palavra = palavra.substring(0, palavra.length() - 1);
            label.add(palavra);
            linhaLabel.add(linha);
            System.out.println("ESTOU ADICIONANDO LABEL");
            return true;
        }
        return false;
    }

    public static int getLinhaLabel (String palavra){
        int linha = -1;
        if(label.contains(palavra)){
            int index = label.indexOf(palavra);
            linha = linhaLabel.get(index);
        }

        return (linha);
    } 



    public static void main (String [] args){
        adicionaLabel("Epa:", 10);
        adicionaLabel("Epa:", 10);
        adicionaLabel("E:pa", 15);
        adicionaLabel("Epa", 25);
        adicionaLabel("E:pa:", 5);
        adicionaLabel("Opa:", 50);

         System.out.println(label);
         System.out.println(linhaLabel);
         System.out.println(getLinhaLabel(("Epa")));
         System.out.println(getLinhaLabel(("Opa")));
    }
}