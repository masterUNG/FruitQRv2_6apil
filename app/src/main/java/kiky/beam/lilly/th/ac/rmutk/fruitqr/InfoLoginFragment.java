package kiky.beam.lilly.th.ac.rmutk.fruitqr;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoLoginFragment extends Fragment {

    private Myconstant myconstant = new Myconstant();
    private String idRecord;

    public InfoLoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //        Show View
        showView();

    }
    private void showView() {
        try {

            //ดึงค่า IdLogin
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(myconstant.getNameFileSharePreference(), Context.MODE_PRIVATE);
            idRecord = sharedPreferences.getString("idLogin", "");


            GetDataWhereOneColumn getDataWhereOneColumn = new GetDataWhereOneColumn(getActivity());
            getDataWhereOneColumn.execute("id", idRecord, myconstant.getUrlGetUserWhereId());

            String result = getDataWhereOneColumn.get();
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            TextView nameTextView = getView().findViewById(R.id.editName);
            nameTextView.setText(jsonObject.getString("Name"));

            TextView firstnameTextView = getView().findViewById(R.id.editFristname);
            firstnameTextView.setText(jsonObject.getString("FirstName"));

            TextView secondnameTextView = getView().findViewById(R.id.editSurname);
            secondnameTextView.setText(jsonObject.getString("SecondName"));

            TextView addressTextView = getView().findViewById(R.id.editAddress);
            addressTextView.setText(jsonObject.getString("Address"));

            TextView phoneTextView = getView().findViewById(R.id.editPhone);
            phoneTextView.setText(jsonObject.getString("Phone"));

            TextView userTextView = getView().findViewById(R.id.editUser);
            userTextView.setText(jsonObject.getString("User"));

            TextView passTextView = getView().findViewById(R.id.editPassword);
            passTextView.setText(jsonObject.getString("Password"));

            TextView typeTextView = getView().findViewById(R.id.editType);
            typeTextView.setText(jsonObject.getString("TypeUser"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_login, container, false);
    }

}
