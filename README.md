# ImprovingPortabilityByOntologies

Source Code and Dataset used in the article: López-Zambrano, J., Lara, J.A. & Romero, C. Improving the portability of predicting students’ performance models by using ontologies. J Comput High Educ 34, 1–19 (2022). [https://doi.org/10.1007/s12528-021-09273-3](https://doi.org/10.1007/s12528-021-09273-3)

This code enables the preprocessing of Moodle datasets and performing portability tests using the Weka library.

## Structure

```
- `README.md`: Description and usage instructions
- `requirements.txt`: Java dependencies
- `src/`: Source code
  - `ArffToCsvConverter.java`: Class for converting ARFF files to CSV
  - `Preprocess.java`: Class for data preprocessing
  - `PortabilityTests.java`: Class for performing portability tests
- `data/`: Moodle datasets
  - `discretized/`: Discretized datasets
  - `numeric/`: Numerical datasets
```

## Prerequisites

1. Java Development Kit (JDK) 8 or higher.
2. [Weka Library](https://www.cs.waikato.ac.nz/ml/weka/): Place the `weka.jar` file in the `lib/` directory.

## Installation

Clone the repository:
```
git clone https://github.com/in1romocgmail/ImprovingPortabilityByOntologies.git
```

## Usage

### Converting format

Run the `ArffToCsvConverter` class to convert ARFF files to CSV. Follow the steps below:

1. Compile the `ArffToCsvConverter.java` file:
```
javac -cp lib/weka.jar src/ArffToCsvConverter.java
```

2. Run the compiled class:
```
java -cp lib/weka.jar:src ArffToCsvConverter FILE.arff FILE.csv
```

### Preprocessing

Run the `Preprocess` class to preprocess datasets. Follow the steps below:

1. Compile the `Preprocess.java` file:
```
javac -cp lib/weka.jar src/Preprocess.java 
```

2. Run the compiled class:
```
java -cp lib/weka.jar:src Preprocess INPUTFILE.csv OUTPUTFILE.csv
```

### Portability Tests

Run the `PortabilityTests` class to perform portability tests. Follow the steps below:

1. Compile the `PortabilityTests.java` file:
```
javac -cp lib/weka.jar src/PortabilityTests.java 
```

2. Run the compiled class:
```
java -cp lib/weka.jar:src PortabilityTests  /PATHDATASET
```

## Reference
López-Zambrano, J., Lara, J.A. & Romero, C. Improving the portability of predicting students’ performance models by using ontologies. J Comput High Educ 34, 1–19 (2022).

```
@article{lopez2022improving,
  title={Improving the portability of predicting students’ performance models by using ontologies},
  author={L{\'o}pez-Zambrano, Javier and Lara, Juan A and Romero, Crist{\'o}bal},
  journal={Journal of computing in higher education},
  pages={1--19},
  year={2022},
  publisher={Springer}
}
```
