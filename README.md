# Infer warning classification

**Repository for the analysis and classification of Infer warnings when analyzing real-worls programs of the Dacapo Benchmark.**

* This classification does not consider warnings present in Test files. 
* This classification does not consider RacerD warnings.

All infer reports and their respective analysis are under the subfolder *Analysis* in each program.

Program | LoC | Total Warnings | Test cases | TP | FP
------------ | ------------- | -------- |----| ---- | ----| 
Avrora | 92041 | 51 | 0| 41 | 12
Joda-Time | 94973 | 58 | 45 | 12 | 1
Jython | 945500 | 219 | 50 | 97 | 82
Xalan-j| 205644 | 54 | 0 | 31 | 23
tomcat | 435438 | 297 | 0 |178 | 119

## Types of bugs
Program  | Total  | *NULL_DEREFERENCE* | *RESOURCE_LEAK* |  *INEFFICIENT_KEYSET_ITERATOR* | *DEADLOCK*
------------ | ------------- | -------- |----|----|----|
Avrora | 51 | 27 | 24 | 0 | 0 
Joda-Time | 13 | 10 | 2 | 1 | 0
Jython | 179 | 95 | 85 | 0 | ***9665***
Xalan-j| 54 | 40 | 14 | 0 | 0
tomcat | 297 | 220 | 74 | 1 | 2


## False Positive bugs

Program | Total | *NULL_DEREFERENCE* | *RESOURCE_LEAK* | 
------------ | ------------- | -------- | ---- |
Avrora | 12 | 9 | 3 |
Joda-Time | 1 | 1 | 0 |
Jython | 82 | 71 | 11 |
Xalan-j| 23 | 21 | 2| 
tomcat | 119 | 108 | 11 |


## Reports found
Program  | Total  | True Positives | False positives |  
------------ | ------------- | -------- |----|
Avrora | 51 | 39 | 12 |
Joda-Time | 12 | 11 | 1 |
Jython | 165 | 83 | 82 | 
Xalan-j| 50 | 27 | 23 | 
tomcat | 265 | 153 | 112 |
**TOTAL**| 543 | 313 | 230 |

We have 42% of false positives.

