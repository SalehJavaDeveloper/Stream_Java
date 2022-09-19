import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

//        List<Person> females = new ArrayList<>();
//        for(Person person : people){
//            if (person.getGender().equals(Gender.FEMALE)){
//                females.add(person);
//            }
//        }
//        System.out.println("Females:");
//        females.forEach(System.out::println);
//
//        List<Person> male = new ArrayList<>();
//        for(Person person: people){
//            if(person.getGender().equals(Gender.MALE)){
//                male.add(person);
//            }
//        }
//        System.out.println("Males:");
//        male.forEach(System.out::println);


        //Filter
     List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
//        females.forEach(System.out::println);

        //Sort
       List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender) .reversed())
                .collect(Collectors.toList());
//       sorted.forEach(System.out::println);

        //AllMatch
      Boolean allMatch =  people.stream()
                .allMatch(person -> person.getAge() > 8);
       // System.out.println(allMatch);

      //AnyMatch
        Boolean anyMatch =  people.stream()
                .anyMatch(person -> person.getAge() > 20);
//       // System.out.println(anyMatch);

        //noneMatch
    boolean noneMatch  =  people.stream()
                .noneMatch(person -> person.getName().equals("james Bond"));
        System.out.println(noneMatch);

        //Max
      people.stream()
                .max(Comparator.comparing(Person::getAge));
        //.ifPresent(System.out::println);

      //Min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        //Group
//      Map<Gender, List<Person>> group = people.stream()
//                .collect(Collectors.groupingBy(Person::getGender));
//      group.forEach((gender, people1) -> {
//          System.out.println(gender);
//          people1.forEach(System.out::println);
//      });

     Optional<String> oldestFemaleAge =  people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
     oldestFemaleAge.ifPresent(System.out::println);


    }

    private static List<Person> getPeople(){
        return List.of(
                new Person("james Bond",20, Gender.MALE),
                new Person("Saleh Allahverdiyev", 19, Gender.MALE),
                new Person("Alina Smith", 33,Gender.FEMALE),
                new Person("Brad Pitt", 44, Gender.MALE)
        );
    }
}
