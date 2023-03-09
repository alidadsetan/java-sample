package com.gloablrelay.interview.dadsetan.user;

public class Name {
  private String firstName;
  private LastName lastName;

  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = new LastName(lastName);
  }

  public LastName getLastName() {
    return this.lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }
}