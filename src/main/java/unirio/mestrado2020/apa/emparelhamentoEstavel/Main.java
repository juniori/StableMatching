package unirio.mestrado2020.apa.emparelhamentoEstavel;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

/**
 * Comentar ...
 *
 */
public class Main {

	private static int[] tamanhos = LoadManager.tamanhos; //
	// {
	// 5,50,100
	// };
	private static String[] tipos = { "best", "ale", "hard" };
	private static boolean isHabilitarLog = false;

	public static void main(String[] args) throws IOException {

		LoadManager lm = new LoadManager(isHabilitarLog);

		System.out.println("Carregando arquivos...");
		lm.importarTodos(tamanhos);
		System.out.println("Arquivos carregados na memória.");

		int qtdExec = 100;
		if (args != null && args.length > 0 && args[0] != null) {
			qtdExec = Integer.valueOf(args[0]);
		}

		while (true) {

			Scanner keyboard = new Scanner(System.in);
			System.out.println("");
			System.out.print("qtdExec: ");
			qtdExec = keyboard.nextInt();
			if (qtdExec==0){
				break;
			}

			for (int n : tamanhos) {

				System.out.print("\n" + n + "; ");
				for (String tipo : tipos) {

					// - - - - - - - - - - - - - - - - - - - - -
					// CARREGAMENTO DOS DADOS
					// - - - - - - - - - - - - - - - - - - - - -
					Preferencia p = lm.mapPrefs.get(tipo + "_" + n);
					// Preferencia p = lm.importar(Matrizes.getFileName(tipo,
					// n));

					if (isHabilitarLog)
						p.listarPrefs();

					int[][] prefH = p.getPrefHomens();
					int[][] prefM = p.getPrefMulheres();
					int[][] ranking = p.getRanking();

					// - - - - - - - - - - - - - - - - - - - - -
					// PROCESSAMENTO DO CASAMENTO ESTÁVEL
					// - - - - - - - - - - - - - - - - - - - - -

					CasamentoEstavel c = new CasamentoEstavel(isHabilitarLog);

					// descarto
					for (int i = 0; i < qtdExec; i++)
						c.processar(prefH, prefM, ranking);

					long estimatedTime = 0;
					long startTime = System.nanoTime();
					for (int i = 0; i < qtdExec; i++) {
						c.processar(prefH, prefM, ranking);
						estimatedTime += (System.nanoTime() - startTime);
					}

					estimatedTime = estimatedTime / qtdExec;

					System.out.print(estimatedTime + "; ");

				}
			}
		}
	}

}
