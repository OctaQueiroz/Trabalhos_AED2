
public class Aquecimento {
	public static int Maiusculos(String palavra){
    int cont=0, letra;
		for(int i = 0; i < palavra.length(); i++){//correndo a string para contar os maiúsculos
      letra = palavra.charAt(i);
      if(letra >= 65 && letra <= 90){//Conferindo se é maiúsculo pela tabela ASCII
        cont++;
      }
		}
    return cont;
	}
	public static void main  (String[]args){
		String palavra = MyIO.readLine();
		do{
		  int x = Maiusculos(palavra);
	    MyIO.println(""+x);
	    palavra = MyIO.readLine();
	}while(palavra.equals("FIM") == false);
	}
}
