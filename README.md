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

**---------------------------------------------------------------------------------------------------------**

As can be seen before besides *Null derefence* and *Resource leak* bugs no false positives were found regarding 
other different types of bugs. Therefore, we chose only to analyse these two kinds of bugs.

The reports found below were run in a  Debian 10 server with 32 cores and 64Gb of RAM.
Infer 0.17.0 was installed from source ***https://github.com/facebook/infer/blob/master/INSTALL.md***.

We had to run infer with the flag *--debug* to get all the files containg the reports concerning the infer analysis.
Unfortunately some files were not created and lead to the loss of certain bugs present in the original execution.

## Reports found
Program  | Total  | True Positives | False positives |  
------------ | ------------- | -------- |----|
Avrora | 51 | 39 | 12 |
Joda-Time | 12 | 11 | 1 |
Jython | 165 | 83 | 82 | 
Xalan-j| 50 | 27 | 23 | 
tomcat | 265 | 153 | 112 |
**TOTAL | 543 | 313 | 230 |**

We have 42% of false positives.


## False Positive bugs
Program | Total | *NULL_DEREFERENCE* | *RESOURCE_LEAK* | 
------------ | ------------- | -------- | ---- |
Avrora | 12 | 9 | 3 |
Joda-Time | 1 | 1 | 0 |
Jython | 82 | 71 | 11 |
Xalan-j| 23 | 21 | 2| 
tomcat | 112 | 102 | 10 |

## True Positive bugs
Program | Total | *NULL_DEREFERENCE* | *RESOURCE_LEAK* | 
------------ | ------------- | -------- | ---- |
Avrora | 39 |18 | 21 |
Joda-Time | 11 | 9 | 2 |
Jython | 83 | 27 | 56 |
Xalan-j| 27 | 18 | 9 | 
tomcat | 153 | |  |
