package com.gloablrelay.interview.dadsetan;

import java.util.List;
import java.util.Map;

import com.gloablrelay.interview.dadsetan.user.Name;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileFinderOutput implements IFinderOutput {
  private String outputPath;

  public FileFinderOutput(String outputPath) {
    this.outputPath = outputPath;
  }

  @Override
  public void showResult(Map<Name, List<Name>> result) {
    Path path = Paths.get(outputPath);
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
      String output = contentFormatter(result);
      writer.append(output);
      writer.close();
    } catch (IOException ex) {
      // TODO

      ex.printStackTrace();
    }
  }

  private static String contentFormatter(Map<Name, List<Name>> output) {
    String result = "";
    for (Map.Entry<Name, List<Name>> entry : output.entrySet()) {
      result = result.concat(getEntryLine(entry));
    }
    result = removeLastCharachter(result);
    return result;
  }

  private static String getEntryLine(Map.Entry<Name, List<Name>> entry) {
    String result = "";
    Name subject = entry.getKey();
    result = result.concat(subject.getFirstName() + " ");
    result = result.concat(subject.getLastName().toString() + ":");
    for (Name related : entry.getValue()) {
      result = result.concat(" " + related.getFirstName() + " " + related.getLastName().toString() + ",");
    }
    result = removeLastCharachter(result);
    result = result.concat("\n");
    return result;
  }

  private static String removeLastCharachter(String string) {
    if (string != null && string.length() > 0) {
      string = string.substring(0, string.length() - 1);
    }
    return string;
  }
}