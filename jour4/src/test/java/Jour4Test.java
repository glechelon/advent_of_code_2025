import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class Jour4Test {

    @Test
    void test() throws IOException {

        //GIVEN
        final String cheminFichier = "src/test/resources/jddTest.txt";

        //WHEN
        final long nombreRouleauxAccessibles = Main.calculerNombreRouleauxAccessibles(cheminFichier);

        //THEN
        Assertions.assertEquals(13L, nombreRouleauxAccessibles);

    }


    @Test
    void testReel() throws IOException {

        //GIVEN
        final String cheminFichier = "src/test/resources/input.txt";

        //WHEN
        final long password = Main.calculerNombreRouleauxAccessibles(cheminFichier);

        //THEN
        System.out.println(password);
    }
}
