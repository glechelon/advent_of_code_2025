import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class Jour3Test {

    @Test
    void test() throws IOException {

        //GIVEN
        final String cheminFichier = "src/test/resources/jddTest.txt";

        //WHEN
        final long totalOutputJoltage = Main.calculerJoltageTotal(cheminFichier);

        //THEN
        Assertions.assertEquals(357, totalOutputJoltage);

    }


    @Test
    void testReel() throws IOException {

        //GIVEN
        final String cheminFichier = "src/test/resources/input.txt";

        //WHEN
        final long password = Main.calculerJoltageTotal(cheminFichier);

        //THEN
        System.out.println(password);
    }
}
