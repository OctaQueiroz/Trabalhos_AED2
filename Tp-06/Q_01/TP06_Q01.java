import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class TP06_Q01{
  public static void main (String[]args)throws Exception{
    String linha;
    String[] entrada;
    int cont;
    Municipio resp; //Para receber o  resultado das remocoes

    Municipio novo = new Municipio();
    linha = MyIO.readLine();

    //pegando os municipios que serao inseridos inicialmente na lista
    ListaDinamica lista = new ListaDinamica();
    do{
      novo.ler(novo, Integer.valueOf(linha));
      lista.inserirFim(novo);
      linha = MyIO.readLine();
    }while(linha.equals("0") == false); 

    //tratando as operacoes da lista-------------------------------------------- 
    cont = Integer.valueOf(MyIO.readLine());

    
    for(int i = 0; i < cont; i ++){
      linha = MyIO.readLine();
      entrada = linha.split(" ");
      if(entrada[0].equals("II")){
        novo.ler(novo, Integer.valueOf(entrada[1]));
        lista.inserirInicio(novo);
      }
      else if(entrada[0].equals("IF")){
        novo.ler(novo, Integer.valueOf(entrada[1]));
        lista.inserirFim(novo);
      }
      else if(entrada[0].equals("I*")){
        novo.ler(novo, Integer.valueOf(entrada[2]));
        lista.inserir(novo, Integer.valueOf(entrada[1]));
      }
      else if(entrada[0].equals("RI")){
        resp = lista.removerInicio();
        MyIO.println("(R) "+resp.getNome());
      }
      else if(entrada[0].equals("RF")){
        resp = lista.removerFim();
        MyIO.println("(R) "+resp.getNome());
      }
      else{
        resp = lista.remover( Integer.valueOf(entrada[1]));
        MyIO.println("(R) "+resp.getNome());
      }
    }
    lista.mostrar();
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

class Celula{
  public Municipio elemento;
  public Celula prox;

  public Celula(){
    this.elemento = null;
    this.prox = null;
  }
  public Celula(Municipio novo){
    this.elemento = novo.clone();
    this.prox = null;
  }

}

class ListaDinamica {
  private Celula primeiro;
  private Celula ultimo;


  /*
  Construtor da classe que cria uma Lista Dinamica sem elementos (somente no cabeca).
  */
  public ListaDinamica() {
    primeiro = new Celula();
    ultimo = primeiro;
  }


  /*
  Insere um elemento na primeira posicao da lista.
  */
  public void inserirInicio(Municipio novo) {
    Celula tmp = new Celula(novo);
    tmp.prox = primeiro.prox;
    primeiro.prox = tmp;
    if (primeiro == ultimo) {                 
      ultimo = tmp;
    }
    tmp = null;
  }


  /*
  Insere um elemento na ultima posicao da lista.
  */
  public void inserirFim(Municipio novo) {
    ultimo.prox = new Celula(novo);
    ultimo = ultimo.prox;
  }


  /*
  Remove um elemento da primeira posicao da lista.
  */
  public Municipio removerInicio() throws Exception {
    if (primeiro == ultimo) {
      throw new Exception("Erro ao remover (vazia)!");
    }

    Celula tmp = primeiro;
    primeiro = primeiro.prox;
    Municipio resp = primeiro.elemento.clone();
    tmp.prox = null;
    tmp = null;
    return resp;
  }


  /*
  Remove um elemento da ultima posicao da lista.
  */
  public Municipio removerFim() throws Exception {
    if (primeiro == ultimo) {
      throw new Exception("Erro ao remover (vazia)!");
    } 

    // Caminhar ate a penultima celula:
    Celula i;
    for(i = primeiro; i.prox != ultimo; i = i.prox);

    Municipio resp = ultimo.elemento.clone(); 
    ultimo = i; 
    i = ultimo.prox = null;
      
    return resp;
  }


  /*
  Insere um elemento em uma posicao especifica considerando que o primeiro elemento valido esta na posicao 0. 
  */
   public void inserir(Municipio novo, int pos) throws Exception {

      int tamanho = tamanho();

      if(pos < 0 || pos > tamanho){
        throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } 
      else if (pos == 0){
        inserirInicio(novo);
      } 
      else if (pos == tamanho){
        inserirFim(novo);
      } 
      else {
         Celula i = primeiro;
         // Caminhar ate a posicao anterior a insercao
         for(int j = 0; j < pos; j++, i = i.prox);
    
         Celula tmp = new Celula(novo);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }


  /*
  Remove um elemento de uma posicao especifica da lista considerando que o primeiro elemento valido esta na posicao 0.
  */
  public Municipio remover(int pos) throws Exception {
      
    Municipio resp;
    int tamanho = tamanho();

    if (primeiro == ultimo){
      throw new Exception("Erro ao remover (vazia)!");

    } 
    else if(pos < 0 || pos >= tamanho){
      throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
    } 
    else if (pos == 0){
      resp = removerInicio();
    } 
    else if (pos == tamanho - 1){
      resp = removerFim();
    } 
    else {
         Celula i = primeiro;
         // Caminhar ate a posicao anterior a remocao
         for(int j = 0; j < pos; j++, i = i.prox);
    
         Celula tmp = i.prox;
         resp = tmp.elemento.clone();
         i.prox = tmp.prox;
         tmp.prox = null;
         i = tmp = null;
      }

    return resp;
  }

  /*
  Mostra os elementos da lista separados por espacos.
  */
  public void mostrar() {
    for (Celula i = primeiro.prox; i != null; i = i.prox) {
      i.elemento.imprimir();
    }
  }

  /*
  Procura um elemento e retorna se ele existe.
  */
  public boolean pesquisar(Municipio x) {
    boolean resp = false;
    for (Celula i = primeiro.prox; i != null; i = i.prox) {
      if(comparaMunicipio(i.elemento, x) == true){
        resp = true;
        i = ultimo;
      }
    }
    return resp;
  }

  /*
  Calcula e retorna o tamanho, em numero de elementos, da lista.
  */
   public int tamanho() {
      int tamanho = 0; 
      for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }

  /*
  Compara dois municipios para saber se sao iguais ou nao
  */
   public boolean comparaMunicipio(Municipio primeiro, Municipio segundo){
    if(primeiro.getID() == segundo.getID() && 
      (primeiro.getNome()).equals(segundo.getNome()) &&
      (primeiro.getUF()).equals(segundo.getUF()) && 
      primeiro.getCodigoUF() == segundo.getCodigoUF() && 
      primeiro.getPopulacao() == segundo.getPopulacao() && 
      primeiro.getNumeroFuncionarios() == segundo.getNumeroFuncionarios() && 
      primeiro.getNumeroComissionarios() == segundo.getNumeroComissionarios() && 
      (primeiro.getEscolaridade()).equals(segundo.getEscolaridade()) &&
      (primeiro.getEstagio()).equals(segundo.getEstagio()) &&
      primeiro.getAtualizacaoPlano() == segundo.getAtualizacaoPlano() &&
      (primeiro.getRegiao()).equals(segundo.getRegiao()) &&
      primeiro.getAtualizacaoCadastro() == segundo.getAtualizacaoCadastro() && 
      (primeiro.getRegiao()).equals(segundo.getRegiao())){
      return true;
    }
    else{
      return false;
    }
  }
}