public class OlesonChristian_Checkup {
    private int _patientNumber;
    public BloodPressure BloodPressure;
    public Cholesterol Cholesterol;

    public OlesonChristian_Checkup(int patientNumber) {
        System.out.println("Creating new checkup for patient " + patientNumber);
        _patientNumber = patientNumber;
        BloodPressure = new BloodPressure(0, 0);
        Cholesterol = new Cholesterol(0, 0);
    }

    /**
     * Prints the checkup results for a patient to string.
     */
    public String toString() {
        return "Patient Number: " + _patientNumber + ",\n" +
                BloodPressure + ",\n" +
                Cholesterol + ",\n" +
               "Ratio: " + Cholesterol.computeRatio() + "\n" +
                "HDL is known as \"good cholesterol\".\n" +
                "You should try to keep your cholesterol ratio below 5, with the optimal cholesterol ratio being 3.5.";
    }
}