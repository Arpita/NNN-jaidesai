package d.jay.viemosample.ViewsCallBack;

import java.util.ArrayList;

import d.jay.viemosample.Model.CategeoryModel;
import d.jay.viemosample.Model.VideoModel;

public interface VideoListFragmentsViewInterface {
    public void showProgressbar();
    public void hideProgressbar();
    public void gotVideoList(ArrayList<VideoModel> categeoryList);
}
