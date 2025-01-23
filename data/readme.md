# Metadata of Moodle Ontology Datasets

Dataset used in the article: López-Zambrano, J., Lara, J.A. & Romero, C. Improving the portability of predicting students’ performance models by using ontologies. J Comput High Educ 34, 1–19 (2022). [https://doi.org/10.1007/s12528-021-09273-3](https://doi.org/10.1007/s12528-021-09273-3)


## Datasets Description
The datasets show students' activities on Moodle in terms of their participation across various interaction categories.

## Structure

```
- `README.md`: Description
- `data/`: Moodle datasets
  - `discretized/`: Discretized datasets
  - `numeric/`: Numerical datasets
```


### Attributes
The datasets include the following attributes:

| **Attribute**              | **Type**   | **Description**                                              |
|---------------------------|------------|-------------------------------------------------------------|
| `LEARNING/READING/VIEWING` | numeric/categorical    | Activities related to learning, reading, or viewing content. |
| `COMMUNICATING`            | numeric/categorical    | Activities related to communication, such as forums or messages. |
| `WORKING/DOING`            | numeric/categorical    | Practical activities or tasks completed by students.         |
| `EVALUATING/EXAMINING`     | numeric/categorical    | Assessment or examination activities.                       |
| `ENGAGEMENT`               | numeric/categorical    | Overall level of engagement or interaction on the platform. |

### Data Format
- **File Type**: ARFF (Attribute-Relation File Format)
- **Encoding**: ISO-8859-1 (Latin-1)
