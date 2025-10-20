# 🧩 Maze Solver (Java)

A **console-based Maze Solver** built using Java that uses **Depth-First Search (DFS)** to find a path from the start (`S`) to the end (`E`) in a 10x10 maze.  
This project demonstrates recursion, backtracking, and logical problem-solving with clear visual feedback in the console.

---

## 🚀 Features
- Input your own **10x10 maze** using custom characters  
- Automatically detects the **start (S)** and **end (E)** points  
- Uses **Depth-First Search (DFS)** algorithm to explore possible paths  
- Marks the successful path using `*` symbols  
- Detects and handles invalid mazes gracefully  
- Clean visual console output of maze traversal and result  

---

## 🧠 Concepts Demonstrated
- **Recursion & Backtracking** for pathfinding  
- **2D Arrays** for maze representation  
- **DFS Algorithm** for traversal and search  
- **Input Validation & Error Handling**  
- **Logic Flow & State Tracking** using boolean arrays  

---

## ⚙️ How to Run
1. Open the project in **IntelliJ IDEA**, **Eclipse**, or any Java IDE.  
2. Ensure JDK 8 or higher is installed.  
3. Run the `MazeSolver.java` file inside the `src/` directory.  
4. Input your maze (10 lines × 10 characters) when prompted.

---

## 💡 Example Maze Input
##########
#S.......#
#.######.#
#.#....#.#
#.#.##.#.#
#...##.#E#
#.####.#.#
#......#.#
######.#.#
##########

### 🧭 Example Output
⚔️ Enter your 10-line maze below:
S = Start | E = End | # = Wall | . = Path

🗺️ Your Maze:

S . . . . . . .
. # # # # # # .
. # . . . . # .
. # . # # . # .
. . . # # . # E
. # # # # . # .
. . . . . . # .
# # # # # . # .
# # # # # # # #

🔍 Solving Maze...
✅ Path Found! Maze with '*' path:

---

## 📂 Folder Structure
MazeSolver/
├── src/
│ └── MazeSolver.java
├── .gitignore
├── MazeSolver.iml
└── README.md

---

## 🧩 Future Enhancements
- Implement **Breadth-First Search (BFS)** for shortest path detection  
- Add a **GUI visualization** using JavaFX or Swing  
- Support for larger and dynamic maze sizes  
- Export solved mazes as text files  

---

## 🧑‍💻 Author
**Raqeeba Yasin**  
🎓 BSCS Student | University of the Punjab  
💻 Java & Android Developer | Frontend Developer | Future Full Stack Engineer  
🇵🇰 Passionate about algorithms, AI, and innovative problem-solving  

📧 **Email:** raqeebayasin@gmail.com | 13056@wisdomhouse.edu.pk  
🔗 **LinkedIn:** [Raqeeba Yasin](https://www.linkedin.com/in/raqeeba-yasin-93ba04362)

---

⭐ *“Every maze has a way out — you just need the right algorithm.”*
