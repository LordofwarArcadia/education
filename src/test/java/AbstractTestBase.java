import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractTestBase {

    @BeforeClass
    @AfterClass
    public static void globalSetupTearDownCommonForMultipleTestSuites(){
        System.out.println("Данный метод является общим для всех классов, выполняется единожды.");
    }

    @Before
    @After
    public void globalBeforeAfterEach(){
        System.out.println("Данный метод является общим для всех тестов, выполняется для (до/после) каждого теста.");
    }
}
