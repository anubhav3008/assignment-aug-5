package problem1;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    // Verify two person with same name & age are same.
    @Test
    public void Equals_TwoPersonWithSameNameAge_ShouldBeEqual(){

        Person person1 = new Person("Anubhav", 32);
        Person person2 = new Person("Anubhav", 32);

        Assert.assertTrue(person1.equals(person2));

        Assert.assertTrue(person2.equals(person1));
    }

    // Verify two person with different name & age are not same.
    @Test
    public void Equals_TwoPersonWithDifferentNameAge_ShouldNotBeEqual(){

        Person person1 = new Person("Anubhav", 32);
        Person person2 = new Person("Ajay", 40);

        Assert.assertFalse(person1.equals(person2));

        Assert.assertFalse(person2.equals(person1));
    }

    // comparison with null always gives false
    @Test
    public void Equals_CompareWithNull_ShouldNotBeEqual(){
        Person person = new Person("Anubhav", 32);
        Assert.assertFalse(person.equals(null));
    }
}
