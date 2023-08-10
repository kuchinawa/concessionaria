package concessionaria.aplicacao;

public class No<T> implements Comparable<Integer>{

    Integer renavam;
    T valor;
    Integer alturaNo;
    No<T> esq, dir;

    public No(Integer k, T v) {

        this.setRenavam(k);
        this.setValor(v);
        this.setAlturaNo(0);
        this.setEsq(null);
        this.setDir(null);
    }

    public int getAlturaNo() {
        return alturaNo;
    }

    public void setAlturaNo(int alturaNo) {
        this.alturaNo = alturaNo;
    }

    public Integer getRenavam() {
        return renavam;
    }
    public void setRenavam(Integer renavam) {
        this.renavam = renavam;
    }
    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
    public No<T> getEsq() {
        return esq;
    }
    public void setEsq(No<T> esq) {
        this.esq = esq;
    }
    public No<T> getDir() {
        return dir;
    }
    public void setDir(No<T> dir) {
        this.dir = dir;
    }

    @Override
    public int compareTo(Integer o) {
        if(this.getRenavam() < o)
            return -1;
        if(this.getRenavam() > o)
            return 1;
        return 0;
    }
}
