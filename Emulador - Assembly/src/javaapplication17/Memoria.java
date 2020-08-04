package javaapplication17;

import java.util.HashMap;


public class Memoria {
	
	private HashMap<String, String> mem = new HashMap<String,String>();
	private HashMap<String, String> operacoes = new HashMap<String,String>();
	private String comando;
	private String endereco;
	private String mar;
	private String mbr;

        // 0000  mov
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
        // 1110  label
        // 1111

	public Memoria() {
		operacoes.put("mov", "0000");
		operacoes.put("add", "0001");
		operacoes.put("sub", "0010");
		operacoes.put("mul", "0011");
		operacoes.put("div", "0100");
		operacoes.put("mod", "0101");
		operacoes.put("jmp", "0110");
		operacoes.put("je", "0111");
		operacoes.put("jne", "1000");
		operacoes.put("jg", "1001");
		operacoes.put("jge", "1010");
		operacoes.put("jl", "1011");
		operacoes.put("jle", "1100");
		operacoes.put("cmp", "1101");
		operacoes.put("label", "1110");

		mem.put("AX", "01010");
		mem.put("BX", "01100");
		mem.put("CX", "01110");
		mem.put("DX", "10000");

	}
	
	public String getEndTemporario() {
		return mar;
	}

	public void setEndTemporario(String endTemporario) {
		this.mar = endTemporario;
	}

	public String readMemoria(String endereco){
		
		return mem.get(endereco);
	}
	
	public void writeMemoria (String endereco, String valor){
		mem.put(endereco, valor);
	}
	
	public String[] getOpcodeAndRegisterPort(String comando, String op1, String op2){
		String[] result = new String[3];
		
		//Se não for nenhuma operação, é tratado como label, que tem endereco 1110 na memoria
		if(operacoes.get(comando)==null) comando = "label";
		
		result[0] = operacoes.get(comando);
		result[1] = mem.get(op1) != null ? mem.get(op1) : "24";
		result[2] = mem.get(op2) != null ? mem.get(op2) : "26";
		
		return result;
	}

}
