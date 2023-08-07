package concessionaria.arvoreAVL.programa;

import concessionaria.arvoreAVL.modelo.ArvoreAVL;

public class Programa {
    public static void main(String[] args) {

        ArvoreAVL avl = new ArvoreAVL();

        avl.inserir(21, "21");
        avl.inserir(24, "24");
        avl.inserir(18, "18");
        avl.inserir(19, "19");
        avl.inserir(15, "15");
        avl.inserir(12, "12");

        avl.ordem();
    }
}