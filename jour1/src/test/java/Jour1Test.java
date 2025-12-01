import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class Jour1Test {

    @Test
    void test() throws IOException {

        //GIVEN
        final String cheminFichier = "src/test/resources/jddTest.txt";

        //WHEN
        final long password = Main.resolvePassword(cheminFichier);

        //THEN
        Assertions.assertEquals(6L, password);

    }


    @Test
    void testReel() throws IOException {

        //GIVEN
        final String cheminFichier = "src/test/resources/input.txt";

        //WHEN
        final long password = Main.resolvePassword(cheminFichier);

        //THEN
        System.out.println(password);
    }
}
