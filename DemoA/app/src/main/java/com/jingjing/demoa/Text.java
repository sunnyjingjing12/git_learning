package com.jingjing.demoa;

/**
 * 放.txt里的字段
 */
public class Text {
    private String text;

    public Text(byte[] butter, String text) {
        this.text = text;
    }
    public  String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
