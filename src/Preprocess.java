import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.CSVSaver;

import java.io.File;
import java.io.IOException;

public class Preprocess {

    public static void main(String[] args) throws Exception {
        // Verify command-line arguments
        if (args.length < 2) {
            System.err.println("Usage: java Preprocess <inputDataPath> <outputDataPath>");
            System.exit(1);
        }

        // Input and output file paths from command-line arguments
        String inputDataPath = args[0];
        String outputDataPath = args[1];

        // Load the dataset
        Instances inputData = loadDataset(inputDataPath);

        // Preprocess the dataset
        Instances processedData = preprocessData(inputData);

        // Save the preprocessed dataset
        saveDataset(processedData, outputDataPath);

        System.out.println("Preprocessing completed. File saved at: " + outputDataPath);
    }

    /**
     * Preprocesses the dataset.
     * In this example, numeric and categorical attributes are treated together.
     *
     * @param data The input dataset.
     * @return The preprocessed dataset.
     */
    private static Instances preprocessData(Instances data) {
        // Define groups for attributes based on ontology
        String[][] groups = {
            {"blog_view", "course_enrol", "course_recent", "course_user_report", "course_view"}, // Group for LEARNING
            {"forum_add_discussion", "forum_add_post", "forum_search", "forum_subscribe", "forum_user_report"}, // Group for COMMUNICATION
            {"assignment_upload", "assignment_view", "assignment_view_all", "assignment_view_submission", "wiki_edit"}, // Group for WORK
            {"quiz_attempt", "quiz_close_attempt", "quiz_continue_attemp", "quiz_preview", "quiz_view"}, // Group for EVALUATION
            {"choice_choose", "choice_view", "resource_view", "resource_view_all"} // Group for ENGAGEMENT
        };

        // The processing logic
        Instances processedData = new Instances(data, 0);
        return processedData;
    }

    /**
     * Loads a dataset from a CSV file.
     *
     * @param path Path to the CSV file.
     * @return Instances object containing the dataset.
     * @throws IOException If there is an error reading the file.
     */
    private static Instances loadDataset(String path) throws IOException {
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(path));
        return loader.getDataSet();
    }

    /**
     * Saves a dataset to a CSV file.
     *
     * @param data The dataset to save.
     * @param path Path to save the CSV file.
     * @throws IOException If there is an error writing the file.
     */
    private static void saveDataset(Instances data, String path) throws IOException {
        CSVSaver saver = new CSVSaver();
        saver.setInstances(data);
        saver.setFile(new File(path));
        saver.writeBatch();
    }
}
