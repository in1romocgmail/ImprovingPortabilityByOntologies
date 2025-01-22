import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.util.Random;

public class PortabilityTests {

    public static void main(String[] args) throws Exception {
        // Validate command line arguments
        if (args.length != 1) {
            System.err.println("Please provide the directory containing the datasets as a command line argument.");
            System.exit(1);
        }

        // Directory containing dataset files
        String datasetDirectory = args[0];

        // Get all CSV files from the specified directory
        File dir = new File(datasetDirectory);
        if (!dir.isDirectory()) {
            System.err.println("The provided path is not a directory.");
            System.exit(1);
        }

        // List of dataset paths
        String[] datasets = dir.list((directory, name) -> name.endsWith(".csv"));

        if (datasets == null || datasets.length == 0) {
            System.err.println("No CSV files found in the specified directory.");
            System.exit(1);
        }

        // Prepend the directory path to each dataset file name
        for (int i = 0; i < datasets.length; i++) {
            datasets[i] = new File(dir, datasets[i]).getAbsolutePath();
        }

        // Loop through each dataset
        for (String trainDatasetPath : datasets) {
            System.out.println("Training on: " + trainDatasetPath);

            // Load training dataset
            Instances trainData = loadDataset(trainDatasetPath);
            trainData.setClassIndex(trainData.numAttributes() - 1);

            // Train J48 classifier
            J48 tree = new J48();
            tree.buildClassifier(trainData);

            // Evaluate on all datasets
            for (String testDatasetPath : datasets) {
                System.out.println("Testing on: " + testDatasetPath);

                // Load test dataset
                Instances testData = loadDataset(testDatasetPath);
                testData.setClassIndex(testData.numAttributes() - 1);

                // Evaluate the model
                Evaluation eval = new Evaluation(trainData);
                eval.evaluateModel(tree, testData);

                // Print evaluation metrics
                System.out.println("Results of the model trained on " + trainDatasetPath + " tested on " + testDatasetPath);
                System.out.println("AUC: " + eval.areaUnderROC(1));
                System.out.println("Confusion Matrix: ");
                System.out.println(eval.toMatrixString());
                System.out.println("====================================\n");
            }
        }
    }

    /**
     * Loads a dataset from a CSV file.
     * @param path Path to the CSV file.
     * @return Instances object containing the dataset.
     * @throws Exception If an error occurs while reading the file.
     */
    private static Instances loadDataset(String path) throws Exception {
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(path));
        return loader.getDataSet();
    }
}
