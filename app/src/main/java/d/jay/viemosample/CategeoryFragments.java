package d.jay.viemosample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import d.jay.viemosample.Model.CategeoryModel;
import d.jay.viemosample.Presenter.CategeoryFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategeoryFragments extends Fragment implements CategeoryfragmentsViewInterface{
    String TAG ="CategeoryFragments";
    View view;
    RecyclerView recyclerView;
    CategeoryFragmentPresenter categeoryFragmentPresenter;


    public CategeoryFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categeory_fragments, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
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

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void gotListOfCategeory(ArrayList<CategeoryModel> categeoryList) {
        Log.i(TAG,"this is value of response" +categeoryList.get(0).getCategeoryName());
    }
}
