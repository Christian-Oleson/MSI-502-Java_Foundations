package OlesonChristian_Rectangle;

/*
@author Christian Oleson
@version 1.0
The RectPrism class which stands for Rectangular Prism
 */
public class RectPrism extends Rectangle {
    private int depth;
    private static int countRectPrismsCreated = 0;

    public RectPrism(int height, int width, int depth) {
        super(height, width);
        setDepth(depth);
        countRectPrismsCreated++;
    }

    /*
    @return the depth of the RectPrism
     */
    public int getDepth() {
        return depth;
    }

    /*
    @param depth set the depth of the RectPrism
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /*
    @return the count of RectPrisms created
     */
    public static int getCountRectPrismsCreated() {
        return countRectPrismsCreated;
    }

    /*
    @return the volume of the RectPrism
     */
    public int computeVolume() {
        return super.computeSurfaceArea() * getDepth();
    }

    /*
    @return the string representation of the RectPrism
     */
    public String toString() {
        return "RectPrism[\n\theight = " + super.getHeight() + ", \n\twidth = " + super.getWidth() + ", \n\tdepth = " + depth + "\n]";
    }
}
