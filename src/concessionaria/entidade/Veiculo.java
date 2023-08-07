import java.text.SimpleDateFormat;
import java.util.Date;

public class Veiculo {
    private String placa;
    private String renavam;
    private String nomeCondutor;
    private String cpfCondutor;
    private String modelo;
    private Date dataFabricacao;

    public Veiculo(String placa, String renavam, String nomeCondutor, String cpfCondutor, String modelo, Date dataFabricacao) {
        this.placa = placa;
        this.renavam = renavam;
        this.nomeCondutor = nomeCondutor;
        this.cpfCondutor = cpfCondutor;
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
    }

    public Veiculo() {
        this.placa = "";
        this.renavam = "";
        this.nomeCondutor = "";
        this.cpfCondutor = "";
        this.modelo = "";
        this.dataFabricacao = new Date();
    }
    private String formatarData(Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }

    @Override
    public String toString() {
        return "Veiculo [placa=" + placa + ", renavam=" + renavam + ", nomeCondutor=" + nomeCondutor
                + ", cpfCondutor=" + cpfCondutor + ", modelo=" + modelo + ", dataFabricacao="
                + formatarData(dataFabricacao) + "]";
    }

    // Getters e Setters (mesmo código já fornecido anteriormente)
    // ...
}
