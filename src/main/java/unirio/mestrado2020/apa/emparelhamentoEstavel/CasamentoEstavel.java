package unirio.mestrado2020.apa.emparelhamentoEstavel;

public class CasamentoEstavel {

	public CasamentoEstavel() {

	}

	public int processar(int[][] homensPrefs, int[][] mulheresPrefs, int[][] ranking, boolean isDebug) {

		int N = homensPrefs.length;
		int[] ultimaMulherProposta = new int[N];
		int[] parceiroAtual = new int[N];
		Lista solteiros = new Lista();
		int qtdInteracoes = 0;

		// Inicializo todos os homens como solteiros
		for (int i = N - 1; i >= 0; i--) {
			solteiros.inserirInicio(i);
			ultimaMulherProposta[i] = 0;
			parceiroAtual[i] = -1;
		}

		// Enquanto existir homem solteiro que não se propôs à toda mulher
		int solteiro;
		while ((solteiro = solteiros.getPrimeiro()) != -1 && ultimaMulherProposta[solteiro] < N) {

			int proponente = solteiro;

			int preferidaIndice = ultimaMulherProposta[solteiro]++;

			int preferida = homensPrefs[solteiro][preferidaIndice];

			if (parceiroAtual[preferida] == -1) {
				parceiroAtual[preferida] = proponente;
				printCasal(++qtdInteracoes, preferida, proponente, isDebug);
				solteiros.retirarInicio();
			} else {

				int pAtual = parceiroAtual[preferida];

				// Se a mulher prefere seu proponente ao seu atual em O(1)
				if (ranking[preferida][pAtual] < ranking[preferida][proponente]) {
					printCasal(++qtdInteracoes, -1, proponente, isDebug);
				} else {

					// Remove da lista de solteiros o homem que props
					solteiros.retirarInicio();

					// Retorna com o parceiro atual para lista de solteiros
					solteiros.inserirInicio(pAtual);

					parceiroAtual[preferida] = proponente;

					printCasal(++qtdInteracoes, preferida, proponente, isDebug);
				}

			}

		}

		return qtdInteracoes;

	}

	private void printCasal(int interacao, int w, int m, boolean isDebug) {

		if (!isDebug)
			return;

		if (w == -1)
			System.out.println(interacao + " - m:" + m);
		else
			System.out.println(interacao + " - m:" + m + " w:" + w);

	}

}
