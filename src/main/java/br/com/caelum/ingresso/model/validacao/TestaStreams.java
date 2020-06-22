package br.com.caelum.ingresso.model.validacao;

//import java.nio.file.Files;
import java.time.Duration;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;

import br.com.caelum.ingresso.model.Filme;

public class TestaStreams {

	public static void main(String[] args) {
	
		Filme f1 = new Filme("Jogador N1", Duration.ofHours(1), "Acao");
		Filme f2 = new Filme("Matriz", Duration.ofHours(1), "Drama");
		Filme f3 = new Filme("Casamento grego", Duration.ofHours(1), "Drama");
		
		List<Filme> filmes = Arrays.asList(f1,f2,f3);

		System.out.println("Filmes: ");
		filmes.stream()
			.map(f -> f.getNome())
			.forEach(System.out::println);
		
		System.out.println("\nDramas: ");
		filmes.stream().
			filter(f -> "Drama".equals(f.getGenero()))
			.map(f -> f.getNome())
			.sorted()
			.forEach(System.out::println);

//		filmes.stream().forEach(f -> System.out.println(f.getNome()));
//		filmes.stream().map(f -> f.getNome()).forEach(listaFilmes -> System.out.println(listaFilmes));		

//						ou
		
/*		for (Filme f : filmes) {
			System.out.println(f.getNome());
		}
*/

/*
		List<Filme> dramas = new ArrayList<Filme>();
		for(Filme f : filmes) {
			if("Drama".equals(f.getGenero())) {
				dramas.add(f);
			}
		}
*/

// 					ou
		
/*		List<Filme> dramas = filmes.stream().
				filter(f -> "Drama".equals(f.getGenero()))
				.collect(Collectors.toList());
*/
		
/*		System.out.println("\nDramas: ");
		for(Filme f : dramas) {
			System.out.println(f.getNome());
		}
*/		
		
	}

}
