import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class Jour2Test {

    @Test
    void test() throws IOException {

        //GIVEN
        final String cheminFichier = "src/test/resources/jddTest.txt";

        //WHEN
        final long password = Main.calculerSommeIdInvalides(cheminFichier);

        //THEN
        Assertions.assertEquals(4174379265L, password);

    }


    @Test
    void testReel() throws IOException {

        //GIVEN
        final String cheminFichier = "src/test/resources/input.txt";

        //WHEN
        final long password = Main.calculerSommeIdInvalides(cheminFichier);

        //THEN
        System.out.println(password);
    }
}
