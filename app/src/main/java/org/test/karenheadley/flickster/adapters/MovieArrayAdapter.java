package org.test.karenheadley.flickster.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.test.karenheadley.flickster.R;
import org.test.karenheadley.flickster.models.Movie;

import java.util.List;

import static org.test.karenheadley.flickster.R.id.tvOverview;

/**
 * Created by Bubba on 10/9/2016.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    //view lookup cache
    private static class ViewHolder{
        TextView name;
        TextView home;
    }
    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item for this postion
        Movie movie = getItem(position);

        //check if existing view is being reused, otherwise inflat the view
        ViewHolder viewHolder;


        //check the existing view being reused
        if (convertView == null){
            // if no view to reuse, inflate a brand new view for row
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie,parent, false);

           /* VIEWHOLDER CODE:  */
           viewHolder.name = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.home = (TextView) convertView.findViewById(tvOverview);

            convertView.setTag(viewHolder);
                       /* VIEWHOLDER CODE:  */

        }
        /*  VIEWHOLDER CODE:   */
        else {
            // view is being recycled, retrieve the viewHolder object for tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.movieImage);

        //clear out image from vonvertView
        ivImage.setImageResource(0);

       /*   Replaced with viewholder pattern */
        /*TextView tvtitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);*/
               //populate data
          /*  tvtitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());*/
        /*   Replaced with viewholder pattern */


        /*VIEWHOLDER CODE:   */
        //populate the data into the template view using the data object
        viewHolder.name.setText(movie.getOriginalTitle());
        viewHolder.home.setText(movie.getOverview());

        /*VIEWHOLDER CODE:   */
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);

        //return the view
        return convertView;
    }


}
