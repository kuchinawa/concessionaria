package concessionaria.aplicacao;

import concessionaria.entidade.Veiculo;

import java.util.List;

public class Protocolo {
    Servidor servidor;
    public Protocolo() {
    }
    public void escolherServidor(int i){
        if(i == 1){
            servidor = new Servidor(new TabelaHashEE(73));
        }else if(i == 2){
            servidor = new Servidor(new TabelaHashEA(73));
        }
    }

    public void inserirVeiculo(Veiculo veiculo) {
        servidor.inserir(veiculo);
    }

    public Veiculo buscarPorPlacaouRenavam(String placarenavam) {
        return servidor.buscarPorPlacaOuRenavam(placarenavam);
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        servidor.atualizarVeiculo(veiculo);
    }

    public int contarVeiculos() {
        return servidor.contarVeiculos();
    }

    public void imprimir() {
        servidor.imprimir();
    }

    public String removerVeiculoPorRenavam(String renavam) {
        return servidor.removerPorRenavam(renavam);
    }

    public float fatorDeCarga() {
        return servidor.fatorDeCarga();
    }
}