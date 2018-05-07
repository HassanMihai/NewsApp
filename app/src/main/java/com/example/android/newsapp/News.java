package com.example.android.newsapp;

public class News {
    /** Title of the news */
    private String mTitle;

    /** Section of the news */
    private String mSectionName;

    /** Author of the news */
    private String mAuthor;

    /** Publication date of the news */
    private String mDateTime;

    /** Website URL of the news */
    private String mUrl;

    public News(String title, String sectionName, String author, String dateTime, String url) {
        mTitle = title;
        mSectionName = sectionName;
        mAuthor = author;
        mDateTime = dateTime;
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDateTime() {
        return mDateTime;
    }

    public String getUrl() {
        return mUrl;
    }
}
