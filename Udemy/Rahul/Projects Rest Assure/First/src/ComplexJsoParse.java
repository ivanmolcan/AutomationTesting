import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsoParse {

    public static void main(String[] args) {
        JsonPath js = new JsonPath(Payload.coursePrice());
        int count = js.getInt("courses.size()");
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        String title1 = js.getString("courses[0].title");

        //Print all course title
        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            if (courseTitles.equalsIgnoreCase("RPA")) {
                int courseCopies = js.get("courses[" + i + "].copies");
                System.out.println(courseCopies);
            }
        }
    }
}
