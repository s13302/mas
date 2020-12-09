package pl.mas.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DaneOsoboweTest {

    @Test
    public void testOppositeAssertion_Wypozyczenie() {
        // Given:
        DaneOsobowe daneOsobowe = new DaneOsobowe("Marcin", "Zielonkiewicz", "AHG3820");
        Wypozyczenie wypozyczenie = new Wypozyczenie();

        // When:
        daneOsobowe.addWypozyczenie(wypozyczenie);

        // Then:
        assertThat(wypozyczenie.getDaneOsobowe())
                .isSameAs(daneOsobowe);
    }

    @Test
    public void testOppositeAssertionWhenNullGiven_Wypozyczenie() {
        // Given:
        DaneOsobowe daneOsobowe = new DaneOsobowe("Marcin", "Zielonkiewicz", "AHG3820");
        Wypozyczenie wypozyczenie = new Wypozyczenie();
        daneOsobowe.addWypozyczenie(wypozyczenie);

        // When:
        daneOsobowe.removeWypozyczenie(wypozyczenie);

        // Then:
        assertThat(wypozyczenie.getDaneOsobowe())
                .isNull();
    }

}
