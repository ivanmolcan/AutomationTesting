import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("d/MM/yyyy hh:mm:ss");
        System.out.println(d.toString());
        System.out.println(sd.format(d));
        System.out.println();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sd2 = new SimpleDateFormat("d/M/yyyy hh:mm:ss");
        System.out.println(sd2.format(cal.getTime()));
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));

        //ArrayList
        

    }
}
