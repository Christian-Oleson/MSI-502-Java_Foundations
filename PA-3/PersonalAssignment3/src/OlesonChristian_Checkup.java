public class OlesonChristian_Checkup {
    private int _patientNumber;
    private BloodPressure _bloodPressure;
    private Cholesterol _cholesterol;

    public OlesonChristian_Checkup(int patientNumber) {
        System.out.println("Creating new checkup for patient " + patientNumber);
        _patientNumber = patientNumber;
        _bloodPressure = new BloodPressure(0, 0);
        _cholesterol = new Cholesterol(0, 0);
    }

    /**
     * Sets the Systolic Blood Pressure
     */
    public void setSystolicBloodPressure(int systolicBloodPressure) {
        _bloodPressure.setSystolicBloodPressure(systolicBloodPressure);
    }

    /**
     * Sets the Diastolic Blood Pressure
     */
    public void setDiastolicBloodPressure(int diastolicBloodPressure) {
        _bloodPressure.setDiastolicBloodPressure(diastolicBloodPressure);
    }

    /**
     * Sets the Blood Pressure
     */
    public void setBloodPressure(BloodPressure bloodPressure) {
        System.out.println("Setting blood pressure to " + bloodPressure);
        _bloodPressure = bloodPressure;
    }

    /**
     * Sets the LDL
     */
    public void setLdl(int ldl) {
        _cholesterol.setLdl(ldl);
    }

    /**
     * Sets the HDL
     */
    public void setHdl(int hdl) {
        _cholesterol.setHdl(hdl);
    }

    /**
     * Sets the Cholesterol
     */
    public void setCholesterol(Cholesterol cholesterol) {
        System.out.println("Setting cholesterol to " + cholesterol);
        _cholesterol = cholesterol;
    }

    /**
     * Gets the LDL
     * @return the LDL
     */
    public int getLdl() {
        System.out.println("Getting LDL");
        return _cholesterol.getLdl();
    }

    /**
     * Gets the HDL
     * @return the HDL
     */
    public int getHdl() {
        System.out.println("Getting HDL");
        return _cholesterol.getHdl();
    }

    /**
     * Gets the Cholesterol
     * @return the cholesterol
     */
    public Cholesterol getCholesterol() {
        System.out.println("Getting cholesterol");
        return _cholesterol;
    }

    /**
     * @return Computers the ratio of HDL to LDL.
     */
    public double computeRatio() {
        System.out.println("Computing ratio...");
        return (double) getHdl() / (double) getLdl();
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