import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */

public class CountryTest {
    /**
     * Test all countries in the country enum
     * Check if the country values are equal to the enum values
     * prob should add more if I remember
     */
    @Test
    void testAllCountries() {
        // Test country values of country enum
        assertEquals(Country.IRELAND, Country.valueOf("IRELAND"));
        assertEquals(Country.UK, Country.valueOf("UK"));
        assertEquals(Country.USA, Country.valueOf("USA"));
        assertEquals(Country.GERMANY, Country.valueOf("GERMANY"));
        assertEquals(Country.FRANCE, Country.valueOf("FRANCE"));
        assertEquals(Country.ITALY, Country.valueOf("ITALY"));
        assertEquals(Country.SPAIN, Country.valueOf("SPAIN"));
        assertEquals(Country.PORTUGAL, Country.valueOf("PORTUGAL"));
        assertEquals(Country.BRAZIL, Country.valueOf("BRAZIL"));
    }
}