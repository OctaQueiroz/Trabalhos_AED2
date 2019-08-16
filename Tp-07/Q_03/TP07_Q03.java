import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class TP07_Q03{

    public static void main (String[]args)throws Exception{
    	double tempo = System.currentTimeMillis();
        String linha;
        String[] entrada;
        int cont;
        No resp; //Para receber o resultado das remocoes
        Municipio novo = new Municipio(); 

        linha = MyIO.readLine();

        //pegando os municipios que serao inseridos inicialmente na arvore
        AVL arvore = new AVL();

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
            else if(entrada[0].equals("R")){
                arvore.remover(Integer.valueOf(entrada[1]));
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

        Arq.openWrite("529934_avl.txt");
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
    public No esq; // No da esquerda.
    public No dir; // No da direita.
    public int nivel; // Numero de niveis abaixo do no

    /**
    * Construtor da classe.
    */
    No(Municipio elemento) {
        this.elemento = elemento.clone();
        this.esq = null;
        this.dir = null;
        this.nivel = 1;
    }

    /**
    * Construtor da classe.
    */
    No(Municipio elemento, No esq, No dir, int nivel) {
        this.elemento = elemento.clone();
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }

    // Cálculo do número de níveis a partir de um vértice
    public No setNivel() {
        this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
        return this;
    }

    // Retorna o número de níveis a partir de um vértice
    public static int getNivel(No no) {
        return (no == null) ? 0 : no.nivel;
    }

}

/**
* AVL - Árvore Binária de Pesquisa com algoritmo de balanceamento AVL.
*/
class AVL {
    private No raiz; // Raiz da arvore.
    public int comparacoes;
    /**
    * Construtor da classe.
    */
    public AVL() {
        raiz = null;
        comparacoes = 0;
    }

    public int getAltura() {
        return nivel(raiz) - 1;
    }

    private int nivel(No no) {
        return (no == null) ? 0 : (1 + Math.max(nivel(no.esq), nivel(no.dir)));
    }

    /**
    * Metodo publico que incializa a recursão de pequisa
    */
    public boolean pesquisar(int id) {
        MyIO.print("raiz ");
        return pesquisar(raiz, id);
    }

    /**
    * Metodo privado recursivo para pesquisar elemento.
    */
    private boolean pesquisar(No no, int id) {
        boolean resp;
        if (no == null) {
            resp = false;
            comparacoes++;
        } else if (id == no.elemento.getID()) {
            resp = true;
            comparacoes++;
        } else if (id < no.elemento.getID()) {
            MyIO.print("esq ");
            resp = pesquisar(no.esq, id);
            comparacoes++;
        } else {
            MyIO.print("dir ");
            resp = pesquisar(no.dir, id);
        }
        return resp;
    }

    /**
    * Metodo publico que inicializa a recursao para imprimir elementos em ordem crescente
    */
    public void mostrarCentral() {
        mostrarCentral(raiz);
    }

    /**
    * Metodo privado recursivo para exibir elementos.
    */
    private void mostrarCentral(No no) {
        if (no != null) {
            mostrarCentral(no.esq); // Elementos da esquerda.
            no.elemento.imprimir(); // Conteudo do no.
            mostrarCentral(no.dir); // Elementos da direita.
        }
    }

    /**
    * Metodo publico que inicializa a recursao para imprimir elementos
    */
    public void mostrarPre() {
        mostrarPre(raiz);
    }

    /**
    *  Metodo privado recursivo para exibir elementos.
    */
    private void mostrarPre(No no) {
        if (no != null) {
            no.elemento.imprimir();
            System.out.print("(fator " + (No.getNivel(no.dir) - no.getNivel(no.esq)) + ") "); // Conteudo do no.
            mostrarPre(no.dir); // Elementos da direita.
        }
    }

    /**
    * Metodo publico que inicializa a recursao para imprimir elementos
    */
    public void mostrarPos() {
        mostrarPos(raiz);
    }

    /**
    * Metodo privado recursivo para exibir elementos.
    */
    private void mostrarPos(No no) {
        if (no != null) {
            mostrarPos(no.esq); // Elementos da esquerda.
            mostrarPos(no.dir); // Elementos da direita.
            no.elemento.imprimir(); // Conteudo do no.
        }
    }

    /**
    * Metodo publico qu inicializa recursao para iserir novos elementos
    */
    public void inserir(Municipio x) throws Exception {
        raiz = inserir(raiz, x);
    }

    /**
    * Metodo privado recursivo para inserir elemento.                                                                                                                                                                                                                          */
    private No inserir(No no, Municipio x) throws Exception {
        if (no == null) {
            no = new No(x);
            comparacoes++;
        } else if(x.getID() == no.elemento.getID()){
            return no;
        } else if (x.getID() < no.elemento.getID()) {
            no.esq = inserir(no.esq, x);
            comparacoes++;
        } else if (x.getID() > no.elemento.getID()) {
            no.dir = inserir(no.dir, x);
            comparacoes++;
        } else {
        }

        no = balancear(no);
        return no;
    }

    private No balancear(No no) throws Exception {
        if (no != null) {
            comparacoes++;
            int fator = no.getNivel(no.dir) - no.getNivel(no.esq);
            // Se balanceada
            if (Math.abs(fator) <= 1) {
                comparacoes++;
                no = no.setNivel();
            // Se desbalanceada para a direita
            } else if (fator == 2) {
                comparacoes++;
                int fatorFilhoDir = no.getNivel(no.dir.dir) - no.getNivel(no.dir.esq);
                // Se o filho a direita tambem estiver desbalanceado
                if (fatorFilhoDir == -1) {
                    comparacoes++;
                    no.dir = rotacionarDir(no.dir);
                }
                no = rotacionarEsq(no);
            // Se desbalanceada para a esquerda
            } else if (fator == -2) {
                comparacoes++;
                int fatorFilhoEsq = no.getNivel(no.esq.dir) - no.getNivel(no.esq.esq);
                // Se o filho a esquerda tambem estiver desbalanceado
                if (fatorFilhoEsq == 1) {
                    comparacoes++;
                    no.esq = rotacionarEsq(no.esq);
                }
                no = rotacionarDir(no);
            } else {
            }
        }
        return no;
    }

    private No rotacionarDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        no.setNivel();
        noEsq.setNivel();

        return noEsq;
    }

    private No rotacionarEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        no.setNivel();
        noDir.setNivel();
        return noDir;
    }

    /**
    * Metodo publico que inicia recursao para remover um elemento da arvore
    */
    public void remover(int x) throws Exception {
        raiz = remover(raiz, x);
    }

    /**
     * Metodo privado recursivo para remover elemento.
     */
    private No remover(No no, int id) throws Exception {

        if (no == null) {
            comparacoes++;
        } else if (id < no.elemento.getID()) {
            no.esq = remover(no.esq, id);
            comparacoes++;
        } else if (id > no.elemento.getID()) {
            no.dir = remover(no.dir, id);
            comparacoes++;
            // Sem no a direita.
        } else if (no.dir == null) {
            no = no.esq;
            comparacoes++;
            // Sem no a esquerda.
        } else if (no.esq == null) {
            no = no.dir;
            comparacoes++;
            // No a esquerda e no a direita.
        } else {
            no.esq = antecessor(no, no.esq);
        }

        no = balancear(no);
        return no;
    }

    /**
     * Metodo para trocar no removido pelo antecessor.
     */
    private No antecessor(No n1, No n2) {

        // Existe no a direita.
        if (n2.dir != null) {
            comparacoes++;
            // Caminha para direita.
            n2.dir = antecessor(n1, n2.dir);
            // Encontrou o maximo da subarvore esquerda.
        } else {
            n1.elemento = n2.elemento; // Substitui N1 por N2.
            n2 = n2.esq; // Substitui N2 por N2.ESQ.
        }
        return n2;
    }
}
