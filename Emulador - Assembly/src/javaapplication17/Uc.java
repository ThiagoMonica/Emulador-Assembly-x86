
package javaapplication17;

import java.util.HashMap;

public class Uc {
    
// HashMap para armazenas valores dos registradores e portas do barramento que deverão abrir ou fechar
	HashMap<String, Integer> valoresRegistradores = new HashMap<String,Integer>();
	private HashMap<Integer, Registrador> portas = new HashMap<Integer,Registrador>();
	private String barramentoRegistradores = null;
	// Inicializando registradores
	Registrador ax = new Registrador("0");
	Registrador bx = new Registrador("0");
	Registrador cx = new Registrador("0");
	Registrador dx = new Registrador("0");
	Registrador irOp1 = new Registrador("0");
	Registrador irOp2 = new Registrador("0");
	Registrador pc = new Registrador("1");
	Registrador mbr = new Registrador("0");
	Registrador mar = new Registrador("0");
	Registrador ulaX = new Registrador("0");
	Memoria memoria = new Memoria();
	//Ula ula = new Ula();

	// Preenchendo HashMap de portas, o número de cada porta refere-se ao desenho do barramento
	public Uc() {
		portas.put(1, pc);
		portas.put(2, pc);
		portas.put(3, mbr);
		portas.put(4, mbr);
		portas.put(5, mar);
		portas.put(9, ax);
		portas.put(10, ax);
		portas.put(11, bx);
		portas.put(12, bx);
		portas.put(13, cx);
		portas.put(14, cx);
		portas.put(15, dx);
		portas.put(16, dx);
		portas.put(19, ulaX);
		portas.put(23, irOp1);
		portas.put(24, irOp1);
		portas.put(25, irOp2);
		portas.put(26, irOp2);
	}

	// Ciclo de busca, recebe um array com o comando em assembly, que deve ser composto por:
	// 1 - Opcode com a operação, 2 - Primeiro registrador, 3 - Segundo registrador
	public String[] cicloDeBusca(String[] comando) {
		// Pega o código binário referente ao comando na memória
		String[] palavra = memoria.getOpcodeAndRegisterPort(comando[0], comando[1], comando[2]);
		// Caso o operando tenha [], deveremos lidar com um endereço na meméria.
		// Ex: Mov AX [1000], deveremos pegar o que estão no endereço 1000 da memória e jogar em AX
		boolean op1Endereco = ( comando[1].contains("[") && comando[1].contains("]"));
		boolean op2Endereco = ( comando[2].contains("[") && comando[2].contains("]"));

		// Preenche os IR com os dados que foram passados no comando
		if (op1Endereco) {
			irOp1.setValue(comando[1].split("\\[")[1].split("\\]")[0]);
		} else {
			irOp1.setValue(comando[1]);
		}

		if (op2Endereco) {
			irOp2.setValue(comando[2].split("\\[")[1].split("\\]")[0]);
		} else {
			irOp2.setValue(comando[2]);
		}

		// Chama o firmware e gera os sinais de controle, para serem interpretados pela UC
		Firmware firmware = new Firmware();
		String[] sinaisDeControle = firmware.getSinaisDeControle(palavra, op1Endereco, op2Endereco);
		

		// Incrementa o PC (converte de binario para inteiro e depois converte de volta para binario)
		int pcIncremented = Integer.parseInt(pc.getValue(), 2) + 1;
		pc.setValue(Integer.toBinaryString(pcIncremented));

		return sinaisDeControle;
	}

	// Ciclo de execução, recebe uma matriz com os sinais de controle indicando quais portas deverão abrir em cada tempo
	// Cada elemento do array é um tempo do processador
	public void cicloExecucao(String[] sinaisDeControle) {
		// Aqui eu usei Scanner para fazer o esquema de iterar cada tempo do processador
		// Toda vez que o usuário apertar ENTER o programa itera para o próximo tempo
		//Scanner entrada = new Scanner (System.in);
		for (String j : sinaisDeControle ) {
			// Pega o que deve ser executado pela ULA e Memoria
			String ulaCode = j.substring(26, 30);
			String memoryCode = j.substring(30, 32);

			// Percorre a string, onde tiver 1 ele deve abrir uma portinha, onde tiver 0 nÃ£o precisa fazer nada
			for (int i = 1; i < 26; i += 2) {
				if (j.charAt(i) == '1') {
					abrirPorta(i + 1);
				}
			}

			for (int i = 0; i < 26; i += 2) {
				if (j.charAt(i) == '1') {
					abrirPorta(i + 1);
				}
			}

			// Chama a operação da ULA, caso exista
			Ula.recebeOperacao(ulaCode);

			// Memoria: 01 - executar um READ, 10 - executar um write, 00 - nÃ£o faz nada
			if (memoryCode.equals("01"))
				mbr.setValue(memoria.readMemoria(mar.getValue()));
			else if (memoryCode.equals("10")) {
				memoria.writeMemoria(mar.getValue(), mbr.getValue());
				valoresRegistradores.put("["+Integer.parseInt(mar.getValue(), 2)+"]", Integer.parseInt(mbr.getValue(), 2));
			}

			// Printa os valores dos regist
			System.out.println("\n"+ getRegisters());
			//entrada.nextLine();
		}
	}

	public void printaValores() {
		System.out.println("\n\n*******************************");
		System.out.println("AX: "+ Integer.parseInt(ax.getValue(), 2));
                NewJFrame.AX = Integer.parseInt(ax.getValue(), 2);
		System.out.println("BX: "+ Integer.parseInt(bx.getValue(), 2));
		System.out.println("CX: "+ Integer.parseInt(cx.getValue(), 2));
		System.out.println("DX: "+ Integer.parseInt(dx.getValue(),2));
		System.out.println("MAR: "+Integer.parseInt(mar.getValue(), 2));
		System.out.println("MBR: "+Integer.parseInt(mbr.getValue(), 2));
		System.out.println("ULAX: "+Integer.parseInt(ulaX.getValue(), 2));
		System.out.println("PC (linha): "+ Integer.parseInt(pc.getValue(), 2));
		System.out.println("IR (OP1): "+irOp1.getValue());
		System.out.println("IR (OP2): "+irOp2.getValue());
		System.out.println("ULA (A): "+Ula.a);
		System.out.println("ULA (B): "+Ula.b);
		System.out.println("ULA (RESULTADO): "+Ula.resultado);
		System.out.println("Valor correndo no barramento: "+barramentoRegistradores);
		System.out.println("*******************************\n");
	}

	// Retorna um hashmap com os valores dos registradores
	public HashMap<String, Integer> getRegisters() {

		valoresRegistradores.put("AX", Integer.parseInt(ax.getValue(), 2));
		valoresRegistradores.put("BX", Integer.parseInt(bx.getValue(), 2));
		valoresRegistradores.put("CX", Integer.parseInt(cx.getValue(), 2));
		valoresRegistradores.put("DX", Integer.parseInt(dx.getValue(),2));
		valoresRegistradores.put("MAR", Integer.parseInt(mar.getValue(), 2));
		valoresRegistradores.put("MBR", Integer.parseInt(mbr.getValue(), 2));
		valoresRegistradores.put("ULAX", Integer.parseInt(ulaX.getValue(), 2));
		valoresRegistradores.put("PC",  Integer.parseInt(pc.getValue(), 2));
		valoresRegistradores.put("ULA(A)", Ula.a);
		valoresRegistradores.put("ULA(B):", Ula.b);
		valoresRegistradores.put("ULA(RESULTADO):", Ula.resultado);
                
                NewJFrame.AX=Integer.parseInt(ax.getValue(), 2);
                NewJFrame.BX=Integer.parseInt(bx.getValue(), 2);
                NewJFrame.CX=Integer.parseInt(cx.getValue(), 2);
                NewJFrame.DX=Integer.parseInt(dx.getValue(), 2);
		NewJFrame.MAR=Integer.parseInt(mar.getValue(), 2);
                NewJFrame.MBR=Integer.parseInt(mbr.getValue(), 2);
                NewJFrame.ULAX=Integer.parseInt(ulaX.getValue(), 2);
                NewJFrame.PC=Integer.parseInt(pc.getValue(), 2);
                NewJFrame.ULAA=Ula.a;
                NewJFrame.ULAB=Ula.b;
                NewJFrame.ULAR=Ula.resultado;
                return valoresRegistradores;
	}

	// Método que abre as portinhas e seta os valores nos registradores
	// Recebe o número da porta para abrir
	// Portinhas de numero impar são entradas para registradores
	// Já portinhas de numero par são saidas dos registradores
	// Então se for impar, faz chama o set do registrador, se for par chama o get
	public void abrirPorta(int porta) {
		// Se for uma dessas portas pode retornar, são portas da memoria e ja foi tratado no método cicloExecucao
		if ((porta > 19 && porta < 23) || (porta == 6 || porta == 7))
			return;

		if (porta % 2 != 0) {
			System.out.println("Entrando na portinha "+porta);
                        NewJFrame.portasUsadas = NewJFrame.portasUsadas + String.valueOf(porta+" ");
			// Portas 19 e 17 são portas da ula, nesses casos seta A ou B
			if (porta == 19) {
				Ula.setA(barramentoRegistradores);
			} else if (porta == 17) {
				Ula.setB(barramentoRegistradores);
			} else {
				portas.get(porta).setValue(barramentoRegistradores);
			}
		} else {
			System.out.println("Saindo da portinha "+porta);
                        NewJFrame.portasUsadas = NewJFrame.portasUsadas + String.valueOf(porta+" ");
			String value;

			// Saida da porta da ULA
			if (porta == 18) {
				value = Ula.getResultado();
			} else {
				value = portas.get(porta).getValue();
				

				if (porta == 26 || porta == 24) {
					value = Integer.toBinaryString(Integer.parseInt(value));
				}
			}

			// Para mover valores de um registrador para o outro, estou usando a variavel auxiliar
			// barramentoRegistradores, que é pra simbolizar o valor que está correndo no barramento
			barramentoRegistradores = value;
		}
	}
}