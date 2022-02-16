package co.zw.engineer.covidscreening.help;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.zw.engineer.covidscreening.R;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

        List<ContactData> list;

        Context context;


public ContactsAdapter(List<ContactData> list, Context context) {
        this.list = list;
        this.context = context;

        }


@Override
public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {

        context=parent.getContext();


        return new ContactsAdapter.ContactsViewHolder(LayoutInflater.from(context).inflate(R.layout.phone_numbers,parent,false));
        }

@Override
public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position){
        ContactData incomingData = list.get(position);

        String labName = incomingData.getLabName();
        String labAdd = incomingData.getLabAddress();
        String labNum = incomingData.getLabNum();
        String labCity = incomingData.getLabCity();
        String labNature = incomingData.getLabNature();



        holder.labName.setText(labName);
        holder.labAddress.setText(labAdd);
        holder.labPhone.setText(labNum);
        holder.city.setText(labCity);
        holder.nature.setText(labNature);

        }

@Override
public int getItemCount()
        {
        return list.size();
        }


public static class ContactsViewHolder extends RecyclerView.ViewHolder {
    TextView labName;
    TextView labAddress;
    TextView labPhone,nature,city;
    View view;

    ContactsViewHolder(View itemView) {
        super(itemView);
        labName = itemView.findViewById(R.id.lab_name);
        labAddress = itemView.findViewById(R.id.lab_address);
        labPhone = itemView.findViewById(R.id.phone_num);
        nature = itemView.findViewById(R.id.nature);
        city = itemView.findViewById(R.id.town);
    }
}
}
