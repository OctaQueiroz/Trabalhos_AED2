import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


class TP07_Q07{
  static int cont2 = 0;
  public static void main (String[]args)throws Exception{
    int comparacoes = 0;
    double tempo = System.currentTimeMillis();
    double tempo2;
    MyIO.setCharset("UTF-8");
    String entrada;
    String[] temporaria;
    int i = 0;
    boolean aux;
    int cont = 0;
    Municipio novo = new Municipio();
    Municipio[] municipiolista = new Municipio[5571];
    for(i = 0; i < 5571; i++){
      municipiolista[i] = new Municipio();
    }
    entrada = MyIO.readLine();
    i = 0;

    HashIndiretoLista tabela = new HashIndiretoLista(21);
    do{
      novo.ler(novo, Integer.valueOf(entrada));
      tabela.inserirInicio(novo);
      entrada = MyIO.readLine();
      i++;
    }while(entrada.equals("0") == false);   
    cont = i;

    /*
    for(aux = 0; aux < i; aux++){
      tabela.inserir(municipiolista[aux]);
    }
    */
    entrada = MyIO.readLine();
    do{
      aux = tabela.pesquisar(Integer.valueOf(entrada));
      if(aux == false){
        MyIO.println("NÃO");
      }
      entrada = MyIO.readLine();
    }while(entrada.equals("FIM") == false);

    tempo2 = System.currentTimeMillis();
    tempo = tempo2 - tempo;
    for(int k = 0; k < 21; k++){
        comparacoes += tabela.tabela[k].comparacoes;
    }
    Arq.openWrite("529934_hashIndireta.txt");
    Arq.print("529934\t"+comparacoes+"\t"+tempo);
    Arq.close();
  }
}
  
class Municipio{
  public  int ID;
  public  String Nome;
  public  String UF;
  public  int CodigoUF;
  public  int Populacao;
  public  int NumeroFuncionarios;
  public  int NumeroComissionarios;
  public  String Escolaridade;
  public  String Estagio;
  public  int AtualizacaoPlano;
  public  String Regiao;
  public  int AtualizacaoCadastro;
  public  String Consorcio;

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

class HashIndiretoLista {
   Lista tabela[];
   int tamanho;
   final int NULO = -1;

   public HashIndiretoLista (){
      this(7);
   }

   public HashIndiretoLista (int tamanho){
      this.tamanho = tamanho;
      tabela = new Lista[tamanho];
      for(int i = 0; i < tamanho; i++){
         tabela[i] = new Lista();
      }
   }

   public int h(int elemento){
      return elemento % tamanho;
   }

   boolean pesquisar(int id){
      int pos = h(id);
      return tabela[pos].pesquisar(id, pos);
   }

   public void inserirInicio (Municipio elemento){
      int pos = h(elemento.getID());
      tabela[pos].inserirInicio(elemento);
   }
/*
   void remover(int elemento){
      int resp = NULO;
      if (pesquisar(elemento) == false){
         throw new Exception("Erro ao remover!");
      } else {
         int pos = h(elemento);
         resp = tabela[pos].remover(elemento);
      }
      return resp;
   }
*/
}
/**
 * Celula simplesmente encadeada
 */
class Celula {
    public Municipio elemento; // Elemento inserido na celula.
    public Celula prox; // Aponta a celula prox.

    /**
     * Construtor da classe.
     */
    Celula() {
        this.elemento = new Municipio();
        this.prox = null;
    }

    Celula(Municipio elemento) {
        this.elemento = elemento.clone();
        this.prox = null;
    }

    /**
     * Construtor da classe.
     */
    Celula(Municipio elemento, Celula prox) {
        this.elemento = elemento.clone();
        this.prox = prox;
    }
}

/**
 * Lista dinamica simplesmente encadeada
 */
class Lista {
    public int comparacoes;
    private Celula primeiro; // Primeira celula: SEM elemento valido.
    private Celula ultimo; // Ultima celula: COM elemento valido.

    /**
     * Construtor da classe: Instancia uma celula (primeira e ultima).
     */
    public Lista() {
        comparacoes = 0;
        primeiro = new Celula();
        ultimo = primeiro;
    }

    /**
     * Mostra os elementos separados por espacos.
     */
    public void mostrar() {
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            i.elemento.imprimir();
        }
    }

    /**
     * Procura um elemento e retorna se ele existe.
     */
    public boolean pesquisar(int x, int pos) {
        boolean retorno = false;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento.getID() == x){
            comparacoes++;
            MyIO.println(pos);
            retorno = true;
            i = ultimo;
         }
        }
        return retorno;
    }

    /**
     * Insere um elemento na primeira posicao da sequencia.
     */
    public void inserirInicio(Municipio elemento) {
        Celula tmp = new Celula(elemento);
      tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
      tmp = null;
    }

    /**
     * Insere um elemento na ultima posicao da sequencia.
     */
    public void inserirFim(Municipio elemento) {
        Celula tmp = new Celula(elemento);
        ultimo.prox = tmp;
        ultimo = ultimo.prox;
      tmp = null;
    }

    /**
     * Insere elemento em um indice especifico.
     */
   public void inserirMeio(Municipio x, int posicao) throws Exception {
      Celula i;
      int cont;

        // Caminhar ate chegar na posicao anterior a insercao
      for(i = primeiro, cont = 0; (i.prox != ultimo && cont < posicao); i = i.prox, cont++);
        
        // Se indice for incorreto:
        if (posicao < 0 || posicao > cont + 1) {
            throw new Exception("Erro ao inserir (posicao " + posicao + "(cont = " + cont + ") invalida)!");

      } else if (posicao == cont + 1) {
         inserirFim(x);
        }else{
         Celula tmp = new Celula(x);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }

    /**
     * Remove um elemento da primeira posicao da sequencia.
      */
    public Municipio removerInicio() throws Exception {
      Municipio resp = new Municipio();

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }else{
         primeiro = primeiro.prox;
         resp = primeiro.elemento.clone();
      }

        return resp;
    }

    /**
     * Remove um elemento da ultima posicao da sequencia.
     * @return Elemento removido.
     * @throws Exception Se a sequencia nao contiver elementos.
     */
    public Municipio removerFim() throws Exception {
      Municipio resp = new Municipio();
      Celula i = null;

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        } else {

         resp = ultimo.elemento.clone();

           // Caminhar ate a penultima celula:
         for(i = primeiro; i.prox != ultimo; i = i.prox);

         ultimo = i;
         i = ultimo.prox = null;
      }

        return resp;
    }

    /**
     * Remove elemento de um indice especifico.
     */
    public Municipio removerMeio(int posicao) throws Exception {
      Celula i;
      Municipio resp = new Municipio();
      int cont;

        if (primeiro == ultimo){
            throw new Exception("Erro ao remover (vazia)!");
      }else{

           // Caminhar ate chegar na posicao anterior a insercao
         for(i = primeiro, cont = 0; (i.prox != ultimo && cont < posicao); i = i.prox, cont++);

         // Se indice for incorreto:
           if (posicao < 0 || posicao > cont + 1) {
            throw new Exception("Erro ao remover (posicao " + posicao + " invalida)!");

         } else if (posicao == cont + 1) {
            resp = removerFim();
         }else{
            Celula tmp = i.prox;
            resp = tmp.elemento.clone();
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
         }
      }

        return resp;
    }
}
