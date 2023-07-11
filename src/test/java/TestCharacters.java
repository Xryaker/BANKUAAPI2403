import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import image.IMDowload;
import jsonObjects.Characters;
import jsonObjects.Result;
import org.json.JSONObject;
import org.junit.Test;
import rest.Rest;

public class TestCharacters {

    @Test
    public void printAllAliveCharacters() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Characters character = om.readValue(Rest.getRest("https://rickandmortyapi.com/api/character"), Characters.class);
        int i=1;
        do {
            System.out.println(character.info.next);
            for (Result l : character.results) {
                System.out.println(l.id);
            }
            if (character.info.next != null) {
                character = om.readValue(Rest.getRest(character.info.next), Characters.class);
                i++;
            }else{
                break;
            }
        } while (true);
        System.out.println("======="+i);
    }

    @Test
    public void print() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        int col = new JSONObject(Rest.getRest("https://rickandmortyapi.com/api/character")).getJSONObject("info").getInt("pages");
        for (int i = 1; i < col; i++) {
            Characters character = om.readValue(Rest.getRest("https://rickandmortyapi.com/api/character?page="+i), Characters.class);
            for (Result l : character.results) {
                if (l.status.equals("Alive")) {
                    System.out.println(l.name+"  = "+l.origin.name);

                }
            }
        }
    }
}
