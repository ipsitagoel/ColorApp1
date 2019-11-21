package com.ipsita.colorapp1;

public class Colors {
    private String colorName, hexCode;

    public Colors(){
      colorName="Red";
      hexCode="0";
    }

    public Colors(String colorName, String hexCode) {
        this.colorName = colorName;
        this.hexCode = hexCode;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }
}
