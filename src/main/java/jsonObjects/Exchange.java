package jsonObjects;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
public class Exchange {
    public int r030;
    public String txt;
    public double rate;
    public String cc;
    public String exchangedate;
}
