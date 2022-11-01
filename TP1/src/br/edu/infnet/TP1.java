package br.edu.infnet;

import java.util.Scanner;

public class TP1 {
	
	private static String[] nomes;
	private static float[] notaAv1;
	private static float[] notaAv2;
	
	private static final int TAMANHO = 100;
	
	private static void imprimirCadastro(int indice) {
		
		System.out.println("-------------------------------------------------");
		System.out.println("Aluno " + nomes[indice] + " registrado na posicao < " + indice + " >");
		System.out.println("-------------------------------------------------");
	}
	
	private static void imprimirBoletim(int indice) {
		
		System.out.println("-------------------------------------------------");
		System.out.println("Imprimindo boletim do aluno na posição < " + indice + " >");
		System.out.println();
		System.out.println("Aluno: " + nomes[indice]);
		System.out.println("Nota AV1: " + notaAv1[indice]);
		System.out.println("Nota AV2: " + notaAv2[indice]);
		System.out.println("Média final: " + calcularMedia(indice));
		System.out.println("Situação: " + verificaSituacao(indice));
		System.out.println("-------------------------------------------------");
	}
	
	private static float calcularMedia(int indice) {
		return (notaAv1[indice] + notaAv2[indice]) / 2;
	}
	
	private static String verificaSituacao(int indice) {
		if(calcularMedia(indice) < 4) {
			return "Reprovado";
		} else {
			if(calcularMedia(indice) >= 4 && calcularMedia(indice) < 7) {
				return "Prova final";
			}
		}
		return "Aprovado";
		}
	private static void imprimirTurma() {			
		for (int i = 0; i < TAMANHO; i++) {
			if(nomes[i] != null) {
				imprimirBoletim(i);
			}
		}		
	}
		
	
	public static void main(String[] args) {
		nomes = new String[TAMANHO];
		notaAv1 = new float[TAMANHO];
		notaAv2 = new float[TAMANHO];
		
		Scanner in = new Scanner(System.in);
		
		int pos = 0;
		String opcao;
		do {
			System.out.println("Informe a opção desejada: ");
			
			System.out.println("[1] Registrar as notas de um novo aluno");
			System.out.println("[2] Consultar boletim de um aluno");
			System.out.println("[3] Consultar notas da turma");
			System.out.println("[4] Sair");				
			
			opcao = in.next();
			
			switch (opcao) {
			case "1":
				if(pos < TAMANHO) {
					
					System.out.println("Registro de notas");
					System.out.println("-------------------------------------------------");
					System.out.print("Informe o aluno para registro: ");					
					nomes[pos] = in.next();
					
					System.out.print("Informe a nota da AV1: ");
					notaAv1[pos] = in.nextInt();
					
					System.out.print("Informe a nota da AV2: ");
					notaAv2[pos] = in.nextFloat();
					
					imprimirCadastro(pos);
					
					pos++;
				} else {
					System.out.println("Impossível realizar um novo registro!");
				}
				break;
				
			case "2":
				System.out.println("Consulta de boletim");
				System.out.println("-------------------------------------------------");
				System.out.print("Informe o aluno para impressão do boletim: ");
				int id = in.nextInt();
				
				if(id >= 0 && id < pos) {
					imprimirBoletim(id);
				} else {
					System.out.println("O índice [" + id + "] é inválido!");
				}				
				break;
				
			case "3":
				System.out.println("Consultar notas da turma");
				System.out.println("-------------------------------------------------");
				imprimirTurma();
				break;
				
			case "4":
				System.out.println("Programa encerrado!!");
				break;
			
			default:
				System.out.println("A opção [" + opcao + "] é inválida");
				break;
			}
			
		} while (!"4".equalsIgnoreCase(opcao));		
		
		in.close();
	}
}