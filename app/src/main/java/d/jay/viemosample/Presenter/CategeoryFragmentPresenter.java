package d.jay.viemosample.Presenter;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import d.jay.viemosample.CategeoryfragmentsViewInterface;
import d.jay.viemosample.Model.CategeoryModel;
import d.jay.viemosample.Utils.Constant;
import d.jay.viemosample.Utils.UrlUtils;
import d.jay.viemosample.Utils.VolleyUtils;

public class CategeoryFragmentPresenter implements CategeoryFragmentPresenterInterface{

    CategeoryfragmentsViewInterface categeoryfragmentsViewInterface;
    Context context;
    String TAG = "CategeoryFragmentPresenter";
    ArrayList<CategeoryModel> categeoryList = new ArrayList<>();

    public CategeoryFragmentPresenter(Context context,CategeoryfragmentsViewInterface categeoryfragmentsViewInterface)
    {
        this.categeoryfragmentsViewInterface = categeoryfragmentsViewInterface;
        this.context = context;
    }
    @Override
    public void getCategeoryList() {
        categeoryfragmentsViewInterface.showProgressbar();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                UrlUtils.GETCATEGEORYLIST, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "this is inside response" + response.toString());
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                CategeoryModel categeoryModel = new CategeoryModel();
                                categeoryModel.setCategeoryName(jsonArray.getJSONObject(i).getString(Constant.CATEGEORYNAME));
                                categeoryModel.setCategeoryPoster(jsonArray.getJSONObject(i).getJSONObject("pictures").getJSONArray("sizes").getJSONObject(3).getString(Constant.CATEGEORYPOSTER));
                                categeoryList.add(categeoryModel);
                            }
                            categeoryfragmentsViewInterface.gotListOfCategeory(categeoryList);
                            categeoryfragmentsViewInterface.hideProgressbar();
                        } catch (Exception e) {

                            Log.i(TAG, "this is inside catch " + e.getMessage());

                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "this is inside errorresponse " + error.getMessage());
                categeoryfragmentsViewInterface.hideProgressbar();

                // hide the progress dialog

            }
        }){
            @Override
            public Map getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Authorization", "bearer b2918607b4301812914f5a5141c4d7da");

                return headers;
            }
        };

        try {
            VolleyUtils volleyUtils = new VolleyUtils(context);
            volleyUtils.addToRequestQueue(jsonObjReq);
        }catch (Exception e)
        {
            Log.i(TAG, "this is inside mainCatch " + e.getMessage());
            categeoryfragmentsViewInterface.hideProgressbar();


        }
    }
}
