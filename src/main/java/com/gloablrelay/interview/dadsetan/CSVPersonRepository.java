package com.gloablrelay.interview.dadsetan;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

import com.gloablrelay.interview.dadsetan.user.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVPersonRepository implements IPersonRepository {
  private String filePath;

  public CSVPersonRepository(String filePath) {
    this.filePath = filePath;
  }

  /**
 * Returns an Image object that can then be painted on the screen. 
 * Read and parse CSV file
 * return a list of persons's information if possible, null otherwise
 */
  @Override
  public List<Person> getPersons() {
    try {
      Reader reader = Files.newBufferedReader(Paths.get(filePath));
      CSVParser csvParser = new CSVParser(reader,
          CSVFormat.DEFAULT.withHeader("first_name", "last_name", "company_name", "address", "city", "province",
              "postal", "phone1", "phone2", "email", "web").withFirstRecordAsHeader());

      List<Person> result = new ArrayList<Person>();
      for (CSVRecord csvRecord : csvParser) {
        String first_name = csvRecord.get("first_name");
        String last_name = csvRecord.get("last_name");
        String company_name = csvRecord.get("company_name");
        String address = csvRecord.get("address");
        String city = csvRecord.get("city");
        String province = csvRecord.get("province");
        String postal = csvRecord.get("postal");
        String phone1 = csvRecord.get("phone1");
        String phone2 = csvRecord.get("phone2");
        String email = csvRecord.get("email");
        String web = csvRecord.get("web");
        result.add(new Person(first_name, last_name, company_name, address, city, province, postal, phone1, phone2,
            email, web));
      }
      csvParser.close();
      return result;
    } catch (IOException e) {
      // TODO Auto-generated catch block
      

      e.printStackTrace();

      
      return null;
    }
  }

}