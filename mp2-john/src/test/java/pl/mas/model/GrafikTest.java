package pl.mas.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class GrafikTest {

    private static final LocalDateTime HOUR_10_AM = LocalDateTime.of(2020, 12, 1, 10, 0, 0, 0);
    private static final LocalDateTime HOUR_6_PM = LocalDateTime.of(2020, 12, 1, 18, 0, 0, 0);

    @Test
    public void testGetLiczbaGodzin() {
        // Given:
        LocalDateTime start = HOUR_10_AM;
        LocalDateTime end = HOUR_6_PM;
        Grafik grafik = new Grafik(start, BigDecimal.ONE);
        grafik.setPracaDo(end);

        // When:
        Long liczbaGodzin = grafik.getLiczbaGodzin();

        // Then:
        assertThat(liczbaGodzin)
                .isNotNull()
                .isNotNegative()
                .isEqualTo(8L);
    }

    @Test
    public void testGetWynagrodzenie() {
        // Given:
        LocalDateTime start = HOUR_10_AM;
        LocalDateTime end = HOUR_6_PM;
        Grafik grafik = new Grafik(start, BigDecimal.ONE);
        grafik.setPracaDo(end);

        // When:
        BigDecimal wynagrodzenie = grafik.getWynagrodzenie();

        // Then:
        assertThat(wynagrodzenie)
                .isNotNull()
                .isEqualTo(BigDecimal.valueOf(8));
    }

    @Test
    public void testOppositeAssertion_Instruktor() {
        // Given:
        Grafik grafik = new Grafik(LocalDateTime.now(), BigDecimal.ONE);
        Instruktor instruktor = new Instruktor("Kamil", "Baleja");

        // When:
        grafik.setInstruktor(instruktor);

        // Then:
        assertThat(instruktor.getGrafik())
                .isNotEmpty()
                .containsOnly(grafik);
    }

    @Test
    public void testOppositeAssertionWhenNullGiven_Instruktor() {
        // Given:
        Grafik grafik = new Grafik(LocalDateTime.now(), BigDecimal.ONE);
        Instruktor instruktor = new Instruktor("Kamil", "Baleja");
        grafik.setInstruktor(instruktor);

        // When:
        grafik.setInstruktor(null);

        // Then:
        assertThat(instruktor.getGrafik())
                .isEmpty();
    }

    @Test
    public void testOppositeAssertionWhenChange_Instruktor() {
        // Given:
        Grafik grafik = new Grafik(LocalDateTime.now(), BigDecimal.ONE);
        Instruktor instruktor1 = new Instruktor("Kamil", "Baleja");
        Instruktor instruktor2 = new Instruktor("Adrian", "Puchacki");
        grafik.setInstruktor(instruktor1);

        // When:
        grafik.setInstruktor(instruktor2);

        // Then:
        assertThat(instruktor1.getGrafik())
                .isEmpty();
        assertThat(instruktor2.getGrafik())
                .isNotEmpty()
                .containsOnly(grafik);
    }

    @Test
    public void testOppositeAssertion_MagazynSprzetu() {
        // Given:
        Grafik grafik = new Grafik(LocalDateTime.now(), BigDecimal.ONE);
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();

        // When:
        grafik.setMagazynSprzetu(magazynSprzetu);

        // Then:
        assertThat(magazynSprzetu.getGrafik())
                .isNotEmpty()
                .containsOnly(grafik);
    }

    @Test
    public void testOppositeAssertionWhenNullGiven_MagazynSprzetu() {
        // Given:
        Grafik grafik = new Grafik(LocalDateTime.now(), BigDecimal.ONE);
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();
        grafik.setMagazynSprzetu(magazynSprzetu);

        // When:
        grafik.setMagazynSprzetu(null);

        // Then:
        assertThat(magazynSprzetu.getGrafik())
                .isEmpty();
    }

    @Test
    public void testOppositeAssertionWhenChange_MagazynSprzetu() {
        // Given:
        Grafik grafik = new Grafik(LocalDateTime.now(), BigDecimal.ONE);
        MagazynSprzetu magazynSprzetu1 = new MagazynSprzetu();
        MagazynSprzetu magazynSprzetu2 = new MagazynSprzetu();
        grafik.setMagazynSprzetu(magazynSprzetu1);

        // When:
        grafik.setMagazynSprzetu(magazynSprzetu2);

        // Then:
        assertThat(magazynSprzetu1.getGrafik())
                .isEmpty();
        assertThat(magazynSprzetu2.getGrafik())
                .isNotEmpty()
                .containsOnly(grafik);
    }

}
