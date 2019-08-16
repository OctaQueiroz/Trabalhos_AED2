import java.io.*;

public class Is{
   public static boolean Vogais(String palavra){
      for(int i = original.length(); i > 0 ; i--){ //checando se todas as letras da string são vogais
         if((palavra.charAt[i]!='a')&&(palavra.charAt[i]!='e')&&(palavra.charAt[i]!='i')&&(palavra.charAt[i]!='o')&&(palavra.charAt[i]!='u')){
            return false;
         }
      }
      return true;
   }
   public static boolean Consoantes(String palavra){
      for(int i = original.length(); i > 0 ; i--){ //checando se todas as letras da string são consoantes
         if((palavra.charAt[i]=='a')||(palavra.charAt[i]=='e')||(palavra.charAt[i]=='i')||(palavra.charAt[i]=='o')||(palavra.charAt[i]=='u')){
            return false;
         }
      }
      return true;
   }
   public static boolean Vogais(String palavra){
      for(int i = original.length(); i > 0 ; i--){ //checando se todas as letras da string são vogais
         if((palavra.charAt[i]!='1')&&(palavra.charAt[i]!='2')&&(palavra.charAt[i]!='3')&&(palavra.charAt[i]!='4')&&(palavra.charAt[i]!='5')&&(palavra.charAt[i]!='6')&&(palavra.charAt[i]!='7')&&(palavra.charAt[i]!='8')&&(palavra.charAt[i]!='9')&&(palavra.charAt[i]!='0')){
            return false;
         }
      }
      return true;
   }
   public static void main  (String[]args){
      Arq.openRead("Teste.txt");
      String palavra = Arq.readString();
      boolean x = Compara(palavra);
      if(x == true)
         System.out.println("Sim");
      else
         System.out.println("Não");
   
   }
}
