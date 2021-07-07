package ar.edu.unlam.larsen.nicolas.p2;

public class DirectorTecnico extends Miembro{
    private Integer edad;

    public DirectorTecnico(Integer numeroDeDocumento, String nombreYApellido, String equipo, Integer edad) {
        super(numeroDeDocumento, nombreYApellido, equipo);
        this.edad = edad;
    }

}
