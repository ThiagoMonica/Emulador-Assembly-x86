package javaapplication17;

class Firmware {

	static final String MEMORY_READ_OPERATION = "01";
	static final String MEMORY_WRITE_OPERATION = "10";
	static final String MEMORY_ADDRESS_VALID_OPERATION = "11";
	static final String MEMORY_NO_OPERATION = "00";

	public String[] getSinaisDeControle(String[] palavra, boolean op1Endereco, boolean op2Endereco) {
		String opCode = palavra[0];
		String operandoUm = palavra[1];
		String operandoDois = palavra[2];

		int portaOp1 = operandoUm.charAt(0) != '2' ? Integer.parseInt(operandoUm, 2) : Integer.parseInt(operandoUm);
		int portaOp2 = operandoDois.charAt(0) != '2' ? Integer.parseInt(operandoDois, 2) : Integer.parseInt(operandoDois);
		String[] result;

		switch(opCode) {
			case "0000": //mov
					if (op1Endereco) {
						int[][] portas = {
							{24, 5},
							{3, portaOp2},
							{6, 20, 21}
						};

						String[] ulaOperations = {
							"0000",
							"0000",
							"0000"
						};

						String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_NO_OPERATION, MEMORY_WRITE_OPERATION };
						result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);

					} else if (op2Endereco) {
						int[][] portas = {
							{26, 5, 20},
							{7, 22},
							{4, portaOp1 - 1}
						};

						String[] ulaOperations = {
							"0000",
							"0000",
							"0000"
						};

						String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_READ_OPERATION, MEMORY_NO_OPERATION };
						result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);

					} else {
						// Portas designadas para entrada são um número inferior ao retornado.
						int[][] portas = {
							{portaOp1 -1, portaOp2}
						};

						String[] ulaOperations = {
							"0000",
						};

						String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_NO_OPERATION, MEMORY_NO_OPERATION };
						result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);
					}

					return result;

			case "0001": //add
			case "0010": //sub
			case "0011": //mul
			case "0100": //div
			case "0101": //mod

				if (op1Endereco) {
					int[][] portas = {
						{24, 5},
						{7, 22, portaOp2, 19},
						{4, 17},
						{18, 3},
						{21, 6}
					};

					String[] ulaOperations = {
						"0000",
						"0000",
						opCode,
						"0000",
						"0000"
					};

					String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_READ_OPERATION, MEMORY_NO_OPERATION, MEMORY_NO_OPERATION, MEMORY_WRITE_OPERATION };

					result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);

				} else if (op2Endereco) {
					int[][] portas = {
						{26, 5},
						{7, 22, portaOp1, 19},
						{4, 17},
						{18, portaOp1 -1}
					};

					String[] ulaOperations = {
						"0000",
						"0000",
						opCode,
						"0000"
					};

					String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_READ_OPERATION, MEMORY_NO_OPERATION, MEMORY_NO_OPERATION };

					result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);
				} else {
					int[][] portas = {
						{portaOp1, 19},
						{portaOp2, 17},
						{18, portaOp1 -1}
					};

					String[] ulaOperations = {
						"0000",
						opCode,
						"0000"
					};

					String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_NO_OPERATION, MEMORY_NO_OPERATION };

					result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);
				}

				return result;

			case "1101": //cmp

				if (op1Endereco) {
					int[][] portas = {
						{24, 5},
						{7, 22, portaOp2, 19},
						{4, 17}
					};

					String[] ulaOperations = {
						"0000",
						"0000",
						opCode
					};

					String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_READ_OPERATION, MEMORY_NO_OPERATION };

					result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);

				} else if (op2Endereco) {
					int[][] portas = {
						{26, 5},
						{7, 22, portaOp1, 19},
						{4, 17}
					};

					String[] ulaOperations = {
						"0000",
						"0000",
						opCode
					};

					String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_READ_OPERATION, MEMORY_NO_OPERATION };

					result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);
				} else {
					int[][] portas = {
						{portaOp1, 19},
						{portaOp2, 17},
					};

					String[] ulaOperations = {
						"0000",
						opCode,
					};

					String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_NO_OPERATION };

					result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);
				}

				return result;
			
			case "1110":
				if (!op1Endereco || !op2Endereco) {
				int[][] portas = {
						{portaOp1, portaOp2},
					};

					String[] ulaOperations = {
						"0000"						
					};

					String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_NO_OPERATION, MEMORY_NO_OPERATION };
					
					result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);
				
					return result;
				}
			// Jumps
			default:
				int[][] portas = {
					{2, 19},
					{24, 17},
					{18, 1}
				};

				String[] ulaOperations = {
					"0000",
					opCode,
					"0000"
				};

				String[] memoryOperations = { MEMORY_NO_OPERATION, MEMORY_NO_OPERATION, MEMORY_NO_OPERATION };
				
				
				
				result = gerarBinarioDeControle(portas, ulaOperations, memoryOperations);

				return result;
		}
	}

	private String[] gerarBinarioDeControle(int[][] portas, String[] ulaOperation, String[] memoryOperation) {
		String[] binariosDeControle = new String[portas.length];

		for(int i = 0; i < portas.length; i++) {
			StringBuilder result = new StringBuilder("00000000000000000000000000");

			for(int j : portas[i])
				result.setCharAt(j-1, '1');

			result.append(ulaOperation[i]);
			result.append(memoryOperation[i]);

			binariosDeControle[i] = result.toString();
			binariosDeControle[i] = binariosDeControle[i].split("\\[")[0];
		}

		return binariosDeControle;
	}

}