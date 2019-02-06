package me.ihxq.blog.utils;

public interface WordCounter {
    default int countText(String text) {

        return 0;
    }
}
