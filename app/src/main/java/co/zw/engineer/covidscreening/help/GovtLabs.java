package co.zw.engineer.covidscreening.help;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import co.zw.engineer.covidscreening.R;


public class GovtLabs extends Fragment {

    private Context ctx;

    RecyclerView recyclerView;
    List<ContactData> contactsData= new ArrayList<>();
    ContactsAdapter contactsAdapter;

    public GovtLabs() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_govt_labs, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_selfscreen);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL,false));

        contactsAdapter = new ContactsAdapter(contactsData, getActivity());
        recyclerView.setAdapter(contactsAdapter);
        return view;

    }
    private List<ContactData> getData() {

        contactsData.add(new ContactData("Microbiology Reference Laboratories", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Plumtree District Hospital", "Address not given", "Contact not given","","Govt"));
        contactsData.add(new ContactData("Gwanda Provincial Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Beitbridge District Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("St Lukes Mission Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Victoria Falls Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Gutu Mission Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Masvingo Provincial Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Gweru Provincial Hospital", "Address not given, Bulawayo", "Contact not given", "","Govt"));

        contactsData.add(new ContactData(" Chinhoyi Provincial Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Kadoma General Hospital", "Address not given", "Contact not given","","Govt"));
        contactsData.add(new ContactData("St Alberts Mission Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Bindura Provincial", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Marondera Provincial Hospitall", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Rusape General Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Mutare Provincial Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Chipinge District Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Sally Mugabe Central Hospital", "Address not given, Bulawayo", "Contact not given", "","Govt"));

        contactsData.add(new ContactData("  Parirenyatwa Central Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("National Virology Reference Laboratory", "Address not given", "Contact not given","","Govt"));
        contactsData.add(new ContactData("Chitungwiza Central Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Chikurubi Maximum Prison", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Thorngrove Hospital Laboratory", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Beatrice Road Infectiuos Diseases Hospital", "Address not given", "Contact not given", "","Govt"));
        contactsData.add(new ContactData("Josiah Tongogara Magama", "Address not given", "Contact not given", "","Govt"));

        return contactsData;


    }
}