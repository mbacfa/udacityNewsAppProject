package com.example.android.udacitynewsappproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * The part of the title string that we use to determine
     * whether or not there is an author present.
     */
    private static final String AUTHOR_SEPARATOR = " | ";


    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param newss   is the list of articles, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> newss) {
        super(context, 0, newss);
    }

    /**
     * Returns a list item view that displays information about the article at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the article at the given position in the list of news
        News currentNews = getItem(position);


        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section_title);
        // Get the section name
        String section = currentNews.getSection();
        // Display the section name in that TextView
        sectionView.setText(section);

        // Get the title
        String title = currentNews.getTitle();

        // If the original title string contains
        // an author and an article title
        // then store the author separately from the article title in 2 Strings,
        // so they can be displayed in 2 TextViews.
        String authorName;
        String articleTitle;

        // Check whether the title string contains the " | " symbol
        if (title.contains(AUTHOR_SEPARATOR)) {
            // Split the string into different parts (as an array of Strings)
            // based on the " | " symbol. We expect an array of 2 Strings, where
            // the first String will be title and the second String will be author.
            String[] parts = title.split(AUTHOR_SEPARATOR);
            articleTitle = parts[0] + AUTHOR_SEPARATOR;
            authorName = parts[1];
        } else {
            // Otherwise, there is no " | " symbol in the title string.
            articleTitle = title;
            // Hence, set the default author name to say "Staff".
            authorName = getContext().getString(R.string.default_author_name);
        }

        // Find the TextView with view ID news_title
        TextView titleView = (TextView) listItemView.findViewById(R.id.news_title);
        // Display the title in that TextView
        titleView.setText(articleTitle);


        // Find the TextView with view ID author name
        TextView authorNameView = (TextView) listItemView.findViewById(R.id.author_name);
        // Display the location offset of the current earthquake in that TextView
        authorNameView.setText(authorName);

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String publicationDate = currentNews.getPublicationTime();
        // Display the date in that TextView
        dateView.setText(publicationDate);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }


}
