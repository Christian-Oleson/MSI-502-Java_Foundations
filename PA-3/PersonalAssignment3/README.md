# Build the class files #
```bash
javac .\BloodPressure.java .\Cholesterol.java .\OlesonChristian_Checkup.java .\OlesonChristian_TestCheckup.java
```

# Create the JAR: #
```bash
jar cfm OlesonChristian_TestCheckup.jar Manifest.txt BloodPressure.class Cholesterol.class OlesonChristian_TestCheckup.class OlesonChristian_Checkup.class
```

# Run the JAR: #
```bash
java -jar .\OlesonChristian_TestCheckup.jar
```