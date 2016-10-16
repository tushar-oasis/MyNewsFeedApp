package com.oasis.mynewsfeedapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Oasis on 12-10-2016.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOCATION_SEPARATOR = "T";

    /**
     *
     * @param context of the app
     * @param news is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news){

        super(context, 0, news);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view(called converView) that we can reuse,
        // otherwise, if convertView is null, inflate a new list item layout.

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).
                    inflate(R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the given list of news
        News currentNews = getItem(position);

        // Find the TextView with view ID abstract
        TextView abstractView = (TextView) listItemView.findViewById(R.id.abstract_view);

        // Get the string value of the abstract news from the current word and put in the text field
        abstractView.setText(currentNews.getTitle());

        // Get the TextView with view ID author_view
        TextView authorView = (TextView) listItemView.findViewById(R.id.author_view);
        authorView.setText(currentNews.getAuthor());

        // Get the published on details about the new article
        String publishedOn = currentNews.getPublishedOn();

        // String to hold the published on date
        String publishedDate;
        // String hold published on time
        String publishedTime;

        /**
         * If the original published on string contains "T", then split it using that keyword.
         */
        if (publishedOn.contains(LOCATION_SEPARATOR)) {
            String[] publishedOnDetails = publishedOn.split(LOCATION_SEPARATOR);
            publishedDate = publishedOnDetails[0];
            publishedTime = publishedOnDetails[1];
        }else{
            publishedDate = "Time and date";
            publishedTime = "not provided";
        }
        TextView publishedDateView = (TextView) listItemView.findViewById(R.id.published_date_view);
        publishedDateView.setText(publishedDate);

        TextView publishedTimeView = (TextView) listItemView.findViewById(R.id.published_time_view);
        publishedTimeView.setText(publishedTime);

        return listItemView;
    }
}
