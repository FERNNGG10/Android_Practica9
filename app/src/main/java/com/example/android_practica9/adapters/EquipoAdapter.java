package com.example.android_practica9.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_practica9.R;
import com.example.android_practica9.models.Equipo;

import java.util.List;

public class EquipoAdapter extends RecyclerView.Adapter<EquipoAdapter.viewHolder> {

    List<Equipo>Lista_equipos;
    private OnClickListener onclickListener;
    public EquipoAdapter(List <Equipo>Lista_Equipos){
        this.Lista_equipos=Lista_Equipos;
    }

    @NonNull
    @Override
    public EquipoAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly = LayoutInflater.from(parent.getContext());
        View v = ly.inflate(R.layout.item_equipos,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EquipoAdapter.viewHolder holder, int position) {
        Equipo e =Lista_equipos.get(position);
        holder.setData(e);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positionh = holder.getAdapterPosition();
               if(onclickListener != null){
                     onclickListener.onClick(positionh,e);
               }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Lista_equipos.size();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onclickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, Equipo model);
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        Equipo equipo;
        TextView nombre,region,titulos;
        ImageView imagen;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.equipo);
            region = itemView.findViewById(R.id.region);
            titulos = itemView.findViewById(R.id.titulos);
            imagen = itemView.findViewById(R.id.imagen);
        }

        public void setData(Equipo e)
        {
            equipo = e;
            nombre.setText(e.getNombre());
            region.setText(e.getLocalidad());
            titulos.setText(String.valueOf(e.getCampeonatos()));
            imagen.setImageResource(e.getImagen());
        }
    }
}
