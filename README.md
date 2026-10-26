# OIBSIP — Java Development Task 2: Number Guessing Game

A console-based Java number guessing game. The program selects a random number and gives the player higher/lower hints until the number is guessed or the attempt limit is reached.

## Features

- Random number generated for each round
- Three difficulty settings:
  - Easy: 1–50, 10 attempts
  - Medium: 1–100, 7 attempts
  - Hard: 1–200, 5 attempts
- “Too High!”, “Too Low!”, and “Correct!” feedback
- Attempt counter and remaining-attempt messages
- Reveals the answer after a lost round
- Play Again option
- Round summaries showing the round number, result, attempt count, and difficulty
- Input validation for menu selections and guesses
- Uses `Random`, `Scanner`, loops, conditionals, and a small class to organize difficulty settings

## Requirements

- Java JDK 8 or newer
- No external dependencies

Check Java is installed:

```bash
java -version
javac -version
```

## Project structure

```text
Java-Task2-NumberGuessingGame/
├── README.md
└── src/
    ├── Main.java
    └── NumberGuessingGame.java
```

## Compile and run

Open a terminal in the project folder.

### Windows (PowerShell or Command Prompt)

```powershell
javac -d out src\*.java
java -cp out Main
```

### macOS / Linux

```bash
mkdir -p out
javac -d out src/*.java
java -cp out Main
```

## Suggested test plan

1. Start the program and choose Easy, Medium, and Hard in separate rounds.
2. Enter letters for the difficulty selection; the program should ask again.
3. Enter letters, zero, negative values, and values above the selected range as guesses; the program should reject them.
4. Guess the correct number and confirm it reports the attempt count.
5. Use all attempts without guessing; confirm it reveals the answer.
6. Play multiple rounds and confirm the round number increases.
7. Enter an invalid replay answer; confirm it asks again.
8. Enter `n` to quit.

## OIBSIP submission checklist

- [ ] Compile and run the program locally.
- [ ] Test all difficulty levels, invalid input, win/loss, replay, and round summaries.
- [ ] Capture screenshots of the running program/output.
- [ ] Keep this folder under the GitHub repository named exactly `OIBSIP`.
- [ ] Use the folder name `Java-Task2-NumberGuessingGame`.
- [ ] Push the source code and this README to GitHub.
- [ ] Record a functioning screen-demo video. The first 2 seconds must show your full name, assigned track, and task title.
- [ ] Post/link the demo video on LinkedIn, tag Oasis Infobyte, and include `#oasisinfobyte` and relevant hashtags such as `#java` and `#internship`.
- [ ] Leave substantive comments on at least two other interns' demo videos.
- [ ] Submit the GitHub repository link using the Task Submission Form shared by your cohort.

## Suggested demo sequence

Show the title card, start the game, select Medium, demonstrate an invalid guess, demonstrate a high/low hint, finish a round (win or lose), replay once, and quit.
