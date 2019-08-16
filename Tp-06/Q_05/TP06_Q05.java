class TP06_Q05{
	public static void main(String[] args){
		String entrada = MyIO.readLine();
		String[] line;
		int linhas, colunas;
		int[][] matrizAux;
		//Criando a lista de matrizes que serao utilizadas 
		int contAux = 2*Integer.valueOf(entrada);//2 matrizes por operacao
		MatrizDinamica[] auxiliar = new MatrizDinamica[contAux];
		for(int cont = 0; cont < contAux; cont++){ 
			//Pegando as dimensoes da matriz
	        entrada = MyIO.readLine();
	        linhas = Integer.valueOf(entrada);
	        entrada = MyIO.readLine();
	        colunas = Integer.valueOf(entrada);

	        matrizAux = new int[linhas][colunas];

	        //Preenchendo uma matriz auxiliar com os numeros da matriz estatica da entrada
	        for(int i = 0; i < linhas; i++){
	        	entrada = MyIO.readLine();
	        	line = entrada.split(" ");
	        	for(int j = 0; j < colunas; j++){
	        		matrizAux[i][j] = Integer.valueOf(line[j]);  
	        	}
	        }
	        //Preenchendo uma matriz dinamica com ass posicoes da matriz auxiliar pŕeviamente preenchida
	        MatrizDinamica matriz = new MatrizDinamica(linhas, colunas);
			matriz.preencher(matrizAux);
			auxiliar[cont] = matriz;
		}
		MatrizDinamica respSoma;
		MatrizDinamica respMult;
		//Organiza a saida 
		for(int i = 0; i < contAux; i++){
			if(i%2 == 0 ){
				auxiliar[i].mostrarDiagonalPrincipal();
				auxiliar[i].mostrarDiagonalSecundaria();
				respSoma = auxiliar[i].soma(auxiliar[i+1]);
				respSoma.imprimirMatriz();
				respMult = auxiliar[i].multiplicacao(auxiliar[i+1]);
				respMult.imprimirMatriz();
			}
			respSoma = respMult = null;
		}
	}
}

class Celula{
	public Celula sup;
	public Celula inf;
	public Celula esq;
	public Celula dir;
	public int elemento;

	Celula(){
		this.sup = null;
		this.inf = null;
		this.esq = null;
		this.dir = null;
		this.elemento = 0;
	}
}

class MatrizDinamica{
	public int linha;
	public int coluna;
	public Celula inicio;

	//Cria a matriz com celulas vazias
	MatrizDinamica(int i, int j){
		linha = i;
		coluna = j;
		inicio = new Celula();
		Celula tmp = inicio;
		for(int line = 0; line < i; line++){
			for(int collumn = 0; collumn < j; collumn++){
				if(line == 0){//Cria a primeira linha toda
					tmp.dir = new Celula();
					tmp.dir.esq = tmp;
					tmp = tmp.dir;
				}
				else if(line > 0 && collumn == 0){//Serve para criar a primeira unidade de uma nova linha
					tmp.inf = new Celula();
					tmp.inf.sup = tmp;
	                if(tmp.dir != null){
	                    tmp = tmp.dir;
	                }
	                else{
	                    MyIO.println("ERRO AO INSERIR NA PRIMEIRA COLUNA");
	                }
				}
				else if(line > 0 && collumn > 0){//Cria as novas linhas a partir da primeira unidade criada acima
					tmp.inf = new Celula();
					tmp.inf.sup = tmp;
					tmp.inf.esq = tmp.esq.inf;
					tmp.esq.inf.dir = tmp.inf;
					if(tmp.dir != null){
                  		tmp = tmp.dir;
               		}
				}
			}
			while(tmp.esq != null){
				tmp = tmp.esq;
			}
	        if(linha > 0){
				if(tmp.inf != null){
				   	tmp = tmp.inf;
				}
	        }
		}
	}
	//Imprime os valores de cada celula da matriz
	public void imprimirMatriz(){
		Celula tmp = inicio;

		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				MyIO.print(tmp.elemento+" ");
				if(tmp.dir != null){ 
					tmp = tmp.dir;
				}	 
			}
			MyIO.print("\n");
			while(tmp.esq != null){
				tmp = tmp.esq;
			}
			if(tmp.inf != null){
				tmp = tmp.inf;
			}
		}
	}
	//Preenche a matriz alocada com valores de uma matriz auxiliar
	public void preencher(int[][] base){
		Celula tmp = inicio;

		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				tmp.elemento = base[i][j];

				if(tmp.dir != null){ 
					tmp = tmp.dir;
				}	 
			}
			while(tmp.esq != null){
				tmp = tmp.esq;
			}
			if(tmp.inf != null){
				tmp = tmp.inf;
			}
		}
	}
	//mostra na tela a diagonal principal da matriz
	public void mostrarDiagonalPrincipal(){

		Celula tmp = inicio;
		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				//Como a diagonal principal é composta pelos valores localizados em [i][j] quando i = j
				if(i==j){
					MyIO.print(tmp.elemento+" ");
				}
			
				if(tmp.dir != null){ 
					tmp = tmp.dir;
				}	 
			}
			while(tmp.esq != null){
				tmp = tmp.esq;
			}
			if(tmp.inf != null){
				tmp = tmp.inf;
			}
		}
		MyIO.println(" ");
	}
	//mostra na tela a diagonal secundaria da matriz
	public void mostrarDiagonalSecundaria(){
		Celula tmp = inicio;
		int aux = coluna -1;//Como a matriz é quadrada, tanto seu numero de linhas quanto de colunas representam suasdimensões laterais
		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				//Levando em conta a relacao de numeros que compoem a diagonal secundaria como [i][j] quando i + j = dimensao - 1
				if(i + j == aux){
					MyIO.print(tmp.elemento+" ");
				}
			
				if(tmp.dir != null){ 
					tmp = tmp.dir;
				}	 
			}
			while(tmp.esq != null){
				tmp = tmp.esq;
			}
			if(tmp.inf != null){
				tmp = tmp.inf;
			}
		}
		MyIO.println(" ");
	}
	//realiza a soma das matrizes e retorna  a matriz resultado
	public MatrizDinamica soma(MatrizDinamica mat){

		MatrizDinamica resp = new MatrizDinamica (linha, coluna);
		Celula tmpResp = resp.inicio;
		Celula tmp = inicio;
		Celula tmpMat = mat.inicio;

		for(int i = 0; i < linha; i++){
			for(int j = 0; j < coluna; j++){
				tmpResp.elemento = tmp.elemento + tmpMat.elemento;

				if(tmp.dir != null && tmpMat.dir != null && tmpResp.dir != null){ 
					tmp = tmp.dir;
					tmpMat = tmpMat.dir;
					tmpResp = tmpResp.dir;
				}	 
			}
			while(tmp.esq != null && tmpMat.esq != null && tmpResp.esq != null){
				tmp = tmp.esq;
				tmpMat = tmpMat.esq;
				tmpResp = tmpResp.esq;
			}
			if(tmp.inf != null && tmpMat.inf != null && tmpResp.inf != null){
				tmp = tmp.inf;
				tmpMat = tmpMat.inf;
				tmpResp = tmpResp.inf;
			}
		}
		return resp;
	}
	//realiza a multiplicacao das matrizes e retorna a matriz resultado
	public MatrizDinamica multiplicacao(MatrizDinamica mat){
	/*
	Para realizar a multiplicacao, foi utilizado este formato:

		for (i=0;i < tam; i++) {
			for (j=0; j < tam; j++) {
			   	for (k=0; k < tam; k++) {
			        r[i][j] = r[i][j] + (a[i][k] * b[k][j]); 
			   	}
		  	}
	    }
	*/
	    MatrizDinamica resp = new MatrizDinamica (linha, coluna);
		Celula tmpResp = resp.inicio;
		Celula tmp = inicio;
		Celula tmpMat = mat.inicio;
		
		for(int i = 0; i < coluna; i++){
			for(int j = 0; j < coluna; j++){
				for(int k = 0; k < coluna; k++){ 
					tmpResp.elemento = tmpResp.elemento + (tmpMat.elemento * tmp.elemento);

					if(tmp.dir != null){// a[i][k+1] 
						tmp = tmp.dir;
					}
					if(tmpMat.inf != null){// b[k+1][j]
						tmpMat = tmpMat.inf;
					}
				}
				//voltando as linhas e colunas representadas por k para 0
				while(tmp.esq != null){// a[i][0]
					tmp = tmp.esq;
				}
				while(tmpMat.sup != null){// b[0][j+1]
					tmpMat = tmpMat.sup;
				}
				//avancando com as colunas representadas pelo j
				if(tmpResp.dir != null){// r[i][j+1]
					tmpResp = tmpResp.dir;
				}
				if(tmpMat.dir != null){// b[k][j+1]
					tmpMat = tmpMat.dir;
				}	 
			}
			
			//voltando com as colunas representadas por j
			while(tmpResp.esq != null){// r[i+1][0]
				tmpResp = tmpResp.esq;
			}
			while(tmpMat.esq != null){// b[k][0]
				tmpMat = tmpMat.esq;
			}
			//avancando com as linhas representadas por i
			if(tmpResp.inf != null){// r[i+1][j] 
				tmpResp = tmpResp.inf;
			}
			if(tmp.inf != null){// a[i+1][k]
				tmp = tmp.inf;
			}
		}
		return resp;
	}
}