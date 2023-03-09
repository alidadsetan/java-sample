package com.gloablrelay.interview.dadsetan;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.gloablrelay.interview.dadsetan.user.LastName;

/**
 * Unit test for simple App.
 */
public class LastNameTest {

  @Test
  public void testSimpleMismatch() {
    LastName lastName1 = new LastName("William");
    LastName lastName2 = new LastName("Williams");
    assertFalse(lastName1.isRelatedTo(lastName2));
  }

  @Test
  public void testSimpleMatch() {
    LastName lastName1 = new LastName("William");
    LastName lastName2 = new LastName("William");
    assertTrue(lastName1.isRelatedTo(lastName2));
  }

  @Test
  public void testOtherHypenedMatch() {
    LastName lastName1 = new LastName("William");
    LastName lastName2 = new LastName("William-Scott");
    assertTrue(lastName1.isRelatedTo(lastName2));
  }

  @Test
  public void testThisHypenedMatch() {
    LastName lastName1 = new LastName("William-Scott");
    LastName lastName2 = new LastName("William");
    assertTrue(lastName1.isRelatedTo(lastName2));
  }

  @Test
  public void testBothHypenedMatch() {
    LastName lastName1 = new LastName("William-Scott");
    LastName lastName2 = new LastName("Scott-Jones");
    assertTrue(lastName1.isRelatedTo(lastName2));
  }
}
