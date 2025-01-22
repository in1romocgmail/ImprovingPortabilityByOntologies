# ImprovingPortabilityByOntologies

This repository contains the source code for the application presented in the article:

**Cerezo, R., Calderón, V., & Romero, C. (2019).** *A holographic mobile-based application for practicing pronunciation of basic English vocabulary for Spanish speaking children*. International Journal of Human-Computer Studies, 124, 13-25. [https://doi.org/10.1016/j.ijhcs.2018.11.009](https://doi.org/10.1016/j.ijhcs.2018.11.009)

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
**Cerezo, R., Calderón, V., & Romero, C. (2019).** *A holographic mobile-based application for practicing pronunciation of basic English vocabulary for Spanish speaking children*. International Journal of Human-Computer Studies, 124, 13-25. [https://doi.org/10.1016/j.ijhcs.2018.11.009](https://doi.org/10.1016/j.ijhcs.2018.11.009)

```
@article{cerezo2019holographic,
  title={A holographic mobile-based application for practicing pronunciation of basic English vocabulary for Spanish speaking children},
  author={Cerezo, Rebeca and Calder{\'o}n, Vicente and Romero, Crist{\'o}bal},
  journal={International Journal of Human-Computer Studies},
  volume={124},
  pages={13--25},
  year={2019},
  publisher={Elsevier}
}
```
