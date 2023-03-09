package com.gloablrelay.interview.dadsetan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.awaitility.Awaitility.await;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.apache.commons.collections4.CollectionUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gloablrelay.interview.dadsetan.user.Name;

class DummyNameRepository implements INameRepository {
  private Name[] names;

  public DummyNameRepository(Name... names) {
    this.names = names;
  }

  @Override
  public List<Name> getNames() {
    return Arrays.asList(names);
  }
}

public class FinderTest {
  private boolean twoRelatedPersonsIsFinishedFlag = false;
  private boolean bigAcceptancyIsFinishedFlag = false;

  private boolean bigAcceptancyTestIsAccepted() {
    return bigAcceptancyIsFinishedFlag;
  }

  private void acceptBigAcceptancyTest() {
    bigAcceptancyIsFinishedFlag = true;
  }

  private boolean twoRelatedPersonsTestIsFinished() {
    return twoRelatedPersonsIsFinishedFlag;
  }

  private void endTwoRelatedPersonsTest() {
    twoRelatedPersonsIsFinishedFlag = true;
  }

  @Test
  public void testTwoRelatedPersons() {
    Name tom = new Name("Tom", "William");
    Name xavier = new Name("Xavier", "William-Scott");

    INameRepository repository = new DummyNameRepository(tom, xavier);

    class DummyFinderOutput implements IFinderOutput {

      @Override
      public void showResult(Map<Name, List<Name>> result) {
        Map<Name, List<Name>> expected = new HashMap<Name, List<Name>>();
        expected.put(tom, Arrays.asList(xavier));
        expected.put(xavier, Arrays.asList(tom));
        assertEquals(expected, result);
        endTwoRelatedPersonsTest();
      }
    }

    RelatedFinder relatedFinder = new RelatedFinder(repository, new DummyFinderOutput());
    relatedFinder.execute();
    await().atMost(1, SECONDS).until(() -> {
      return twoRelatedPersonsTestIsFinished();
    });
  }

  @Test
  public void testBigAcceptancy() {

    Name tom = new Name("Tom", "William");
    Name xavier = new Name("Xavier", "William-Scott");
    Name antonio = new Name("Antonio", "William");
    Name jake = new Name("Jake", "Scott-William");
    Name emily = new Name("Emily", "Scott-Jones");
    Name mary = new Name("Mary", "Williams");

    INameRepository repository = new DummyNameRepository(tom, xavier, antonio, jake, emily, mary);

    class DummyFinderOutput implements IFinderOutput {

      @Override
      public void showResult(Map<Name, List<Name>> result) {
        assertTrue(CollectionUtils.isEqualCollection(result.get(tom), Arrays.asList(xavier, antonio, jake)));
        assertTrue(CollectionUtils.isEqualCollection(result.get(xavier), Arrays.asList(tom, antonio, jake, emily)));
        assertTrue(CollectionUtils.isEqualCollection(result.get(antonio), Arrays.asList(tom, xavier, jake)));
        assertTrue(CollectionUtils.isEqualCollection(result.get(jake), Arrays.asList(tom, xavier, antonio, emily)));
        assertTrue(CollectionUtils.isEqualCollection(result.get(emily), Arrays.asList(xavier, jake)));

        assertFalse(result.containsKey(mary));

        acceptBigAcceptancyTest();
      }
    }

    RelatedFinder relatedFinder = new RelatedFinder(repository, new DummyFinderOutput());
    relatedFinder.execute();

    await().atMost(1, SECONDS).until(() -> {
      return bigAcceptancyTestIsAccepted();
    });
  }

}
