package unirio.mestrado2020.apa.emparelhamentoEstavel;

public class Matrizes {

	
	
	public static String BASE_PATH    = "C:\\Users\\junior\\workspace2\\emparelhamentoEstavel\\src\\resources\\entradas\\"; 
	
	public static String BEST_SM_5    = BASE_PATH +"best\\best_sm_5.txt"; 
	public static String BEST_SM_50   = BASE_PATH +"best\\best_sm_50.txt";
	public static String BEST_SM_100  = BASE_PATH +"best\\best_sm_100.txt";
	public static String BEST_SM_200  = BASE_PATH +"best\\best_sm_200.txt";
	public static String BEST_SM_300  = BASE_PATH +"best\\best_sm_300.txt";
	public static String BEST_SM_400  = BASE_PATH +"best\\best_sm_400.txt";
	public static String BEST_SM_500  = BASE_PATH +"best\\best_sm_500.txt";
	public static String BEST_SM_600  = BASE_PATH +"best\\best_sm_600.txt";
	public static String BEST_SM_700  = BASE_PATH +"best\\best_sm_700.txt";
	public static String BEST_SM_800  = BASE_PATH +"best\\best_sm_800.txt";
	public static String BEST_SM_900  = BASE_PATH +"best\\best_sm_900.txt";
	public static String BEST_SM_1000 = BASE_PATH +"best\\best_sm_1000.txt";
	
	public static String ALE_SM_5    = BASE_PATH +"ale\\ale_sm_5.txt";
	public static String ALE_SM_50   = BASE_PATH +"ale\\ale_sm_50.txt";
	public static String ALE_SM_100  = BASE_PATH +"ale\\ale_sm_100.txt";
	public static String ALE_SM_200  = BASE_PATH +"ale\\ale_sm_200.txt";
	public static String ALE_SM_300  = BASE_PATH +"ale\\ale_sm_300.txt";
	public static String ALE_SM_400  = BASE_PATH +"ale\\ale_sm_400.txt";
	public static String ALE_SM_500  = BASE_PATH +"ale\\ale_sm_500.txt";
	public static String ALE_SM_600  = BASE_PATH +"ale\\ale_sm_600.txt";
	public static String ALE_SM_700  = BASE_PATH +"ale\\ale_sm_700.txt";
	public static String ALE_SM_800  = BASE_PATH +"ale\\ale_sm_800.txt";
	public static String ALE_SM_900  = BASE_PATH +"ale\\ale_sm_900.txt";
	public static String ALE_SM_1000 = BASE_PATH +"ale\\ale_sm_1000.txt";	
	
	public static String HARD_SM_5    = BASE_PATH +"hard\\hard_sm_5.txt";
	public static String HARD_SM_50   = BASE_PATH +"hard\\hard_sm_50.txt";
	public static String HARD_SM_100  = BASE_PATH +"hard\\hard_sm_100.txt";
	public static String HARD_SM_200  = BASE_PATH +"hard\\hard_sm_200.txt";
	public static String HARD_SM_300  = BASE_PATH +"hard\\hard_sm_300.txt";
	public static String HARD_SM_400  = BASE_PATH +"hard\\hard_sm_400.txt";
	public static String HARD_SM_500  = BASE_PATH +"hard\\hard_sm_500.txt";
	public static String HARD_SM_600  = BASE_PATH +"hard\\hard_sm_600.txt";
	public static String HARD_SM_700  = BASE_PATH +"hard\\hard_sm_700.txt";
	public static String HARD_SM_800  = BASE_PATH +"hard\\hard_sm_800.txt";
	public static String HARD_SM_900  = BASE_PATH +"hard\\hard_sm_900.txt";
	public static String HARD_SM_1000 = BASE_PATH +"hard\\hard_sm_1000.txt";	
	
	
	public static String getFileName(String tipo, int n){
		return BASE_PATH +tipo +"\\"+tipo+"_sm_"+n+".txt";
	}
	
	
	public static void main(String[] args) {
		long nn = 10;
		System.out.println(nn/3);
	}
}
