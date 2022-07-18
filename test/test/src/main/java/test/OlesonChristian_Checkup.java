package test;

public class OlesonChristian_Checkup {
    private int _patientNumber;
    public BloodPressure _bloodPressure;
    public Cholesterol _cholesterol;

    public OlesonChristian_Checkup(int patientNumber) {
        System.out.println("Creating new checkup for patient " + patientNumber);
        _patientNumber = patientNumber;
        _bloodPressure = new BloodPressure(0, 0);
        _cholesterol = new Cholesterol(0, 0);
    }

    /**
     * @return Computers the ratio of HDL to LDL.
     */
    public double computeRatio() {
        System.out.println("Computing ratio...");
        return (double) _cholesterol.getHdl() / (double) _cholesterol.getLdl();
    }

    /**
     * Prints the checkup results for a patient to string.
     */
    public String toString() {
        return "Patient Number: " + _patientNumber + ",\n" +
               _bloodPressure + ",\n" +
               _cholesterol + ",\n" +
               "Ratio: " + computeRatio() + "\n" +
                "HDL is known as \"good cholesterol\".\n" +
                "You should try to keep your cholesterol ratio below 5, with the optimal cholesterol ratio being 3.5.";
    }
}