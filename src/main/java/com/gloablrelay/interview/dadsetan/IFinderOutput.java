package com.gloablrelay.interview.dadsetan;

import java.util.Map;
import java.util.List;

import com.gloablrelay.interview.dadsetan.user.Name;

public interface IFinderOutput{
  public void showResult(Map<Name, List<Name>> result);
}