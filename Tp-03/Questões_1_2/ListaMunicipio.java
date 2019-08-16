class ListaMunicipio{
	private Municipio[] vet;
	private int n;

	ListaMunicipio(int tamanho){
		vet = new Municipio[tamanho];
		n = 0;//quantidade de elementos na lista
	} 	

	public void InserirInicio(Municipio x)throws Exception{
		if(n >= vet.length)
			throw new Exception("Erro ao inserir no inicio!");
		//empurrar elementos para o fim do array
		for(int i = n; i > 0; i--){
			vet[i] = vet[i-1].clone();
		}	 
		vet[0] = x.clone();
		n++;
	}

	public void InserirFim(Municipio x)throws Exception{
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

	public Municipio RemoverInicio()throws Exception{
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

	public Municipio RemoverFim()throws Exception{
		if(n == 0)
			throw new Exception("Erro ao remover do fim!");
		//retorna o último elemmento da lista
		return vet[--n];//primeiro é subtraído 1 do valor de n, depois ele é retornado
	}

	public Municipio Remover(int pos)throws Exception{
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

	public void Mostrar(){
		for (int i = 0; i < n; i++){
			MyIO.println(vet[i]+"\t");
		}
	}

    public int isVazia() {
      if(n == 0)
      	return 1;

      else
      	return 0;
    }
}