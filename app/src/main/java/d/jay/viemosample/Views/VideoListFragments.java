package d.jay.viemosample.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import d.jay.viemosample.Adapter.CategeoryListAdapter;
import d.jay.viemosample.Model.CategeoryModel;
import d.jay.viemosample.Model.VideoModel;
import d.jay.viemosample.Presenter.CategeoryFragmentPresenter;
import d.jay.viemosample.Presenter.VideoListFragmentsPresenter;
import d.jay.viemosample.R;
import d.jay.viemosample.ViewsCallBack.VideoListFragmentsViewInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoListFragments extends Fragment implements VideoListFragmentsViewInterface {
    String TAG ="CategeoryFragments";
    View view;
    RecyclerView recyclerView;
    VideoListFragmentsPresenter videoListFragmentsPresenter;
    CategeoryListAdapter categeoryListAdapter;
    GridLayoutManager gridLayoutManager;
    int pageNo;
    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);
        initilizePresenter();
        getCategeoryList();
        return view;
    }


    public void initilizePresenter()
    {
        videoListFragmentsPresenter = new VideoListFragmentsPresenter(getActivity(),VideoListFragments.this);
    }

    public void getCategeoryList()
    {
        videoListFragmentsPresenter.getVideoList();
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void gotVideoList(ArrayList<VideoModel> categeoryList) {

    }
}
