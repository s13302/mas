package pl.mas.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WypozyczenieTest {

    @Test
    public void testOppositeAssertion_DaneOsobowe() {
        // Given:
        DaneOsobowe daneOsobowe = new DaneOsobowe("Marcin", "Zielonkiewicz", "GHA88888");
        Wypozyczenie wypozyczenie = new Wypozyczenie();

        // When:
        wypozyczenie.setDaneOsobowe(daneOsobowe);

        // Then:
        assertThat(daneOsobowe.getWypozyczenia())
                .containsOnly(wypozyczenie);
    }

    @Test
    public void testOppositeAssertionWhenNullGiven_DaneOsobowe() {
        // Given:
        DaneOsobowe daneOsobowe = new DaneOsobowe("Marcin", "Zielonkiewicz", "GHA88888");
        Wypozyczenie wypozyczenie = new Wypozyczenie(daneOsobowe);

        // When:
        wypozyczenie.setDaneOsobowe(null);

        // Then:
        assertThat(daneOsobowe.getWypozyczenia())
                .isEmpty();
    }

    @Test
    public void testOppositeAssertionWhenChange_DaneOsobowe() {
        // Given:
        DaneOsobowe daneOsobowe1 = new DaneOsobowe("Marcin", "Zielonkiewicz", "GHA88888");
        DaneOsobowe daneOsobowe2 = new DaneOsobowe("Karol", "Polak", "TT8292");
        Wypozyczenie wypozyczenie = new Wypozyczenie(daneOsobowe1);

        // When:
        wypozyczenie.setDaneOsobowe(daneOsobowe2);

        // Then:
        assertThat(daneOsobowe2.getWypozyczenia())
                .containsOnly(wypozyczenie);
    }

}
