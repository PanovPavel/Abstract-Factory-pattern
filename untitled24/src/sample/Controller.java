package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Callback;

public class Controller {
    public Canvas canvas;
    public GraphicsContext gr;
    public ListView viewArrow;
    private ObservableList<AbstractProductArrow> items;
    private AbstractProductArrow currentArrow1;
    public void initialize() {
        ArrowDependence currentArrow = new FactoryDependence().CreateArrow(1, 5, 55, 55);
        ArrowAssociation arrowAssociation = new FactoryAssociation().CreateArrow(1, 5, 55, 55);
        ArrowFour arrowFour = new FactoryFour().CreateArrow(1, 5, 55, 55);
        items = FXCollections.observableArrayList(currentArrow,arrowAssociation,arrowFour);
        viewArrow.setItems(items);
        viewArrow.getSelectionModel().select(1);
        //choiceBox.setValue("Ассоциация");
        gr = canvas.getGraphicsContext2D();
        currentArrow1 = null;
        viewArrow.setCellFactory(new Callback<ListView<AbstractProductArrow>, ListCell<AbstractProductArrow>>() {
            @Override
            public ListCell<AbstractProductArrow> call(ListView<AbstractProductArrow> listView) {
                ListCell<AbstractProductArrow> cella = new ListCell() {
                    protected void updateItem(Object item, boolean empty) {
                        super.updateItem(item,empty);
                        AbstractProductArrow apa = ((AbstractProductArrow) item);
                        if(apa != null) {
                            Canvas cnv=new Canvas();
                            cnv.setHeight(60);// задание размера элемента отображения
                            cnv.setWidth(100);
                            GraphicsContext gr=cnv.getGraphicsContext2D();
                            apa.setStartX(10);
                            apa.setEndX(55);
                            apa.setStartY(10);
                            apa.setEndY(55);
                            apa.draw(gr);
                            setGraphic(cnv);
                        }
                    }
                };
                return cella;
            }
        });
    }
    public void mouseClicked(MouseEvent mouseEvent) {
    }
    public void mousePressed(MouseEvent mouseEvent) {
        currentArrow1 = (AbstractProductArrow) items.get(viewArrow.getSelectionModel().getSelectedIndex()).clone();
        currentArrow1.setStartX(mouseEvent.getX());
        currentArrow1.setStartY(mouseEvent.getY());
    }
    public void mouseReleased(MouseEvent mouseEvent) {
        if(currentArrow1 != null) {
            currentArrow1.setEndX(mouseEvent.getX());
            currentArrow1.setEndY(mouseEvent.getY());
            currentArrow1.draw(gr);
        }
    }
}

