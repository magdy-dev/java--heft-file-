# java--heft-file-
# File Filtering Utility

## Introduction

Welcome to the File Filtering Utility! This tool helps you filter and organize data from multiple input files into separate output files based on data types. Whether you have integers, floating-point numbers, or strings, this utility can handle it all efficiently.

## Features

- **Categorizes Data**: Separates integers, floats, and strings into different files.
- **Custom Output Options**: Customize output file paths and prefixes.
- **Statistics Generation**: Get brief or full statistics on the data processed.
- **Error Handling**: Robust error handling to ensure smooth execution.
- **Extensible**: Easily add more features in the future!

## Requirements

- **Java 11 or higher**: Make sure you have Java installed on your system. You can check your Java version by running `java -version` in your terminal.

## Getting Started

### Step 1: Clone the Repository

First, you'll need to clone the repository to your local machine. Open your terminal and run:
If you’re using Maven, you can build the project by running:
mvn clean package


### Step 2:Create or gather your input files with data
Lorem ipsum dolor sit amet 45
3.1415
consectetur adipiscing
-0.001
test task
100500

in1.txt
in2.txt
Normal form of floating point number
1.528535047E-25
Long
123456789

Step 4: Running the Utility
java -jar target/file-filtering-1.0-SNAPSHOT.jar -o /path/to/output -p prefix_ -a -s in1.txt in2.txt

Step 5: Check the Output
After running the command, check the specified output directory. You should see:

sample_integers.txt
sample_floats.txt
sample_strings.txt

45
100500
123456789

3.1415
-0.001
1.528535047E-25


Lorem ipsum dolor sit amet
consectetur adipiscing
test task
Normal form of floating point number
Long


Integers: 3
Floats: 3
Strings: 5

