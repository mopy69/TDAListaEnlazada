package Negocio;

import Negocio.Nodo;

public class Lista {

    Nodo L;
    int cant;

    public Lista() {
        this.L = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (L == null);
    }

    public void insertar(int ele) {
        if (vacia()) {
            Nodo p = new Nodo();
            p.setDato(ele);
            L = p;
            cant++;
        } else { //hay mas elementos
            Nodo Aux = L;
            Nodo Ant = null;
            while ((Aux != null) && (Aux.getDato() <= ele)) {
                Ant = Aux;
                Aux = Aux.getEnlace();
            }
            if (Ant == null) { //insertamos en la cabeza
                Nodo p = new Nodo();
                p.setDato(ele);
                p.setEnlace(L);
                L = p;
                cant++;
            } else {

                Nodo p = new Nodo();
                p.setDato(ele);
                Ant.setEnlace(p);
                p.setEnlace(Aux);
                cant++;

            }
        }
    }

    public void Eliminar(int ele) {
        if (!vacia()) {
            Nodo Aux = L;
            Nodo Ant = null;
            while ((Aux != null) && (Aux.getDato() != ele)) {
                Ant = Aux;
                Aux = Aux.getEnlace();
            }
            if (Aux != null) {
                if (Ant == null) {
                    L = L.getEnlace();
                    cant--;
                } else {
                    Ant.setEnlace(Aux.getEnlace());
                    cant--;
                }
            }
        }
    }

    public boolean Existe(int ele) {
        boolean x = false;
        if (!vacia()) {
            Nodo Aux = L;
            while ((Aux != null) && (Aux.getDato() != ele)) {
                Aux = Aux.getEnlace();
            }
            if (Aux != null) {
                x = true;
            }
        }
        return x;
    }

    public int getDato(int pos) {
        Nodo Aux = L;
        for (int i = 1; i <= pos; i++) {
            Aux = Aux.getEnlace();
        }
        return (Aux.getDato());
    }

    @Override
    public String toString() {
        String S = "L-> <";
        Nodo Aux = L;
        while (Aux != null) {
            S = S + Aux.getDato() + ",";
            Aux = Aux.getEnlace();
        }
        S = S + ">";
        return S;
    }

    public void invertir() {
        InvertirR(L);
    }

    private void InvertirR(Nodo p) {
        if (p == null) { //nada
        } else {
            if (p.getEnlace() == null) {//nada
                L = p;
            } else {//caso general
                InvertirR(p.getEnlace());
                p.getEnlace().setEnlace(p);
                p.setEnlace(null);
            }
        }
    }

    public void intercambiar2() {
        if (cant > 1) {
            Nodo ant = null;
            Nodo aux = L;
            L = aux.getEnlace();
            while (aux != null && aux.getEnlace() != null) { //mientras el nodo no sea nullo ni el siguiente tampoco
                Nodo siguiente = aux.getEnlace();
                Nodo siguiente2 = siguiente.getEnlace();

                siguiente.setEnlace(aux);
                aux.setEnlace(siguiente2);

                if (ant != null) {
                    ant.setEnlace(siguiente);
                }

                ant = aux;
                aux = siguiente2;
            }
        }
    }

    public void intercambiar2F() {
        if (cant > 1) {
            Nodo ant = L;
            Nodo aux = L.getEnlace();
            while (aux != null && aux.getEnlace() != null) { //mientras el nodo no sea nullo ni el siguiente tampoco
                Nodo siguiente = aux.getEnlace();
                Nodo siguiente2 = siguiente.getEnlace();

                siguiente.setEnlace(aux);
                aux.setEnlace(siguiente2);

                if (ant != null) {
                    ant.setEnlace(siguiente);
                }

                ant = aux;
                aux = siguiente2;
            }
        }
    }

    public void intercambiar3() {
        if (cant > 2) {
            Nodo ant = null;
            Nodo aux = L;
            L = aux.getEnlace();
            while (aux != null && aux.getEnlace() != null && aux.getEnlace().getEnlace() != null) { //mientras el nodo no sea nullo ni el siguiente tampoco
                Nodo siguiente = aux.getEnlace();
                Nodo siguiente2 = siguiente.getEnlace();
                Nodo siguiente3 = siguiente2.getEnlace();

                siguiente2.setEnlace(siguiente);
                siguiente.setEnlace(aux);
                aux.setEnlace(siguiente3);

                if (ant != null) {
                    ant.setEnlace(siguiente2);
                } else {
                    L = siguiente2;
                }

                ant = aux;
                aux = siguiente3;
            }
        }
    }

    public void intercambiarmedios() {
        if (cant > 2) {
            Nodo ant = null;
            Nodo aux = L;

            while (aux != null && aux.getEnlace() != null && aux.getEnlace().getEnlace() != null) { //mientras el nodo no sea nullo ni el siguiente tampoco
                Nodo med = aux.getEnlace();
                Nodo ultm = med.getEnlace();
                Nodo Otro = ultm.getEnlace();

                med.setEnlace(ultm);
                ultm.setEnlace(aux);
                aux.setEnlace(Otro);

                if (ant != null) {
                    ant.setEnlace(med);
                } else {
                    L = med;
                }

                ant = aux;
                aux = Otro;
            }
        }
    }

    public void intercambiarExtremos() {
        if (cant > 1) {
            Nodo prim = L;
            Nodo penulti = prim.getEnlace();

            while (penulti.getEnlace().getEnlace() != null) {
                penulti = penulti.getEnlace();
            }

            Nodo ult = penulti.getEnlace();

            ult.setEnlace(prim.getEnlace());
            penulti.setEnlace(prim);
            prim.setEnlace(null);
            L = ult;
        }
    }

    public void elimRepetido(int dato) {
        if (cant > 1) {
            Nodo ant = null;
            Nodo aux = L;
            while (aux.getEnlace() != null && dato != aux.getDato()) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (aux.getEnlace() != null) {
                ant = aux;
                aux = aux.getEnlace();
                while (aux.getEnlace() != null && dato == aux.getDato()) {
                    aux = aux.getEnlace();
                }
                ant.setEnlace(aux);
            }
        }
    }

    public void eliminarTodosRepe() {
        if (cant > 1) {
            Nodo ant = null;
            Nodo aux = L;
            int dato = L.getDato();
            while (aux.getEnlace() != null) {
                ant = aux;
                while (aux.getEnlace() != null && aux.getEnlace().getDato() == dato) {
                    aux = aux.getEnlace();
                    cant--;
                }

                ant.setEnlace(aux.getEnlace());
                if (aux.getEnlace() != null) {
                    aux = aux.getEnlace();
                    dato = aux.getDato();
                }
            }
        }
    }

    public void eliminarTodosRepeYRepe() {
        while (L.getEnlace() != null && L.getDato() == L.getEnlace().getDato()) {
            L = L.getEnlace();
            if (L.getEnlace() == null) {
                L = null;
            }
            cant--;
        }

        if (cant > 1) {
            Nodo ant = null;
            Nodo aux = L;
            while (aux.getEnlace() != null) {
                ant = aux;
                while (aux.getEnlace() != null && aux.getEnlace().getDato() == aux.getDato()) {
                    aux = aux.getEnlace();
                    cant--;
                }
                if (aux.getEnlace() != null) {
                    aux = aux.getEnlace();
                    ant.setEnlace(aux);
                } else {
                    ant.setEnlace(null);
                }
            }
        }

    }

    public static void main(String[] args) {
        Lista Ll = new Lista();
        Ll.insertar(2);
        Ll.insertar(2);
        Ll.insertar(2);
        Ll.insertar(2);
        Ll.insertar(1);
        Ll.insertar(5);
        Ll.insertar(6);
        Ll.insertar(6);
        Ll.insertar(6);
        Ll.insertar(6);
        Ll.insertar(3);
        Ll.insertar(4);
        System.out.println(Ll);
        //Ll.invertir();
        Ll.eliminarTodosRepeYRepe();
        System.out.println(Ll);
        //Ll.Eliminar(8);
        //Ll.Eliminar(1);
        //System.out.println(Ll);
    }
}
