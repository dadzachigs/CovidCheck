package co.zw.engineer.covidscreening.information.vaccine;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import co.zw.engineer.covidscreening.R;


public class VaccineFqa extends Fragment {


    private VaccineViewModel questionsViewModel;

    public VaccineFqa() {
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
        View view = inflater.inflate(R.layout.fragment_vaccine_fqa, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_final);

        recyclerView.setHasFixedSize(true);
        //recyclerView.setAdapter(questionAdapter);
        LinearLayoutManager setLayot = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(setLayot);


        final VaccineQsnsAdapter questionAdapter = new VaccineQsnsAdapter(getContext());
        recyclerView.setAdapter(questionAdapter);

        questionsViewModel = ViewModelProviders.of(this).get(VaccineViewModel.class);
        questionsViewModel.getAllQuestions().observe(getViewLifecycleOwner(), new Observer<List<VaccineQsns>>() {
            @Override
            public void onChanged(@Nullable List<VaccineQsns> questions) {
                questionAdapter.setQuestions(questions);
                // Log.d("where is data", "onChanged: "+questionAdapter);

            }
        });


        return view;
    }
}