import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MunicipioMain{

  public static void main  (String[]args)throws Exception{
    String entrada;
    String[] temporaria = new String[3];
    int i = 0;
    int aux = 0;
    int comt = 0;
    Municipio novo = new Municipio();
    Municipio[] municipiolista = new Municipio[5571];
    entrada = MyIO.readLine();

    do{
      novo.ler(novo,entrada);
      municipiolista[i] = novo.clone();
      entrada = MyIO.readLine();
      i++;
    }while(entrada.equals("0") == false);
    entrada = MyIO.readLine();
    aux = Integer.valueOf(entrada);s
    ListaMunicipio lista = new ListaMunicipio(aux);
    do{
      entrada = MyIO.readLine();
          temporaria = entrada.split("\t");
          if(temporaria[0].equals("II" == true)){
            lista.inserirInicio(municipiolista[Integer.valueOf(temporaria[1])]);
          }
          else if(temporaria[0].equals("I*" == true)){
            lista.inserir(municipiolista[Integer.valueOf(temporaria[2])], Integer.valueOf(temporaria[1]));
          }
          else if(temporaria[0].equals("IF" == true)){
            lista.inserirFim(municipiolista[Integer.valueOf(temporaria[1])]);
          }
          else if(temporaria[0].equals("RI" == true)){
            lista.removerInicio();
          }
          else if(temporaria[0].equals("R*" == true)){
            lista.remover(Integer.valueOf(temporaria[1]));
          }
          else if(temporaria[0].equals("RF" == true)){
            lista.inserirFim();
          }
    }while(cont<=aux);

    lista.mostrar();

    //for(i = 0; municipiolista[i] != null; i++){
    //  municipiolista[i].imprimir();
    //}
  }
}
  
class Municipio{
  private  int ID;
  private  String Nome;
  private  String UF;
  private  int CodigoUF;
  private  int Populacao;
  private  int NumeroFuncionarios;
  private  int NumeroComissionarios;
  private  String Escolaridade;
  private  String Estagio;
  private  int AtualizacaoPlano;
  private  String Regiao;
  private  int AtualizacaoCadastro;
  private  String Consorcio;

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


  public  Municipio ler(Municipio novo, String entrada)throws Exception{
    
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
      
      return novo;
  }
  /*Metodo din}amico com array List
  public void matriciaArquivo(ArrayList<Municipio> lista)throws Exception{
      int linha;
      String []separadaTemp = new String [70];
      String palavra="";
      BufferedReader myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/variaveisexternas.txt"), "ISO-8859-1"));
      Municipio temporario = null;

      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        if(i!=0){ 
          separadaTemp = palavra.split("\t");
          temporario = (Municipio) lista.get(i);      
          temporario.setID(Integer.valueOf(separadaTemp[0]));
          temporario.setRegiao(separadaTemp[1]);
          temporario.setCodigoUF(Integer.valueOf(separadaTemp[2]));
          temporario.setUF(separadaTemp[3]);
          temporario.setNome(separadaTemp[4]);
          temporario.setPopulacao(Integer.valueOf(separadaTemp[6]));
          lista.get(i).imprimir();
        }
      }
      myBuffer.close();

      lista.get(10).imprimir();

      myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/gestaoambiental.txt"),"ISO-8859-1"));
      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        if(i!=0){
          separadaTemp = palavra.split("\t");
          temporario = (Municipio) lista.get(i);   
          temporario.setEstagio(separadaTemp[7]);
         // lista.get(i).imprimir();
        }
      }
      myBuffer.close();

      myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/recursosparagestao.txt"),"ISO-8859-1"));
      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        if(i!=0){ 
          separadaTemp = palavra.split("\t");
          temporario = (Municipio) lista.get(i);             
          
          if(separadaTemp[6].equals("Não foi atualizado") == true||separadaTemp[6].equals("-") == true||separadaTemp[6].equals("Não soube informar*")==true||separadaTemp[6].equals("Recusa")==true){
            separadaTemp[6] = "0";
            temporario.setAtualizacaoCadastro(Integer.valueOf(separadaTemp[6]));
          }
          else{     
            temporario.setAtualizacaoCadastro(Integer.valueOf(separadaTemp[6]));
          }
        }
      }
      myBuffer.close();

      myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/recursoshumanos.txt"),"ISO-8859-1"));
      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        if(i!=0){
          temporario = (Municipio) lista.get(i);   
          if(separadaTemp[4].equals("Não foi atualizado") == true||separadaTemp[4].equals("-") == true||separadaTemp[4].equals("Não soube informar*")==true||separadaTemp[4].equals("Recusa")==true||separadaTemp[4].equals("Sim")==true){
            separadaTemp[4] = "0";
            temporario.setnumeroFuncionarios(Integer.valueOf(separadaTemp[4]));
          }
          else{     
            temporario.setnumeroFuncionarios(Integer.valueOf(separadaTemp[4]));
          }    

          if(separadaTemp[7].equals("Não foi atualizado") == true||separadaTemp[7].equals("-") == true||separadaTemp[7].equals("Não soube informar*")==true||separadaTemp[7].equals("Recusa")==true||separadaTemp[7].equals("Sim")==true){
            separadaTemp[7] = "0";
            temporario.setnumeroComissionarios(Integer.valueOf(separadaTemp[7]));
          }
          else{     
            temporario.setnumeroComissionarios(Integer.valueOf(separadaTemp[7]));
          }              
        }
      }
      myBuffer.close();

      myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/planejamentourbano.txt"),"ISO-8859-1"));
      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        if(i!=0){
          temporario = (Municipio) lista.get(i);   
          temporario.setEscolaridade(separadaTemp[5]);
          if(separadaTemp[8].equals("Não foi atualizado") == true||separadaTemp[8].equals("-") == true){
            separadaTemp[8] = "0";
            temporario.setAtualizacaoPlano(Integer.valueOf(separadaTemp[8]));
          }
          else{
            temporario.setAtualizacaoPlano(Integer.valueOf(separadaTemp[8]));
          }    
        }
      }
      myBuffer.close();      

      myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/articulacaoointerinstitucional.txt"),"ISO-8859-1"));
      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        if(i!=0){
          separadaTemp = palavra.split("\t");
          temporario = (Municipio) lista.get(i);   
          temporario.setConsorcio(separadaTemp[5]);
        }
      }
      myBuffer.close();
  }
  */
  /* Metodo din}amico com array
  public void matriciaArquivo(Municipio[] novo)throws Exception{
      int linha;
      String []separadaTemp = new String [70];
      String palavra="";
      BufferedReader myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/variaveisexternas.txt"), "ISO-8859-1"));
      for(int i = 0; i < 70; i++){
        separadaTemp[i] = new String();
      }

      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        separadaTemp = palavra.split("\t");   
        if(i!=0){   
          novo[i].setID(Integer.valueOf(separadaTemp[0]));
          novo[i].setRegiao(separadaTemp[1]);
          novo[i].setCodigoUF(Integer.valueOf(separadaTemp[2]));
          novo[i].setUF(separadaTemp[3]);
          novo[i].setNome(separadaTemp[4]);
          novo[i].setPopulacao(Integer.valueOf(separadaTemp[6]));
        }
      }
      myBuffer.close();

      myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/gestaoambiental.txt"),"ISO-8859-1"));
      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        if(i!=0){
          separadaTemp = palavra.split("\t");  
          novo[i].setEstagio(separadaTemp[7]);
        }
      }
      myBuffer.close();

      myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/recursosparagestao.txt"),"ISO-8859-1"));
      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        if(i!=0){ 
          separadaTemp = palavra.split("\t");            
          
          if(separadaTemp[6].equals("Não foi atualizado") == true||separadaTemp[6].equals("-") == true||separadaTemp[6].equals("Não soube informar*")==true||separadaTemp[6].equals("Recusa")==true){
            separadaTemp[6] = "0";
            novo[i].setAtualizacaoCadastro(Integer.valueOf(separadaTemp[6]));
          }
          else{     
            novo[i].setAtualizacaoCadastro(Integer.valueOf(separadaTemp[6]));
          }
        }
      }
      myBuffer.close();

      myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/recursoshumanos.txt"),"ISO-8859-1"));
      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        if(i!=0){  
          if(separadaTemp[4].equals("Não informado") == true||separadaTemp[4].equals("-") == true||separadaTemp[4].equals("Não soube informar*")==true||separadaTemp[4].equals("Recusa")==true||separadaTemp[4].equals("Sim")==true){
            separadaTemp[4] = "0";
            novo[i].setNumeroFuncionarios(Integer.valueOf(separadaTemp[4]));
          }
          else{     
            novo[i].setNumeroFuncionarios(Integer.valueOf(separadaTemp[4]));
          }    

          if(separadaTemp[7].equals("Não informado") == true||separadaTemp[7].equals("-") == true||separadaTemp[7].equals("Não soube informar*")==true||separadaTemp[7].equals("Recusa")==true||separadaTemp[7].equals("Sim")==true){
            separadaTemp[7] = "0";
            novo[i].setNumeroComissionarios(Integer.valueOf(separadaTemp[7]));
          }
          else{     
            novo[i].setNumeroComissionarios(Integer.valueOf(separadaTemp[7]));
          }            
        }
      }
      myBuffer.close();

      myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/planejamentourbano.txt"),"ISO-8859-1"));
      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();

        if(i!=0){  
          novo[i].setEscolaridade(separadaTemp[5]);
          MyIO.println(separadaTemp[7]);
          if(separadaTemp[8].equals("Não foi atualizado") == true||separadaTemp[8].equals("-") == true){
            separadaTemp[8] = "0";
            novo[i].setAtualizacaoPlano(Integer.valueOf(separadaTemp[8]));
          }
          else{
            novo[i].setAtualizacaoPlano(Integer.valueOf(separadaTemp[8]));
          }    
        }
      }
      myBuffer.close();      

      myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/tmp/articulacaoointerinstitucional.txt"),"ISO-8859-1"));
      for(int i = 0; i < 5571;  i++){
        palavra = myBuffer.readLine();
        if(i!=0){
          separadaTemp = palavra.split("\t");  
          novo[i].setConsorcio(separadaTemp[5]);
        }
      }
      myBuffer.close();
  }
  */
}

class ListaMunicipio{
  private Municipio[] vet;
  private int n;

  ListaMunicipio(int tamanho){
    vet = new Municipio[tamanho];
    n = 0;//quantidade de elementos na lista
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
  }

  public void inserirFim(Municipio x)throws Exception{
    if(n >= vet.length)
      throw new Exception("Erro ao inserir no fim!");
    //insere na posicao n que é uma posição à frente do ultimo elemento da lista
    vet[n] = x.clone();
    n++;
  }

  public void inserir(Municipio x, int pos)throws Exception{
    if(n >= vet.length)
      throw new Exception("Erro ao inserir na posicao "+pos+" !");
    //empurrar elemenos à partir daquela posição para o fim do array
    for (int i = n;i > pos ; i--){
      vet[i] = vet[i-1].clone();
    }
    vet[pos] = x.clone();
    n++;
  }

  public Municipio removerInicio()throws Exception{
    if(n == 0)
      throw new Exception("Erro ao remover do inicio!");

    Municipio resp = vet[0].clone();
    n--;
    //empurrar elementos para o começo do array
    for (int i = 0; i < n; i++){
      vet[i] = vet[i+1].clone();  
    } 
    return resp;    
  }

  public Municipio removerFim()throws Exception{
    if(n == 0)
      throw new Exception("Erro ao remover do fim!");
    //retorna o último elemmento da lista
    return vet[--n];//primeiro é subtraído 1 do valor de n, depois ele é retornado
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
      return resp;
  }

  public void mostrar(){
    for (int i = 0; i < n; i++){
      vet[i].imprimir();
    }
  }

    public int isVazia() {
      if(n == 0)
        return 1;

      else
        return 0;
    }
}