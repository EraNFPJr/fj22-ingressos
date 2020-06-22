package br.com.caelum.ingresso.model.validacao;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class TestadorDeGerenciadorDeSessao {

	public static void main(String[] args) {
		
		// Teste 1
		Filme f = new Filme("Jogador N1", Duration.ofHours(1), "Acao");
		Sala s = new Sala("Sala VIP");
		Sessao sessaoNova = new Sessao(LocalTime.of(22, 00), f, s);
		List<Sessao> sessoes = new ArrayList<>();
		GerenciadorDeSessao ger = new GerenciadorDeSessao(sessoes);
		System.out.println(ger.cabe(sessaoNova) == true ? "ok" : "falha");

		// Teste 2
		f = new Filme("Jogador N1", Duration.ofHours(2), "Acao");
		s = new Sala("Sala VIP");
		sessaoNova = new Sessao(LocalTime.of(22, 0), f, s);
		sessoes = new ArrayList<>();
		ger = new GerenciadorDeSessao(sessoes);
		System.out.println(ger.cabe(sessaoNova) == false ? "ok" : "falha");
		
		// Teste 3
		f = new Filme("Jogador N1", Duration.ofHours(1), "Acao");
		s = new Sala("Sala VIP");
		sessaoNova = new Sessao(LocalTime.of(22, 0), f, s);
		Sessao sessaoAtual = new Sessao(LocalTime.of(19,0),f, s);
		sessoes = Arrays.asList(sessaoAtual);
		ger = new GerenciadorDeSessao(sessoes);
		System.out.println(ger.cabe(sessaoNova) == true ? "ok" : "falha");
		
		//Teste 4
		f = new Filme("Jogador N1", Duration.ofHours(1), "Acao");
		s = new Sala("Sala VIP");
		sessaoNova = new Sessao(LocalTime.of(22, 0), f, s);
		sessaoAtual = new Sessao(LocalTime.of(21,30),f, s);
		sessoes = Arrays.asList(sessaoAtual);
		ger = new GerenciadorDeSessao(sessoes);
		System.out.println(ger.cabe(sessaoNova) == false ? "ok" : "falha");
		
		//Teste 5
		f = new Filme("Jogador N1", Duration.ofHours(1), "Acao");
		s = new Sala("Sala VIP");
		sessaoNova = new Sessao(LocalTime.of(22, 20), f, s);
		sessaoAtual = new Sessao(LocalTime.of(20,00),f, s);
		Sessao sessaoAtualTwo = new Sessao(LocalTime.of(21,10),f, s);
		sessoes = Arrays.asList(sessaoAtual,sessaoAtualTwo);
		ger = new GerenciadorDeSessao(sessoes);
		System.out.println(ger.cabe(sessaoNova) == true ? "ok" : "falha");

		//Teste 6
		f = new Filme("Jogador N1", Duration.ofHours(1), "Acao");
		s = new Sala("Sala VIP");
		sessaoNova = new Sessao(LocalTime.of(22, 10), f, s);
		sessaoAtual = new Sessao(LocalTime.of(20,00),f, s);
		sessaoAtualTwo = new Sessao(LocalTime.of(21,10),f, s);
		sessoes = Arrays.asList(sessaoAtual,sessaoAtualTwo);
		ger = new GerenciadorDeSessao(sessoes);
		System.out.println(ger.cabe(sessaoNova) == false ? "ok" : "falha");		
		
		
	}

}
