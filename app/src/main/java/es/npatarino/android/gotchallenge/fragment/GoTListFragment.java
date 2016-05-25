package es.npatarino.android.gotchallenge.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import es.npatarino.android.gotchallenge.R;
import es.npatarino.android.gotchallenge.adapter.GoTAdapter;
import es.npatarino.android.gotchallenge.model.GoTCharacter;

/**
 * Created by ZohebS on 20-05-2016.
 */
public class GoTListFragment extends Fragment {

    private static final String TAG = "GoTListFragment";
    private List<GoTCharacter> goTCharacterList;
    RecyclerView recyclerView;
    GoTAdapter gotAdapter;

    public GoTListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        goTCharacterList = new ArrayList<>();
        gotAdapter = new GoTAdapter(getActivity(), goTCharacterList);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        final ContentLoadingProgressBar pb = (ContentLoadingProgressBar) rootView.findViewById(R.id.pb);
         recyclerView = (RecyclerView) rootView.findViewById(R.id.rv);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(gotAdapter);

        /*new Thread(new Runnable() {

            @Override
            public void run() {
                String url = "http://52.18.228.107:3000/characters";

                URL obj = null;
                try {
                    obj = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod("GET");
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    Type listType = new TypeToken<ArrayList<GoTCharacter>>() {
                    }.getType();
                    final List<GoTCharacter> characters = new Gson().fromJson(response.toString(), listType);
                    GoTListFragment.this.getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adp.addAll(characters);
                            adp.notifyDataSetChanged();
                            pb.hide();
                        }
                    });
                } catch (IOException e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }


            }
        }).start();*/
        return rootView;
    }
}
