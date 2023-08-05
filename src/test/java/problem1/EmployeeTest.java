package problem1;


import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

    // Verify two employees with same name, age and role are same
    @Test
    public void Equals_TwoEmployeesWithSameNameAgeRole_ShouldBeEqual(){

        Employee employee1 = new Employee("Anubhav", 32, "SDE");
        Employee employee2 = new Employee("Anubhav", 32, "SDE");

        Assert.assertTrue(employee1.equals(employee2));

        Assert.assertTrue(employee2.equals(employee1));
    }

    // Verify two employees with DIFFERENT name, age and role are same
    @Test
    public void Equals_TwoEmployeesWithDifferentNameAgeRole_ShouldNotBeEqual(){

        Employee employee1 = new Employee("Abhinav", 35, "QA");
        Employee employee2 = new Employee("Anubhav", 32, "SDE");

        Assert.assertFalse(employee1.equals(employee2));

        Assert.assertFalse(employee2.equals(employee1));
    }

    // Different data types should not be equal
    @Test
    public void Equals_DifferentDataType_ShouldNotBeEqual(){
        Person person = new Person("Anubhav", 31);
        Employee employee = new Employee("Anubhav", 31, null);

        Assert.assertFalse(person.equals(employee));
        Assert.assertFalse(employee.equals(person));
    }

    // comparison with null always gives false
    @Test
    public void Equals_CompareWithNull_ShouldNotBeEqual(){
        Employee employee = new Employee("Anubhav", 31, "SDE");
        Assert.assertFalse(employee.equals(null));
    }
}
