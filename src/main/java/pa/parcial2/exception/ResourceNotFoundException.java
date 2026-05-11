package pa.parcial2.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
