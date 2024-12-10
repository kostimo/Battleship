// Because a Ship has size and takes several grid cells, we could need such class as shipCell
// 1. Ship will consist of some shipCells which can have different state (e.g. damaged or not damaged)
// 2. Also, it can be helpful because now we can check for example if all shipCells are damaged, in this case
//    we can mark the Ship as sunk.

public class shipCell {
    private final int x;
    private final int y;
    private boolean isDamaged =false;

    public shipCell(int x, int y)
    {
        this.x =x;
        this.y =y;
    }
    public void printCell()
    {
        System.out.println("shipCell: " + x + " " + y + " " + isDamaged);
    }

    public boolean getIsDamaged()
    {
        return isDamaged;
    }
    public void setIsDamaged()
    {
        this.isDamaged =true;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
