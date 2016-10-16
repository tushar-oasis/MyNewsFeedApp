package com.oasis.mynewsfeedapp;

/**
 * Created by Oasis on 12-10-2016.
 */

public class News {

    /** Abstract of the news */
    private String mTitle;

    /** Published on date and time string*/
    private String mPublishedOn;

    /** Details URL for the news */
    private String mDetailsUrl;

    /** Author of the news */
    private String mAuthor;

    /**
     *
     * @param anAbstract
     * @param author
     * @param publishedOn
     * @param detailsUrl
     */
    public News(String anAbstract, String author, String publishedOn, String detailsUrl) {
        mTitle = anAbstract;
        mAuthor = author;
       mPublishedOn = publishedOn;
        mDetailsUrl = detailsUrl;
    }

    /**
     *
     * @return abstract of the news
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     *
     * @return authhor of the news
     */
    public String getAuthor() {
        return mAuthor;
    }

    /**
     *
     * @return published on details about the news article
     */
    public String getPublishedOn() {
        return mPublishedOn;
    }

    /**
     *
     * @return details URL of the news
     */
    public String getDetailsUrl() {
        return mDetailsUrl;
    }
}
