# Sorting Algorithm Visualiser

A command-line tool for visualising sorting algorithms in use.

Supports multiple sorting algorithms, array sizes, and array orderings using flexible CLI flags.

## Features

- Implements multiple sorting algorithms:
  - Bubble Sort
  - Selection Sort
  - Insertion Sort
  - Bubble Sort
- Configurable array generation:
  - Random Array
  - Sorted Array
  - Reversed Array
  - Nearly Sorted Array (with customisable disorder %)
- Visualises sorting process in terminal, highlighting any key changes
- CLI flags for array size, selected algorithm, array generation and help 

## Usage
```bash
javac Visualiser.java
java Visualiser [options]
```

## Options
```bash
  --help                 Print this help message
  --sort <algorithm>     Choose algorithm: bubble (default), selection, insertion, merge
  --size <num>           Set array size (default 20)
  --array <type>         Choose array type: random (default), nearly, sorted, reversed
  --nearly <n%>          Set array type nearly sorted, with swap portion n% (default 10%)
```

## Examples

```bash
# Visualises Bubble sort on randomly shuffled array of size 20
java Visualiser 

# Visualises Merge sort on a randomly shuffled array of size 50
java Visualiser --sort merge --size 50

# Visualises Insertion sort on a nearly sorted array with disorder 5%
java Visualiser --sort insertion --nearly 5
```
