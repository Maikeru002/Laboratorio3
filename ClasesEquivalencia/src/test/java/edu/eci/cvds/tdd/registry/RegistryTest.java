package edu.eci.cvds.tdd.registry;
import org.junit.Assert;
import org.junit.Test;

public class RegistryTest{

    private Registry registry = new Registry();

    @Test
    public void INVALID_AGETEST() {
        Person person = new Person("Miguel Barrera", 324012, -4, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
     
    @Test
    public void UNDERAGETEST() {
        Person person = new Person("Miguel Barrera", 324012, 4, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void DUPLICATEDTEST() {
        Person person = new Person("Miguel Barrera", 324012, 20, Gender.MALE, true);
        Person person2 = new Person("Miguel Barrera", 324012, 20, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        result = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void DEADTEST() {
        Person person = new Person("Miguel Barrera", 324012, 19, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    
    // TODO Complete with more test cases
}
