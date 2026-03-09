# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Java solutions for [Codility](https://app.codility.com/programmers/) developer training lessons, plus interview practice problems.

## Running Code

```bash
# Build all solutions
./gradlew build

# Run a specific solution (defaults to BinaryGap if omitted)
./gradlew run -PmainClass=main.codility.lesson.one.Iterations.BinaryGap.Solution
./gradlew run -PmainClass=main.codility.interview.db.LoyaltyProgram
```

Each `Solution.java` has a `main()` method with inline test cases — no external test framework is used. The CSV files for `LoyaltyProgram` are loaded via `getResourceAsStream` and are included automatically by the Gradle `resources` source set.

## Code Structure

```plaintext
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
