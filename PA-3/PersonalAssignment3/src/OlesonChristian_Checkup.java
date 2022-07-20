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
     * Gets the patient number
     * @return the patient number (integer)
     */
    public int getPatientNumber() {
        return _patientNumber;
    }

    /**
     * Gets the Systolic Blood Pressure
     * @return the Systolic Blood Pressure (integer)
     */
    public int getSystolicBloodPressure() {
        return BloodPressure.getSystolicBloodPressure();
    }

    /**
     * Gets the Diastolic Blood Pressure
     * @return the Diastolic Blood Pressure (integer)
     */
    public int getDiastolicBloodPressure() {
        return BloodPressure.getDiastolicBloodPressure();
    }

    /**
     * Gets the LDL
     * @return the LDL (integer)
     */
    public int getLdl() {
        return Cholesterol.getLdl();
    }

    /**
     * Gets the HDL
     * @return the HDL (integer)
     */
    public int getHdl() {
        return Cholesterol.getHdl();
    }

    /**
     * Sets the Systolic Blood Pressure
     * @param systolicBloodPressure the Systolic Blood Pressure to set
     */
    public void setSystolicBloodPressure(int systolicBloodPressure) {
        BloodPressure.setSystolicBloodPressure(systolicBloodPressure);
    }

    /**
     * Sets the Diastolic Blood Pressure
     * @param diastolicBloodPressure the Diastolic Blood Pressure to set
     */
    public void setDiastolicBloodPressure(int diastolicBloodPressure) {
        BloodPressure.setDiastolicBloodPressure(diastolicBloodPressure);
    }

    /**
     * Sets the LDL
     * @param ldl the LDL to set
     */
    public void setLdl(int ldl) {
        Cholesterol.setLdl(ldl);
    }

    /**
     * Sets the HDL
     * @param hdl the HDL to set
     */
    public void setHdl(int hdl) {
        Cholesterol.setHdl(hdl);
    }

    /**
     * Computes the ratio of HDL to LDL
     * @return the ratio of HDL to LDL (double)
     */
    public double computeRatio() {
        return Cholesterol.computeRatio();
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