package me.ihxq.blog.service.utils;

public interface WordCounter {
    default int countText(String text){

        return 0;
    }
}
