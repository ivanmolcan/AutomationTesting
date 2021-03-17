package streams;

import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Peter", "John", "Jozo", "Viktor");
        int count = 0;

//        for (int i = 0; i < names.size(); i++) {
//            String actual = names.get(i);
//            if (actual.startsWith("J")) {
//                count++;
//            }
//        }
//        System.out.println(count);

        //To iste len v jednom riadku vdaka streams
        Long c = names.stream().filter(s -> s.startsWith("J")).count();
        System.out.println(c);

        //Dalsie vytvorenie streamu
        Long d = Stream.of("Ivan", "Peter", "John", "Jozo", "Viktor").filter(s -> s.startsWith("J")).count();
        System.out.println(d);

        //Vypisanie vsetkych mien
//        names.stream().filter(s -> s.length() > 3).forEach(s -> System.out.println(s));
        names.stream().filter(s -> s.length() > 3).limit(2).forEach(s -> System.out.println(s));

        System.out.println();
        streamMap();
        System.out.println();
        streamMap2();
        System.out.println();
        streamCollect();
    }

    public static void streamMap() {

        //print names which have last letter as "r" with Uppercase
        Stream.of("Ivan", "Peter", "John", "Jozo", "Viktor").filter(s -> s.endsWith("r"))
                .map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        System.out.println();
        //print names which have first letter as "J" a with uppercase and sorted
        Stream.of("Ivan", "Peter", "John", "Jozo", "Viktor", "Jano").map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));

        System.out.println();
        List<String> names = Arrays.asList("Ivan", "Peter", "John", "Jozo", "Viktor", "Jano");
        names.stream().filter(s -> s.startsWith("J")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
    }

    public static void streamMap2() {
        List<String> names1 = Arrays.asList("Ivan", "Peter", "John", "Jozo", "Viktor", "Jano");
        List<String> names2 = Arrays.asList("Fero", "Ignac", "Jakub", "Hugo", "Arpad", "Filip", "Frantisek");

        //Spojenie dvoch streamov
        Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
        newStream.sorted().forEach(s -> System.out.print(s + ", "));
        System.out.println();

        //Anymatch vrati len true or false, Filter na druhu stranu vrati celu hodnotu s ktorou sa da dalej pracovat
        Stream<String> newStream2 = Stream.concat(names1.stream(), names2.stream());
        boolean flag = newStream2.anyMatch(s -> s.equalsIgnoreCase("Jano"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    public static void streamCollect() {

        //prehodenie stream do listu
        List<String> ls = Stream.of("Ivan", "Peter", "John", "Jozo", "Viktor").filter(s -> s.endsWith("r"))
                .map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));
        System.out.println();

        //print unique number from this array, sort it
        Stream.of(3, 2, 2, 7, 5, 1, 9, 7).distinct().sorted().forEach(s -> System.out.print(s + ", "));
        System.out.println();

        //zobrazit len treti index
        List<Integer> li = Stream.of(3, 2, 2, 7, 5, 1, 9, 7).distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(3));

    }
}
