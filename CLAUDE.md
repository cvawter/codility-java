# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Java solutions for [Codility](https://app.codility.com/programmers/) developer training lessons, plus interview practice problems.

## Running Code

There is no build tool (Maven/Gradle). This is a plain Java project intended to be run directly via an IDE (e.g., IntelliJ IDEA) or `javac`/`java` from the command line.

To compile and run a solution from the project root:
```bash
# Compile (output .class files to out/ directory)
javac -d out -sourcepath src/main src/main/codility/lesson/one/Iterations/BinaryGap/Solution.java

# Run (use the package path as the class name)
java -cp out main.codility.lesson.one.Iterations.BinaryGap.Solution
```

Each `Solution.java` has a `main()` method with inline test cases — no external test framework is used.

For the `LoyaltyProgram` interview problem, the CSV data files (`log_day1.csv`, `log_day2.csv`) must be on the classpath alongside the class files (they are loaded via `getResourceAsStream`):
```bash
javac -d out -sourcepath src/main src/main/codility/interview/db/LoyaltyProgram.java
cp src/main/codility/interview/db/*.csv out/main/codility/interview/db/
java -cp out main.codility.interview.db.LoyaltyProgram
```

## Code Structure

```
src/main/codility/
├── lesson/
│   ├── one/Iterations/BinaryGap/        # Lesson 1
│   ├── two/Arrays/                      # Lesson 2: CyclicRotation, OddOccurrencesInArray
│   ├── three/TimeComplexity/            # Lesson 3: FrogJmp, PermMissingElem, TapeEquilibrium
│   ├── four/CountingElements/           # Lesson 4: MissingInteger, MaxCounters
│   ├── five/PrefixSums/CountDiv/        # Lesson 5
│   └── six/Sorting/Distinct/            # Lesson 6
└── interview/db/                        # Interview prep: LoyaltyProgram (HashMap/Set problem)
```

## Conventions

- Each problem lives in its own package directory with a `Solution.java` containing both the solution method(s) and a `main()` with test cases.
- The package root is `main.codility.*` (matching the `src/main/` source root).
- Some solutions include alternative implementations (e.g., `solution_copilot`) for comparison.
- Lesson solutions that are stubs (unimplemented) return `-1` as a placeholder.
- The `interview/db/` package is for non-Codility interview practice problems and may include supporting classes and CSV data files.
