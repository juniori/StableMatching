package unirio.mestrado2020.apa.emparelhamentoEstavel;

import java.io.IOException;

/**
 * Comentar ...
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {

		// - - - - - - - - - - - - - - - - - - - - -
		// CARREGAMENTO DOS DADOS
		// - - - - - - - - - - - - - - - - - - - - -
		LoadManager lm = new LoadManager(Matrizes.HARD_SM_5, true);
		int prefH[][] = lm.importarMatrizPref(SexoEnum.HOMEM);
		int prefM[][] = lm.importarMatrizPref(SexoEnum.MULHER);
		int homens[] = lm.obterHomensUnicos(prefM);
		int mulheres[] = lm.obterMulheresUnicos(prefH);
		lm.listarMatrizPref(prefH, "MEN'S PREFERENCES");
		lm.listarMatrizPref(prefM, "WOMEN'S PREFERENCES");

		// - - - - - - - - - - - - - - - - - - - - -
		// PROCESSAMENTO DO CASAMENTO ESTÁVEL
		// - - - - - - - - - - - - - - - - - - - - -
		CasamentoEstavel c = new CasamentoEstavel(true);
		long startTime = System.nanoTime();
		c.processar(homens, mulheres, prefH, prefM);
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println("Tempo de execucao: " + estimatedTime + " milissegundos");

	}

}
