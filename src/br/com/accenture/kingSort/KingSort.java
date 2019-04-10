package br.com.accenture.kingSort;
public class KingSort {
	
	/*metodo principal */
	public static void main(String [] args){
		String [] kings = {"Louis I", "Philippe VI", "Charles X", "Jean II", "Charles XV", "Charles VII", "Charles VII", "Louis XI"};
		printKingsNames(getSortedList( kings ));
	}
	
	/*metodo de ordenacao */
	public static String[] getSortedList(String[] kings){
	   String temp;
	   for (int i = 1; i < kings.length; i++) {
			for (int j = i; j > 0; j--) {
				 if (compare(kings[j], kings[j - 1]) < 0) {
				      temp = kings[j];
				      kings[j] = kings[j - 1];
				      kings[j - 1] = temp;
				 }
			}
	   }
	   return kings;
	}
	
	/*Compara os dois nomes, caso sejam iguais o método que compara os números romanos é chamado*/
	public static int compare(String king1, String king2){
		String[] arrayName1 = king1.split(" ");
		String nameKing1 = arrayName1[0];
		String romanNumber1 = arrayName1[1];
		
		String[] arrayName2 = king2.split(" ");
		String nameKing2 = arrayName2[0];
		String romanNumber2 = arrayName2[1];
		
		if( nameKing1.compareTo(nameKing2) < 0){
			return -1;
		}else if(nameKing1.compareTo(nameKing2) > 0)	{
			return 1;
		}else{
			return compareRomanNumber(romanNumber1, romanNumber2);
		}
	}
	
	/*Compara dois números romanos retornando 1 caso o primeiro seja maior,
	 * -1 caso se menor e 0 caso sejam iguais */
	public static int compareRomanNumber(String number1, String number2){
		if(romanToDecimal(number1) > romanToDecimal(number2)){
			return 1;
		}else if(romanToDecimal(number1) < romanToDecimal(number2)){
			return -1;
		}else{
			return 0;
		}
	}
	
	/*transforma um numero romano simples em um numero decimal*/
	public static int getSimpleNumber(char simpleNumber){
		switch(simpleNumber){
			case 'M':
				return 1000;
			case 'D':
				return 500;
			case 'C':
				return 100;
			case 'L':
				return 50;
			case 'X':
				return 10;
			case 'V':
				return 5;
			case 'I': 
				return 1;
			default:
				return 0;
		} 
	}
	
	/*Transforma um numero romano em um numero decimal*/
	public static int romanToDecimal(String romanNumeral ){
		int result = 0;
		
		//percorre todos os caracteres que formam o numero romano
		for(int i = 0;i < romanNumeral.length() ;i++) {
			
			//caso seja o ultimo caracter retorna seu valor simples
			if( i == romanNumeral.length() -1 ){
				result += getSimpleNumber(romanNumeral.charAt(i));
			}else{	
				if (getSimpleNumber(romanNumeral.charAt(i)) < getSimpleNumber(romanNumeral.charAt(i+1))) {
					//se o caracter representa um valor menor que seu sucessor entao esse valor deve ser subtraido do somatorio
					result -= getSimpleNumber(romanNumeral.charAt(i));
				} else { 
					//caso contrario o valor e somado
					result += getSimpleNumber(romanNumeral.charAt(i));
				}
			}	
		}
		return result;
	}
	
	
	/*exibe a lista de reis*/
	public static void printKingsNames(String[] kings){
		for(String kingName : kings){
			System.out.println(kingName);
		}
	}

}
