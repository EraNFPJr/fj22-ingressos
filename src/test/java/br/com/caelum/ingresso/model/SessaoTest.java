package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {

	private Filme filme;
	private Sala sala;
	private Lugar a1, a2, a3;
	private Sessao sessao;
	
	@Before
	public void preparaSessoes() {
		this.filme = new Filme("Rogue One",Duration.ofMinutes(120), "SCI-FI", BigDecimal.ONE);
		this.sala = new Sala("Eldorado - IMax", new BigDecimal("22.5"));
		this.sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		this.a1 = new Lugar("A", 1);
		this.a2 = new Lugar("A", 2);
		this.a3 = new Lugar("A", 3);
	}	
	
	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme() {
		BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
		Assert.assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());
	}

	@Test
	public void garanteQueOLugarA1EstaOcupadoEOsLugaresA2EA3Disponiveis() {
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO, a1);
		Set<Ingresso> ingressos = Stream.of(ingresso).collect(Collectors.toSet());
		
		sessao.setIngressos(ingressos);
		
		Assert.assertFalse(sessao.isDisponivel(a1));
		Assert.assertTrue(sessao.isDisponivel(a2));
		Assert.assertTrue(sessao.isDisponivel(a3));
	}

}
