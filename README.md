# Who Wants to Be a Millionaire: CLI Edition

![Millionaire CLI](https://img.shields.io/badge/Java-100%25-orange)

A fully playable **console version** of the iconic game show, built entirely in **Java**.  
Test your knowledge across 16 progressively difficult questions, climb the money ladder, and use lifelines strategically to reach the top prize of $1,000,000!

---

## 🎮 Gameplay Overview

Players navigate the game entirely from the command line (CLI) with simple text commands.  
Here’s how it works:

1. **Game Start**
   - The host introduces the player and the game.
   - The first question (Difficulty 1) is presented along with four answer options: `A`, `B`, `C`, `D`.

2. **Answering Questions**
   - Type your choice (`A-D`) and press Enter.
   - If correct, you move up the **money ladder**.
   - If wrong, your final winnings fall back to the last **safe haven**:
     - Question 5 → $1,000  
     - Question 10 → $32,000

3. **Money Ladder**
Q16: $1,000,000
Q15: $500,000
Q14: $250,000
Q13: $125,000
Q12: $64,000
Q11: $32,000 ← Safe haven
Q10: $16,000
...
Q5: $1,000 ← Safe haven
Q4: $500
...
Q1: $100
Notice something? If you were at Q15 and got it wrong, you lose not just the million but also your 500 grand, and you fall back down to 32 grand. That's why Q16 is a complex and incredibly specialized question. Don't be a cheater and look inside Questions.java, which is the place where all of the questions' answers are.


4. **Lifelines**
Players can use lifelines at any time by typing commands:  
- `ll` → Show all available lifelines  
- `50` → 50/50: removes two wrong options  
- `aud` → Ask the Audience: generates simulated audience votes  
- `phone` → Phone a Friend: gives a hint  

5. **Cashboard**
- Type `cb` at any point to display a beautifully formatted ASCII **cash board** showing all prize levels and your current position.

6. **Winning the Game**
- Answer all 16 questions correctly to win $1,000,000.
- Use strategy and lifelines wisely: one wrong answer late in the game can drop you back thousands of dollars!

---

## 🛠 How It Works
A fellow nerd! Well, this is how the game works on the inside!

The game is built using **Object-Oriented Programming (OOP)** principles:

- **Questions Class**
- Stores all 1000+ questions (hard-coded or loaded from arrays).
- Each `Question` object contains:
 - `question` text
 - `options` (A–D)
 - `correctAnswer` index
 - `difficulty` level

- **Lifelines Class**
- Tracks usage of lifelines.
- Implements:
 - 50/50 removal logic
 - Audience vote simulation with random probabilities (actually very proud of this)
 - Phone-a-friend hints
 - ASCII cashboard display (coded by ChatGPT, because I am not an ASCII artist)

- **Main Class**
- Handles game flow:
 - Displaying questions
 - Reading user input
 - Checking answers
 - Updating money and current question
 - Integrating lifelines and cashboard

---

## 💡 Features

- Console-based CLI, play it in your IDE
- Fully dynamic money ladder and safe havens
- Lifelines with mechanics that mimic the TV show
- ASCII cashboard with clear “YOU ARE HERE” marker
- OOP architecture ready for future upgrades (if i have the time)

---

## 🎯 How to Play

1. Clone the repository:
'''bash
git clone https://github.com/SiriWastaken/Who-Wants-to-Be-a-Millionaire-CLI-Edition.git
cd Who-Wants-to-Be-a-Millionaire-CLI-Edition
'''bash

Compile the Java files:
javac *.java


Run the game:
java Main


Commands during the game:
Answer a question: A, B, C, or D
Check current money: cb
Show lifelines menu: ll
Use lifelines: 50, aud, phone

📦 Project Structure
Who-Wants-to-Be-a-Millionaire-CLI-Edition/
├── Main.java # What you play: the frontend, where all of the methods (pieces of code that can be called (done) anywhere in the program) are incredibly helpful.)
├── Questions.java     # Contains Question class & question bank - (i know you've been looking for this file.. CHEATER!)
├── Lifelines.java     # Lifelines and ASCII cashboard - simple(ish) file.
└── README.md          # You're looking at this right now!

🔮 Future Enhancements
JavaFX GUI for interactive play with visual lifelines. Visuals are always fun, right? 
Sounds from the original TV showDynamic question loading from a file or from an API 👀. Also, it would fix a problem where you can look inside the code to find the answers. However, it would take you a while since the question order is random.
Timer-based questions for an extra challenge
High score leaderboard, maybe with multiplayer on LAN?????? (I'm a new programmer, so... unlikely, although it would be cool to come back to this after taking AP CS A)

👏 Credits
Inspired by the iconic TV game show Who Wants to Be a Millionaire?
Created as a portfolio project to demonstrate Java OOP, arrays, and CLI interaction.

⚡ License
MIT License: Forking and looking at other repos are among the best ways to learn to program and get inspired for projects. Feel free to fork this repo!
