package Negocio;

public class Nodo {

    int Dato;
    Nodo Enlace;

    public Nodo() {
        this.Enlace = null;
    }

    public Nodo(int Dato, Nodo Enlace) {
        this.Dato = Dato;
        this.Enlace = Enlace;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public void setEnlace(Nodo Enlace) {
        this.Enlace = Enlace;
    }

    public int getDato() {
        return Dato;
    }

    public Nodo getEnlace() {
        return Enlace;
    }

    @Override
    public String toString() {
        return (Dato + "->");
    }
}
