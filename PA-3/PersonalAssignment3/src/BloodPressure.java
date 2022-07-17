public class BloodPressure {
    private int _systolicBloodPressure;
    private int _diastolicBloodPressure;

    public BloodPressure(int systolicBloodPressure, int diastolicBloodPressure) {
        _systolicBloodPressure = systolicBloodPressure;
        _diastolicBloodPressure = diastolicBloodPressure;
    }

    /**
     * Gets the Systolic Blood Pressure
     * @return the Systolic Blood Pressure
     */
    public int getSystolicBloodPressure() {
        return _systolicBloodPressure;
    }

    /**
     * Gets the Diastolic Blood Pressure
     * @return the Diastolic Blood Pressure
     */
    public int getDiastolicBloodPressure() {
        return _diastolicBloodPressure;
    }

    /**
     * Sets the Systolic Blood Pressure
     * @param systolicBloodPressure the Systolic Blood Pressure to set
     */
    public void setSystolicBloodPressure(int systolicBloodPressure) {
        _systolicBloodPressure = systolicBloodPressure;
    }

    /**
     * Sets the Diastolic Blood Pressure
     * @param diastolicBloodPressure the Diastolic Blood Pressure to set
     */
    public void setDiastolicBloodPressure(int diastolicBloodPressure) {
        _diastolicBloodPressure = diastolicBloodPressure;
    }

    /**
     * @return the string representation of the blood pressure
     */
    public String toString() {
        return "Blood Pressure [ \n\tSystolic Blood Pressure: " + _systolicBloodPressure + ", \n\tDiastolic Blood Pressure: " + _diastolicBloodPressure + "\n]";
    }
}