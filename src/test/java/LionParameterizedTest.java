import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private String sex;

    @Parameterized.Parameters
    public static Object [][] data () {
        return new Object [][] {
                {"Самец"},
                {"Самка"},
                {null},
                {"Небинарная личность"}
        };
    }

    public LionParameterizedTest (String sex) {
        this.sex = sex;

    }
    @Test
    public void doesHasMane() throws Exception  {
        if (sex != null && (sex.equals("Самец") || sex.equals("Самка")))
        {
            Lion lion = new Lion (sex, null);
            if (sex.equals("Самец"))
                assertEquals (true, lion.doesHaveMane());
            else
                assertEquals (false, lion.doesHaveMane());
        }
        else {
            Exception exception = assertThrows(Exception.class,
                    () -> new Lion(sex, null));
            Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        }

    }
}
