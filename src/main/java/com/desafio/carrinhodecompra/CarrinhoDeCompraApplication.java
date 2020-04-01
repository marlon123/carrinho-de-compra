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
		String sistema_operacional = "";
		try{
			if (Objects.isNull(args) || args.length < 2) {
				mapInfo.put("Mensagem", "Faltando parâmetro");
				throw new Exception("Faltando parâmetro");
			}
			navegador = args[0].trim();
			sistema_operacional = args[1].trim();

			setup(navegador, sistema_operacional);
			executarCenarioDeTestePrincipal();
			executarCenarioDeTesteAlternativo();
			tearDown();
		}catch (Exception e){
			log.error(e.getMessage());
		}
	}

	private static void setup(String navegador, String sistema_operacional){
		log.info("***Configurando WebDriver!***");
		DriverFactory.getDriver(navegador, sistema_operacional);
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
