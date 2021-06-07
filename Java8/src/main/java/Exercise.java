
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise {


    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Saurabh", "B", 28),
                new Person("Shalini", "C", 21),
                new Person("Nandini", "Sharma", 24)
        );

        // sort by last name
/*
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        System.out.println(people.toString());
*/

        Condition condition = (p) -> p.getFirstName().startsWith("N");

        Function<Person, String> f = (t) -> {
            if (condition.test(t))
                return t.getFirstName().toUpperCase();
            return t.getFirstName();
        };

        System.out.println(f.apply(people.get(2))); // NANDINI
        System.out.println(people.stream().map(f).collect(Collectors.toList())); // [Saurabh, Shalini, NANDINI]

        printConditionally(people, condition);  // Person: Nandini Sharma 24

        List<String> someone = people.stream()
                .map(p -> {
                        if (condition.test(p))
                            return p.getLastName();
                        return p.getFirstName();
                        }
                    ).collect(Collectors.toList());

       System.out.println(someone);  // [Saurabh, Shalini, Sharma]



    }
    private static void printConditionally(List<Person> people, Condition condition) {
        for(Person p: people) {
            if(condition.test(p))
                System.out.println(p);
        }
    }


}

@FunctionalInterface
interface Condition {
    boolean test(Person p);
}