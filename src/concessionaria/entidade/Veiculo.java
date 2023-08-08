package concessionaria.entidade;

public class Veiculo {

    private String placa;
    private String renavam;
    private String nomeCondutor;
    private String cpfCondutor;
    private String modelo;
    private int ano;

    public Veiculo() {
        this.placa = "";
        this.renavam = "";
        this.nomeCondutor = "";
        this.cpfCondutor = "";
        this.modelo = "";
        this.ano = 0;
    }


    public Veiculo(String placa, String renavam, String nomeCondutor, String cpfCondutor, String modelo, int ano) {
        this.placa = placa;
        this.renavam = renavam;
        this.nomeCondutor = nomeCondutor;
        this.cpfCondutor = cpfCondutor;
        this.modelo = modelo;
        setAno(ano);
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getNomeCondutor() {
        return nomeCondutor;
    }

    public void setNomeCondutor(String nomeCondutor) {
        this.nomeCondutor = nomeCondutor;
    }

    public String getCpfCondutor() {
        return cpfCondutor;
    }

    public void setCpfCondutor(String cpfCondutor) {
        this.cpfCondutor = cpfCondutor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano < 1900 || ano > 3000) {
            throw new IllegalArgumentException("Ano de fabricação inválido. O ano deve estar entre 1900 e 3000.");
        }
        this.ano = ano;
    }
    @Override
    public String toString() {
        return "Veiculo [placa=" + placa + ", renavam=" + renavam + ", nomeCondutor=" + nomeCondutor + ", cpfCondutor="
                + cpfCondutor + ", modelo=" + modelo + ", ano=" + ano + "]";
    }
}
