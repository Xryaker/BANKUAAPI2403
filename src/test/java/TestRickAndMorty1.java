import org.json.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.Rest;

public class TestRickAndMorty1 {
    static JSONObject jsonObject = null;

    @BeforeClass
    public static void b() {
        Assert.assertEquals(200,Rest.getStatuseCode("https://rickandmortyapi.com/api"));
            jsonObject = new JSONObject(Rest.getRest("https://rickandmortyapi.com/api"));

    }

    @Test
    public void test1() {
        Assert.assertEquals(200,Rest.getStatuseCode(jsonObject.getString("characters")));
    }
    @Test
    public void test2() {
        Assert.assertEquals(200,Rest.getStatuseCode(jsonObject.getString("locations")));
    }
    @Test
    public void test3() {
        Assert.assertEquals(200,Rest.getStatuseCode(jsonObject.getString("episodes")));
    }
}
