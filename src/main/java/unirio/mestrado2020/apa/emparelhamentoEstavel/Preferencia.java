package unirio.mestrado2020.apa.emparelhamentoEstavel;

public class Preferencia {

	private int prefHomens[][];
	private int prefMulheres[][];

	public int[][] getPrefHomens() {
		return prefHomens;
	}

	public void setPrefHomens(int[][] prefHomens) {
		this.prefHomens = prefHomens;
	}

	public int[][] getPrefMulheres() {
		return prefMulheres;
	}

	public void setPrefMulheres(int[][] prefMulheres) {
		this.prefMulheres = prefMulheres;
	}

	public int[][] getRanking() {

		int N = prefHomens.length;
		int[][] ranking = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int preferida = prefHomens[i][j];
				ranking[preferida][prefMulheres[preferida][i]] = i;
			}
		}

		// for (int i = 0; i < N; i++) {
		// ranking[preferida][mulheresPrefs[preferida][i]] = i;
		// }

		return ranking;

	}

}
