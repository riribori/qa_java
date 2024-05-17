import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
    public class CatTest {
    private List<String> expectedFood;
    private String soundCat;
    @Mock
    Feline feline;
    Cat cat;

    @Before
    public void setCat() {
        cat = new Cat(feline);
        expectedFood = List.of("Животные", "Птицы", "Рыба");
        soundCat = "Мяу";

    }

    @Test
    public void foodCatTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> foodCat = cat.getFood();
        assertEquals(expectedFood, foodCat);

    }

    @Test
    public void soundCatTest() {
        String actualSound = cat.getSound();
        assertEquals(soundCat, actualSound);

    }
}


