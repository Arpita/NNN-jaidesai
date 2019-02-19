package d.jay.viemosample.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import d.jay.viemosample.Adapter.CategeoryListAdapter;
import d.jay.viemosample.ViewsCallBack.CategeoryfragmentsViewInterface;
import d.jay.viemosample.Model.CategeoryModel;
import d.jay.viemosample.Presenter.CategeoryFragmentPresenter;
import d.jay.viemosample.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategeoryFragments extends Fragment implements CategeoryfragmentsViewInterface {
    String TAG ="CategeoryFragments";
    View view;
    RecyclerView recyclerView;
    CategeoryFragmentPresenter categeoryFragmentPresenter;
    CategeoryListAdapter categeoryListAdapter;
    GridLayoutManager gridLayoutManager;
    ProgressBar progressBar;

    public CategeoryFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categeory_fragments, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);
        initilizePresenter();
        getCategeoryList();
        return view;
    }

    public void initilizePresenter()
    {
      categeoryFragmentPresenter = new CategeoryFragmentPresenter(getActivity(),CategeoryFragments.this);
    }

    public void getCategeoryList()
    {
        categeoryFragmentPresenter.getCategeoryList();
    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void gotListOfCategeory(ArrayList<CategeoryModel> categeoryList) {
        Log.i(TAG,"this is value of response" +categeoryList.get(0).getCategeoryName());
        gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        categeoryListAdapter = new CategeoryListAdapter(getActivity(), categeoryList);
        recyclerView.setAdapter(categeoryListAdapter);
    }
}
