package de.michel.mysql.readData;

public class Test
{
  public static void main(String[] args)
  {
    // Abfrage aller vorhandenen Namen
    MySQLConnection.printNameList();

    // Neuen Datensatz hinzufügen
    MySQLConnection.insertName("Simon", "Michel");

    // Datensatz mit der ID 1 ändern
    MySQLConnection.updateName("Peter", "Pan", 1);
  }
}