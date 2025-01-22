# ImprovingPortabilityByOntologies

This repository contains the source code associated to the paper:

**López-Zambrano, J., Lara, J.A. & Romero, C.** Improving the portability of predicting students’ performance models by using ontologies. J Comput High Educ 34, 1–19 (2022). [https://doi.org/10.1007/s12528-021-09273-3](https://doi.org/10.1007/s12528-021-09273-3)
## Structure

- `README.md`: Description and usage instructions.
- `requirements.txt`: Python dependencies.
- `src/`: Source code.
  - `preprocess_data.py`: Script for data preprocessing.
  - `discover_rules.py`: Sequential SD-DFPTRee script to discover rules.
  - `sd_dfptree.py`: SD-DFPTRee Spark script to discover rules.
  - `postprocess_rules.py`: Script for postprocessing rules.
- `data/`: Datasets used.

## Installation

Clone the repository:

```
git clone https://github.com/in1romocgmail/ImprovingPortabilityByOntologies.git
```

## Requirements

Install the dependencies using:

```
pip install -r requirements.txt
```

Copy the dataset to be used into the `data` directory.

## Usage

### Step 1: Preprocess Data

```
python src/preprocess_data.py --input data/input/raw_data.csv --output data/output/preprocessed_data.csv
```

### Step 2: Discover Rules

```
python src/discover_rules.py --input data/output/preprocessed_data.csv --output data/output/rules.csv
```

### Step 3: Discover Rules with Spark

```
python src/sd_dfptree.py --input data/output/preprocessed_data.csv --output data/output/spark_rules.csv
```

### Step 4: Postprocess Rules

```
python src/postprocess_rules.py --input data/output/spark_rules.csv --output data/output/final_rules.csv
```

## Reference
López-Zambrano, J., Lara, J.A. & Romero, C. Improving the portability of predicting students’ performance models by using ontologies. J Comput High Educ 34, 1–19 (2022). https://doi.org/10.1007/s12528-021-09273-3
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
