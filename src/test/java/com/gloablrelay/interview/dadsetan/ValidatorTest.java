package com.gloablrelay.interview.dadsetan;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.gloablrelay.interview.dadsetan.user.Person;
import com.gloablrelay.interview.dadsetan.user.PersonValidator;

/**
 * Unit test for simple App.
 */
public class ValidatorTest {
  /**
   * Rigorous Test.
   */
  @Test
  public void testLessThan256() {
    assertTrue(PersonValidator.lessThan256("ali"));
  }

  @Test
  public void testMoreThan256() {
    String moreThan256 = "";
    for (int i = 0; i < 257; i++) {
      moreThan256 += "a";
    }
    assertFalse(PersonValidator.lessThan256(moreThan256));
  }

  @Test
  public void testMandatoryFieldsValid() {
    Person person = new Person("Amineh", "Dadsetan", "", "", "", "", "", "", "", "amineh.dadsetan@gmail.com", "");
    PersonValidator personValidator = new PersonValidator(person);
    assertTrue(personValidator.mandatoryFieldsAreValid());
  }

  @Test
  public void testMandatoryFieldsInvalidLastName() {
    Person person = new Person("Amineh", "", "", "", "", "", "", "", "", "amineh.dadsetan@gmail.com", "");
    PersonValidator personValidator = new PersonValidator(person);
    assertFalse(personValidator.mandatoryFieldsAreValid());
  }

  @Test
  public void testMandatoryFieldsInvalidFirstName() {
    Person person = new Person("", "Dadsetan", "", "", "", "", "", "", "", "amineh.dadsetan@gmail.com", "");
    PersonValidator personValidator = new PersonValidator(person);
    assertFalse(personValidator.mandatoryFieldsAreValid());
  }

  @Test
  public void testMandatoryFieldsInvalidEmail() {
    Person person = new Person("Amineh", "Dadsetan", "", "", "", "", "", "", "", "", "");
    PersonValidator personValidator = new PersonValidator(person);
    assertFalse(personValidator.mandatoryFieldsAreValid());
  }

  @Test
  public void testValidNameAlphabetMuller() {
    String muller = "Müller";
    assertFalse(PersonValidator.nameIsValid(muller));
  }

  @Test
  public void testValidNameDoubleDash() {
    String name = "--";
    assertFalse(PersonValidator.nameIsValid(name));
  }

  @Test
  public void testValidNameSmithJones() {
    String name = "Smith-Jones";
    assertTrue(PersonValidator.nameIsValid(name));
  }

  @Test
  public void testValidNameHarper7() {
    String name = "Harper7";
    assertFalse(PersonValidator.nameIsValid(name));
  }

  @Test
  public void testValidNameVanGogh() {
    String name = "van Gogh";
    assertTrue(PersonValidator.nameIsValid(name));
  }

}
