package concessionaria.aplicacao;


import concessionaria.entidade.Veiculo;

import java.util.List;

public class ArvoreAVL<T> {

    No<T> raiz;

    public ArvoreAVL() {
        this.setRaiz(null);
    }

    public No<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(No<T> raiz) {
        this.raiz = raiz;
    }

    public void ordem() {
        this.ordem(getRaiz());
    }

    private void ordem(No<T> a) {
        if (a != null) {
            this.ordem(a.getEsq());
            System.out.println(a.getChave() + ": " + a.getValor());
            this.ordem(a.getDir());
        }
    }
    private Integer altura(No<T> a) {
        if (a == null)
            return -1;
        return a.alturaNo;
    }

    private Integer maior(Integer a, Integer b) {
        return (a > b) ? a : b;
    }

    private Integer obterFB(No<T> a) {
        if (a == null)
            return 0;
        return this.altura(a.getEsq()) - this.altura(a.getDir());
    }

    private No<T> res(No<T> x) {
        No<T> y = x.getDir();
        No<T> z = y.getEsq();
        // executa rotação
        y.setEsq(x);
        x.setDir(z);
        x.alturaNo = 1 + this.maior(altura(x.getEsq()), altura(x.getDir()));
        y.alturaNo = 1 + this.maior(altura(y.getEsq()), altura(y.getDir()));
        return y;
    }

    private No<T> rds(No<T> y) {
        No<T> x = y.getEsq();
        No<T> z = x.getDir();
        // executa rotação
        x.setDir(y);
        y.setEsq(z);
        ;
        y.alturaNo = 1 + this.maior(altura(y.getEsq()), altura(y.getDir()));
        x.alturaNo = 1 + this.maior(altura(x.getEsq()), altura(x.getDir()));
        return x;
    }

    private No<T> menorChave(No<T> arv) {
        No<T> temp = arv;

        if (temp == null)
            return null;

        while (temp.getEsq() != null)
            temp = temp.getEsq();

        return temp;
    }

    public void inserir(Integer k, T v) {
        this.raiz = this.inserir(getRaiz(), k, v);
    }

    private No<T> inserir(No<T> a, Integer k, T v) {
        if (a == null)
            return new No<T>(k, v);
        if (a.compareTo(k) > 0)
            a.esq = this.inserir(a.getEsq(), k, v);
        else if (a.compareTo(k) < 0)
            a.dir = this.inserir(a.getDir(), k, v);
        else
            return a;
        /* 2. Atualiza altura do ancestral do nó inserido */
        a.alturaNo = 1 + this.maior(this.altura(a.getEsq()), this.altura(a.getDir()));
        /* 3. Obter FB */
        int fb = this.obterFB(a);
        int fbEsq = this.obterFB(a.getEsq());
        int fbDir = this.obterFB(a.getDir());

        if (fb > 1 && fbEsq >= 0)
            return this.rds(a);
        if (fb > 1 && fbEsq < 0) {
            a.esq = this.res(a.esq);
            return rds(a);
        }

        if (fb < -1 && fbDir <= 0)
            return this.res(a);
        if (fb < -1 && fbDir > 0) {
            a.dir = this.rds(a.dir);
            return res(a);
        }
        return a;
    }
    public void remover(Integer k) {
        raiz = remover(raiz, k);
    }

    private No<T> remover(No<T> arv, Integer k) {
        if (arv == null)
            return arv;

        if (k < arv.getChave())
            arv.setEsq(remover(arv.getEsq(), k));
        else if (k > arv.getChave())
            arv.setDir(remover(arv.getDir(), k));
        else {
            if (arv.getEsq() == null && arv.getDir() == null) {
                arv = null;
            } else if (arv.getEsq() == null) {
                No<T> temp = arv;
                arv = temp.getDir();
                temp = null;
            } else if (arv.getDir() == null) {
                No<T> temp = arv;
                arv = temp.getEsq();
                temp = null;
            } else {
                No<T> temp = menorChave(arv.getDir());
                arv.setChave(temp.getChave());
                arv.setValor(temp.getValor());
                temp.setChave(k);
                arv.setDir(remover(arv.getDir(), k));
            }
        }

        if (arv == null)
            return arv;

        arv.setAlturaNo(1 + maior(altura(arv.getEsq()), altura(arv.getDir())));

        int fb = obterFB(arv);
        int fbSubArvEsq = obterFB(arv.getEsq());
        int fbSubArvDir = obterFB(arv.getDir());

        if (fb > 1 && fbSubArvEsq >= 0)
            return rds(arv);

        if (fb < -1 && fbSubArvDir <= 0)
            return res(arv);

        if (fb > 1 && fbSubArvEsq < 0) {
            arv.setEsq(res(arv.getEsq()));
            return rds(arv);
        }

        if (fb < -1 && fbSubArvDir > 0) {
            arv.setDir(rds(arv.getDir()));
            return res(arv);
        }

        return arv;
    }
    public No<T> buscar(Integer k) {
        return buscar(getRaiz(), k);
    }

    private No<T> buscar(No<T> r, Integer k) {
        if (r == null)
            return null;

        else if (k.compareTo(r.getChave()) < 0)
            return this.buscar(r.getEsq(), k);

        else if (k.compareTo(r.getChave()) > 0)
            return this.buscar(r.getDir(), k);

        else
            return r;
    }

    public int contarNos() {
        return contarNos(getRaiz());
    }

    private int contarNos(No<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsq()) + contarNos(no.getDir());
    }


    public No<T> buscarPorRenavam(Integer renavam) {
        System.out.println();
        return buscarPorRenavam(getRaiz(), renavam);
    }

    private No<T> buscarPorRenavam(No<T> no, Integer renavam) {
        if (no == null) {
            return null;
        }
        int comparacao = renavam.compareTo(no.getChave());
        if (comparacao == 0) {
            return no;
        } else if (comparacao < 0) {
            return buscarPorRenavam(no.getEsq(), renavam);
        } else {
            return buscarPorRenavam(no.getDir(), renavam);
        }
    }
}