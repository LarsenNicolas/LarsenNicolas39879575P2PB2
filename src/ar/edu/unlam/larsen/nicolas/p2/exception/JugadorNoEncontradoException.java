package ar.edu.unlam.larsen.nicolas.p2.exception;

@SuppressWarnings("serial")
public class JugadorNoEncontradoException extends Exception {
    public JugadorNoEncontradoException() {
        super("El jugador no fue encontrado");
    }
}
