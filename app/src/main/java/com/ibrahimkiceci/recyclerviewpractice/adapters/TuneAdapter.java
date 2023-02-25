package com.ibrahimkiceci.recyclerviewpractice.adapters;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.ibrahimkiceci.recyclerviewpractice.R;
import com.ibrahimkiceci.recyclerviewpractice.model.Tune;

import java.util.List;

public class TuneAdapter extends RecyclerView.Adapter<TuneAdapter.TuneViewHolder> {
    List<Tune>TuneList;

    public List<Tune> getTuneList() {
        return TuneList;
    }

    public void setTuneList(List<Tune> tuneList) {
        TuneList = tuneList;
        notifyDataSetChanged();
    }

    public TuneAdapter(List<Tune> tuneList) {
        TuneList = tuneList;
    }

    @NonNull
    @Override
    public TuneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate external layout and assign it to a view object, itemView ;
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_tuneitem, parent, false);
        //create tune view holder object using this itemView
        TuneViewHolder tuneViewHolder = new TuneViewHolder(itemView);

        //return tune view holder object

        return tuneViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull TuneViewHolder holder, int position) {
        // data degistikce burasi calisir
        //responsible for binding position data to the holder object
        holder.textViewTune.setText(TuneList.get(position).getTuneName());
        holder.imageViewTune.setImageResource(TuneList.get(position).getTunePic());
        // reset default UI as needed - to get rid of dirty view holders
        holder.itemView.setBackgroundColor(Color.parseColor("#f59b71")); // exp: AllTunes'dan sectigimiz bir itemView yeni bir taba gecince secili bir sekilde kalabiliyor. Yeni bir taba gecince her biri tiklanmamis gibi gorunsun istiyorsak, bu reset default UI yapmalisin !!
        holder.itemView.setAlpha(1f);

    }

    @Override
    public int getItemCount() {
        //return size of the adapter data
        return TuneList.size();
    }

    //remember not to implement until you create custom view holder ---> cunku default olarak recyclerViewHolder geliyor. Biz custom view holder kullanmak istiyoruz
    // and then update extends with the custom view holder inner class

    public class TuneViewHolder extends RecyclerView.ViewHolder {
        // define custom view holder data
        ImageView imageViewTune;
        TextView textViewTune;

        public TuneViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewTune = itemView.findViewById(R.id.imgViewTune);
            textViewTune = itemView.findViewById(R.id.txtViewTune);
            itemView.setBackgroundColor(Color.parseColor("#f59b71")); //orange
            itemView.setAlpha(1f); //transparency

            // you may add item click listeners here.

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        if (((ColorDrawable)itemView.getBackground()).getColor() != Color.LTGRAY){
                            itemView.setBackgroundColor(Color.LTGRAY); //gray
                            itemView.setAlpha(0.5f);

                        }else {
                            itemView.setBackgroundColor(Color.parseColor("#f59b71"));
                            itemView.setAlpha(1f);
                        }

                }
            });

        }
    }

}
