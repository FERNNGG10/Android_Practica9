package com.example.android_practica9.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_practica9.R;
import com.example.android_practica9.models.Permiso;

import java.util.List;

public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.viewHolder> {
    List <Permiso> Lista_Permisos;

    private OnCheckedChangeListener onCheckedChangeListener;
    public  PermisoAdapter(List<Permiso>Lista_permisos){
        Lista_Permisos=Lista_permisos;
    }
    @NonNull
    @Override
    public PermisoAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly =LayoutInflater.from(parent.getContext());
        View v=ly.inflate(R.layout.item_permisos,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisoAdapter.viewHolder holder, int position) {
        Permiso p =Lista_Permisos.get(position);
        holder.setData(p);
        holder.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int adapterPosition = holder.getAdapterPosition();
                    if(b){
                        if (onCheckedChangeListener != null) {
                            onCheckedChangeListener.OnChecked(adapterPosition, p);
                        }
                    }


            }
        });

    }

    @Override
    public int getItemCount() {
        return Lista_Permisos.size();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

   public interface OnCheckedChangeListener{
        void OnChecked(int position, Permiso model);
   }


    public class viewHolder extends RecyclerView.ViewHolder {
        Permiso permiso;
        TextView descpermiso;
        Switch switch1;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            descpermiso =itemView.findViewById(R.id.descpermiso);
            switch1 = itemView.findViewById(R.id.switch1);

        }

        public void setData(Permiso p)
        {
            permiso=p;
            descpermiso.setText(p.getNombre());
        }
    }
}
