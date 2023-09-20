package concessionaria.aplicacao;

import concessionaria.entidade.Veiculo;

public class Servidor {
    private Tabela tabela;

    public Servidor(Tabela oi) {
        tabela = oi;
    }

    public void inserir(Veiculo veiculo) {
        tabela.inserir(veiculo);
    }

    public Veiculo buscarPorPlacaOuRenavam(String placaneravam){
        return tabela.buscarPorPlacaOuRenavam(placaneravam);
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        tabela.atualizarVeiculo(veiculo);
    }

    public String removerPorRenavam(String renavam) {
        return tabela.removerPorRenavam(renavam);
    }

    public int contarVeiculos() {
        return tabela.contarVeiculos();
    }

    public void imprimir() {
        tabela.imprimirVeiculos();
    }

    public float fatorDeCarga() {
        return tabela.fatorDeCarga();
    }
}
