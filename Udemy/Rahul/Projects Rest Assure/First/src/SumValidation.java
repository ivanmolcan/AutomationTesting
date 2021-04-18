import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class SumValidation {

    @Test
    public void sumValidation() {
        JsonPath js = new JsonPath(Payload.coursePrice());
        int count = js.getInt("courses.size()");

        for (int i = 0; i < count; i++) {
            int price = js.getInt("courses[" + i + "].price");
            int copies = js.getInt("courses[" + i + "].copies");
            int amount = price * copies;
            System.out.println(amount);
        }
    }
}
