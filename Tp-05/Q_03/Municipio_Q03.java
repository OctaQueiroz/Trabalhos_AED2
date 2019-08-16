import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Municipio_Q03{
  static int[] cont2 = new int [2];
  public static void main (String[]args)throws Exception{
    double tempo = System.currentTimeMillis();
    double tempo2;
    MyIO.setCharset("ISO-8859-1");
    String entrada;
    String[] temporaria;
    int i = 0;
    int aux = 0;
    int cont = 0;
    Municipio novo = new Municipio();
    Municipio[] municipiolista = new Municipio[5571];
    for(i = 0; i < 5571; i++){
      municipiolista[i] = new Municipio();
    }
    entrada = MyIO.readLine();
    i = 0;
    do{
      novo.ler(novo, Integer.valueOf(entrada));
      municipiolista[i] = novo.clone();
      entrada = MyIO.readLine();
      i++;
    }while(entrada.equals("0") == false);   
    cont = i;
    ListaMunicipio lista = new ListaMunicipio(i);
    for(aux = 0; aux < i; aux++){
      lista.inserirInicio(municipiolista[aux]);
    }
    lista.selecao(cont2);
    lista.mostrar();
    tempo2 = System.currentTimeMillis();
    tempo = tempo2 - tempo;
    Arq.openWrite("529934_selecao.txt");
    Arq.print("529934\t"+cont2[0]+"\t"+cont2[1]+"\t"+tempo);
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

class ListaMunicipio{
  private Municipio[] vet;
  private int n;

  ListaMunicipio(int tamanho){
    vet = new Municipio[tamanho];
    n = 0;//quantidade de elementos na lista
    for(int i = 0; i < tamanho; i++){
     vet[i] = new Municipio();
    }
  }   

  public void inserirInicio(Municipio x)throws Exception{
    if(n >= vet.length)
      throw new Exception("Erro ao inserir no inicio!");
    //empurrar elementos para o fim do array
    for(int i = n; i > 0; i--){
      vet[i] = vet[i-1].clone();
    }  
    vet[0] = x.clone();
    n++;
    //MyIO.println(n);
  }

  public void inserirFim(Municipio x)throws Exception{
    if(n >= vet.length)
      throw new Exception("Erro ao inserir no fim!");
    //insere na posicao n que é uma posição à frente do ultimo elemento da lista
    vet[n] = x.clone();
    n++;
    //MyIO.println(n);
  }

  public void inserir(Municipio x, int pos)throws Exception{
    if(n >= vet.length || pos < 0 || pos > n)
      throw new Exception("Erro ao inserir na posicao "+pos+" !");
    //empurrar elemenos à partir daquela posição para o fim do array
    for (int i = n;i > pos ; i--){
      vet[i] = vet[i-1].clone();
    }
    vet[pos] = x.clone();
    n++;
    //MyIO.println(n);
  }

  public Municipio removerInicio()throws Exception{
    if(n == 0)
      throw new Exception("Não há nenhum item para ser  removido!");

    Municipio resp = vet[0].clone();
    n--;
    //empurrar elementos para o começo do array
    for (int i = 0; i < n; i++){
      vet[i] = vet[i+1].clone();  
    }
    //MyIO.println(n); 
    return resp;  
  }

  public Municipio removerFim()throws Exception{
    if(n == 0)
      throw new Exception("Erro ao remover do fim!");
    //retorna o último elemmento da lista
    n = n - 1;
    //MyIO.println(n);
    return vet[n].clone();//primeiro é subtraído 1 do valor de n, depois ele é retornado
  }

  public Municipio remover(int pos)throws Exception{
    if(n == 0 || pos < 0 || pos >= n)
      throw new Exception("Erro ao remover da posicao"+pos+"!");

      Municipio resp = vet[pos].clone();
      n--;
      //empurrar elementos para a posição de remoção
      for (int i = pos; i < n; i++){
        vet[i] = vet[i+1].clone();
      }
     // MyIO.println(n);
      return resp;
  }

  public void mostrar(){
    for (int i = 0; i < n; i++){
      vet[i].imprimir();
    }
  }

  public Municipio retornaItem(int pos){
    return vet[pos].clone();
  }

  public void swap(int pos1, int pos2){
    Municipio temp;
    temp = vet[pos1].clone();     
    vet[pos1] = vet[pos2].clone();     
    vet[pos2] = temp.clone();     
  }

  public int[] selecao(int[] cont2){
    int menor;
    for (int i = 0; i < (n - 1); i++) {
      menor = i;
      for (int j = (i + 1); j < n; j++){
        cont2[0] = cont2[0] + 1;
        if (vet[menor].getAtualizacaoPlano() > vet[j].getAtualizacaoPlano()){
          menor = j;
        }
        else if(vet[menor].getAtualizacaoPlano() == vet[j].getAtualizacaoPlano()){
          if(vet[menor].getID() > vet[j].getID()){
            menor = j;
          }
        }
      }
      swap(menor, i);
      cont2[1] = cont2[1] + 1;
    }
    return cont2;
  }  

  public int isVazia() {
    if(n == 0)
      return 1;

    else
      return 0;
  }
}