package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.ProdutoPage;

public class HomePageTests extends BaseTests {

    @Test
    public void testContarProdutos_oitoProdutosDiferentes() {
        carregarPaginaInicial();
        assertThat(homePage.contarProdutos(), is(8));
    }

    @Test
    public void testValidaCarrinhoZerado() {
        int produtosNoCarrinho = homePage.obterQtdadeProdCarrinho();
        assertThat(produtosNoCarrinho, is(0));
    }

    @Test
    public void testValidarDetalhesDoProduto() {
        int indice = 0;
        String nomeProduto_home = homePage.obterNomeProduto(indice);
        String precoProduto_home = homePage.obterPrecoProduto(indice);
//
//        System.out.println(nomeProduto_home);
//        System.out.println(precoProduto_home);
//
//        ProdutoPage produtoPage = homePage.clicarProduto(indice);
//
//        String nomeProduto_produtoPage = produtoPage.obterNomeProduto();
//        String precoProuto_produtoPage = produtoPage.obterPrecoProduto();
//
//        System.out.println(nomeProduto_produtoPage);
//        System.out.println(precoProuto_produtoPage);
    }
}
