package unirio.mestrado2020.apa.emparelhamentoEstavel;

import java.util.ArrayList;
import java.util.List;

/*
 * Video mostrando o chines

https://www.sanfoundry.com/java-program-gale-shapley-algorithm/#:~:text=Gale%20Shapley%20Algorithm%20is%20used,of%20preferences%20for%20each%20element.&text=Here%20is%20the%20source%20code,to%20Implement%20Gale%20Shapley%20Algorithm
https://www.youtube.com/watch?v=0m_YW1zVs-Q&t=3s

Inicializar cada pessoa como livre

enquanto(existir homem solteiro que não se propôs à toda mulher){
	m = selecionar um homem
	w = 1ª  mulher na lista que ele ainda não propos
	if (w is free){
		noiva m e w
	}else if (w prefere m ao seu parceiro atual){
		noiva m e w e seta o parceiro para livre
	}else{
		w rejeita m
	}
}

Ranking slide 84 da 2º aula: https://moodleccet.uniriotec.br/pluginfile.php/18650/mod_resource/content/6/AA-02-Analise.pdf


*/
public class CasamentoEstavel {

	private List<String> casais = new ArrayList<String>();
	Boolean isLogHabilitado = false;

	public CasamentoEstavel(Boolean isHabilitarLog) {
		this.isLogHabilitado = isHabilitarLog;
	}

	public void processar(int[][] homensPrefs, int[][] mulheresPrefs, int[][] ranking) {

		int N = homensPrefs.length;
		int[] ultimaMulherProposta = new int[N];
		int[] parceiroAtual = new int[N];
		Lista solteiros = new Lista();

		// Inicializo todos os homens como solteiros
		for (int i = N -1; i > 0; i--) {
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
				addCasal(preferida, proponente);
				solteiros.retirarInicio();
			} else {

				int pAtual = parceiroAtual[preferida];

				// Verifica se a mulher prefere seu proponente ao seu atual
				boolean isPrefereAtual = (ranking[preferida][pAtual] < ranking[preferida][proponente]) ? true : false;

				if (isPrefereAtual) {
					addCasal(-1, proponente);
				} else {
					solteiros.retirarInicio();
					solteiros.inserirInicio(pAtual);
					parceiroAtual[preferida] = proponente;
					addCasal(preferida, proponente);
				}

			}

		}

		printRanking(ranking);
		printCasais();

	}

	private void addCasal(int w, int m) {

		if (!this.isLogHabilitado)
			return;

		if (w == -1) {
			casais.add("m:" + m);
		} else {
			casais.add("m:" + m + " w:" + w);
		}

	}

	private void printCasais() {

		if (!this.isLogHabilitado)
			return;

		System.out.println("RESULTADO");

		for (int i = 0; i < casais.size(); i++) {
			System.out.println(i + 1 + " - " + casais.get(i));
		}
	}

	public void printRanking(int[][] ranking) {

		if (!this.isLogHabilitado)
			return;

		System.out.println("RANKING");

		for (int i = 0; i < ranking.length; i++) {

			String str = "";
			for (int j = 0; j < ranking.length; j++) {
				str = str + ranking[i][j] + ((j != ranking.length - 1) ? ", " : "");
			}
			System.out.println(str);
		}

	}

}
