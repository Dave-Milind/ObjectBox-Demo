package com.milind.testassignment.Search;

import java.util.ArrayList;

public class SearchModel {


ArrayList<Data>data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public class Data{

String url;
String title;
Images images;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}

public class Images{

    FixedHeightSmallStill fixed_height_small_still;
    FixedWidth fixed_width;
    OriginalStill original_still;

    public OriginalStill getOriginal_still() {
        return original_still;
    }

    public void setOriginal_still(OriginalStill original_still) {
        this.original_still = original_still;
    }

    public FixedHeightSmallStill getFixed_height_small_still() {
        return fixed_height_small_still;
    }

    public void setFixed_height_small_still(FixedHeightSmallStill fixed_height_small_still) {
        this.fixed_height_small_still = fixed_height_small_still;
    }



    public FixedWidth getFixed_width() {
        return fixed_width;
    }

    public void setFixed_width(FixedWidth fixed_width) {
        this.fixed_width = fixed_width;
    }
}
public class FixedHeightSmallStill{
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    String url;
    String width;
    String height;

}

class FixedWidth{
String url;
String mp4;
String webp;

    public String getWebp() {
        return webp;
    }

    public void setWebp(String webp) {
        this.webp = webp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMp4() {
        return mp4;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }
}
class OriginalStill{

        String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
}
