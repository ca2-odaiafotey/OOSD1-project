# Car Parts and Accessories Shop – OO Systems Development Project

## Module: UFCFC3-30-1 Introduction to OO Systems Development

---

## Project Description

This project is a Java-based GUI application for a Car Parts and Accessories shop. It lets the user create stock items, add stock, sell stock, and change prices. The application is built using Java Swing for the GUI.

---

## How to Set Up and Run

1. Make sure you have Java (JDK 11 or higher) installed.
2. Clone or download this repository.
3. Open the project in an IDE like IntelliJ IDEA or Eclipse.
4. Make sure the `Assignment` package is inside a project called `OOSD1`.
5. To run the GUI, run the `ShopGUI` class.
6. To run the console tests, run `TestNavSys` or `TestPolymorphism`.

---

## Project Structure

```
OOSD1/
  Assignment/
    StockItem.java       - Base class for all stock items
    NavSys.java          - Subclass: Navigation System
    DashCam.java         - Subclass: Dash Camera
    CarMats.java         - Subclass: Car Mats
    AirFreshener.java    - Subclass: Air Freshener
    TestNavSys.java      - Console test for NavSys
    TestPolymorphism.java - Console test for polymorphism
    ShopGUI.java         - Main GUI application
  README.md
  TestCases_and_UML.md
  uml_diagram.png
```

---

## Classes Overview

- **StockItem** – The parent class. Has stock code, quantity, and price. Has methods to add stock, sell stock, get/set price, and get VAT.
- **NavSys** – Inherits from StockItem. Represents a GeoVision Sat Nav navigation system.
- **DashCam** – Inherits from StockItem. Has an extra `resolution` attribute.
- **CarMats** – Inherits from StockItem. Has an extra `color` attribute.
- **AirFreshener** – Inherits from StockItem. Has an extra `scent` attribute.

---

## Usage

- Run `ShopGUI` to open the graphical interface.
- Use the top panel to create new stock items by choosing the type, entering a stock code, quantity, and price.
- Use the bottom panel to select an item and add stock, sell stock, or change the price.
- The display area shows the current stock information after each action.
