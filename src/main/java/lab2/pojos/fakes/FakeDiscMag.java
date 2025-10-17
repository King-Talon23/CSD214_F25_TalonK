package lab2.pojos.fakes;

import lab2.pojos.Magazine;

public class FakeDiscMag extends Magazine {
    private boolean hasDisc;

    public FakeDiscMag(FakeMagazine dm, boolean b) {
    }


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
