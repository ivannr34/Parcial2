package pa.parcial2.util;
import pa.parcial2.modelo.Categoria;

public class CategoriaUtil {

    public static Categoria calcularCategoria(Integer edad) {

        if (edad == 7) return Categoria.PRE_BENJAMIN;
        if (edad >= 8 && edad <= 9) return Categoria.BENJAMIN;
        if (edad >= 10 && edad <= 11) return Categoria.ALEVIN;
        if (edad >= 12 && edad <= 13) return Categoria.INFANTIL;
        if (edad >= 14 && edad <= 15) return Categoria.CADETE;
        if (edad >= 16 && edad <= 17) return Categoria.JUVENIL;
        if (edad >= 18 && edad <= 19) return Categoria.JUNIOR;
        if (edad >= 20 && edad <= 23) return Categoria.SUB23;
        if (edad >= 24 && edad <= 39) return Categoria.ABSOLUTA;
        if (edad >= 40 && edad <= 49) return Categoria.VETERANO1;
        if (edad >= 50 && edad <= 59) return Categoria.VETERANO2;

        return Categoria.VETERANO3;
    }
}