import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;

import java.io.File;
import java.io.IOException;

public class ArffToCsvConverter {

    public static void main(String[] args) {
        // Verify that the required arguments are provided
        if (args.length < 2) {
            System.err.println("Usage: java ArffToCsvConverter <inputArffFile> <outputCsvFile>");
            return;
        }

        // Input ARFF file path from command-line arguments
        String inputArffFile = args[0];
        // Output CSV file path from command-line arguments
        String outputCsvFile = args[1];

        try {
            // Load ARFF file
            ArffLoader loader = new ArffLoader();
            loader.setSource(new File(inputArffFile));
            Instances data = loader.getDataSet();

            // Save to CSV file
            CSVSaver saver = new CSVSaver();
            saver.setInstances(data);
            saver.setFile(new File(outputCsvFile));
            saver.writeBatch();

            System.out.println("Conversion completed: " + outputCsvFile);

        } catch (IOException e) {
            System.err.println("Error during conversion: " + e.getMessage());
        }
    }
}
