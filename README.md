# Sorting Algorithm Visualiser

A command-line tool for visualising sorting algorithms in use.

Supports multiple sorting algorithms, array sizes, and array orderings using flexible CLI flags.

## Features

- Implements multiple sorting algorithms:
  - Bubble Sort
  - Selection Sort
  - Insertion Sort
  - Merge Sort
  - Shaker Sort
  - Gnome Sort
  - Quick Sort
- Configurable array generation:
  - Random Array
  - Sorted Array
  - Reversed Array
  - Nearly Sorted Array (with customisable disorder %)
- Visualises sorting process in terminal, highlighting any key changes
- CLI flags for array size, selected algorithm, bar width, array generation and help 

## Usage
```bash
javac Visualiser.java
java Visualiser [options]
```

## Options
```bash
  --help                 Print this help message
  --sort <algorithm>     Choose algorithm: bubble (default), selection, insertion, merge, shaker, gnome
  --size <num>           Set array size (default 20)
  --array <type>         Choose array type: random (default), nearly, sorted, reversed
  --nearly <n%>          Set array type nearly sorted, with swap portion n% (default 10%)
  --width <num>          Set bar width (default 100)
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
