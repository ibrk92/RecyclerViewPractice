package com.ibrahimkiceci.recyclerviewpractice.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibrahimkiceci.recyclerviewpractice.R;
import com.ibrahimkiceci.recyclerviewpractice.model.Tune;

import java.util.List;

public class TuneAdapter2 extends RecyclerView.Adapter<TuneAdapter2.TuneViewHolder2> {

    List<Tune> TuneList;
    int SelectedInd; //selected tune index, default = 0

    public List<Tune> getTuneList() {
        return TuneList;
    }

    public void setTuneList(List<Tune> tuneList) {
        TuneList = tuneList;
        SelectedInd = -1;
        notifyDataSetChanged();

    }

    public int getSelectedInd() {
        return SelectedInd;
    }

    public void setSelectedInd(int selectedInd) {
        SelectedInd = selectedInd;
        notifyDataSetChanged();
    }

    public TuneAdapter2(List<Tune> tuneList) {
        TuneList = tuneList;
        SelectedInd = -1;


    }

    @NonNull
    @Override
    public TuneViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_tuneitem2, parent, false);
        TuneViewHolder2 tuneViewHolder2 = new TuneViewHolder2(itemView);

        // I am gonna create click listener in here because i need a position
        // tuneViewHolder2.getAdapterPosition();
        tuneViewHolder2.imageViewPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tuneViewHolder2.getAdapterPosition() == SelectedInd){
                    //stop currently playing song
                    setSelectedInd(-1); //setter has notify data set has changed


                }else{
                    setSelectedInd(tuneViewHolder2.getAdapterPosition()); //when it is clicked
                }

            }
        });

        return  tuneViewHolder2;

    }

    @Override
    public void onBindViewHolder(@NonNull TuneViewHolder2 holder, int position) {

        holder.imageView2Tune.setImageResource(TuneList.get(position).getTunePic());
        holder.textView2Tune.setText(TuneList.get(position).getTuneName());
        //play and pause depends on what is the position and what is the selected index.
        // Yukaridaki method icerisindeki current position !!

        // if the current item is the same as the selected Index, i want to the pause icon;
        // if the current item is not selected item, i want to the play icon;
        //selected index corresponds to what is currently playing.

        if(holder.getAdapterPosition() == SelectedInd ){
            // direk position yazmak yerine holder.getAdapterPosition() yazman daha cok tavsiye edilir.
              holder.imageViewPlayPause.setImageResource(R.drawable.pause);

        }else {
            holder.imageViewPlayPause.setImageResource(R.drawable.play);
        }
    }

    @Override
    public int getItemCount() {
        return TuneList.size();
    }

    public class TuneViewHolder2 extends RecyclerView.ViewHolder {

        ImageView imageView2Tune;
        TextView textView2Tune;
        ImageView imageViewPlayPause;

        public TuneViewHolder2(@NonNull View itemView) {
            super(itemView);

            imageView2Tune = itemView.findViewById(R.id.imageView2Tune);
            textView2Tune = itemView.findViewById(R.id.textView2Tune);
            imageViewPlayPause = itemView.findViewById(R.id.imageViewPlayPause);

        }
    }
}
