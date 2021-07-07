package ar.edu.unlam.larsen.nicolas.p2;

import ar.edu.unlam.larsen.nicolas.p2.exception.JugadorNoEncontradoException;

import java.util.*;

public class Torneo {
    private Set<Miembro> miembros;
    private Set<Partido> partidos = new HashSet<Partido>();
    private List<String> goles = new LinkedList<>();

    public Torneo () {
        this.miembros = new TreeSet<>();
    }

    public boolean agregarMiembro(Miembro miembro) {
        return this.miembros.add(miembro);
    }

    public Partido registrarPartido(String equipoLocal, String equipoVisitante) {
        Partido nuevoPartido = new Partido();
        this.miembros.forEach( miembro -> {
            if(miembro instanceof Jugador) {
                Jugador jugador = (Jugador) miembro;
                if(miembro.getEquipo().equals(equipoLocal)) {
                    nuevoPartido.agregarAEquipoLocal(jugador);
                }
                else if(miembro.getEquipo().equals(equipoVisitante)) {
                    nuevoPartido.agregarAEquipoVisitante(jugador);
                }
            }
        });
        partidos.add(nuevoPartido);
        return nuevoPartido;
    }

    public boolean registrarGol(Integer numeroPartido, Integer numeroCamiseta, Equipo equipo, Integer minuto) throws JugadorNoEncontradoException {
        Partido partido = getPartidoById(numeroPartido);
        Jugador goleador = partido.bucarJugador(numeroCamiseta, equipo);
        if (goleador == null) {
            throw new JugadorNoEncontradoException();
        } else {
            this.goles.add(goleador.getNombreYApellido() + " " + minuto + " min.");
        }
        return true;
    }

    public Partido getPartidoById(Integer numeroPartido) {
        Partido partidoEncontado = null;
        for (Partido partido : this.partidos) {
            if(partido.getIdPartido() == numeroPartido){
                partidoEncontado = partido;
            }
        }
        return partidoEncontado;
    }

    public List<String> getGoles() {
        return goles;
    }

    public Equipo getEquipoGanador(Integer idPartido) {
        Partido partido = getPartidoById(idPartido);
        return partido.getEquipoGanador();
    }
}
