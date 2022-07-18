package OlesonChristian_TestCheckup;

public class Cholesterol {
    private int _ldl;
    private int _hdl;

    public Cholesterol(int ldl, int hdl) {
        _ldl = ldl;
        _hdl = hdl;
    }

    /**
     * Gets the LDL
     * @return LDL
     */
    public int getLdl() {
        System.out.println("Getting LDL...");
        return _ldl;
    }

    /**
     * Gets the HDL
     * @return HDL
     */
    public int getHdl() {
        System.out.println("Getting HDL...");
        return _hdl;
    }

    /**
     * Sets the LDL
     * @param ldl the LDL to set
     */
    public void setLdl(int ldl) {
        System.out.println("Setting LDL...");
        _ldl = ldl;
    }

    /**
     * Sets the HDL
     * @param hdl the HDL to set
     */
    public void setHdl(int hdl) {
        System.out.println("Setting HDL...");
        _hdl = hdl;
    }

    /**
     * @return the string representation of the cholesterol
     */
    public String toString() {
        System.out.println("Printing cholesterol...");
        return "Cholesterol [\n\tLDL: " + _ldl + ",\n\tHDL: " + _hdl + "\n]";
    }
}