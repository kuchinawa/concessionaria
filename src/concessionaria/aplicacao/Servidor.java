package concessionaria.aplicacao;
import concessionaria.entidade.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private ArvoreAVL<Veiculo> baseDeDados;

    public Servidor() {
        baseDeDados = new ArvoreAVL<>();
    }

    public Veiculo buscarPorRenavam(String renavam) {
        return baseDeDados.buscarPorRenavam(Integer.valueOf(renavam)).getValor();
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        baseDeDados.inserir(Integer.valueOf(veiculo.getPlaca()), veiculo);
    }


}
