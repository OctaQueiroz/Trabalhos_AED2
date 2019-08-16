
public class Ciframento {
	public static String Codifica(String palavra){
		String codigo = "";
		char letra;
		int asc;
		for(int i = 0; i < palavra.length(); i++){
			letra = palavra.charAt(i);
			asc = (int)letra + 3;
			letra = (char)asc;
			codigo += letra;
		}
		return codigo;
	}
	public static void main  (String[]args){
		String palavra = MyIO.readLine();
		do{
			String resultado = new String(Codifica(palavra));
		  MyIO.println(""+resultado);
			palavra = MyIO.readLine();
	  }while(palavra.equals("FIM") == false);	
	}
}
