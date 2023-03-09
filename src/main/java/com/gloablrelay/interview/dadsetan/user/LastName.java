package com.gloablrelay.interview.dadsetan.user;

import java.util.Arrays;
import java.util.List;

public class LastName {
  protected String lastName;

  public LastName(String lastName) {
    this.lastName = lastName;
  }

  public boolean isRelatedTo(LastName other) {
    List<String> otherSplitedName = other.nameSplit();
    List<String> thisSplitedName = nameSplit();
    for (String part : otherSplitedName) {
      if (thisSplitedName.contains(part)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString(){
    return this.lastName;
  }

  protected List<String> nameSplit() {
    List<String> list = Arrays.asList(lastName.split("-"));
    return list;
  }
}