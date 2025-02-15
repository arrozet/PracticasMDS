# Practices repository for Software Modeling and Design

This repository contains the materials and solutions for the "Software Modeling and Design" course practices, part of the Software Engineering degree at ETSII, UMA, for the academic year 24-25.

## Directory Structure

- **`P1/`**: materials for Practice 1 - Aviation System
  - `USE/`: USE models and scenarios
    - `P1_SistemaAviacion.use`: class definitions for the aviation system
    - `P1_SistemaAviacionTodoBien.soil`: scenario with valid constraints
    - `P1_SistemaAviacionTodoMal.soil`: scenario violating constraints
    - `fotos/`: images used in the scenarios
  - `VisualParadigm/`: Visual Paradigm diagrams
    - `SistemaAviacion.vpp`: main diagram for the aviation system
  - `entrega/`: submission files

- **`P2/`**: materials for Practice 2 - Car System
  - `a-no_tiempo/`: no-time constraints scenarios
    - `USE/`: USE models and scenarios
    - `VisualParadigm/`: Visual Paradigm diagrams
  - `b-comportamiento/`: behavior scenarios
    - `USE/`: behavior scenarios and models
    - `VisualParadigm/`: behavior diagrams
  - `entrega/`: submission files

- **`P3/`**: materials for Practice 3 - Animal Shelter System
  - `apartado_a/`: adoption management system
    - `Java/JavaA/`: Java code for the adoption system
    - `VisualParadigm/JavaA.vpp`: UML diagrams for the system
  - `apartado_d/`: solution to a proposed problem in the assignment, which involved modifying the class hierarchy to allow a single person to have multiple roles (e.g., a volunteer can also adopt an animal, or an adopter can make donations). The solution implemented ensures proper role management, maintains data consistency, and supports method reuse through the use of a proxy pattern.
    - `Java/JavaDProxy/`: Java code for solving the proposed problem
    - `VisualParadigm/JavaDProxy.vpp`: UML diagrams for the system
  - `entrega/`: submission files

- **`P4/`**: materials for Practice 4 - Car Rental System
  - `Ejercicio_1/`: exercise 1 files (Iterator Pattern)
    - `Java/`: Java code for the car rental system
    - `VisualParadigm/`: UML diagrams for the system
  - `Ejercicio_2/`: exercise 2 files (State Pattern)
    - `Java/alquiler_coches/`: Java code for rental system modifications
    - `VisualParadigm/`: UML diagrams for the modified system
  - `Ejercicio_3/`: exercise 3 files (Strategy Pattern)
    - `Java/`: Java code for promotional strategies
    - `VisualParadigm/`: UML diagrams for promotional strategy integration
  - `base/`: base system for car rental
    - `Java/alquiler_coches/`: base Java code
    - `VisualParadigm/`: UML diagrams for the base system
  - `entrega/`: submission files

## Usage

1. Navigate to the relevant practice folder.
2. Open the `.use` or `.vpp` files with the appropriate software.
3. Run Java code using a Java compiler or IDE.

## Tools

- **USE (UML-based Specification Environment)**: for modeling and validation of system invariants.
- **Visual Paradigm**: for UML diagram creation and visualization.
- **Java**: implementation of system logic and behavior.

## License

This repository is for educational purposes only, intended for the academic development of students in the "Software Modeling and Design" course.

## Acknowledgments

- Special thanks to the instructors for their guidance and support throughout the course.
