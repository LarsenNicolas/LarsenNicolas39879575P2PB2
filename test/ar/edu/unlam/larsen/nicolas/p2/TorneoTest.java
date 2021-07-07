package ar.edu.unlam.larsen.nicolas.p2;

import ar.edu.unlam.larsen.nicolas.p2.exception.JugadorNoEncontradoException;
import org.junit.Assert;
import org.junit.Test;

public class TorneoTest {
    @Test
    public void queSePuedaCrearUnTorneoSinJugadoresRepetidos() {
        Torneo copaAmerica = new Torneo();
        Miembro jugador = new Jugador("Carlos Bueno", "Uruguay", 30303045, 5, Posicion.DEL);
        Miembro jugador1 = new Jugador("Carlos Bilardo", "Argentina", 34557815, 5, Posicion.DEF);
        Miembro jugador2 = new Jugador("Carlos Sand", "Argentina", 30303045, 5, Posicion.MED);

        Assert.assertEquals(true, copaAmerica.agregarMiembro(jugador));
        Assert.assertEquals(true, copaAmerica.agregarMiembro(jugador1));
        // Al agregar jugador 2 con mismo DNI que jugador agregarMiembro deberia devolver false.
        Assert.assertEquals(false, copaAmerica.agregarMiembro(jugador2));
    }

    @Test
    public void queSePuedaRegistrarUnPartidoConIdAutoIncrementalYQueCadaEquipoTengaSusJugadoresInscriptos() {
        Torneo copaAmerica = new Torneo();
        copaAmerica.agregarMiembro(new Jugador("Carlos Bueno", "Uruguay", 30303045, 5, Posicion.DEL));
        copaAmerica.agregarMiembro(new Jugador("Carlos Bilardo", "Argentina", 34557815, 5, Posicion.DEF));
        copaAmerica.agregarMiembro(new Jugador("Carlos Sand", "Argentina", 30301045, 5, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Suarez Luis", "Uruguay", 30303095, 5, Posicion.DEL));
        copaAmerica.agregarMiembro(new Jugador("Rivaldo", "Brasil", 30303245, 5, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Messi Lionel", "Argentina", 30303040, 5, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Riquelme Juan", "Argentina", 40303045, 5, Posicion.MED));
        copaAmerica.agregarMiembro(new DirectorTecnico(35789575, "Escaloni Lionel", "Argentina", 48));
        copaAmerica.agregarMiembro(new Jugador("Torsiglieri Pedro", "Argentina", 20303045, 5, Posicion.MED));
        copaAmerica.agregarMiembro(new DirectorTecnico(25789575, "Tabarez Maestro", "Uruguay", 48));
        copaAmerica.agregarMiembro(new Jugador("Acuna Javier", "Argentina", 35303045, 5, Posicion.DEF));

        Partido nuevoPartido = copaAmerica.registrarPartido("Argentina", "Uruguay");

        Assert.assertEquals(6,nuevoPartido.getEquipoLocal().size());
        Assert.assertEquals(2,nuevoPartido.getEquipoVisitante().size());
        Assert.assertEquals(1,nuevoPartido.getIdPartido());

        nuevoPartido = copaAmerica.registrarPartido("Brasil", "Uruguay");

        Assert.assertEquals(1,nuevoPartido.getEquipoLocal().size());
        Assert.assertEquals(2,nuevoPartido.getEquipoVisitante().size());
        Assert.assertEquals(2,nuevoPartido.getIdPartido());

    }

    @Test (expected = JugadorNoEncontradoException.class)
    public void queSepuedaRegistrarUnGolTireUnaExcepcion() throws JugadorNoEncontradoException {
        Torneo copaAmerica = new Torneo();
        copaAmerica.agregarMiembro(new Jugador("Carlos Bueno", "Uruguay", 30303045, 5, Posicion.DEL));
        copaAmerica.agregarMiembro(new Jugador("Carlos Bilardo", "Argentina", 34557815, 15, Posicion.DEF));
        copaAmerica.agregarMiembro(new Jugador("Carlos Sand", "Argentina", 30301045, 9, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Suarez Luis", "Uruguay", 30303095, 8, Posicion.DEL));
        copaAmerica.agregarMiembro(new Jugador("Rivaldo", "Brasil", 30303245, 4, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Messi Lionel", "Argentina", 30303040, 3, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Riquelme Juan", "Argentina", 40303045, 2, Posicion.MED));
        copaAmerica.agregarMiembro(new DirectorTecnico(35789575, "Escaloni Lionel", "Argentina", 48));
        copaAmerica.agregarMiembro(new Jugador("Torsiglieri Pedro", "Argentina", 20303045, 11, Posicion.MED));
        copaAmerica.agregarMiembro(new DirectorTecnico(25789575, "Tabarez Maestro", "Uruguay", 48));
        copaAmerica.agregarMiembro(new Jugador("Acuna Javier", "Argentina", 35303045, 7, Posicion.DEF));

        Partido nuevoPartido = copaAmerica.registrarPartido("Argentina", "Uruguay");

        copaAmerica.registrarGol(nuevoPartido.getIdPartido(), 999, Equipo.Local, 15);
    }

    @Test
    public void queSepuedaRegistrarUnGol() throws JugadorNoEncontradoException {
        Torneo copaAmerica = new Torneo();
        copaAmerica.agregarMiembro(new Jugador("Carlos Bueno", "Uruguay", 30303045, 5, Posicion.DEL));
        copaAmerica.agregarMiembro(new Jugador("Carlos Bilardo", "Argentina", 34557815, 15, Posicion.DEF));
        copaAmerica.agregarMiembro(new Jugador("Carlos Sand", "Argentina", 30301045, 9, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Suarez Luis", "Uruguay", 30303095, 8, Posicion.DEL));
        copaAmerica.agregarMiembro(new Jugador("Rivaldo", "Brasil", 30303245, 4, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Messi Lionel", "Argentina", 30303040, 10, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Riquelme Juan", "Argentina", 40303045, 2, Posicion.MED));
        copaAmerica.agregarMiembro(new DirectorTecnico(35789575, "Escaloni Lionel", "Argentina", 48));
        copaAmerica.agregarMiembro(new Jugador("Torsiglieri Pedro", "Argentina", 20303045, 11, Posicion.MED));
        copaAmerica.agregarMiembro(new DirectorTecnico(25789575, "Tabarez Maestro", "Uruguay", 48));
        copaAmerica.agregarMiembro(new Jugador("Acuna Javier", "Argentina", 35303045, 7, Posicion.DEF));

        Partido nuevoPartido = copaAmerica.registrarPartido("Argentina", "Uruguay");

        copaAmerica.registrarGol(nuevoPartido.getIdPartido(),10, Equipo.Local, 15);

        Assert.assertEquals("Messi Lionel 15 min.", copaAmerica.getGoles().get(0));
    }

    @Test
    public void queSeDevuelvaElEquipoGanador() throws JugadorNoEncontradoException {
        Torneo copaAmerica = new Torneo();
        copaAmerica.agregarMiembro(new Jugador("Carlos Bueno", "Uruguay", 30303045, 5, Posicion.DEL));
        copaAmerica.agregarMiembro(new Jugador("Carlos Bilardo", "Argentina", 34557815, 15, Posicion.DEF));
        copaAmerica.agregarMiembro(new Jugador("Carlos Sand", "Argentina", 30301045, 9, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Suarez Luis", "Uruguay", 30303095, 8, Posicion.DEL));
        copaAmerica.agregarMiembro(new Jugador("Rivaldo", "Brasil", 30303245, 4, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Messi Lionel", "Argentina", 30303040, 10, Posicion.MED));
        copaAmerica.agregarMiembro(new Jugador("Riquelme Juan", "Argentina", 40303045, 2, Posicion.MED));
        copaAmerica.agregarMiembro(new DirectorTecnico(35789575, "Escaloni Lionel", "Argentina", 48));
        copaAmerica.agregarMiembro(new Jugador("Torsiglieri Pedro", "Argentina", 20303045, 11, Posicion.MED));
        copaAmerica.agregarMiembro(new DirectorTecnico(25789575, "Tabarez Maestro", "Uruguay", 48));
        copaAmerica.agregarMiembro(new Jugador("Acuna Javier", "Argentina", 35303045, 7, Posicion.DEF));

        Partido nuevoPartido = copaAmerica.registrarPartido("Argentina", "Uruguay");

        copaAmerica.registrarGol(1,10, Equipo.Local, 15);
        copaAmerica.registrarGol(1,5, Equipo.Visitante, 20);
        copaAmerica.registrarGol(1,7, Equipo.Local, 80);

        Assert.assertEquals(Equipo.Local, copaAmerica.getEquipoGanador(nuevoPartido.getIdPartido()));
    }

}
