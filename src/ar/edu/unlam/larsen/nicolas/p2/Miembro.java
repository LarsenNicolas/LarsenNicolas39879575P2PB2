package ar.edu.unlam.larsen.nicolas.p2;

public class Miembro implements Comparable<Miembro>{
    private Integer numeroDeDocumento;
    private String nombreYApellido;
    private String equipo;

    public Miembro(Integer numeroDeDocumento, String nombreYApellido, String equipo) {
        this.numeroDeDocumento = numeroDeDocumento;
        this.nombreYApellido = nombreYApellido;
        this.equipo = equipo;
    }


    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Miembro miembro = (Miembro) o;
        return numeroDeDocumento.equals(miembro.numeroDeDocumento);
    }

    @Override
    public int hashCode() {
        return numeroDeDocumento;
    }

    @Override
    public int compareTo(Miembro otro) {
        return this.numeroDeDocumento.compareTo(otro.numeroDeDocumento);
    }

}
