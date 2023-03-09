package com.gloablrelay.interview.dadsetan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.gloablrelay.interview.dadsetan.user.Name;

public class RelatedFinder {
  INameRepository repository;
  IFinderOutput output;

  public RelatedFinder(INameRepository repository, IFinderOutput output) {
    this.repository = repository;
    this.output = output;
  }
  /**
 * Runs the main algorithm to find the relations
 */
  public void execute() {
    List<Name> names = repository.getNames();

    if( names == null )
    {
      System.out.println("Error in getting persons' names");
      output.showResult( null );
      return; 
    }
      

    Map<Name, List<Name>> result = new HashMap<Name, List<Name>>();
    // iterates trough the name in a nested loop to find all the related indivisuals
    // method isRelatedTo is defined in line
    for (int i =0 ; i < names.size(); i++) {
      Name name = names.get(i);
      for (int j=i+1; j < names.size(); j++) {
        Name otherName = names.get(j);
        if (otherName.getLastName().isRelatedTo(name.getLastName())) {
          if (result.get(name) == null) {
            result.put(name, new ArrayList<Name>());
          }
          result.get(name).add(otherName);
          if(result.get(otherName) == null){
            result.put(otherName, new ArrayList<Name>());
          }
          result.get(otherName).add(name);
        }
      }
    }
    // long endTime = System.nanoTime();
    // long duration = (endTime - startTime);

    output.showResult(result);
    System.out.println("result has been  written to the output file ");
  }
}
