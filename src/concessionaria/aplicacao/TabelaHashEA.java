package concessionaria.aplicacao;

import concessionaria.entidade.Veiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabelaHashEA extends Tabela {
    private No<Veiculo>[] tabela;
    private int tamanho;
    private BufferedWriter logWriter;

    public TabelaHashEA(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new No[this.tamanho];

        try {
            logWriter = new BufferedWriter(new FileWriter("logEA.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int calcularHash(String chave) {
        return Integer.parseInt(chave) % this.tamanho;
    }

    public void inserir(Veiculo veiculo) {
        String renavam = veiculo.getRenavam();
        int hash = calcularHash(renavam);

        while(tabela[hash] != null) {
            if(tabela[hash].getChave().equals(renavam)) {
                break;
            }
            hash = (hash + 1) % tamanho;
        }
        if (tabela[hash] == null) {
            tabela[hash] = new No<>(renavam, veiculo);
        }


        registrarLog("Inserção - Renavam: " + renavam + ", Índice: " + hash + ", Fator de Carga: " + fatorDeCarga());
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        String renavam = veiculo.getRenavam();
        int hash = calcularHash(renavam);

        if (tabela[hash] == null) {
            return;
        }

        for (No <Veiculo> v : tabela) {
            if (v.getValor().getRenavam().equals(renavam)) {
                v.setValor(veiculo);
                registrarLog("Atualização - Renavam: " + renavam + ", Índice: " + hash + ", Fator de Carga: " + fatorDeCarga());
                return;
            }
        }
    }

    public String removerPorRenavam(String renavam) {
        int hash = calcularHash(renavam);

        if (tabela[hash] == null) {
            return "Veículo não encontrado.";
        }

        int i = 0;
        for (No <Veiculo> v : tabela) {
            if(v != null) {
                if (v.getValor().getRenavam().equals(renavam)) {
                    System.out.println("Removendo veículo com renavam " + v.getChave());
                    tabela[i] = null;
                    registrarLog("Remoção - Renavam: " + renavam + ", Índice: " + hash + ", Fator de Carga: " + fatorDeCarga());
                    return "Veículo removido com sucesso.";
                }

            }i++;
        }

        return "Veículo não encontrado.";
    }

    public int contarVeiculos() {
        int total = 0;

        for (int i = 0; i < tamanho; i++) {
            if (tabela[i] != null) {
                total ++;
            }
        }

        return total;
    }

    public void imprimirVeiculos() {
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Posição");
        tableModel.addColumn("Chave");
        tableModel.addColumn("Valor");

        for (int i = 0; i < this.tamanho; i++) {
            if (tabela[i] != null) {
                tableModel.addRow(new Object[]{i, tabela[i].getChave(), tabela[i].getValor()});
            } else {
                tableModel.addRow(new Object[]{i, "null", "null"});
            }
        }

        JTable table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 600));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(null, panel, "Informações da Tabela Hash", JOptionPane.INFORMATION_MESSAGE);
    }

    public Veiculo buscarPorPlacaOuRenavam(String placaOuRenavam) {
        int h = this.calcularHash(placaOuRenavam);
        while (tabela[h] != null) {
            if (tabela[h].getChave().equals(placaOuRenavam)) {
                return tabela[h].getValor();
            }
            h = (h + 1) % tamanho;
        }


        return null;
    }

    public float fatorDeCarga() {
        return (float) contarVeiculos() / tamanho;
    }

    private void registrarLog(String mensagem) {
        try {
            logWriter.write(mensagem);
            logWriter.newLine();
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
