package co.zw.engineer.covidscreening.information.symptoms;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.zw.engineer.covidscreening.R;


public class SymptomsQs extends Fragment {


    private SymptomsViewlModel questionsViewModel;

    public SymptomsQs() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_symptoms_qs, container, false);



        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_final);

        recyclerView.setHasFixedSize(true);
        //recyclerView.setAdapter(questionAdapter);
        LinearLayoutManager setLayot = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(setLayot);


        final SymptomsQsnsAdapter questionAdapter = new SymptomsQsnsAdapter(getContext());
        recyclerView.setAdapter(questionAdapter);

        questionsViewModel = ViewModelProviders.of(this).get(SymptomsViewlModel.class);
        questionsViewModel.getAllQuestions().observe(getViewLifecycleOwner(), questions -> {
            questionAdapter.setQuestions(questions);
            // Log.d("where is data", "onChanged: "+questionAdapter);

        });


        return view;
    }
}