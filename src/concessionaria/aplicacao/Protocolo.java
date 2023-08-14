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

    public Veiculo buscarPorRenavam(String renavam) {
        return servidor.buscarPorRenavam(renavam);
    }

    public List<Veiculo> listarVeiculosEmOrdem() {
        return servidor.listarVeiculosEmOrdem();
    }

    public void listarVeiculos() {
        servidor.listarVeiculos();
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        servidor.atualizarVeiculo(veiculo);
    }

    public int contarVeiculos() {
        return servidor.contarVeiculos();
    }

    public String removerVeiculoPorRenavam(Integer renavam) {
        return servidor.removerPorRenavam(renavam);
    }
}

