package ar.edu.unlam.larsen.nicolas.p2;

import ar.edu.unlam.larsen.nicolas.p2.exception.JugadorNoEncontradoException;

import java.util.HashSet;
import java.util.Set;

public class Partido {
    public static int id = 1;
    private int idPartido;
    private Integer golesEquipoLocal;
    private Integer getGolesEquipoVisitante;
    private Set<Jugador> equipoLocal = new HashSet<Jugador>();
    private Set<Jugador> equipoVisitante = new HashSet <Jugador>();

    public Partido() {
        idPartido = Partido.id++;
        this.golesEquipoLocal = 0;
        this.getGolesEquipoVisitante = 0;
    }

    public boolean agregarAEquipoLocal(Jugador miembro) {
        return this.equipoLocal.add(miembro);
    }

    public boolean agregarAEquipoVisitante(Jugador miembro) {
        return this.equipoVisitante.add(miembro);
    }

    public Jugador bucarJugador(Integer numeroCamiseta, Equipo equipo) throws JugadorNoEncontradoException {
        Jugador goleador = null;
        if (equipo == Equipo.Local) {
            this.golesEquipoLocal++;
            for (Jugador jugador: this.equipoLocal) {
                if( jugador.getNumeroDeCamiseta() == numeroCamiseta ) {
                    goleador = jugador;
                }
            }
        }
        if (equipo == Equipo.Visitante) {
            this.getGolesEquipoVisitante++;
            for (Jugador jugador: this.equipoVisitante) {
                if( jugador.getNumeroDeCamiseta() == numeroCamiseta ) {
                    goleador = jugador;
                }
            }
        }
        if (goleador == null) {
            throw new JugadorNoEncontradoException();
        }
        return goleador;
    }


    public Integer getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(Integer golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public Integer getGetGolesEquipoVisitante() {
        return getGolesEquipoVisitante;
    }

    public void setGetGolesEquipoVisitante(Integer getGolesEquipoVisitante) {
        this.getGolesEquipoVisitante = getGolesEquipoVisitante;
    }

    public Equipo getEquipoGanador() {
        if (this.golesEquipoLocal == this.getGolesEquipoVisitante) {
            return Equipo.Empate;
        }
        if (this.golesEquipoLocal > this.getGolesEquipoVisitante) {
            return Equipo.Local;
        }
        else return Equipo.Visitante;
    }

    public static int getId() {
        return id;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public Set<Jugador> getEquipoLocal() {
        return equipoLocal;
    }

    public Set<Jugador> getEquipoVisitante() {
        return equipoVisitante;
    }

}
