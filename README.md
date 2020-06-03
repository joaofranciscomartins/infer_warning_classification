# Infer warning classification

**Repository for the analysis and classification of Infer warnings when analyzing real-worls programs of the Dacapo Benchmark.**

* This classification does not consider warnings present in Test files. 
* This classification does not consider RacerD warnings.

All infer reports and their respective analysis are under the subfolder *Analysis* in each program.

Program | LoC | Total Warnings | Test cases TP | FP
------------ | ------------- | -------- |----| ---- | ----|
Avrora | 92041 | 53 | 0| 41 | 12
Joda-Time | 94973 | 92 | 46| 91 | 1
Jython | 945500 | 219 | 0 | 137 | 82
Xalan-j| 205644 | 54 | 0 | 31 | 23

## Types of False Positive bugs

Program | Total | *NULL_DEREFERENCE* | *RESOURCE_LEAK* | 
------------ | ------------- | -------- | ---- |
Avrora | 12 | 9 | 3 |
Joda-Time | 1 | 1 | 0 |
Jython | 82 | 71 | 11 |
Xalan-j| 23 | 21 | 2| 
