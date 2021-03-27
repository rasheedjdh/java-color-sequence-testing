package com.rasheedjdh;

public class CapacityRule {
    int windowWidth;
    Color color;
    int maxCapacity;

    public CapacityRule(int windowWidth, Color color, int maxCapacity) {
        this.windowWidth = windowWidth;
        this.color = color;
        this.maxCapacity = maxCapacity;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "CapacityRule{" +
                "windowWidth=" + windowWidth +
                ", color=" + color +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
