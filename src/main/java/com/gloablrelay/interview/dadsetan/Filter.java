package com.gloablrelay.interview.dadsetan;

import java.util.List;
import java.util.function.Function;

import com.gloablrelay.interview.dadsetan.user.Name;
import com.gloablrelay.interview.dadsetan.user.Person;
import com.gloablrelay.interview.dadsetan.user.PersonValidator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter implements INameRepository {
  private IPersonRepository repository;

  public Filter(IPersonRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Name> getNames() {
    List<Person> persons = repository.getPersons();

    if( persons == null   ){
      System.out.println("persons list is null");
      return null;
    }

    Stream<Person> filteredPersonStream = persons.stream().filter(person -> {
      PersonValidator validator = new PersonValidator(person);
      return validator.isValid();
    });

    Function<Person, Name> nameAdapter = person -> new Name(person.getFirstName(), person.getLastName());

    return filteredPersonStream.map(nameAdapter).collect(Collectors.toList());
  }

}