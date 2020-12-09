package pl.mas.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SprzetTest {

    @Test
    public void testOppositeAssertion_MagazynSprzetu() {
        // Given:
        Sprzet sprzet = new Narty("Rossignol", "AH1000", "AH1000-1010", 54.3);
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();

        // When:
        sprzet.setMagazyn(magazynSprzetu);

        // Then:
        assertThat(magazynSprzetu.getSprzet())
                .containsOnly(sprzet);
    }

    @Test
    public void testOppositeAssertionWhenChangeToNull_MagazynSprzetu() {
        // Given:
        Sprzet sprzet = new Narty("Rossignol", "AH1000", "AH1000-1010", 54.3);
        MagazynSprzetu magazynSprzetu = new MagazynSprzetu();
        sprzet.setMagazyn(magazynSprzetu);

        // When:
        sprzet.setMagazyn(null);

        // Then:
        assertThat(magazynSprzetu.getSprzet())
                .isEmpty();
    }

    @Test
    public void testOppositeAssertionWhenChange_MagazynSprzetu() {
        // Given:
        Sprzet sprzet = new Narty("Rossignol", "AH1000", "AH1000-1010", 54.3);
        MagazynSprzetu magazynSprzetu1 = new MagazynSprzetu();
        MagazynSprzetu magazynSprzetu2 = new MagazynSprzetu();
        sprzet.setMagazyn(magazynSprzetu1);

        // When:
        sprzet.setMagazyn(magazynSprzetu2);

        // Then:
        assertThat(magazynSprzetu1.getSprzet())
                .isEmpty();
        assertThat(magazynSprzetu2.getSprzet())
                .containsOnly(sprzet);
    }
}
