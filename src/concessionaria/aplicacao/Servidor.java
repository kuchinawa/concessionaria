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

    public String inserir(Veiculo veiculo) {
        arvoreVeiculos.inserir(veiculo.getRenavamInt(), veiculo);
        return "Veículo inserido com sucesso.";
    }
    public List<Veiculo> listarVeiculosEmOrdem() {
        List<Veiculo> veiculos = new ArrayList<>();
        // Use o método ordem() da árvore para percorrer e adicionar os veículos à lista
        arvoreVeiculos.ordem();
        veiculos = arvoreVeiculos.ordem();
        return veiculos;
    }
    public String remover(String revanam) {
        arvoreVeiculos.remover(Integer.parseInt(revanam));
        return "Veículo removido com sucesso.";
    }
/*
    public static void main(String[] args) {
        Servidor servidor = new Servidor();

        try {
            System.out.println(servidor.inserir(new Veiculo("123456789", "ABC1D23", "Joao", "12345678922", "kwid", 2021)));
            System.out.println(servidor.inserir(new Veiculo("123456789", "ABC1D23", "Joao", "12345678922", "kwid", 2021)));
            System.out.println(servidor.inserir(new Veiculo("582064820", "ABC1K32", "João", "12345678901", "Sedan", 2022)));
            System.out.println(servidor.inserir(new Veiculo("547021559", "DEF2G34", "Maria", "23456789012", "Hatch", 2021)));
            System.out.println(servidor.inserir(new Veiculo("973025445", "HJK3L45", "Pedro", "34567890123", "SUV", 2020)));
            System.out.println(servidor.inserir(new Veiculo("192748467", "MNB4O56", "Ana", "45678901234", "Crossover", 2019)));
            System.out.println(servidor.inserir(new Veiculo("617295837", "POI5Q67", "Carlos", "56789012345", "Sedan", 2018)));
            System.out.println(servidor.inserir(new Veiculo("840562973", "ZXC6V78", "Mariana", "67890123456", "Hatch", 2022)));
            System.out.println(servidor.inserir(new Veiculo("475916238", "ASD7F89", "Lucas", "78901234567", "SUV", 2021)));
            System.out.println(servidor.inserir(new Veiculo("216837594", "QWE8R90", "Beatriz", "89012345678", "Crossover", 2020)));
            System.out.println(servidor.inserir(new Veiculo("358614729", "TYU9I01", "Gustavo", "90123456789", "Sedan", 2019)));
            System.out.println(servidor.inserir(new Veiculo("182795346", "PLK1A12", "Fernanda", "23456789090", "Hatch", 2023)));
            System.out.println(servidor.inserir(new Veiculo("695148237", "FGH2J23", "Thiago", "34567890101", "SUV", 2022)));
            System.out.println(servidor.inserir(new Veiculo("274951386", "ZXC3K34", "Carolina", "45678901212", "Crossover", 2021)));
            System.out.println(servidor.inserir(new Veiculo("834527916", "QWE4L45", "Rafael", "56789012323", "Sedan", 2020)));
            System.out.println(servidor.inserir(new Veiculo("489632157", "ASD5M56", "Larissa", "67890123434", "Hatch", 2019)));
            System.out.println(servidor.inserir(new Veiculo("763859124", "TYU6N67", "Eduardo", "78901234545", "SUV", 2018)));
            System.out.println(servidor.inserir(new Veiculo("921674538", "PLK7O78", "Amanda", "89012345656", "Crossover", 2017)));
            System.out.println(servidor.inserir(new Veiculo("156782429", "FGH8P89", "Guilherme", "90123456767", "Sedan", 2022)));
            System.out.println(servidor.inserir(new Veiculo("349821657", "ZXC9Q90", "Sophia", "23456789078", "Hatch", 2021)));
            System.out.println(servidor.inserir(new Veiculo("567921483", "ASD1R01", "Leonardo", "34567890189", "SUV", 2020)));
            System.out.println(servidor.inserir(new Veiculo("846592371", "QWE2S12", "Isabela", "45678901290", "Crossover", 2019)));
            System.out.println(servidor.inserir(new Veiculo("238476915", "TYU3T23", "Matheus", "56789012301", "Sedan", 2018)));
            System.out.println(servidor.inserir(new Veiculo("915283764", "PLK4U34", "Julia", "67890123412", "Hatch", 2022)));
            System.out.println(servidor.inserir(new Veiculo("457132869", "FGH5V45", "Ricardo", "78901234523", "SUV", 2021)));
            System.out.println(servidor.inserir(new Veiculo("648293157", "ZXC6W56", "Aline", "89012345634", "Crossover", 2020)));
            System.out.println(servidor.inserir(new Veiculo("369574218", "QWE7X67", "Bruno", "90123456745", "Sedan", 2019)));
            System.out.println(servidor.inserir(new Veiculo("724916385", "TYU8Y78", "Laura", "23456789056", "Hatch", 2021)));
            System.out.println(servidor.inserir(new Veiculo("149682735", "PLK9Z89", "Joana", "34567890167", "SUV", 2022)));
            System.out.println(servidor.inserir(new Veiculo("836241597", "HJK0B01", "Felipe", "45678901278", "Crossover", 2023)));
            System.out.println(servidor.inserir(new Veiculo("324869571", "FGH1C02", "Bianca", "56789091234", "Sedan", 2022)));
            System.out.println(servidor.inserir(new Veiculo("927156384", "POG2D23", "Ricardo", "67890182345", "Hatch", 2021)));
            System.out.println(servidor.inserir(new Veiculo("618735294", "MNB3E34", "Mariana", "78901273456", "SUV", 2020)));
            System.out.println(servidor.inserir(new Veiculo("413269857", "TYU4F45", "Gustavo", "89012364567", "Crossover", 2019)));
            System.out.println(servidor.inserir(new Veiculo("847592631", "ZXC5G56", "Amanda", "90123455678", "Sedan", 2018)));
            System.out.println(servidor.inserir(new Veiculo("536814972", "PLK6H67", "Thiago", "12345656789", "Hatch", 2022)));
            System.out.println(servidor.inserir(new Veiculo("249681753", "ASD7I78", "Isabela", "23456747890", "SUV", 2021)));
            System.out.println(servidor.inserir(new Veiculo("751936482", "QWE8J89", "Ricardo", "34567838901", "Crossover", 2020)));
            System.out.println(servidor.inserir(new Veiculo("812547693", "FGH9K90", "Bianca", "45678929012", "Sedan", 2019)));
            System.out.println(servidor.inserir(new Veiculo("659418237", "ZXC1L01", "Mariana", "56789010123", "Hatch", 2018)));
            System.out.println(servidor.inserir(new Veiculo("437895216", "TYU2M12", "Gustavo", "67890101234", "SUV", 2022)));
            System.out.println(servidor.inserir(new Veiculo("283764951", "PLK3N23", "Amanda", "78901212345", "Crossover", 2021)));
            System.out.println(servidor.inserir(new Veiculo("941623875", "ASD4O34", "Thiago", "89012323456", "Sedan", 2020)));
            System.out.println(servidor.inserir(new Veiculo("765139284", "QWE5P45", "Isabela", "90123434567", "Hatch", 2019)));
            System.out.println(servidor.inserir(new Veiculo("526497138", "FGH6Q56", "Ricardo", "12345645678", "SUV", 2018)));
            System.out.println(servidor.inserir(new Veiculo("314782965", "ZXC7R67", "Bianca", "23456756789", "Crossover", 2022)));
            System.out.println(servidor.inserir(new Veiculo("879256314", "TYU8S78", "Mariana", "34567867890", "Sedan", 2021)));
            System.out.println(servidor.inserir(new Veiculo("692314875", "PLK9T89", "Gustavo", "45678978901", "Hatch", 2020)));
            System.out.println(servidor.inserir(new Veiculo("138457926", "ASD0U90", "Amanda", "56789089012", "SUV", 2019)));
            System.out.println(servidor.inserir(new Veiculo("417692358", "QWE1V01", "Thiago", "67890190123", "Crossover", 2018)));
            System.out.println(servidor.inserir(new Veiculo("895263412", "FGH2W12", "Isabela", "78901201234", "Sedan", 2022)));

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao inserir veículo: " + e.getMessage());
        }

        System.out.println(servidor.arvoreVeiculos.contarNos());

        System.out.println(servidor.buscarPorPlacaERenavam("ABC1D23", "123456789"));
        System.out.println(servidor.listarVeiculosEmOrdem());
       // servidor.arvoreVeiculos.ordem();

    }*/
}


