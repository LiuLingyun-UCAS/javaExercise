package com.lly.chapter08.collection_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class CollectionExercise01 {

    public static void main(String[] args) {
        List<News> news = new ArrayList<>();
        news.add(new News("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣域“，引民众担忧"));
        news.add(new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));
        Collections.reverse(news);
        for (News n : news) {
            System.out.println(n);
        }

    }
}

class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        if (title.length() <= 15){
            return title;
        }
        return title.substring(0, 15) + "...";
    }
}
