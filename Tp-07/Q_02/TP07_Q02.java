import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class TP07_Q02{

    public static void main (String[]args)throws Exception{
    	double tempo = System.currentTimeMillis();
        String linha;
        String[] entrada;
        int cont;
        No resp; //Para receber o  resultado das remocoes
        Municipio novo = new Municipio(); 

        linha = MyIO.readLine();

        //pegando os municipios que serao inseridos inicialmente na arvore
        ArvoreArvore arvore = new ArvoreArvore();

        do{
            novo.ler(novo, Integer.valueOf(linha));
            arvore.inserirSec(novo);
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
                arvore.inserirSec(novo);
            }
            else if(entrada[0].equals("R")){
                arvore.removerIni(Integer.valueOf(entrada[1]));
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
    public int elemento; // Conteudo do no.
    public No esq; // No da esquerda.
    public No dir; // No da direita.
    public No2 outro;
    
   /**
     * Construtor da classe
     */
    No(int elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
        this.outro = null;
    }

    /**
     * Construtor da classe.
     */
    No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.outro = null;
    }
}
class No2 {
    public Municipio elemento; // Conteudo do no.
    public No2 esq; // No da esquerda.
    public No2 dir; // No da direita.
    
   /**
     * Construtor da classe.
     */
    No2(Municipio elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
    }

    /**
     * Construtor da classe.
     */
    No2(Municipio elemento, No2 esq, No2 dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}
/**
 * Arvore de arvore
 */
class ArvoreArvore {
    private No raiz; // Raiz da arvore.
    public int comparacoes;
    /**
     * Construtor da classe.
     */
    public ArvoreArvore()throws Exception  {
        comparacoes = 0;
        raiz = null;
        inserir(29);
        inserir(21);
        inserir(50);
        inserir(14);
        inserir(25);
        inserir(35);
        inserir(52);
        inserir(12);
        inserir(16);
        inserir(23);
        inserir(27);
        inserir(32);
        inserir(42);
        inserir(51);
        inserir(53);
        inserir(11);
        inserir(13);
        inserir(15);
        inserir(17);
        inserir(22);
        inserir(24);
        inserir(26);
        inserir(28);
        inserir(31);
        inserir(33);
        inserir(41);
        inserir(43);
    }
    public void inserir(int x) throws Exception {
        raiz = inserir(x, raiz);
    }

    /**
    * Metodo privado recursivo para inserir elemento.
    */
    private No inserir(int x, No i) throws Exception {
        if (i == null){
            comparacoes++;
            i = new No(x);
        } 
        else if (x < i.elemento){
            comparacoes++;
            i.esq = inserir(x, i.esq);
        }
        else if (x > i.elemento){
            comparacoes++;
            i.dir = inserir(x, i.dir);
        } 
        return i;
    }
    /**
     * Metodo publico iterativo para pesquisar elemento.
     */
    public boolean pesquisar(int id) {
        boolean resp = false;
        return pesquisar(raiz, id, resp);
    }

    private boolean pesquisar(No no, int id , boolean resp) {
        if (no != null){
            if(resp != true)
                resp = pesquisarSegundaArvore(no.outro, id);
                pesquisar(no.esq, id, resp); // Elementos da esquerda.
                pesquisar(no.dir, id, resp); // Elementos da direita.
        }
        return resp;
    }

    private boolean pesquisarSegundaArvore(No2 no, int id){
        boolean resp;
        if (no == null){ 
            resp = false;
        } 
        else if (id == no.elemento.getID()){ 
            resp = true; 
        } 
        else if (id < no.elemento.getID()){ 
            resp = pesquisarSegundaArvore(no.esq, id); 
        } 
        else{ 
            resp = pesquisarSegundaArvore(no.dir, id); 
        }
        return resp;
    }

    public void inserirSec(Municipio x) throws Exception {
        inserirSegundaArvore(raiz, x);
    }

    private void inserirSegundaArvore(No no, Municipio novo){
        if (no == null){ 
        }
        else if (novo.getCodigoUF() == no.elemento){ 
            inserirSegundaArvore(no.outro, novo); 
        } 
        else if (novo.getCodigoUF() < no.elemento){ 
            inserirSegundaArvore(no.esq, novo); 
        } 
        else{ 
            inserirSegundaArvore(no.dir, novo); 
        }
    }

    private No2 inserirSegundaArvore(No2 i, Municipio novo){
        if (i == null){
            comparacoes++;
            i = new No2(novo);
        } 
        else if (novo.getID() < i.elemento.getID()){
            comparacoes++;
            i.esq = inserirSegundaArvore(i.esq, novo);
        }
        else if (novo.getID() > i.elemento.getID()){
            comparacoes++;
            i.dir = inserirSegundaArvore(i.dir, novo);
        } 
        return i;
    }

    public void removerIni(int id) throws Exception {
        remover(id, raiz);
    }

    private void remover(int id, No i) {
        if (i != null) {
            removerArvoreSecundaria(id, i.outro);
            remover(id, i.esq); // Elementos da esquerda.
            remover(id, i.dir); // Elementos da direita.
        }
    }

    private No2 removerArvoreSecundaria(int id, No2 i) throws Exception {
        if (i == null) {
            comparacoes++;
            return i;
        } else if (id < i.elemento.getID()) {
            comparacoes++;
            i.esq = removerArvoreSecundaria(id, i.esq);
        } else if (id > i.elemento.getID()) {
            comparacoes++;
            i.dir = removerArvoreSecundaria(id, i.dir);
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
    private No2 antecessor(No2 i, No2 j) {
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
