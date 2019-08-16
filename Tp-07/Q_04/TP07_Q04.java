import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class TP07_Q04{

    public static void main (String[]args)throws Exception{
        MyIO.setCharset("ISO-8859-1");
    	double tempo = System.currentTimeMillis();
        String linha;
        String[] entrada;
        int cont;
        No resp; //Para receber o resultado das remocoes
        Municipio novo = new Municipio(); 

        linha = MyIO.readLine();

        //pegando os municipios que serao inseridos inicialmente na arvore
        Alvinegra arvore = new Alvinegra();

        do{
            novo.ler(novo, Integer.valueOf(linha));
            arvore.inserir(novo);
            linha = MyIO.readLine();
        }while(linha.equals("0") == false); 

        //arvore.mostrarCentral();
        //tratando as operacoes na arvore-------------------------------------------- 
        cont = Integer.valueOf(MyIO.readLine());

        for(int i = 0; i <= cont; i ++){
            linha = MyIO.readLine();
            entrada = linha.split(" ");
            if(entrada[0].equals("I")){
                novo.ler(novo, Integer.valueOf(entrada[1]));
                arvore.inserir(novo);
            }
            /*
            else if(entrada[0].equals("R")){
                arvore.remover(Integer.valueOf(entrada[1]));
            }
            */
        }
        boolean pesq;
        do{
            pesq = arvore.pesquisar(Integer.valueOf(linha));
            if(pesq){
            	MyIO.print("SIM");
            }
            else{
            	MyIO.print("NAO");
            }
            MyIO.println(" ");
            linha = MyIO.readLine();
        }while(linha.equals("FIM") == false); 

        double tempo2 = System.currentTimeMillis();
    	tempo = tempo2 - tempo;

        Arq.openWrite("529934_Alvinegra.txt");
    	Arq.print("529934\t"+arvore.comparacoes+"\t"+tempo);
    	Arq.close();
        //arvore.mostrarCentral();
    }
}

class Municipio{
    public  int ID;
    public  int CodigoUF;
    public  int Populacao;
    public  int NumeroFuncionarios;
    public  int NumeroComissionarios;
    public  int AtualizacaoPlano;
    public  int AtualizacaoCadastro;
    public  String Escolaridade;
    public  String Estagio;
    public  String Regiao;
    public  String Consorcio;
    public  String UF;
    public  String Nome;

    public Municipio(){
        this.ID = 0;
        this.Nome = "";
        this.UF = "";
        this.CodigoUF = 0;
        this.Populacao = 0;
        this.NumeroFuncionarios = 0;
        this.NumeroComissionarios = 0;
        this.Escolaridade = "";
        this.Estagio = "";
        this.AtualizacaoPlano = 0;
        this.Regiao = "";
        this.AtualizacaoCadastro = 0;
        this.Consorcio = "";
    }

    public Municipio(int ID, String Nome, String UF,int CodigoUF, int Populacao, int NumeroFuncionarios, int NumeroComissionarios, String Escolaridade, String Estagio, int AtualizacaoPlano, String Regiao, int AtualizacaoCadastro, String Consorcio){
        this.ID = ID;
        this.Nome = Nome;
        this.UF = UF;
        this.CodigoUF = CodigoUF;
        this.Populacao = Populacao;
        this.NumeroFuncionarios = NumeroFuncionarios;
        this.NumeroComissionarios = NumeroComissionarios;
        this.Escolaridade = Escolaridade;
        this.Estagio = Estagio;
        this.AtualizacaoPlano = AtualizacaoPlano;
        this.Regiao = Regiao;
        this.AtualizacaoCadastro = AtualizacaoCadastro;
        this.Consorcio = Consorcio;
    }

    public void setID(int x){
        this.ID = x;
    }
    public int getID(){
        return ID;
    }
    public void setNome(String n){
        this.Nome = n;
    }
    public String getNome(){
        return Nome;
    }
    public void setUF(String n){
        this.UF = n;
    }
    public String getUF(){
        return UF;
    }
    public void setCodigoUF(int x){
        this.CodigoUF = x;
    }
    public int getCodigoUF(){
        return CodigoUF;
    }
    public void setPopulacao(int x){
        this.Populacao = x;
    }
    public int getPopulacao(){
        return Populacao;
    }
    public void setNumeroFuncionarios(int x){
        this.NumeroFuncionarios = x;
    }
    public int getNumeroFuncionarios(){
        return NumeroFuncionarios;
    }
    public void setNumeroComissionarios(int x){
        this.NumeroComissionarios = x;
    }
    public int getNumeroComissionarios(){
        return NumeroComissionarios;
    }
    public void setEscolaridade(String n){
        this.Escolaridade = n;
    }
    public String getEscolaridade(){
        return Escolaridade;
    }
    public void setEstagio(String n){
        this.Estagio = n;
    }
    public String getEstagio(){
        return Estagio;
    }
    public void setAtualizacaoPlano(int x){
        this.AtualizacaoPlano = x;
    }
    public int getAtualizacaoPlano(){
        return AtualizacaoPlano;
    }
    public void setRegiao(String n){
        this.Regiao = n;
    }
    public String getRegiao(){
        return Regiao;
    }
    public void setAtualizacaoCadastro(int x){
        this.AtualizacaoCadastro = x;
    }
    public int getAtualizacaoCadastro(){
        return AtualizacaoCadastro;
    }
    public void setConsorcio(String y){
        if(y.equals("Sim") == true)
            this.Consorcio = "true";
        else
            this.Consorcio = "false";
    }
    public boolean getConsorcio(){
        if(Consorcio.equals("Sim"))
            return true;
        else
            return false;
    }
    public void imprimir(){
        MyIO.println(this.ID+" "+
                     this.Nome+" "+
                     this.UF+" "+
                     this.CodigoUF+" "+
                     this.Populacao+" "+
                     this.NumeroFuncionarios+" "+
                     this.NumeroComissionarios+" "+
                     this.Escolaridade+" "+
                     this.Estagio+" "+
                     this.AtualizacaoPlano+" "+
                     this.Regiao+" "+
                     this.AtualizacaoCadastro+" "+
                     this.Consorcio);
    }
    public Municipio clone(){
        Municipio clone = new Municipio();
        clone.ID = this.ID;
        clone.Nome = this.Nome;
        clone.UF = this.UF;
        clone.CodigoUF = this.CodigoUF;
        clone.Populacao = this.Populacao;
        clone.NumeroFuncionarios = this.NumeroFuncionarios;
        clone.NumeroComissionarios = this.NumeroComissionarios;
        clone.Escolaridade = this.Escolaridade;
        clone.Estagio = this.Estagio;
        clone.AtualizacaoPlano = this.AtualizacaoPlano;
        clone.Regiao = this. Regiao;
        clone.AtualizacaoCadastro = this.AtualizacaoCadastro;
        clone.Consorcio = this.Consorcio;
        //clone.prox = this.prox;
        return clone;
    }

    public void ler(Municipio novo, int entrada)throws Exception{
    
        int linha;
        String []separadaTemp;
        String []separada = new String[13];
        String palavra="";
        linha = Integer.valueOf(entrada);
        BufferedReader myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/variaveisexternas.txt"), "ISO-8859-1"));
          
        for(int i = 0; i <= linha;  i++){
            palavra = myBuffer.readLine();
        }
        separadaTemp = palavra.split("\t");
        separada[0] = separadaTemp[0];//ID
        separada[1] = separadaTemp[1];//Regiao
        separada[2] = separadaTemp[2];//CodigoUF
        separada[3] = separadaTemp[3];//UF
        separada[4] = separadaTemp[4];//Nome
        separada[5] = separadaTemp[6];//Populacao

        myBuffer.close();

        myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/gestaoambiental.txt"),"ISO-8859-1"));
        for(int i = 0; i <= linha;  i++){
            palavra = myBuffer.readLine();
        }
        separadaTemp = palavra.split("\t");
        separada[6] = separadaTemp[7];//Estagio

        myBuffer.close();

        myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/recursosparagestao.txt"),"ISO-8859-1"));
        for(int i = 0; i <= linha;  i++){
            palavra = myBuffer.readLine();
        }
        separadaTemp = palavra.split("\t");
        separada[7] = separadaTemp[6];//Atualizacao Cadastro

        myBuffer.close();

        myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/recursoshumanos.txt"),"ISO-8859-1"));
        for(int i = 0; i <= linha;  i++){
            palavra = myBuffer.readLine();
        }
        separadaTemp = palavra.split("\t");
        separada[8] = separadaTemp[4];//Numero de funcionarios
        separada[9] = separadaTemp[7];//Numero de comissionários

        myBuffer.close();

        myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/planejamentourbano.txt"),"ISO-8859-1"));
        for(int i = 0; i <= linha;  i++){
            palavra = myBuffer.readLine();
        }
        separadaTemp = palavra.split("\t");
        separada[10] = separadaTemp[5];//Escolaridade
        separada[11] = separadaTemp[8];//Atualizacao do Plano

        myBuffer.close();

        myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/articulacaoointerinstitucional.txt"),"ISO-8859-1"));
        for(int i = 0; i <= linha;  i++){
            palavra = myBuffer.readLine();
        }
        separadaTemp = palavra.split("\t");
        separada[12] = separadaTemp[5];//Consorcio

        myBuffer.close();
      
        novo.setID(Integer.valueOf(separada[0]));
        novo.setNome(separada[4]);
        novo.setUF(separada[3]);
        novo.setCodigoUF(Integer.valueOf(separada[2]));
        novo.setPopulacao(Integer.valueOf(separada[5]));
        novo.setNumeroFuncionarios(Integer.valueOf(separada[8]));
        novo.setNumeroComissionarios(Integer.valueOf(separada[9]));
        novo.setEscolaridade(separada[10]);
        novo.setEstagio(separada[6]);
        if(separada[11].equals("Não foi atualizado") == true||separada[11].equals("-") == true){
            separada[11] = "0";
            novo.setAtualizacaoPlano(Integer.valueOf(separada[11]));
        }
        else
            novo.setAtualizacaoPlano(Integer.valueOf(separada[11]));       
        novo.setRegiao(separada[1]);
        if(separada[7].equals("Não foi atualizado") == true||separada[7].equals("-") == true||separada[7].equals("Não soube informar*")){
            separada[7] = "0";
            novo.setAtualizacaoCadastro(Integer.valueOf(separada[7]));
        }
        else    
            novo.setAtualizacaoCadastro(Integer.valueOf(separada[7]));
        novo.setConsorcio(separada[12]);
    }
}
/**
 * No da arvore binaria
 */
class No{
  public boolean cor;
  public Municipio elemento;
  public No esq, dir;
  public No (){
      this.elemento = new Municipio();
      this.cor = false;
      this.esq = null;
      this.dir = null;
  }
  public No (Municipio elemento){
      this.elemento = elemento.clone();
      this.cor = false;
      this.esq = null;
      this.dir = null;
  }
  public No (Municipio elemento, boolean cor){
      this.elemento = elemento.clone();
      this.cor = cor;
      this.esq = null;
      this.dir = null;
  }
  public No (Municipio elemento, boolean cor, No esq, No dir){
    this.elemento = elemento.clone();
    this.cor = cor;
    this.esq = esq;
    this.dir = dir;
  }
}

/**
 * Arvore binaria de pesquisa
 */
class Alvinegra {
	private No raiz; // Raiz da arvore.
    public int comparacoes;

	/**
	 * Construtor da classe.
	 */
	public Alvinegra() {
	    raiz = null;
        comparacoes = 0;
	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 */
	public boolean pesquisar(int elemento) {
        MyIO.print("raiz ");
		return pesquisar(elemento, raiz);
	}

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 */
	private boolean pesquisar(int elemento, No i) {
        boolean resp;
		if (i == null) {
            comparacoes++;
            resp = false;
        } else if (elemento == i.elemento.getID()) {
            comparacoes++;
            resp = true;
        } else if (elemento < i.elemento.getID()) {
            comparacoes++;
            MyIO.print("esq ");
            resp = pesquisar(elemento, i.esq);
        } else {
            comparacoes++;
            MyIO.print("dir ");
            resp = pesquisar(elemento, i.dir);
        }
        return resp;
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarCentral() {
		mostrarCentral(raiz);
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 */
	private void mostrarCentral(No i) {
		if (i != null) {
			mostrarCentral(i.esq); // Elementos da esquerda.
			i.elemento.imprimir();
         System.out.print(((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
			mostrarCentral(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarPre() {
		mostrarPre(raiz);
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 */
	private void mostrarPre(No i) {
		if (i != null) {
         i.elemento.imprimir();
			System.out.print(((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
			mostrarPre(i.esq); // Elementos da esquerda.
			mostrarPre(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarPos() {
		mostrarPos(raiz);
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 */
	private void mostrarPos(No i) {
		if (i != null) {
			mostrarPos(i.esq); // Elementos da esquerda.
			mostrarPos(i.dir); // Elementos da direita.
         i.elemento.imprimir();
			System.out.print(((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
		}
	}


	/**
	 * Metodo publico iterativo para inserir elemento.
	 */
	public void inserir(Municipio elemento) throws Exception {
   
      //Se a arvore tiver tres ou mais elementos
      if(raiz != null && raiz.esq != null && raiz.dir != null){
            comparacoes++;
		   inserir(elemento, null, null, null, raiz);
         //System.out.println("Arvore com tres ou mais elementos...");
      
      //Senao, se a arvore estiver vazia
      } else if(raiz == null){
        comparacoes++;
         raiz = new No(elemento, false);
         //System.out.println("Antes, zero elementos. Agora, raiz(" + i.elemento.imprimir() + ").");

      //Senao, se a arvore tiver um elemento 
      } else if (raiz.esq == null && raiz.dir == null){
        comparacoes++;
         if (raiz.elemento.getID() > elemento.getID()){
            comparacoes++;
            raiz.esq = new No(elemento, true);
            //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e esq(" + raiz.esq.elemento +").");
         } else {
            comparacoes++;
            raiz.dir = new No(elemento, true);
            //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e dir(" + raiz.dir.elemento +").");
         }

      //Senao, se a arvore tiver dois elementos (raiz e dir)
      } else if (raiz.esq == null){
        comparacoes++;
         if(raiz.elemento.getID() > elemento.getID()){
            comparacoes++;
            raiz.esq = new No(elemento);
            //System.out.println("Antes, dois elementos(A). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");

         } else if (raiz.dir.elemento.getID() > elemento.getID()){
            comparacoes++;
            raiz.esq = new No(raiz.elemento);
            raiz.elemento = elemento.clone();
            //System.out.println("Antes, dois elementos(B). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");

         } else {
            comparacoes++;
            raiz.esq = new No(raiz.elemento);
            raiz.elemento = raiz.dir.elemento.clone();
            raiz.dir.elemento = elemento.clone();
            //System.out.println("Antes, dois elementos(C). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         }

         raiz.esq.cor = raiz.dir.cor = false;
         
      //Senao, se a arvore tiver dois elementos (raiz e esq)
      } else if (raiz.dir == null){
         comparacoes++;
         if(raiz.elemento.getID() < elemento.getID()){
            comparacoes++;
            raiz.dir = new No(elemento);
           //ystem.out.println("Antes, dois elementos(D). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         } else if (raiz.esq.elemento.getID() < elemento.getID()){
            comparacoes++;
            raiz.dir = new No(raiz.elemento);
            raiz.elemento = elemento.clone();
            //System.out.println("Antes, dois elementos(E). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         } else {
            comparacoes++;
            raiz.dir = new No(raiz.elemento);
            raiz.elemento = raiz.esq.elemento.clone();
            raiz.esq.elemento = elemento.clone();
            //System.out.println("Antes, dois elementos(F). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
         }

         raiz.esq.cor = raiz.dir.cor = false;
      } else {
        comparacoes++;
         throw new Exception("Erro ao inserir!");
      }

      raiz.cor = false;
   }

   private void balancear(No bisavo, No avo, No pai, No i){

      //Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
      if(pai.cor == true){
        comparacoes++;
         //4 tipos de reequilibrios e acoplamento
         if(pai.elemento.getID() > avo.elemento.getID()){ // rotacao a esquerda ou direita-esquerda
            comparacoes++;
            if(i.elemento.getID() > pai.elemento.getID()){
               comparacoes++;
               avo = rotacaoEsq(avo);
            } else {
                comparacoes++;
               avo = rotacaoDirEsq(avo);
            }

         } else { // rotacao a direita ou esquerda-direita
            comparacoes++;
            if(i.elemento.getID() < pai.elemento.getID()){
                comparacoes++;
               avo = rotacaoDir(avo);
            } else {
                comparacoes++;
               avo = rotacaoEsqDir(avo);
            }
         }

         if (bisavo == null){
            comparacoes++;
            raiz = avo;
         } else {
            comparacoes++;
            if(avo.elemento.getID() < bisavo.elemento.getID()){
               comparacoes++;
               bisavo.esq = avo;
            } else {
                comparacoes++;
               bisavo.dir = avo;
            }
         }

         //reestabelecer as cores apos a rotacao
         avo.cor = false;
         avo.esq.cor = avo.dir.cor = true;
         //System.out.println("Reestabeler cores: avo(" + avo.elemento + "->branco) e avo.esq / avo.dir(" + avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)");
      } //if(pai.cor == true)
   }

	/**
	 * Metodo privado recursivo para inserir elemento.
	 */
	private No inserir(Municipio elemento, No bisavo, No avo, No pai, No i) throws Exception {
		No resp = new No();
        if (i == null) {
            comparacoes++;
         if(elemento.getID() < pai.elemento.getID()){
            comparacoes++;
            i = pai.esq = new No(elemento, true);
         } else {
            comparacoes++;
            i = pai.dir = new No(elemento, true);
         }

         if(pai.cor == true){
            comparacoes++;
            balancear(bisavo, avo, pai, i);
         }

      } else {
        comparacoes++;
        //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
         if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
            comparacoes++;
            i.cor = true;
            i.esq.cor = i.dir.cor = false;
            if(i == raiz){
                comparacoes++;
               i.cor = false;
            }else if(pai.cor == true){
                comparacoes++;
               balancear(bisavo, avo, pai, i);
            }
         }
         if (elemento.getID() < i.elemento.getID()) {
            comparacoes++;
            resp = inserir(elemento, avo, pai, i, i.esq);
         } else if (elemento.getID() > i.elemento.getID()) {
            comparacoes++;
            resp = inserir(elemento, avo, pai, i, i.dir);
         } else {
            comparacoes++;
            return resp;
            //throw new Exception("Erro inserir (elemento repetido)!");
         }
      }
      return resp;
	}

   private No rotacaoDir(No no) {
      //System.out.println("Rotacao DIR(" + no.elemento + ")");
      No noEsq = no.esq;
      No noEsqDir = noEsq.dir;

      noEsq.dir = no;
      no.esq = noEsqDir;

      return noEsq;
   }

   private No rotacaoEsq(No no) {
      //System.out.println("Rotacao ESQ(" + no.elemento + ")");
      No noDir = no.dir;
      No noDirEsq = noDir.esq;

      noDir.esq = no;
      no.dir = noDirEsq;
      return noDir;
   }

   private No rotacaoDirEsq(No no) {
      no.dir = rotacaoDir(no.dir);
      return rotacaoEsq(no);
   }

   private No rotacaoEsqDir(No no) {
      no.esq = rotacaoEsq(no.esq);
      return rotacaoDir(no);
   }
}
