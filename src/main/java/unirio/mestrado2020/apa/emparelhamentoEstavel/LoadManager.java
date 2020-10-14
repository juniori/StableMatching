package unirio.mestrado2020.apa.emparelhamentoEstavel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoadManager {

	private int matrizSize = 0;
	private int mansPrefsStartLine = 0;
	private int mansPrefsEndLine = 0;
	private int womesPrefsStartLine = 0;
	private int womesPrefsEndLine = 0;
	Boolean isLogHabilitado = false;
	public Map<String, Preferencia> mapPrefs = new HashMap<String, Preferencia>();
	public static int[] tamanhos = { 5, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };
	public static String[] tipos = { "best", "ale", "hard" };

	public LoadManager() {
		super();
	}

	private void carregarArquivo(String filename) throws IOException {

		File file = new File(filename);

		BufferedReader br = new BufferedReader(new FileReader(file));

		// -----------------------------------
		// Identificando o tamanho da matriz
		// -----------------------------------
		int matrizSize = 0;
		String line;
		while ((line = br.readLine()) != null) {
			if (line.startsWith("N")) {
				matrizSize = Integer.valueOf(line.replaceAll("\\D+", ""));
				break;
			}
		}
		br.close();
		this.matrizSize = matrizSize;

		// -----------------------------------
		// Linhas de início e termino das preferencias dos homens
		// -----------------------------------
		this.mansPrefsStartLine = 4; // Constante
		this.mansPrefsEndLine = this.matrizSize + mansPrefsStartLine - 1;

		// -----------------------------------
		// Linhas de início e termino das preferencias das mulheres
		// -----------------------------------
		this.womesPrefsStartLine = this.mansPrefsEndLine + 2;
		this.womesPrefsEndLine = this.matrizSize + this.womesPrefsStartLine - 1;

		this.log("File name: " + file.getAbsolutePath());
		this.log("N \t" + this.getMatrizSize());
		// this.log("mansPrefsStartLine: " + this.getMensPrefsStartLine() + " -
		// " + this.getMensPrefsEndLine());
		// this.log("womesPrefsStartLine: " + this.getWomesPrefsStartLine() + "
		// - " + this.getWomesPrefsEndLine());

	}

	public Preferencia importar(String fileName) throws IOException {
		this.carregarArquivo(fileName);
		Preferencia p = new Preferencia();
		p.setPrefHomens(importarMatrizPref(fileName, SexoEnum.HOMEM));
		p.setPrefMulheres(importarMatrizPref(fileName, SexoEnum.MULHER));
		return p;
	}

	public Preferencia importarTodos() throws IOException {

		Preferencia p = new Preferencia();

		for (String tipo : tipos) {
			for (int n : LoadManager.tamanhos) {
				mapPrefs.put(tipo + "_" + n, importar(Matrizes.getFileName(tipo, n)));
			}
		}

		return p;
	}

	private void log(String str) {

		if (this.isLogHabilitado) {
			// System.out.println(str);
		}
	}

	public int[][] importarMatrizPref(String fileName, SexoEnum sexo) throws IOException {

		int startLine, endLine;

		if (sexo == SexoEnum.HOMEM) {
			startLine = this.mansPrefsStartLine;
			endLine = this.mansPrefsEndLine;
		} else {
			startLine = this.womesPrefsStartLine;
			endLine = this.womesPrefsEndLine;
		}

		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));

		int preferenciasPorPessoa[][] = new int[this.matrizSize][this.matrizSize];

		int indexPessoa = 0;

		for (int i = 1; i <= endLine; i++) {

			String line = br.readLine();

			if (i >= startLine) {

				String preferencias[] = line.trim().replaceAll("\\s+", ",").split(",");

				int prefs[] = new int[this.matrizSize];
				for (int j = 0; j < preferencias.length; j++) {
					prefs[j] = Integer.valueOf(preferencias[j]);
				}

				preferenciasPorPessoa[indexPessoa++] = prefs;

			}

		}

		br.close();

		return preferenciasPorPessoa;
	}

	public void listarMatrizPref(int[][] matrizPref, String titulo) {

		if (!this.isLogHabilitado)
			return;

		System.out.println(titulo);

		for (int i = 0; i < matrizPref.length; i++) {

			String str = "";
			for (int j = 0; j < matrizPref.length; j++) {
				str = str + matrizPref[i][j] + ((j != matrizPref.length - 1) ? ", " : "");
			}
			System.out.println(str);
		}

	}

	public int getMatrizSize() {
		return matrizSize;
	}

	public void setMatrizSize(int matrizSize) {
		this.matrizSize = matrizSize;
	}

	public int getMensPrefsStartLine() {
		return mansPrefsStartLine;
	}

	public void setMensPrefsStartLine(int mansPrefsStartLine) {
		this.mansPrefsStartLine = mansPrefsStartLine;
	}

	public int getMensPrefsEndLine() {
		return mansPrefsEndLine;
	}

	public void setMensPrefsEndLine(int mansPrefsEndLine) {
		this.mansPrefsEndLine = mansPrefsEndLine;
	}

	public int getWomesPrefsStartLine() {
		return womesPrefsStartLine;
	}

	public void setWomesPrefsStartLine(int womesPrefsStartLine) {
		this.womesPrefsStartLine = womesPrefsStartLine;
	}

	public int getWomesPrefsEndLine() {
		return womesPrefsEndLine;
	}

	public void setWomesPrefsEndLine(int womesPrefsEndLine) {
		this.womesPrefsEndLine = womesPrefsEndLine;
	}

}
