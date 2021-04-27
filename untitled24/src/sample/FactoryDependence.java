package sample;

public class FactoryDependence implements AbstractFactory {
    @Override
    public ArrowDependence CreateArrow(double startX, double startY, double endX, double endY) {
        return new ArrowDependence(startX, startY, endX, endY);
    }
}
