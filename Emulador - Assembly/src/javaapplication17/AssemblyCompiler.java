package javaapplication17;

import java.util.HashMap;

class AssemblyCompiler {
    public static String linha;
    public static String linha2;
    public static String linha3;
	
	public static HashMap<?, ?> getRegisters(Uc uc) {
		return uc.getRegisters();
	}

	// Compilador assembly, recebe uma matriz com código em assembly.
	// Dentro da matriz, os arranjos devem ser compostos de:
	// 1 - Opcode com a operação, 2 - Primeiro registrador, 3 - Segundo registrador
	public static void compiladorAssembly(String[][] codigoAssembly) {
		Uc uc = new Uc();
		int pc = Integer.parseInt(uc.pc.getValue()) - 1;
		uc.printaValores();

		// Gera o firmware e em seguida passa para o ciclo de execução
		while(pc < codigoAssembly.length) {

			String[] sinaisDeControle = uc.cicloDeBusca(codigoAssembly[pc]);
			System.out.print("\t"+codigoAssembly[pc][0]+" ");
			System.out.print(codigoAssembly[pc][1]+" ");
			System.out.println(codigoAssembly[pc][2]+"\n");
			uc.cicloExecucao(sinaisDeControle);

			pc = Integer.parseInt(uc.pc.getValue(), 2) - 1;

		}
	}	
}
