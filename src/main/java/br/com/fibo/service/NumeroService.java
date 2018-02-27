package br.com.fibo.service;

import br.com.fibo.util.MensagensUtil;

public class NumeroService {

	//Array pra guardar os números da sequência de fibonacci
	private Long[] numerosFibonacci = new Long[100];

	//Método que verifica se o número existe na sequência de fibonnaci e mostra qual é o próximo
	public void numeroExiste(Long numero) {
		
		//Esse boolean é usado pra saber se o número que foi passado como parâmetro foi encontrado na sequência de fibonnaci
		boolean numeroEncontrado = false;
		
		//For para preencher o array com os números da sequência de fibonnaci
		for (int i = 0; i < 100; i++) {
			numerosFibonacci[i] = fibo(i);
		}
		
		//Esse FOR pega o número que foi passado como parâmetro e verifica se ele existe no nosso array, caso exista
		//ele adiciona a mensagem dizendo que pertence e muda o valor do boolean.
		for (int i = 0; i < numerosFibonacci.length; i++) {			
			if (numerosFibonacci[i].equals(numero)) {				
				MensagensUtil.info(
						numero + " pertence à sequência de fibonacci, o próximo número é: " + numerosFibonacci[i + 1]);
				numeroEncontrado = true;
			}
		}

		if (numeroEncontrado == false) {
			MensagensUtil.error(numero + " não pertence à sequência de fibonacci");
		}

	}

	//Método para retornar o próximo número da sequência de fibonacci. Achei na internet, n entendi muito bem como funciona e
	//também não procurei entender ;), só sei que funciona
	static Long fibo(int n) {
		Long F = (long) 0; // atual
		Long ant = (long) 0; // anterior

		for (int i = 1; i <= n; i++) {

			if (i == 1) {
				F = (long) 1;
				ant = (long) 0;
			} else {
				F += ant;
				ant = F - ant;
			}

		}

		return F;
	}
}
