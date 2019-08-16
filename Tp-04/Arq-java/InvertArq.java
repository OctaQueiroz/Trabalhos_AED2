import java.io.*;

class InvertArq{
	public static void main(String[]args){
		try{
         int n = MyIO.readInt();
        	RandomAccessFile raf = new RandomAccessFile("entradas.txt", "rw");
			double linha;
			for(int i = 0; i < n; i++){//le todas as entradas no formato double e insere no arquivo
				linha = MyIO.readDouble();
				raf.writeDouble(linha);
			}
			long inicioInvert = raf.getFilePointer() - 8;//pega o ponteiro que esta no fim do aruivo e subtrai dele 8 bytes 
			raf.close();//que e o equivalente ao double ja que no rafl e escrito em bytes

			RandomAccessFile inverte = new RandomAccessFile("entradas.txt", "r");	
	
			for(int i = 0; i < n; i++){
				inverte.seek(inicioInvert);//aponta para o inicio da ultima linha do arquivo
				linha = inverte.readDouble();
				if(linha == (int)linha){//se a linha for igual a linha convertida em inteiro, printa o inteiro, senao, printa a linha
					MyIO.println((int)linha);
				}else{
					MyIO.println(linha);
				}
				inicioInvert = inicioInvert - 8;//sobe uma linha no arquivo
			}
			inverte.close();
		}
		catch(IOException erro){
			erro.printStackTrace();
		}
	}
}