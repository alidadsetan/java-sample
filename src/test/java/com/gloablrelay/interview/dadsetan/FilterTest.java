package com.gloablrelay.interview.dadsetan;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import com.gloablrelay.interview.dadsetan.user.Name;
import com.gloablrelay.interview.dadsetan.user.Person;

class DummyPersonRepository implements IPersonRepository {
  private Person[] persons;

  public DummyPersonRepository(Person... persons) {
    this.persons = persons;
  }

  @Override
  public List<Person> getPersons() {
    return Arrays.asList(persons);
  }
}

public class FilterTest {
  /**
   * Rigorous Test.
   */
  @Test
  public void testFilter() {
    Person person1 = new Person("", "", "", "", "", "", "", "", "", "", "");
    Person person2 = new Person("Tom", "William", "", "", "", "", "", "", "", "tom.william@rautenstrauch.com", "");
    IPersonRepository repository = new DummyPersonRepository(person1, person2);
    Filter filter = new Filter(repository);
    List<Name> names = filter.getNames();
    assertTrue(names.size() == 1);
    assertTrue(names.get(0).getFirstName() == "Tom");
    assertTrue(names.get(0).getLastName().toString() == "William");
  }
}
