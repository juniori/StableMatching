package unirio.mestrado2020.apa.emparelhamentoEstavel;

import java.io.File;

public class Matrizes {

	// public static String BASE_PATH =
	// "C:\\Users\\junior\\workspace2\\emparelhamentoEstavel\\src\\resources\\entradas\\";

	public static String BEST_SM_5 = getBasePath() + "best\\best_sm_5.txt";
	public static String BEST_SM_50 = getBasePath() + "best\\best_sm_50.txt";
	public static String BEST_SM_100 = getBasePath() + "best\\best_sm_100.txt";
	public static String BEST_SM_200 = getBasePath() + "best\\best_sm_200.txt";
	public static String BEST_SM_300 = getBasePath() + "best\\best_sm_300.txt";
	public static String BEST_SM_400 = getBasePath() + "best\\best_sm_400.txt";
	public static String BEST_SM_500 = getBasePath() + "best\\best_sm_500.txt";
	public static String BEST_SM_600 = getBasePath() + "best\\best_sm_600.txt";
	public static String BEST_SM_700 = getBasePath() + "best\\best_sm_700.txt";
	public static String BEST_SM_800 = getBasePath() + "best\\best_sm_800.txt";
	public static String BEST_SM_900 = getBasePath() + "best\\best_sm_900.txt";
	public static String BEST_SM_1000 = getBasePath() + "best\\best_sm_1000.txt";

	public static String ALE_SM_5 = getBasePath() + "ale\\ale_sm_5.txt";
	public static String ALE_SM_50 = getBasePath() + "ale\\ale_sm_50.txt";
	public static String ALE_SM_100 = getBasePath() + "ale\\ale_sm_100.txt";
	public static String ALE_SM_200 = getBasePath() + "ale\\ale_sm_200.txt";
	public static String ALE_SM_300 = getBasePath() + "ale\\ale_sm_300.txt";
	public static String ALE_SM_400 = getBasePath() + "ale\\ale_sm_400.txt";
	public static String ALE_SM_500 = getBasePath() + "ale\\ale_sm_500.txt";
	public static String ALE_SM_600 = getBasePath() + "ale\\ale_sm_600.txt";
	public static String ALE_SM_700 = getBasePath() + "ale\\ale_sm_700.txt";
	public static String ALE_SM_800 = getBasePath() + "ale\\ale_sm_800.txt";
	public static String ALE_SM_900 = getBasePath() + "ale\\ale_sm_900.txt";
	public static String ALE_SM_1000 = getBasePath() + "ale\\ale_sm_1000.txt";

	public static String HARD_SM_5 = getBasePath() + "hard\\hard_sm_5.txt";
	public static String HARD_SM_50 = getBasePath() + "hard\\hard_sm_50.txt";
	public static String HARD_SM_100 = getBasePath() + "hard\\hard_sm_100.txt";
	public static String HARD_SM_200 = getBasePath() + "hard\\hard_sm_200.txt";
	public static String HARD_SM_300 = getBasePath() + "hard\\hard_sm_300.txt";
	public static String HARD_SM_400 = getBasePath() + "hard\\hard_sm_400.txt";
	public static String HARD_SM_500 = getBasePath() + "hard\\hard_sm_500.txt";
	public static String HARD_SM_600 = getBasePath() + "hard\\hard_sm_600.txt";
	public static String HARD_SM_700 = getBasePath() + "hard\\hard_sm_700.txt";
	public static String HARD_SM_800 = getBasePath() + "hard\\hard_sm_800.txt";
	public static String HARD_SM_900 = getBasePath() + "hard\\hard_sm_900.txt";
	public static String HARD_SM_1000 = getBasePath() + "hard\\hard_sm_1000.txt";

	public static String getFileName(String tipo, int n) {
		return getBasePath() + tipo + "\\" + tipo + "_sm_" + n + ".txt";
	}

	public static String getBasePath() {
		String BASE_PATH = "./src/resources/entradas/";
		File f = new File(BASE_PATH);
		if (!f.exists()) {
			BASE_PATH = "entradas/";
		}
		return BASE_PATH;
	}

}
