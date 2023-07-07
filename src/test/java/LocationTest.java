import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import image.IMDowload;
import jsonObjects.Characters;
import jsonObjects.location.Locations;
import jsonObjects.location.Result;
import org.json.JSONObject;
import org.junit.Test;
import rest.Rest;

import java.io.IOException;

public class LocationTest {
    @Test
    public void test1() throws IOException {
        ObjectMapper om = new ObjectMapper();
        Locations location = om.readValue(Rest.getRest("https://rickandmortyapi.com/api/location"), Locations.class);
        do {
            for (Result l : location.results) {
                System.out.print(l.name+ " = " +l.type+" : ");
                for (String resident : l.residents) {
                    JSONObject object=new JSONObject(Rest.getRest(resident));
                   // System.out.print(object.getString("name")+", ");
                    IMDowload.download(object.getString("image"),object.getString("name"));
                }
                System.out.println("");
            }
            if (location.info.next != null) {
                location = om.readValue(Rest.getRest(location.info.next), Locations.class);
            }
        } while (location.info.next != null);
    }
}
