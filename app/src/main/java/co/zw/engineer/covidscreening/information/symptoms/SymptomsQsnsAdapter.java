package co.zw.engineer.covidscreening.information.symptoms;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import co.zw.engineer.covidscreening.R;

public class SymptomsQsnsAdapter extends RecyclerView.Adapter<SymptomsQsnsAdapter.QuestionViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<SymptomsQsns> question = new ArrayList();
    private final Context mContext;



    public SymptomsQsnsAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public SymptomsQsnsAdapter.QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       /* View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new QuestionViewHolder(itemView);*/
        final View itemView = mLayoutInflater.inflate(R.layout.list_item, parent, false);;
        return new SymptomsQsnsAdapter.QuestionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SymptomsQsnsAdapter.QuestionViewHolder holder, int position) {

        //holder.currentPosition = position;

        if (question == null) {
            return;
        }

        final SymptomsQsns currentNote = question.get(position);
        if (question != null) {
            holder.titleText.setText(currentNote.getTitle());
            holder.contentText.setText(currentNote.getContent());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), Reader.class);
                    intent.putExtra("title", holder.titleText.getText());
                    intent.putExtra("content", holder.contentText.getText());
                    v.getContext().startActivity(intent);
                }
            });

        }


    }

    @Override
    public int getItemCount() {


        return question.size();


    }


    public void setQuestions(List<SymptomsQsns> question) {

        this.question = question;
        notifyDataSetChanged();
        notifyItemInserted(question.size());
    }

    static class QuestionViewHolder extends RecyclerView.ViewHolder {
        public TextView titleText;
        public TextView contentText;
        public int currentPosition;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            this.titleText = itemView.findViewById(R.id.tittle_tv);
            this.contentText = itemView.findViewById(R.id.description_textview);


        }
    }
}
