
public class Palindromo {
	public static boolean Compara(String original){
		String invertida = "";
		for(int i = original.length(); i > 0 ; i--){ //criando uma cópia invertida da string
			invertida += original.charAt(i-1);
		}
		if(invertida.equals(original))
			return true;
		else
			return false;
	}
	public static void main  (String[]args){
		String palavra = MyIO.readLine();
		do{
		boolean x = Compara(palavra);
		if(x == true)
			MyIO.println("SIM");
		else
			MyIO.println("NAO");
	  palavra = MyIO.readLine();
		}while(palavra.equals("FIM") == false);
	}
}
