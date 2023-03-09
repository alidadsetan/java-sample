package com.gloablrelay.interview.dadsetan;


public final class App {
    private App() {
    }

    /**
     * This method runs finder.execute().
     */
    public static void main(String[] args) {
        String csvPath = "simple_test_file.csv";
        String outputPath = "output.txt";
        IPersonRepository csvPersonRepository = new CSVPersonRepository(csvPath);


        INameRepository nameRepository = new Filter(csvPersonRepository);

        IFinderOutput fileOutput = new FileFinderOutput(outputPath);

        RelatedFinder finder = new RelatedFinder(nameRepository, fileOutput);
        finder.execute();
        // List<Person> persons = csvPersonRepository.getPersons();
      
    }
}
