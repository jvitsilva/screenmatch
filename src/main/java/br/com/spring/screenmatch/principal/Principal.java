package br.com.spring.screenmatch.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.spring.screenmatch.model.DadosSerie;
import br.com.spring.screenmatch.model.DadosTemporada;
import br.com.spring.screenmatch.service.ConsumoApi;
import br.com.spring.screenmatch.service.ConverteDados;

public class Principal {

    Scanner input = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    private ConsumoApi consumoapi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu(){
        
        System.out.println("Digite o nome da serie para busca: ");
        String nomeSerie = input.nextLine();
        String url = ENDERECO + nomeSerie.replace(" ", "+") + API_KEY;
        var json = consumoapi.obterDados(url);
		DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for(int i = 1; i <= dadosSerie.totalTemporada(); i++){
				json = consumoapi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
				DadosTemporada dadosTemp = conversor.obterDados(json, DadosTemporada.class);
				temporadas.add(dadosTemp);
			}
        for (DadosTemporada temp : temporadas) {
            System.out.println(temp);
            System.out.println();
        }
		//temporadas.forEach(System.out::println);
    }
}
