public class BloodPressure {
    private int _systolicBloodPressure;
    private int _diastolicBloodPressure;

    public BloodPressure(int systolicBloodPressure, int diastolicBloodPressure) {
        _systolicBloodPressure = systolicBloodPressure;
        _diastolicBloodPressure = diastolicBloodPressure;
    }

    /**
     * Sets the Systolic Blood Pressure
     * @param systolicBloodPressure the Systolic Blood Pressure to set
     */
    public void setSystolicBloodPressure(int systolicBloodPressure) {
        System.out.println("Setting Systolic Blood Pressure...");
        _systolicBloodPressure = systolicBloodPressure;
    }

    /**
     * Sets the Diastolic Blood Pressure
     * @param diastolicBloodPressure the Diastolic Blood Pressure to set
     */
    public void setDiastolicBloodPressure(int diastolicBloodPressure) {
        System.out.println("Setting Diastolic Blood Pressure...");
        _diastolicBloodPressure = diastolicBloodPressure;
    }

    /**
     * @return the string representation of the blood pressure
     */
    public String toString() {
        System.out.println("Printing blood pressure...");
        return "Blood Pressure [ \n\tSystolic Blood Pressure: " + _systolicBloodPressure + ", \n\tDiastolic Blood Pressure: " + _diastolicBloodPressure + "\n]";
    }
}