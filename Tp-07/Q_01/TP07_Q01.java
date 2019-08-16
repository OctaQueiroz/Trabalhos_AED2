import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class TP07_Q01{

    public static void main (String[]args)throws Exception{
    	double tempo = System.currentTimeMillis();
        String linha;
        String[] entrada;
        int cont;
        No resp; //Para receber o  resultado das remocoes
        Municipio novo = new Municipio(); 

        linha = MyIO.readLine();

        //pegando os municipios que serao inseridos inicialmente na arvore
        ArvoreBinaria arvore = new ArvoreBinaria();

        do{
            novo.ler(novo, Integer.valueOf(linha));
            arvore.inserir(novo);
            linha = MyIO.readLine();
        }while(linha.equals("0") == false); 

        //arvore.mostrarPre();
        //tratando as operacoes na arvore-------------------------------------------- 
        cont = Integer.valueOf(MyIO.readLine());

        for(int i = 0; i <= cont; i ++){
            linha = MyIO.readLine();
            entrada = linha.split(" ");
            if(entrada[0].equals("I")){
                novo.ler(novo, Integer.valueOf(entrada[1]));
                arvore.inserir(novo);
            }
            else if(entrada[0].equals("R")){
                resp = arvore.remover(Integer.valueOf(entrada[1]));
            }
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

        Arq.openWrite("529934_arvoreBinaria.txt");
    	Arq.print("529934\t"+arvore.comparacoes+"\t"+tempo);
    	Arq.close();
        //arvore.mostrarPre();
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
        separada[1] = separadaTemp[1];//Região
        separada[2] = separadaTemp[2];//CódigoUF
        separada[3] = separadaTemp[3];//UF
        separada[4] = separadaTemp[4];//Nome
        separada[5] = separadaTemp[6];//População

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
        separada[7] = separadaTemp[6];//Atualização Cadastro

        myBuffer.close();

        myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/recursoshumanos.txt"),"ISO-8859-1"));
        for(int i = 0; i <= linha;  i++){
            palavra = myBuffer.readLine();
        }
        separadaTemp = palavra.split("\t");
        separada[8] = separadaTemp[4];//Número de funcionários
        separada[9] = separadaTemp[7];//Número de comissionários

        myBuffer.close();

        myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/planejamentourbano.txt"),"ISO-8859-1"));
        for(int i = 0; i <= linha;  i++){
            palavra = myBuffer.readLine();
        }
        separadaTemp = palavra.split("\t");
        separada[10] = separadaTemp[5];//Escolaridade
        separada[11] = separadaTemp[8];//Atualização do Plano

        myBuffer.close();

        myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/articulacaoointerinstitucional.txt"),"ISO-8859-1"));
        for(int i = 0; i <= linha;  i++){
            palavra = myBuffer.readLine();
        }
        separadaTemp = palavra.split("\t");
        separada[12] = separadaTemp[5];//Consórcio

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
class No {
    public Municipio elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.

    /**
    * Construtor do No sem filhos
    */
    public No(Municipio novo) {
        this.elemento = novo.clone();
        this.esq = null;
        this.dir = null;
    }

    /**
    * Construtor da classe com filhos
    */
    public No(Municipio elemento, No esq, No dir) {
        this.elemento = elemento.clone();
        this.esq = esq;
        this.dir = dir;
    }
}

/**
* Arvore binaria de pesquisa
*/
class ArvoreBinaria {
    private No raiz; // Raiz da arvore.
    public int comparacoes;
    /**
    * Construtor da arvore.
    */
    public ArvoreBinaria() {
        this.raiz = null;
        this.comparacoes = 0;
    }

    /**
    * Metodo publico que incializa a pesquiza recursiva.
    */
    public boolean pesquisar(int x) {
    	MyIO.print("raiz ");
        return pesquisar(x, raiz);
    }

    /**
    * Metodo privado recursivo para pesquisar elemento.
    */
    private boolean pesquisar(int x, No i) {
        boolean resp;
        if (i == null){
        	comparacoes++;
            resp = false;
        }
        else if (x == i.elemento.getID()){
        	comparacoes++;
            resp = true;
        } 
        else if (x < i.elemento.getID()){
        	MyIO.print("esq ");
        	comparacoes++;
            resp = pesquisar(x, i.esq);
        } 
        else{
        	MyIO.print("dir ");
        	comparacoes++;
            resp = pesquisar(x, i.dir);
        }
        return resp;
    }

    /**
    * Metodo publico ique inicializa i método recursivo para exibir elementos na ordem de insercao
    */
    public void mostrarCentral() {
        mostrarCentral(raiz);
    }

    /**
    * Metodo privado recursivo para exibir elementos na ordem em que foram inseridos
    */
    private void mostrarCentral(No i) {
        if (i != null) {
            mostrarCentral(i.esq); // Elementos da esquerda.
            i.elemento.imprimir() ; // Conteudo do no.
            mostrarCentral(i.dir); // Elementos da direita.
        }
    }

    /**
    * Metodo publico que inicializa o método recursivo para exibir elementos em ordem crescente de ID
    */
    public void mostrarPre() {
        mostrarPre(raiz);
    }

    /**
    * Metodo privado recursivo para exibir elementos em ordem crescente
    */
    private void mostrarPre(No i) {
        if (i != null) {
            i.elemento.imprimir(); // Conteudo do no.
            mostrarPre(i.esq); // Elementos da esquerda.
            mostrarPre(i.dir); // Elementos da direita.
        }
    }

    /**
    * Metodo publico que inicializa o metodo recursivo para exibir elementos em ordem decrescente 
    */
    public void mostrarPos() {
        mostrarPos(raiz);
    }

    /**
    * Metodo privado recursivo para exibir elementos em ordem decrescente
    */
    private void mostrarPos(No i) {
        if (i != null) {
            mostrarPos(i.esq); // Elementos da esquerda.
            mostrarPos(i.dir); // Elementos da direita.
            i.elemento.imprimir(); // Conteudo do no.
        }
    }


    /**
    * Metodo publico que inicializa a recursao para inserir elemento.
    */
    public void inserir(Municipio x) throws Exception {
        raiz = inserir(x, raiz);
    }

    /**
    * Metodo privado recursivo para inserir elemento.
    */
    private No inserir(Municipio x, No i) throws Exception {
        if (i == null){
        	comparacoes++;
            i = new No(x);
        } 
        else if (x.getID() < i.elemento.getID()){
        	comparacoes++;
            i.esq = inserir(x, i.esq);
        }
        else if (x.getID() > i.elemento.getID()){
        	comparacoes++;
            i.dir = inserir(x, i.dir);
        } 
        return i;
    }

    /**
    * Metodo publico que inicializa a recursao para remover elemento.
    */
    public No remover(int x) throws Exception {
        raiz = remover(x, raiz);
        return raiz;
    }

    /**
    * Metodo privado recursivo para remover elemento.
    */
    private No remover(int x, No i) throws Exception {
        if (i == null) {
        	comparacoes++;
       		return i;
        } else if (x < i.elemento.getID()) {
        	comparacoes++;
            i.esq = remover(x, i.esq);
        } else if (x > i.elemento.getID()) {
        	comparacoes++;
            i.dir = remover(x, i.dir);
        // Sem no a direita.
        } else if (i.dir == null) {
        	comparacoes++;
            i = i.esq;
        // Sem no a esquerda.
        } else if (i.esq == null) {
        	comparacoes++;
            i = i.dir;
        // No a esquerda e no a direita.
        } else {
        	comparacoes++;
            i.esq = antecessor(i, i.esq);
        }
        return i;
    }

    /**
    * Metodo para trocar no removido pelo antecessor.
    */
    private No antecessor(No i, No j) {
        // Existe no a direita.
        if (j.dir != null) {
        	comparacoes++;
            // Caminha para direita.
            j.dir = antecessor(i, j.dir);
            // Encontrou o maximo da subarvore esquerda.
        } else {
        	comparacoes++;
            i.elemento = j.elemento.clone(); // Substitui i por j.
            j = j.esq; // Substitui j por j.ESQ.
        }
        return j;
    }
}
