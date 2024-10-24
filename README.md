# Task Manager with JTE Templates

This is a simple Task Management web application using the **JTE** templating engine for rendering dynamic views. The application allows users to add tasks, mark them as completed, and manage task lists efficiently.

## Features
- Display a list of tasks with the ability to mark them as completed.
- Add new tasks using a simple form.
- Dynamic updates on task status via checkbox interaction.

## Technologies Used
- Java
- JTE Template Engine
- HTML/CSS
- JavaScript (for handling task completion)

## Getting Started

### Prerequisites

To run this project locally, you will need:
- Java 21 or higher
- Maven

### Installation

1. Clone the repository:
2. Build the project using Maven:
3. Run the project:
4. Open your browser and navigate to:
    ```
    http://localhost:8080/tasks
    ```

### Usage

- On the **main page**, you will see a list of tasks. Each task can be marked as completed using the checkbox next to it.
- To add a new task, click on the "Dodaj zadanie" button, which will take you to a form where you can enter the task details.

### File Breakdown

- `task.jte`: Displays the list of tasks, allowing users to mark them as completed.
- `newTask.jte`: Contains the form to add a new task.
- `style.css`: Contains the styles for both pages, ensuring a clean and responsive design.
- `script.js`: JavaScript file for handling the task status toggle (e.g., marking tasks as completed or incomplete).

## Screenshots

### Task List
![image](https://github.com/user-attachments/assets/a7a06eb6-1821-4203-82b5-24359e873791)

### Add New Task
![image](https://github.com/user-attachments/assets/8a9c8fbe-bdf2-43da-9900-9c4906c5ddcc)

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Contact

For any inquiries, feel free to reach out to the project maintainers:
- Adrian Kapuścik - adrian1230@wp.pl
- GitHub: [adekeagle](https://github.com/adekeagle)
