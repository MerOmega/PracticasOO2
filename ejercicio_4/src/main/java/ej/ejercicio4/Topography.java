package ej.ejercicio4;

public abstract class Topography {


    abstract double getProportion();

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Topography topografia = (Topography) obj;
        return Double.compare(topografia.getProportion() , this.getProportion()) == 0;
    }
}
