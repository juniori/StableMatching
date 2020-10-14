package unirio.mestrado2020.apa.emparelhamentoEstavel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Comentar ...
 *
 */
public class Principal {

	static String saida = "c"; // (c),(t),(i);
	static int execucoes = 1;
	static String[] tiposInstancia = { "ale", "best", "hard" };
	static int tamanhosInstancia[] = { 5, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };

	public static void main(String[] args) throws IOException {

		// Leitura dos parâmetros de tela
		lerParametrosTela(args);

		if (!saida.equals("c")) {
			System.out.print("\nN");
			for (String tipo : tiposInstancia) {
				System.out.print(";" + tipo);
			}
		}

		for (int tamanho : tamanhosInstancia) {

			if (!saida.equals("c")) {
				System.out.print("\n" + tamanho);
			}

			for (String tipo : tiposInstancia) {

				if (saida.equals("c")) {
					System.out.println("\n" + tipo + " INSTANCE STABLE MARIAGE ");
					System.out.println("N \t" + tamanho);
				}

				// - - - - - - - - - - - - - - - - - - - - -
				// CARREGANDO ARQUIVO CORRESPONDENTE A INSTÂNCIA NA MEMÓRIA
				// - - - - - - - - - - - - - - - - - - - -
				LoadManager lm = new LoadManager();
				Preferencia p = lm.importar(Matrizes.getFileName(tipo, tamanho));

				int[][] prefH = p.getPrefHomens();
				int[][] prefM = p.getPrefMulheres();
				int[][] ranking = p.getRanking();

				if (saida.equals("c")) {
					imprimirMatriz("MEN'S PREFERENCES", prefH);
					imprimirMatriz("WOMEN'S PREFERENCES", prefM);
					imprimirMatriz("RANKING", ranking);
					System.out.println("RESULTADO");
				}

				CasamentoEstavel c = new CasamentoEstavel();
				boolean imprimirCasais = saida.equals("c");
				int iteracoes = 0;

				// - - - - - - - - - - - - - - - - - - - - -
				// MENSURAÇÃO DO TEMPO
				// - - - - - - - - - - - - - - - - - - - - -

				long estimatedTime = 0;
				for (int i = 0; i < execucoes; i++) {
					long startTime = System.nanoTime();
					iteracoes = c.processarGaleShapley(prefH, prefM, ranking, imprimirCasais);
					estimatedTime += (System.nanoTime() - startTime);
				}
				estimatedTime = estimatedTime / execucoes;

				// - - - - - - - - - - - - - - - - - - - - -
				// IMPRESSÃO DOS RESULTADOS
				// - - - - - - - - - - - - - - - - - - - - -
				if (saida.equals("c")) {
					System.out.println("Tempo de execucao: " + estimatedTime + " nanosegundos.");
				} else if (saida.equals("i")) {
					System.out.print(";" + iteracoes);
				} else {
					System.out.print(";" + estimatedTime);
				}

			}
		}

	}

	private static LoadManager carregarArquivosEntrada() throws IOException {
		LoadManager lm = new LoadManager();
		System.out.println("Realizando leitura dos arquivos...");
		lm.importarTodos();
		System.out.println("Arquivos lidos!");
		return lm;
	}

	private static void lerParametrosTela(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Informe o tipo de saída desejada (c)asais, (i)terações, (t)empo:");
		String textSaida = keyboard.nextLine();
		while (textSaida.equals("")) {
			textSaida = keyboard.nextLine();
		}
		saida = textSaida;

		System.out.println("Informe um Tipo (ale | best | hard ) ou * para todas:");
		String textTipo = keyboard.nextLine();
		while (textTipo.equals("")) {
			textTipo = keyboard.nextLine();
		}
		if (!"*".equals(textTipo)) {
			tiposInstancia = new String[1];
			tiposInstancia[0] = textTipo.toLowerCase();
		}

		System.out.println("Informe o tamanho para N: (5|50|100|200|300|400|500|600|700|800|900|1000) ou * para todas:");
		String textTamanho = keyboard.nextLine();
		while (textTamanho.equals("")) {
			textTamanho = keyboard.nextLine();
		}
		if (!"*".equals(textTamanho)) {
			tamanhosInstancia = new int[1];
			tamanhosInstancia[0] = Integer.valueOf(textTamanho);
		}

		if (saida.equals("t")) {
			System.out.println("Número de execuções para ser apurada a média do tempo das execuções:");
			String textExecucoes = keyboard.nextLine();
			if (!"".equals(textExecucoes)) {
				execucoes = Integer.valueOf(textExecucoes);
			}

		}

	}

	public static void imprimirMatriz(String titulo, int[][] matriz) {

		System.out.println(titulo);

		for (int i = 0; i < matriz.length; i++) {

			String str = "";
			for (int j = 0; j < matriz.length; j++) {
				str = str + matriz[i][j] + "   ";
			}
			System.out.println(str);
		}

	}

}
