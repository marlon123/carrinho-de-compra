package com.desafio.carrinhodecompra;

import com.desafio.carrinhodecompra.core.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.desafio.carrinhodecompra.pages.CarrinhoPage.validarSmartTVNoCarrinho;
import static com.desafio.carrinhodecompra.pages.GarantiaEstendidaPage.continuarSemGarantiaEstendida;
import static com.desafio.carrinhodecompra.pages.HomeMagazineLuizaPage.*;
import static com.desafio.carrinhodecompra.pages.ProdutoSelecionadoPage.adicionarProdutoNoCarrinho;
import static com.desafio.carrinhodecompra.pages.ResultadoBuscaPage.confirmarProdutoNaoEncontrado;

@Slf4j
public class CarrinhoDeCompraApplication {
	private static Map<String, Object> mapInfo = new HashMap();

	public static void main(String[] args) {
		log.info("***Iniciando Testes at {}***", LocalDateTime.now());
		String navegador = "";
		try{
			if (Objects.isNull(args) || args.length == 0) {
				mapInfo.put("Mensagem", "Nenhum parametro informado");
				throw new Exception("Nenhum parametro informado");
			}
			navegador = args[0].trim();

			setup(navegador);
			executarCenarioDeTestePrincipal();
			executarCenarioDeTesteAlternativo();
			tearDown();
		}catch (Exception e){
			log.error(e.getMessage());
		}
	}

	private static void setup(String navegador){
		log.info("***Configurando WebDriver!***");
		DriverFactory.getDriver(navegador);
	}

	private static void tearDown(){
		log.info("***Encerrando WebDriver!***");
		DriverFactory.killDriver();
	}

	@Test
	public static void executarCenarioDeTestePrincipal() throws Exception{
		log.info("***Cenario de teste principal iniciado com sucesso***");
		acessarHomeMagazineLuiza();
		pesquisarSmartTVDisponivel();
		confirmarProdutosEncontrados();
		selecionarSmartTVDisponivel();
		adicionarProdutoNoCarrinho();
		continuarSemGarantiaEstendida();
		validarSmartTVNoCarrinho();
		log.info("***Cenario de teste principal validado com sucesso***");
	}

	@Test
	public static void executarCenarioDeTesteAlternativo() throws Exception{
		log.info("***Cenario de teste alternativo iniciado com sucesso***");
		acessarHomeMagazineLuiza();
		pesquisarSmartTVSemEstoque();
		selecionarSmartTVSemEstoque();
		confirmarProdutoNaoEncontrado();
		log.info("***Cenario de teste alternativo validado com sucesso***");
	}

}
