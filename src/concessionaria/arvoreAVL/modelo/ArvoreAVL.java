package concessionaria.arvoreAVL.modelo;

public class ArvoreAVL {

    No raiz;

    public ArvoreAVL() {
        this.setRaiz(null);
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public void ordem() {
        this.ordem(getRaiz());
    }

    private void ordem(No a){

        if(a != null) {
            this.ordem(a.getEsq());
            System.out.println(a.getChave() + ": " + a.getValor());
            this.ordem(a.getDir());
        }

    }

    // pegar altura de um nó avl

    private Integer altura(No a) {

        if(a == null)
            return -1;

        return a.getAlturaNo();

    }

    private Integer maior(Integer a, Integer b) {

        return (a > b) ? a : b;

    }

    private Integer obterFB(No a) {

        if(a == null)
            return 0;

        return this.altura(a.getEsq()) - this.altura(a.getDir());
    }

    public void inserir(Integer k, String v) {
        this.raiz = this.inserir(getRaiz(), k, v);
    }

    private No inserir(No a, Integer k, String v) {

        if(a == null)
            return new No(k, v);

        if(k < a.chave)
            a.esq = this.inserir(a.esq, k, v);

        else if(k > a.chave)
            a.dir = this.inserir(a.dir, k, v);

        else
            return a;

        /*2. Atualiza altura do ancestral do nó inserido */

        a.alturaNo = 1 +
                this.maior(this.altura(a.getEsq()), this.altura(a.getDir()));

        /*3. Obter FB */

        int fb = this.obterFB(a);
        int fbEsq = this.obterFB(a.getEsq());
        int fbDir = this.obterFB(a.getDir());


        if(fb > 1 && fbEsq >= 0)

            return this.rds(a);

        if(fb > 1 && fbEsq < 0) {

            a.esq = this.res(a.esq);
            return rds(a);
        }

        if(fb < -1 && fbDir <= 0)

            return this.res(a);

        if(fb < -1 && fbDir > 0) {

            a.dir = this.rds(a.dir);
            return res(a);
        }

        return a;
    }

    private No res(No x) {

        No y = x.getDir();
        No z = y.getEsq();

        // executa rotação

        y.setEsq(x);
        x.setDir(z);

        x.alturaNo = 1 + this.maior(altura(x.getEsq()), altura(x.getDir()));
        y.alturaNo = 1 + this.maior(altura(y.getEsq()), altura(y.getDir()));

        return y;
    }

    private No rds(No y) {

        No x = y.getEsq();
        No z = x.getDir();

        // executa rotação

        x.setDir(y);
        y.setEsq(z);;

        y.alturaNo = 1 + this.maior(altura(y.getEsq()), altura(y.getDir()));
        x.alturaNo = 1 + this.maior(altura(x.getEsq()), altura(x.getDir()));

        return x;
    }

    /*
     * Implementar a remoção de acordo com o código da prática 4
     */

}
