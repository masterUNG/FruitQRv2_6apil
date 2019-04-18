package kiky.beam.lilly.th.ac.rmutk.fruitqr;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowListProductFragment extends Fragment {
    private Myconstant myconstant = new Myconstant();


    public ShowListProductFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//      Create RecylerView
        createRecylerView();


    }//Main Method

    private void createRecylerView() {
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerShowListProduct);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        try {

            GetAllDataThread getAllDataThread = new GetAllDataThread(getActivity());
            getAllDataThread.execute(myconstant.getUrlGetAllDeatailProduct());

            String jsonString = getAllDataThread.get();
            Log.d("AprilV1", jsonString);

            ArrayList<String> nameStringArratList = new ArrayList<>();
            ArrayList<String> dateStringArratList = new ArrayList<>();
            ArrayList<String> amountStringArratList = new ArrayList<>();
            ArrayList<String> unitStringArratList = new ArrayList<>();
            ArrayList<String> iconStringArratList = new ArrayList<>();

            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i += 1) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            nameStringArratList.add(jsonObject.getString("Name"));
            dateStringArratList.add(jsonObject.getString("Date"));
            amountStringArratList.add(jsonObject.getString("Amount"));
            unitStringArratList.add(jsonObject.getString("Unit"));
            iconStringArratList.add(jsonObject.getString("Image"));
                Log.d("18AprilC1", iconStringArratList.get(i));

        }

        ShowListAdapter showListAdapter = new ShowListAdapter(getActivity(), nameStringArratList,
                dateStringArratList, amountStringArratList, unitStringArratList, iconStringArratList, new OnClickItem() {
            @Override
            public void onClickitem(View view, int position) {
                Log.d("18AprilV1", "Position ==> " + position);

            }
        });
            recyclerView.setAdapter(showListAdapter);


        } catch (Exception e) {
            Log.d("18AprilV1", "e ==> " + e.toString());
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_list_product, container, false);
    }

}
