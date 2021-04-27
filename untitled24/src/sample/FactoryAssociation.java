package sample;

public class FactoryAssociation implements AbstractFactory {
    @Override
    public ArrowAssociation CreateArrow(double startX, double startY, double endX, double endY) {
        return new ArrowAssociation(startX, startY, endX, endY);
    }
}
