package com.gloablrelay.interview.dadsetan.user;
import org.apache.commons.validator.routines.EmailValidator;


public class PersonValidator {
  private Person person;

  public PersonValidator(Person person) {
    this.person = person;
  }

  public static boolean lessThan256(String str) {
    return str.length() < 256;
  }

  public static boolean nameIsValid(String name) {
    return PersonValidator.nameOnlyContainsAlphabetHyphensSpace(name)
        & PersonValidator.nameContainsAtLeastOneAlphabet(name);
  }

  public static boolean nameOnlyContainsAlphabetHyphensSpace(String name) {
    return name.matches("[a-zA-Z\\s-]+");
  }

  public static boolean nameContainsAtLeastOneAlphabet(String name) {
    return name.matches(".*[a-zA-Z]+.*");
  }

  public static boolean nonEmptyString(String string) {
    return string.length() > 0;
  }

  public static boolean isValidEmail(String email) {
    EmailValidator validator = EmailValidator.getInstance();
    return validator.isValid(email);
  }

  public boolean mandatoryFieldsAreValid() {
    boolean result = PersonValidator.nonEmptyString(person.getFirstName())
        & PersonValidator.nonEmptyString(person.getLastName()) & PersonValidator.nonEmptyString(person.getEmail());
    return result;
  }

  public boolean allFieldsAreLessThan256() {
    boolean result = true;
    result &= lessThan256(person.getAddress());
    result &= lessThan256(person.getCity());
    result &= lessThan256(person.getCompanyName());
    result &= lessThan256(person.getEmail());
    result &= lessThan256(person.getFirstName());
    result &= lessThan256(person.getLastName());
    result &= lessThan256(person.getPhone1());
    result &= lessThan256(person.getPhone2());
    result &= lessThan256(person.getPostal());
    result &= lessThan256(person.getProvince());
    result &= lessThan256(person.getWeb());
    return result;
  }

  public boolean namesAreValid() {
    return nameIsValid(person.getFirstName()) & nameIsValid(person.getLastName());
  }

  public boolean isValid() {
    return allFieldsAreLessThan256() & mandatoryFieldsAreValid() & namesAreValid() & isValidEmail(person.getEmail());
  }
}
