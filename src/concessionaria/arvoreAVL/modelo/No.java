package concessionaria.arvoreAVL.modelo;

public class No {

    Integer chave;
    String valor;
    Integer alturaNo;
    No esq, dir;

    public No(Integer k, String v) {

        this.setChave(k);
        this.setValor(v);
        this.setAlturaNo(0);
        this.setEsq(null);
        this.setDir(null);

    }

    public Integer getChave() {
        return chave;
    }

    public void setChave(Integer chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getAlturaNo() {
        return alturaNo;
    }

    public void setAlturaNo(Integer alturaNo) {
        this.alturaNo = alturaNo;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

}
