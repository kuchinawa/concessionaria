package concessionaria.aplicacao;
import concessionaria.entidade.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private ArvoreAVL<Veiculo> baseDeDados;

    public Servidor() {
        baseDeDados = new ArvoreAVL<>();
    }

    public Veiculo buscarPorPlaca(String placa) {
        return baseDeDados.buscarPorPlaca(placa);
    }

    public Veiculo buscarPorRenavam(String renavam) {
        return baseDeDados.buscarPorRenavam(renavam);
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        baseDeDados.inserir(veiculo.getPlaca(), veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        baseDeDados.emOrdem(listaVeiculos::add);
        return listaVeiculos;
    }

    public void alterarVeiculo(String placa, Veiculo novoVeiculo) {
        baseDeDados.remover(placa);
        cadastrarVeiculo(novoVeiculo);
    }

    public void removerVeiculo(String placa) {
        baseDeDados.remover(placa);
    }
}
