package unirio.mestrado2020.apa.emparelhamentoEstavel;

import java.io.IOException;
import java.util.Scanner;

/**
 * Comentar ...
 *
 */
public class Principal {

	static boolean isDebug = false;
	static int execucoes = 1;

	static String[] tipos = { "ale", "best", "hard" };

	static int tamanhos[] = { 5, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		if (args != null && args.length > 0 && args[0] != null) {
			String p0 = String.valueOf(args[0]);
			if (p0.equals("-help")) {
				System.out.println("debug:[true|false] - Se debug = true, então o programa exibirá a lista de preferências, ranking e casais.");
				System.exit(0);
			}
		}

		if (args != null && args.length > 0 && args[0] != null) {

			isDebug = Boolean.valueOf(args[0]);

			Scanner keyboard = new Scanner(System.in);

			if (isDebug) {
				System.out.println("Informe um Tipo (ale | best | hard):");
				String textTipo = keyboard.nextLine();
				tipos = new String[1];
				tipos[0] = textTipo;

				System.out.println("Informe o tamanho para N: (5|50|100|200|300|400|500|600|700|800|900|1000");
				String textTamanho = keyboard.nextLine();
				tamanhos = new int[1];
				tamanhos[0] = Integer.valueOf(textTamanho);
			} else {
				System.out.println("Número de execuções para ser apurada a média do tempo das execuções:");
				String textExecucoes = keyboard.nextLine();
				execucoes = Integer.valueOf(textExecucoes);
			}

		}

		LoadManager lm = new LoadManager(isDebug);
		System.out.println("Realizando leitura dos arquivos...");
		lm.importarTodos();
		System.out.println("Arquivos lidos!");

		if (!isDebug) {
			System.out.print("\nN");
			for (String tipo : tipos) {
				System.out.print(";" + tipo);
			}
		}

		for (int tamanho : tamanhos) {

			if (!isDebug) {
				System.out.print("\n" + tamanho);
			}

			for (String tipo : tipos) {

				if (isDebug) {
					System.out.println("\n" + tipo + " INSTANCE STABLE MARIAGE ");
					System.out.println("N \t" + tamanho);
				}

				// - - - - - - - - - - - - - - - - - - - - -
				// CARREGAMENTO DOS DADOS
				// - - - - - - - - - - - - - - - - - - - - -
				Preferencia p = lm.mapPrefs.get(tipo + "_" + tamanho);

				int[][] prefH = p.getPrefHomens();
				int[][] prefM = p.getPrefMulheres();
				int[][] ranking = p.getRanking();

				if (isDebug) {
					imprimirMatriz("MEN'S PREFERENCES", prefH);
					imprimirMatriz("WOMEN'S PREFERENCES", prefM);
					imprimirMatriz("RANKING", ranking);
					System.out.println("RESULTADO");
				}

				CasamentoEstavel c = new CasamentoEstavel();

				long estimatedTime = 0;
				int interacoes = 0;

				long startTime = System.nanoTime();
				for (int i = 0; i < execucoes; i++) {
					interacoes = c.processar(prefH, prefM, ranking, isDebug);
					estimatedTime += (System.nanoTime() - startTime);
				}
				estimatedTime = (estimatedTime / execucoes);

				if (isDebug) {
					System.out.println("Tempo de execucao: " + estimatedTime + " nanosegundos.");
				} else {
					System.out.print(";" + estimatedTime);
				}

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
