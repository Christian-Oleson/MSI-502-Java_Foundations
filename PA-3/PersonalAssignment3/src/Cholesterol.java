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
        return _ldl;
    }

    /**
     * Gets the HDL
     * @return HDL
     */
    public int getHdl() {
        return _hdl;
    }

    /**
     * Sets the LDL
     * @param ldl the LDL to set
     */
    public void setLdl(int ldl) {
        _ldl = ldl;
    }

    /**
     * Sets the HDL
     * @param hdl the HDL to set
     */
    public void setHdl(int hdl) {
        _hdl = hdl;
    }

    /**
     * @return the string representation of the cholesterol
     */
    public String toString() {
        return "Cholesterol [\n\tLDL: " + _ldl + ",\n\tHDL: " + _hdl + "\n]";
    }
}