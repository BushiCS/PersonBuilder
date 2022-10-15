import org.example.Person;
import org.example.PersonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {
    Person personTest = new Person("Yuriy", "Sviridov", 28, "Saint-Petersburg");
    PersonBuilder builder = new PersonBuilder();
    Person aunt = builder.name("Julia")
            .age(54)
            .surname("Roberts")
            .city("New York")
            .build();

    @Test
    @DisplayName("Test HappyBirthday()")
    public void happyBirthdayTest() {
        Assertions.assertEquals(29, personTest.happyBirthday());
        Assertions.assertEquals(55, aunt.happyBirthday());
    }

    @Test
    @DisplayName("Test hasAge()")
    public void hasAgeTest() {
        Assertions.assertTrue(personTest.hasAge());
    }

    @Test
    @DisplayName("test builder()")
    public void buildTest() {
        Assertions.assertThrows(IllegalStateException.class, () -> new PersonBuilder().name("Test").surname("surTest").build());
    }

    @Test
    @DisplayName("Test correct age")
    public void getAgeTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PersonBuilder().name("Test").surname("surTest").age(-5).city("cityTest").build());
    }

    @Test
    @DisplayName("Test hasAddress()")
    public void hasAddressTest() {
        Assertions.assertTrue(personTest.hasAddress());

    }

    @Test
    @DisplayName("Test newChildBuilder()")
    public void newChildBuilder() {
        Assertions.assertEquals(new PersonBuilder().surname("Sviridov").city("Saint-Petersburg"), personTest.newChildBuilder());
    }
}

