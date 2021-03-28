/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maratona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Erico
 */
public class P1246 {
/*
	public static void main(String[] args) throws NumberFormatException, IOException {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        StringBuffer out = new StringBuffer();
	        String entrada =null;
	        Estacionamento estacionamento = new Estacionamento(1);
	        while((entrada = in.readLine())!=null){
	        	
	        	if(entrada.equals(""))
	        		break;
	        	String dados[] = entrada.split(" ");
	        	int cumprimentoEstacionamento = Integer.parseInt(dados[0]);
	        	int nOperacoes= Integer.parseInt(dados[1]);
	        	
	        	estacionamento.reiniciarEstacionamento(cumprimentoEstacionamento);
	        	
	        	for(int i=0;i<nOperacoes;i++){
	        		dados = in.readLine().split(" ");
	        		if(dados[0].equals("C")){
	        			Carro c = new Carro(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]));
	        			estacionamento.addCarro(c);
	        		}
	        		else{
	        			estacionamento.removerCarro(Integer.parseInt(dados[1]));
	        		}
	        	}
	        	out.append(estacionamento.caixa).append("\n");
	        }
	        System.out.print(out);
	}
  */  
}


class Estacionamento{
	boolean estacionamento[] = new boolean[10000];
	int tamanhoEstacionamento;
	long caixa;
	List<Carro> carros;
	
	public Estacionamento(int tamanho){
		init(tamanho);
	}
	
	public void reiniciarEstacionamento(int tamanho){
		init(tamanho);
	}
	
	private void init(int tamanho){
		tamanhoEstacionamento = tamanho;
		
		for(int i=0; i<tamanhoEstacionamento;i++){
			estacionamento[i] = false;
		}
		caixa = 0;
		carros = new ArrayList<Carro>();
	}
	
	
	public boolean addCarro(Carro carro){
		int tamanhoDisponivel = 0;
		int indice = 0;
		int inicial=0;
		while(tamanhoDisponivel<carro.tamanho && tamanhoEstacionamento>indice){
			if(!estacionamento[indice++]){
				tamanhoDisponivel++;
			}
			else{
				tamanhoDisponivel=0;
				inicial=indice;
			}
		}
		if(tamanhoDisponivel<carro.tamanho){
			return false;
		}
		for(int i=inicial;i<(inicial+carro.tamanho);i++){
			estacionamento[i] = true;
		}
		carro.posicaoInicialEstacionado=inicial;
		carros.add(carro);
		caixa+=10;
		return true;
	}
	
	public void removerCarro(int placa){
	
		for(Carro cadaCarro: carros){
			if(cadaCarro.placa==placa){
				if(cadaCarro.posicaoInicialEstacionado!=-1){
					for(int i=cadaCarro.posicaoInicialEstacionado;i<cadaCarro.posicaoInicialEstacionado+cadaCarro.tamanho;i++){
						estacionamento[i] = false;
					}
				}
				carros.remove(cadaCarro);
				break;
			}
		}
	}
}

class Carro{
	int placa;
	int tamanho;
	int posicaoInicialEstacionado;
	public Carro(int p, int s){
		placa = p; tamanho = s;
		posicaoInicialEstacionado = -1;
	}
}
