package concessionaria.aplicacao;

import concessionaria.entidade.Veiculo;
import java.util.ArrayList;
import java.util.List;
public class Servidor {
    private ArvoreAVL<Veiculo> arvoreVeiculos;
    public Servidor() {
        arvoreVeiculos = new ArvoreAVL<>();
    }

    public Veiculo buscarPorPlacaERenavam(String placa, String renavam) {
        No<Veiculo> veiculoNo = arvoreVeiculos.buscar(Integer.parseInt(renavam));
        if (veiculoNo != null) {
            Veiculo veiculoEncontrado = veiculoNo.getValor();
            if (veiculoEncontrado.getPlaca().equals(placa)) {
                return veiculoEncontrado;
            }
        }
        return null;
    }
    public Veiculo buscarPorRenavam(String renavam) {
        int renavamInt = Integer.parseInt(renavam);
        No<Veiculo> veiculoNo = arvoreVeiculos.buscar(renavamInt);
        if (veiculoNo != null) {
            return veiculoNo.getValor();
        }
        return null;
    }
    public String inserir(Veiculo veiculo) {
        arvoreVeiculos.inserir(veiculo.getRenavamInt(), veiculo);

        return "Veículo inserido com sucesso.";
    }
    public void  listarVeiculos() {
        arvoreVeiculos.ordem();
    }
    public List<Veiculo> listarVeiculosEmOrdem() {
        List<Veiculo> veiculos = new ArrayList<>();
        listarVeiculosEmOrdem(arvoreVeiculos.getRaiz(), veiculos);
        return veiculos;
    }

    private void listarVeiculosEmOrdem(No<Veiculo> no, List<Veiculo> veiculos) {
        if (no != null) {
            listarVeiculosEmOrdem(no.getEsq(), veiculos);
            veiculos.add(no.getValor());
            listarVeiculosEmOrdem(no.getDir(), veiculos);
        }
    }
    public String remover(String revanam) {
        arvoreVeiculos.remover(Integer.parseInt(revanam));
        return "Veículo removido com sucesso.";
    }
    public void atualizarVeiculo(Veiculo veiculo) {
        arvoreVeiculos.remover(veiculo.getRenavamInt());
        arvoreVeiculos.inserir(veiculo.getRenavamInt(), veiculo);
    }

    public int contarVeiculos() {
        return arvoreVeiculos.contarNos();
    }
    public String removerPorRenavam(Integer renavam) {
        No<Veiculo> veiculoNo = arvoreVeiculos.buscarPorRenavam(renavam);
        if (veiculoNo != null) {
            arvoreVeiculos.remover(renavam);
            return "Veículo removido com sucesso.";
        }
        return "Veículo não encontrado.";
    }
    public int alturaRaizArvore() {
        return arvoreVeiculos.raiz.getAlturaNo();
    }
}


