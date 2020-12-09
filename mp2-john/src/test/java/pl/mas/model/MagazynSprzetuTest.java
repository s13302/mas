package pl.mas.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MagazynSprzetuTest {

    @Test
    public void testOppositeAssertion_Sprzet() {
        // Given:
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();
        Sprzet sprzet = new Narty("Rossignol", "AH1000", "AH1000-1010", 54.3);

        // When:
        magazynSprzetu.addSprzet(sprzet);

        // Then:
        assertThat(sprzet.getMagazyn())
                .isNotNull()
                .isSameAs(magazynSprzetu);
    }

    @Test
    public void testOppositeAssertionWhenNullAdded_Sprzet() {
        // Given:
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();

        // When:
        magazynSprzetu.addSprzet(null);

        // Then:
        assertThat(magazynSprzetu.getSprzet())
                .isEmpty();
    }

    @Test
    public void testOpossiteAssertionWhenRemove_Sprzet() {
        // Given:
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();
        Sprzet sprzet = new Narty("Rossignol", "AH1000", "AH1000-1010", 54.3);
        magazynSprzetu.addSprzet(sprzet);

        // When:
        magazynSprzetu.removeSprzet(sprzet);

        // Then:
        assertThat(sprzet.getMagazyn())
                .isNull();
    }

    @Test
    public void testOpossiteAssertionWhenRemoveNull_Sprzet() {
        // Given:
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();

        // When :
        magazynSprzetu.removeSprzet((String) null);

        // Then:
        assertThat(magazynSprzetu.getSprzet())
                .isEmpty();
    }

    @Test
    public void testOppositeAssertion_Grafik() {
        // Given:
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();
        Grafik grafik = new Grafik(LocalDateTime.now(), BigDecimal.ONE);

        // When:
        magazynSprzetu.addGrafik(grafik);

        // Then:
        assertThat(grafik.getMagazynSprzetu())
                .isNotNull()
                .isSameAs(magazynSprzetu);
    }

    @Test
    public void testOppositeAssertionWhenNullAdded_Grafik() {
        // Given:
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();

        // When:
        magazynSprzetu.addGrafik(null);

        // Then:
        assertThat(magazynSprzetu.getGrafik())
                .isEmpty();
    }

    @Test
    public void testOppositeAssertionWhenRemove_Grafik() {
        // Given:
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();
        Grafik grafik = new Grafik(LocalDateTime.now(), BigDecimal.ONE);
        magazynSprzetu.addGrafik(grafik);

        // When:
        magazynSprzetu.removeGrafik(grafik);

        // Then:
        assertThat(grafik.getMagazynSprzetu())
                .isNull();
    }

    @Test
    public void testOppositeAssertionWhenNullRemove_Grafik() {
        // Given:
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();

        // When:
        magazynSprzetu.removeGrafik(null);

        // Then:
        assertThat(magazynSprzetu.getGrafik())
                .isEmpty();
    }

}
