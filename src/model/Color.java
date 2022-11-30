package model;

public enum Color {

    BLACK("Noir"), WHITE("Blanc");

    final String colorFrench;

    Color(String colorFrench) {
        this.colorFrench = colorFrench;
    }

    public String getColorFrench()
    {
        return colorFrench;
    }
}
