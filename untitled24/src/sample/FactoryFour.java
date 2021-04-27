package sample;

public class FactoryFour implements AbstractFactory {
    @Override
    public ArrowFour CreateArrow(double startX, double startY, double endX, double endY) {
        return new ArrowFour(startX, startY, endX, endY);
    }
}
