package pl.mas.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class InstruktorTest {

    @Test
    public void testOpositeAssertion_Grafik() {
        // Given:
        Instruktor instruktor = new Instruktor("Marcin", "Zielonkiewicz");
        Grafik grafik = new Grafik(LocalDateTime.now(), BigDecimal.ONE);

        // When:
        instruktor.addGrafik(grafik);

        // Then:
        assertThat(grafik.getInstruktor())
                .isNotNull()
                .isSameAs(instruktor);
    }

    @Test
    public void testOpositeAssertionWhenNullAdded_Grafik() {
        // Given:
        Instruktor instruktor = new Instruktor("Marcin", "Zielonkiewicz");

        // When:
        instruktor.addGrafik(null);

        // Then:
        assertThat(instruktor.getGrafik())
                .isEmpty();
    }

    @Test
    public void testOpositeAssertionWhenRemove_Grafik() {
        // Given:
        Instruktor instruktor = new Instruktor("Marcin", "Zielonkiewicz");
        Grafik grafik = new Grafik(LocalDateTime.now(), BigDecimal.ONE);
        instruktor.addGrafik(grafik);

        // When:
        instruktor.removeGrafik(grafik);

        // Then:
        assertThat(grafik.getInstruktor())
                .isNull();
    }

    @Test
    public void testOpositeAssertionWhenNullRemove_Grafik() {
        // Given:
        Instruktor instruktor = new Instruktor("Marcin", "Zielonkiewicz");

        // When:
        instruktor.removeGrafik(null);

        // Then:
        assertThat(instruktor.getGrafik())
                .isEmpty();
    }

    @Test
    public void testOpositeAssertion_SprzetInstruktora() {
        // Given:
        Instruktor instruktor = new Instruktor("Marcin", "Zielonkiewicz");

        // When:
        instruktor.addSprzetInstruktora("narty");

        // Then:
        assertThat(instruktor.getSprzetInstruktora())
                .isNotEmpty()
                .map(Instruktor.SprzetInstruktora::getRodzaj)
                .containsOnly("narty");
    }

    @Test
    public void testOppositeAssertionWhenNull_SprzetInstruktora() {
        // Given:
        Instruktor instruktor = new Instruktor("Marcin", "Zielonkiewicz");

        // When:
        try {
            instruktor.addSprzetInstruktora(null);
        } catch (Exception e) {

            // Then:
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Rodzaj może być tylko \"narty\" lub \"snowboard\"");
        }
    }

}
