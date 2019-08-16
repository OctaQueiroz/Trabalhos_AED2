import java.util.ArrayList;
public class MunicipioMain{
	/*
	public static void main  (String[]args)throws Exception{
		String entrada;
		Municipio novo = new Municipio();
		entrada = MyIO.readLine();

		do{
			novo.ler(novo,entrada);
			novo.imprimir();
			entrada = MyIO.readLine();
		}while(entrada.equals("0") == false);
	}
	*/
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
		//	municipiolista[i].imprimir();
		//}
	}

	/*
	public static void main  (String[]args)throws Exception{
		String entrada;
		Municipio novo;
		ArrayList<Municipio> lista = new ArrayList<Municipio>();
		for (int i = 0; i < 5571; i++) {
			novo = new Municipio();
			lista.add(novo);
		}
		Municipio.matriciaArquivo(lista);
		do{
			lista.get(Integer.valueOf(entrada)).imprimir();
			entrada = MyIO.readLine();
		}while(entrada.equals("0") == false);
	}
	*/
	/*
	public static void main  (String[]args)throws Exception{
		String entrada;
		Municipio[] novo = new Municipio[5571];
		Municipio aux = new Municipio();
		for (int i = 0; i < 5571; i++){
			novo[i] = new Municipio();
		}
		aux.matriciaArquivo(novo);
		entrada = MyIO.readLine();
	//	for (int i = 0; i < 5571; i++){
		//	novo[i].imprimir();
		//}
	//	do{
	//		novo[Integer.valueOf(entrada)].imprimir();
		//	entrada = MyIO.readLine();
	//	}while(entrada.equals("0") == false);
	}
	*/
}
	