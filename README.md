# NotePad Java Project

## Overview
This is a simple Notepad application built using Java, designed to demonstrate Object-Oriented Programming (OOP) concepts. The project is ideal for technical interviews, showcasing practical implementation of OOP principles such as encapsulation, inheritance, polymorphism, and abstraction.

## Features
- Basic text editing (New, Open, Save, Exit)
- Text formatting (Font, Color)
- Edit operations (Cut, Copy, Paste, Undo, Redo)
- Keyboard shortcuts
- Simple GUI using Java Swing

## OOP Concepts Demonstrated
### 1. **Encapsulation**
- Each functionality (File, Edit, Format, Color) is encapsulated in its own class (e.g., `Function_File.java`, `Function_Edit.java`).
- Data and methods are bundled together, exposing only necessary interfaces.

### 2. **Inheritance**
- Common behaviors are inherited where appropriate (e.g., extending Swing components).
- Promotes code reuse and logical hierarchy.

### 3. **Polymorphism**
- Methods are overridden to provide specific behaviors for different actions.
- Event handling uses polymorphic listeners.

### 4. **Abstraction**
- Complex operations are abstracted into helper classes and methods.
- The user interacts with a simple GUI, hiding implementation details.

## Project Structure
```
src/
  Function_Color.java      // Handles color changes
  Function_Edit.java       // Edit operations (cut, copy, paste, etc.)
  Function_File.java       // File operations (new, open, save, exit)
  Function_Format.java     // Text formatting
  GUI.java                 // Main GUI logic
  KeyHandler.java          // Keyboard shortcuts
  META-INF/MANIFEST.MF     // Manifest file
Exe/
  Notepad.exe              // Compiled executable
Img/
  NOTEPAD.ICO, NOTEPAD.png // Icons
```

## How to Run
1. Compile the Java source files in `src/`.
2. Run the `GUI` class to launch the application.
3. Alternatively, use the provided `Notepad.exe` if available.

## Interview Talking Points
- **Class Design:** Each feature is modularized into separate classes, demonstrating clean separation of concerns.
- **Event Handling:** Uses listeners and handlers to manage user actions, showing real-world OOP usage.
- **Extensibility:** The design allows easy addition of new features by creating new classes or extending existing ones.
- **Java Swing:** Practical use of Java's GUI library for desktop applications.

## Learning Outcomes
- Understand how OOP principles are applied in real projects.
- Learn to structure code for maintainability and scalability.
- Gain experience with Java Swing and event-driven programming.

---
**Author:** Apurv Patel

Feel free to use this project as a reference in interviews to discuss OOP design and implementation in Java.
