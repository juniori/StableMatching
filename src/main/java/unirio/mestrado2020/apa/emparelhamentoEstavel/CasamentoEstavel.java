package unirio.mestrado2020.apa.emparelhamentoEstavel;

import java.util.concurrent.TimeUnit;

public class CasamentoEstavel {

	public CasamentoEstavel() {

	}

	public int processarGaleShapley(int[][] homensPrefs, int[][] mulheresPrefs, int[][] ranking, boolean isDebug) {
		
		int N = homensPrefs.length;
		int[] indiceUltimaMulherProposta = new int[N];
		int[] parceiroAtual = new int[N];
		Lista solteiros = new Lista();
		int qtdInteracoes = 0;

		// Inicializa todos os homens como solteiros e sem proposta feita e as
		// mulheres sem nenhum parceiro.
		for (int i = N - 1; i >= 0; i--) {
			solteiros.inserirInicio(i);
			indiceUltimaMulherProposta[i] = 0;
			parceiroAtual[i] = -1;
		}

		// Enquanto existir homem solteiro
		int solteiro;
		while ((solteiro = solteiros.getPrimeiro()) != -1) {

			int proponente = solteiro;

			int preferidaIndice = indiceUltimaMulherProposta[solteiro]++;

			int preferida = homensPrefs[solteiro][preferidaIndice];

			// Se a mulher ainda não tem nenhum parceiro
			if (parceiroAtual[preferida] == -1) {
				parceiroAtual[preferida] = proponente;
				solteiros.retirarInicio();
				imprimirCasal(++qtdInteracoes, proponente, preferida, isDebug);
			} else {
				int pAtual = parceiroAtual[preferida];
				// Se a mulher prefere seu proponente ao seu atual em O(1)
				if (ranking[preferida][pAtual] < ranking[preferida][proponente]) {
					imprimirCasal(++qtdInteracoes, proponente, -1, isDebug);
				} else {
					solteiros.retirarInicio();
					solteiros.inserirInicio(pAtual);
					parceiroAtual[preferida] = proponente;
					imprimirCasal(++qtdInteracoes, proponente, preferida, isDebug);
				}
			}
		}
		return qtdInteracoes;
	}

	private void imprimirCasal(int interacao, int man, int woman, boolean isDebug) {
		if (!isDebug)
			return;
		if (woman == -1)
			System.out.println(interacao + " - m:" + man);
		else
			System.out.println(interacao + " - m:" + man + " w:" + woman);

	}

}
