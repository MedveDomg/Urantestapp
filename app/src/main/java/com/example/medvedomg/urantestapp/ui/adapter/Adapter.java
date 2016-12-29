package com.example.medvedomg.urantestapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medvedomg.urantestapp.R;
import com.example.medvedomg.urantestapp.ui.activity.MainActivity;
import com.example.medvedomg.urantestapp.ui.model.FileModel;
import com.example.medvedomg.urantestapp.ui.model.FileType;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by medvedomg on 28.12.16.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.TestViewHolder>{

    ArrayList<FileModel> mList = new ArrayList<>();

    MainActivity mMainActivity;

    int mBarCheck;

    FileType mIconCheck;

    int imageBar;


    public Adapter(MainActivity mainActivity) {

        mMainActivity = mainActivity;
//        mList = list;
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageBar;
        ImageView mImageIcon;
        TextView mTvMainName;
        TextView mTvModifiedName;

        public TestViewHolder(View itemView) {
            super(itemView);

            mImageBar = (ImageView) itemView.findViewById(R.id.image_bar_color);
            mImageIcon = (ImageView) itemView.findViewById(R.id.image_main_icon);
            mTvMainName = (TextView) itemView.findViewById(R.id.tv_main_nameitem);
            mTvModifiedName = (TextView) itemView.findViewById(R.id.tv_main_modified);
        }
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recyclerview, parent,false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        FileModel fileModel = mList.get(position);

//        mBarCheck = fileModel.isBlue() ? R.drawable.blue_bar : R.drawable.orange_bar;
        Picasso.with(mMainActivity.getActivityContext())
                .load(R.drawable.orange_bar)
//                .fit()
                .into(holder.mImageBar);
//        holder.mImageBar.setImageResource(R.drawable.blue_bar);
//        mIconCheck = fileModel.getFileType();
//
//        switch (mIconCheck) {
//            case IMAGE:
//                imageBar = R.drawable.image_icon;
//                break;
//            case FOLDER:
//                imageBar = R.drawable.folder_icon;
//                break;
//            case OBJECT:
//                imageBar = R.drawable.file_icon;
//                break;
//            default:
//                imageBar = R.drawable.image_icon;
//        }

        Picasso.with(mMainActivity.getApplicationContext())
                .load(R.drawable.file_icon)
                .into(holder.mImageIcon);
//
        holder.mTvMainName.setText(fileModel.getFileName());
        holder.mTvModifiedName.setText("modified 06.06.2016");
    }

    @Override
    public int getItemCount() {
        return mList.size();
//        return 10;
    }

    public void updateFilesList(ArrayList<FileModel> files) {
        this.mList.clear();
        this.mList.addAll(files);
        notifyDataSetChanged();
    }

}
