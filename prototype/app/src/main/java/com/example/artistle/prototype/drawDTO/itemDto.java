package com.example.artistle.prototype.drawDTO;

/**
 * Created by artistle on 01.11.17.
 */

public class itemDto {
    String title;
    String content;
    int buy;

    public itemDto() {
    }

    public itemDto(String title, String content, int buy) {
        this.title = title;
        this.content = content;
        this.buy = buy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }
}
