import org.junit.*;
import org.junit.rules.ExpectedException;
import ua.training.Model;

public class TestModel {
    private static Model model;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @BeforeClass
    public static void runT() {
        model = new Model();
        model.setActualNumber(86);
        model.setMinNumber(0);
        model.setMaxNumber(100);
    }

    @Test
    public void testTriedNumber() {
        boolean res = model.checkTriedNumber(86);
        Assert.assertTrue(res);
    }

    @Test
    public void testSetActualNumber() {
        int res = model.setActualNumber();
        Assert.assertTrue("Less than min number", res >= model.getMinNumber());
        Assert.assertTrue("More than max number", res <= model.getMaxNumber());
    }
}
