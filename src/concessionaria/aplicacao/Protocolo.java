package concessionaria.aplicacao;

import concessionaria.entidade.Veiculo;

import java.util.List;

public class Protocolo {
    Servidor servidor = new Servidor();

    public void inserirVeiculo(Veiculo veiculo) {
        servidor.inserir(veiculo);
    }
    public Veiculo buscarPorPlacaERenavam(String placa, String renavam) {
        return servidor.buscarPorPlacaERenavam(placa, renavam);
    }

    public List<Veiculo> listarVeiculos() {
        return servidor.listarVeiculosEmOrdem();
    }
}

