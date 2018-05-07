package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String DATE_SEPARATOR = "T";
    private static final String TIME_SEPARATOR = "Z";

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param allNews is the list of allNews, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> allNews) {
        super(context, 0, allNews);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the list of news
        News currentNews = getItem(position);

        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        // Display the title of the current News in that TextView
        titleView.setText(currentNews.getTitle());

        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        // Display the section name of the current News in that TextView
        sectionView.setText(currentNews.getSectionName());

        // Find the TextView with view ID author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        if (currentNews.getAuthor() != null) {
            // Display the author of the current News in that TextView
            authorView.setText(currentNews.getAuthor());
        } else {
            authorView.setVisibility(View.INVISIBLE);
        }

        String originalDateTime = currentNews.getDateTime();

        String newsDate;
        String newsTime;

        if (originalDateTime.contains(DATE_SEPARATOR)) {
            String[] parts = originalDateTime.split(DATE_SEPARATOR);
            newsDate = parts[0];
            if (parts[1].contains(TIME_SEPARATOR)) {
                newsTime = parts[1].replace(TIME_SEPARATOR, "");
            } else {
                newsTime = parts[1];
            }
        } else {
            newsDate = null;
            newsTime = null;
        }

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        if (newsDate != null) {
            // Display the date of the current News in that TextView
            dateView.setText(newsDate);
        } else {
            dateView.setVisibility(View.GONE);
        }

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        if (newsTime != null) {
            // Display the time of the current News in that TextView
            timeView.setText(newsTime);
        } else {
            timeView.setVisibility(View.GONE);
        }

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
