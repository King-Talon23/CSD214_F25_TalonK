package lab2.pojos;

public class discMag extends magazine {
    private boolean hasDisc;


    public boolean isHasDisc() { return hasDisc; }
    public void setHasDisc(boolean hasDisc) { this.hasDisc = hasDisc; }


    @Override
    public void initialize() {
        super.initialize();
        this.hasDisc = getInputBoolean("Has disc (true/false)", hasDisc);
    }


    @Override
    public void edit() { initialize(); }


    @Override
    public void sellItem() { super.sellItem(); }
}
