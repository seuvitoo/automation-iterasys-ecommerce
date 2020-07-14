package homepage;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProdutoPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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

        ProdutoPage produtoPage = homePage.clicarProduto(indice);

        String nomeProduto_produtoPage = produtoPage.obterNomeProduto();
        String precoProuto_produtoPage = produtoPage.obterPrecoProduto();

        assertThat(nomeProduto_home.toUpperCase(), is(nomeProduto_produtoPage.toUpperCase()));
        assertThat(precoProduto_home, is(precoProuto_produtoPage));
    }

    @Test
    public void testLoginComSucesso() {
        LoginPage loginPage = homePage.clicarBotaoSignIn();
        loginPage.preencherEmail("vy.santos@live.com");
        loginPage.preencherPassword("123456");
        loginPage.clicarBotaoSignIn();

        assertThat(loginPage.validaUsuarioLogado("Victor Santos"), is(true));
    }
}
