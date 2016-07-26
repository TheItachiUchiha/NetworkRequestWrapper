package com.ankit.example;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ankit.volleywrapper.GsonConverter;
import com.ankit.example.R;
import com.ankit.volleywrapper.VolleyRequestHandler;
import com.ankit.wrapper.GlobalRequest;
import com.ankit.wrapper.GsonModelListener;
import com.ankit.wrapper.IRequestListener;
import com.ankit.wrapper.RequestBuilder;
import com.ankit.wrapper.Response;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class Main2ActivityFragment extends Fragment {

    public Main2ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GlobalRequest.newBuilder().setRequestManager(new VolleyRequestHandler(getActivity()))
                .setConverter(new GsonConverter()).build();
        new RequestBuilder().get().url("http://stage.firstcry.com/svcs/MyAccountService.svc/getorderdetail/oid=3128726PMH8299707").tag("tag").asGsonObject(new GsonModelListener<Data>
                () {
            @Override
            public Class<Data> getModel() {
                return Data.class;
            }
        }).asJsonObject(new
                                IRequestListener<JSONObject>() {
                                    @Override
                                    public Object onRequestSuccess(Response<JSONObject> response) {
                                        return null;
                                    }

                                    @Override
                                    public void onParseSuccess(Object response) {
                                        @SuppressWarnings("unchecked")
                                        Data beanPostArrayList = (Data) response;
                                        Log.e("response",beanPostArrayList.getRestrictedBrand());
                                    }

                                    @Override
                                    public void onRequestErrorCode(int errorCode) {

                                    }
                                }).send(getContext());

    }
}
