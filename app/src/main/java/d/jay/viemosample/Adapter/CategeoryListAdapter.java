package d.jay.viemosample.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import d.jay.viemosample.Model.CategeoryModel;
import d.jay.viemosample.R;

public class CategeoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    CategeoryListViewHolder viewHolder;
    Context context;
    ArrayList<CategeoryModel> categeoryList;

    public CategeoryListAdapter(Context context,ArrayList<CategeoryModel> categeoryList)
    {
        this.context = context;
        this.categeoryList = categeoryList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View viewItem = inflater.inflate(R.layout.raw_categeory_list, viewGroup, false);
        viewHolder = new CategeoryListViewHolder(viewItem);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    final CategeoryListViewHolder categeoryListViewHolder = (CategeoryListViewHolder) viewHolder;
    CategeoryModel categeoryModel = categeoryList.get(i);
        Glide.with(context).load(categeoryModel.getCategeoryPoster()).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                categeoryListViewHolder.progressBar.setVisibility(View.GONE);

                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                categeoryListViewHolder.progressBar.setVisibility(View.GONE);

                return false;
            }
        } ).apply(new RequestOptions().centerCrop()).into(categeoryListViewHolder.iv_categeoryPoster);

        categeoryListViewHolder.tv_categeoryName.setText(categeoryModel.getCategeoryName());
    }

    @Override
    public int getItemCount() {
        return categeoryList.size();
    }

    public class CategeoryListViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView iv_categeoryPoster;
        public ProgressBar progressBar;
        public TextView tv_categeoryName;

        public CategeoryListViewHolder(View itemView) {
            super(itemView);

            iv_categeoryPoster = itemView.findViewById(R.id.iv_categeoryPoster);
            progressBar = itemView.findViewById(R.id.progressBar);
            tv_categeoryName = itemView.findViewById(R.id.tv_categeoryName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 //   videoListCallBack.onClickVideoList(videoList.get(getAdapterPosition()));
                }
            });

        }
    }
}
