package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ArrowFour extends AbstractProductArrow implements Cloneable {
    double arrowHeadSize;// размер кончика стрелки

    public ArrowFour(double x, double y, double w, double h ) {
        this.color = Color.BLACK;
        this.startX = x;
        this.startY = y;
        this.endX = w;
        this.endY = h;
        // определение пропорций кончика стрелки
        arrowHeadSize=0.09*Math.sqrt((startX-endX)*(startX-endX)+(startX-endX)*(startX-endX));
    }
    public void draw(GraphicsContext gc) {
        drawArrowstart(gc);//начало стрелки
        drawLine(gc);//линия
        drawArrowend(gc);//конец стрелки
    }

    public String toString() {
        return "Зависимость";
    }

    public void drawArrowstart(GraphicsContext gc) {
        gc.setFill(color);
        gc.strokeOval(startX-width, startY-width, 2*width, 2*width);
    }

    public void drawLine(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(width);
        gc.setLineDashes(4.);
        gc.moveTo(startX, startY);
        gc.lineTo(endX, endY);
        gc.stroke();// соединить точки
    }

    public void drawArrowend(GraphicsContext gc) {
        gc.moveTo(endX, endY);
        double angle = Math.atan2((endY - startY), (endX - startX)) - Math.PI / 2.0;
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        //point1
        double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
        double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
        //point2
        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
        gc.lineTo(x1, y1);
        gc.moveTo(x2, y2);
        gc.lineTo(endX, endY);
        gc.strokeRect(endX,endY,8,8);
    }

    public void setStartPoint(double startX, double startY) {
        this.startX = startX;
        this.startY = startY;
    }

    public void setEndPoint(double endX, double endY) {
        this.endX = endX;
        this.endY = endY;
        arrowHeadSize=0.09*Math.sqrt((startX-this.endX)*(startX-this.endX)+(startX-this.endX)*(startX-this.endX));
    }
}
