package com.lisamia;

import java.awt.*;

public class WuLine {

    public static void drawLine(Graphics g, double x0, double y0, double x1, double y1) {
        boolean steep = Math.abs(y1 - y0) > Math.abs(x1 - x0);
        double temp;
        if (steep) {
            temp = x0;
            x0 = y0;
            y0 = temp;
            temp = x1;
            x1 = y1;
            y1 = temp;
        }
        if (x0 > x1) {
            temp = x0;
            x0 = x1;
            x1 = temp;

            temp = y0;
            y0 = y1;
            y1 = temp;
        }

        double dx = x1 - x0;
        double dy = y1 - y0;
        if (dx == 0 || dy == 0) {
            g.drawLine((int)x0, (int)y0, (int)x1, (int)y1);
            return;
        }

        double transparency = dy / dx;

        double xEnd = round(x0);
        double yEnd = y0 + transparency * (xEnd - x0);
        double xGap = rDoublePart(x0 + 0.5);
        double xPixel1 = xEnd;
        double yPixel1 = intPart(yEnd);

        if (steep) {
            draw(g, yPixel1, xPixel1, rDoublePart(yEnd) * xGap);
            draw(g, yPixel1 + 1, xPixel1, doublePart(yEnd) * xGap);
        } else {
            draw(g, xPixel1, yPixel1, rDoublePart(yEnd) * xGap);
            draw(g, xPixel1, yPixel1 + 1, doublePart(yEnd) * xGap);
        }
        double intery = yEnd + transparency;

        xEnd = round(x1);
        yEnd = y1 + transparency * (xEnd - x1);
        xGap = doublePart(x1 + 0.05);
        double xPixel2 = xEnd;
        double yPixel2 = intPart(yEnd);
        if (steep) {
            draw(g, yPixel2, xPixel2, rDoublePart(yEnd) * xGap);
            draw(g, yPixel2 + 1, xPixel2, doublePart(yEnd) * xGap);
        } else {
            draw(g, xPixel2, yPixel2, rDoublePart(yEnd) * xGap);
            draw(g, xPixel2, yPixel2 + 1, doublePart(yEnd) * xGap);
        }

        if (steep) {
            for (int x = (int) (xPixel1 + 1); x <= xPixel2 - 1; x++) {
                draw(g, intPart(intery), x, rDoublePart(intery));
                draw(g, intPart(intery) + 1, x, doublePart(intery));
                intery += transparency;
            }
        } else {
            for (int x = (int) (xPixel1 + 1); x <= xPixel2 - 1; x++) {
                draw(g, x, intPart(intery), rDoublePart(intery));
                draw(g, x, intPart(intery) + 1, doublePart(intery));
                intery += transparency;
            }
        }
    }

    private static void draw(Graphics g, double x, double y, double c) {
        g.setColor(new Color(0f, 0f, 0f, (float) c));
        g.fillRect((int) x-1, (int) y-1, 2, 2);
    }
    private static double doublePart(double x) {
        if (x < 0) return (1 - (x - Math.floor(x)));
        return (x - Math.floor(x));
    }

    private static int intPart(double x) {
        return (int) x;
    }
    private static double rDoublePart(double x) {
        return 1 - doublePart(x);
    }

    private static int round(double x) {
        return intPart(x + 0.05);
    }

}
