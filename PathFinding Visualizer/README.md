# 🧭 Pathfinding Visualizer (Java)

A **console-based Pathfinding Visualizer** built in Java that demonstrates how algorithms explore and discover the shortest path in a grid maze.  
This project uses the **Breadth-First Search (BFS)** algorithm to find an optimal route between a **Start (S)** and **End (E)** node while avoiding walls.

---

## 🚀 Features
- 📍 Set custom **Start** and **End** points in a 10×10 grid  
- 🧱 Add walls dynamically to simulate obstacles  
- 🔍 Uses **Breadth-First Search (BFS)** for shortest path discovery  
- 🌟 Visually shows visited nodes (`*`) and final path  
- 🧠 Implements **Object-Oriented Programming (OOP)** concepts  
- 🖥️ Runs entirely in the console (no graphics required)

---

## 🧠 Key Concepts
- **Graph Traversal** — BFS algorithm using a queue  
- **Data Structures** — `Queue`, `ArrayList`, and 2D arrays  
- **OOP** — Encapsulation of each grid cell as a `Node` class  
- **Path Reconstruction** — Using parent pointers (`previous` references)  
- **Condition Checks** — Valid node boundaries and wall avoidance  

---

## ⚙️ How It Works
1. The program generates a **10×10 grid** of nodes (`.`).  
2. You select:
   - The **start** node (`S`)  
   - The **end** node (`E`)  
   - Any number of **walls** (`#`) to block movement.  
3. The BFS algorithm explores all possible routes until it finds the shortest path.  
4. The visited nodes are marked with `*`, and the final grid is displayed.

---

## 💡 Example Usage
Set START point (row col): 0 0
Set END point (row col): 4 4
Add WALLS. Enter -1 to stop.
Wall at (row col): 2 2
Wall at (row col): 3 2
Wall at (row col): -1

Initial Grid:
S . . . . . . . . .
. . . . . . . . . .
. . # . . . . . . .
. . # . . . . . . .
. . . . E . . . . .

Finding path...
Path found:

S * * * . . . . . .
. . * . . . . . . .
. . # . . . . . . .
. . # . . . . . . .
. . . . E . . . . .


---

## 📂 Folder Structure
PathfindingVisualizer/
├── src/
│ └── PathfindingVisualizer.java
├── .gitignore
├── PathfindingVisualizer.iml
└── README.md


---

## 🧩 Future Enhancements
- Add **Dijkstra’s** and **A\*** algorithms  
- Visualize movement using a **JavaFX GUI**  
- Implement **weighted grids** for varied path costs  
- Export grid states for performance comparison  

---

## 🧑‍💻 Author
**Raqeeba Yasin**  
🎓 BSCS Student | University of the Punjab  
💻 Java & Android Developer | Frontend Developer | Aspiring Full Stack Engineer  
🇵🇰 Passionate about creating intelligent, problem-solving software  

📧 **Email:** raqeebayasin@gmail.com | 13056@wisdomhouse.edu.pk  
🔗 **LinkedIn:** [Raqeeba Yasin](https://www.linkedin.com/in/raqeeba-yasin-93ba04362)

---

⭐ *“Every problem has a path — the key is knowing how to find it.”*
