import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.util.Random;

public class PortabilityTests {

    public static void main(String[] args) throws Exception {
        // Rutas a los conjuntos de datos
        String[] datasets = {
            "path/to/path/to/Moodle1.csv",
            "path/to/path/to/Moodle2.csv",
            "path/to/path/to/Moodle3.csv",
            "path/to/path/to/Moodle4.csv",
            "path/to/path/to/Moodle5.csv",
            "path/to/path/to/Moodle6.csv",
            "path/to/path/to/Moodle7.csv",
            "path/to/path/to/Moodle8.csv",
            "path/to/path/to/Moodle9.csv",
            "path/to/path/to/Moodle10.csv",
            "path/to/path/to/Moodle11.csv",
            "path/to/path/to/Moodle12.csv",
            "path/to/path/to/Moodle13.csv",
            "path/to/path/to/Moodle14.csv",
            "path/to/path/to/Moodle15.csv",
            "path/to/path/to/Moodle16.csv",
        };

        // Bucle a través de cada conjunto de datos
        for (String trainDatasetPath : datasets) {
            System.out.println("Entrenando en: " + trainDatasetPath);

            // Cargar conjunto de datos de entrenamiento
            Instances trainData = loadDataset(trainDatasetPath);
            trainData.setClassIndex(trainData.numAttributes() - 1);

            // Entrenar clasificador J48
            J48 tree = new J48();
            tree.buildClassifier(trainData);

            // Evaluar en todos los conjuntos de datos
            for (String testDatasetPath : datasets) {
                System.out.println("Probando en: " + testDatasetPath);

                // Cargar conjunto de datos de prueba
                Instances testData = loadDataset(testDatasetPath);
                testData.setClassIndex(testData.numAttributes() - 1);

                // Evaluar el modelo
                Evaluation eval = new Evaluation(trainData);
                eval.evaluateModel(tree, testData);

                // Imprimir métricas de evaluación
                System.out.println("Resultados del modelo entrenado en " + trainDatasetPath + " probado en " + testDatasetPath);
                System.out.println("AUC: " + eval.areaUnderROC(1));
                System.out.println("Matriz de confusión: ");
                System.out.println(eval.toMatrixString());
                System.out.println("====================================\n");
            }
        }
    }

    /**
     * Carga un conjunto de datos desde un archivo CSV.
     * @param path Ruta al archivo CSV.
     * @return Objeto Instances que contiene el conjunto de datos.
     * @throws Exception Si hay un error al leer el archivo.
     */
    private static Instances loadDataset(String path) throws Exception {
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(path));
        return loader.getDataSet();
    }
}
