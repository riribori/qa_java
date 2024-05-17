import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;


public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        feline = Mockito.spy(feline);
        Mockito.doReturn(List.of("Животные", "Птицы", "Рыба")).when(feline).getFood("Хищник");
        List<String> foodList = feline.eatMeat();
        assertNotNull(foodList);
        assertEquals(3, foodList.size());
        assertTrue(foodList.contains("Животные"));
        assertTrue(foodList.contains("Птицы"));
        assertTrue(foodList.contains("Рыба"));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testGetSpecificKittens() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(3);
        assertEquals(3, kittens);
    }

}
