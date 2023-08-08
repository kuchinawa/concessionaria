package concessionaria.arvoreAVL.programa;


import concessionaria.aplicacao.ArvoreAVL;

public class Programa {
    public static void main(String[] args) {

        ArvoreAVL<String> avl = new ArvoreAVL<String>();

        avl.inserir(21, "21");
        avl.inserir(24, "24");
        avl.inserir(18, "18");
        avl.inserir(19, "19");
        avl.inserir(15, "15");
        avl.inserir(17, "17");
        avl.inserir(16, "16");
        avl.inserir(20, "20");
        avl.inserir(23, "23");
        avl.inserir(22, "22");
        avl.inserir(25, "25");
        //avl.inserir(12, "12");

        avl.ordem();
        avl.getRaiz();


    }
}
