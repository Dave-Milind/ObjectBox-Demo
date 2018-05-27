package com.milind.testassignment.Search;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.jakewharton.rxbinding2.view.RxView;
import com.milind.testassignment.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridViewAdapter extends BaseAdapter {

    SearchModel searchModel;
    Context context;
    SearchController searchController;
    String url;


    public GridViewAdapter(Context context, SearchModel searchModel,SearchController searchController) {
        this.searchModel = searchModel;
        this.context = context;
       this. searchController=searchController;
    }

    @Override
    public int getCount() {
        return searchModel.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(context);
            grid = inflater.inflate(R.layout.gridviewlayout, null);

            ImageView imageView = (ImageView) grid.findViewById(R.id.imgView_grid);

            //Getting still image url
            url = searchModel.getData().get(position).getImages().getOriginal_still().getUrl();

            Picasso.get().load(url).into(imageView);
            Log.e("rrr", "getView called , url= " + url);


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //getting Mp4 url and giving it to next controller when clicked on image
                   String mp4Url=searchModel.getData().get(position).getImages().getFixed_width().getMp4();
                searchController.onImageClick(mp4Url);
                }
            });


        } else {
            grid = (View) convertView;
        }

        return grid;
    }



}
