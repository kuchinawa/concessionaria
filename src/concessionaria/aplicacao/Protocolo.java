package concessionaria.aplicacao;

public class Protocolo {

    public static final String SEPARADOR = "|";

    // Definição das operações possíveis
    public static final String BUSCAR = "BUSCAR";
    public static final String CADASTRAR = "CADASTRAR";
    public static final String LISTAR = "LISTAR";
    public static final String ALTERAR = "ALTERAR";
    public static final String REMOVER = "REMOVER";

    public static String criarMensagem(String operacao, String parametros) {
        return operacao + SEPARADOR + parametros;
    }

    public static String extrairOperacao(String mensagem) {
        String[] partes = mensagem.split(SEPARADOR);
        return partes[0];
    }

    public static String extrairParametros(String mensagem) {
        String[] partes = mensagem.split(SEPARADOR);
        if (partes.length > 1) {
            return partes[1];
        }
        return "";
    }
}

