package ar.edu.unlam.larsen.nicolas.p2;

public class Jugador extends Miembro{
    private Integer numeroDeCamiseta;
    private Posicion posicion;

    public Jugador(String nombreYApellido, String equipo, Integer numeroDeDocumento, Integer numeroDeCamiseta, Posicion posicion) {
        super(numeroDeDocumento, nombreYApellido, equipo);
        this.numeroDeCamiseta = numeroDeCamiseta;
        this.posicion = posicion;
    }

    public Integer getNumeroDeCamiseta() {
        return numeroDeCamiseta;
    }

    public void setNumeroDeCamiseta(Integer numeroDeCamiseta) {
        this.numeroDeCamiseta = numeroDeCamiseta;
    }


    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }



}
