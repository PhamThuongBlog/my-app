# PIT Results – Human + LLM Combined Tests

This directory stores PIT results for the **combined test suite**
consisting of **human-written tests and LLM-generated tests**.

## Purpose
This configuration evaluates whether **LLM-generated tests complement
human-written tests**, leading to higher coverage and mutation scores.

## Contents (generated during CI)
- `index.html` – PIT mutation testing report
- `mutations.csv` – mutation results
- combined coverage statistics

## Configuration
- Test sources:
  - Manually written unit tests
  - LLM-generated unit tests
- Traditional automated tests (Randoop, EvoSuite) excluded

## Usage in Paper
Reported as:
> **Hybrid human + LLM testing configuration**
