package com.example.android.udacitynewsappproject;

public class News {

    /**
     * Name of the section
     */
    private String mSection;

    /**
     * Title of the article
     */
    private String mTitle;

    /**
     * Time of the publication
     */
    private String mPublicationTime;

    /**
     * Website URL of the news item
     */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param title           is the magnitude (size) of the earthquake
     * @param section         is the section under which the article was published
     * @param publicationTime is the time when the article was published
     */
    public News(String section, String title, String publicationTime, String url) {
        mTitle = title;
        mSection = section;
        mPublicationTime = publicationTime;
        mUrl = url;
    }

    /**
     * Returns the section of the article.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the title of the article.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the time of the publication.
     */
    public String getPublicationTime() {
        return mPublicationTime;
    }

    public String getUrl() {
        return mUrl;
    }
}
