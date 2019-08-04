package com.example.vrgsoft;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.vrgsoft.nyt.Result;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    public interface RecyclerViewClickListener {
        void onClick(Result result);
    }

    public interface RecyclerViewLongClickListener {
        void onLongClick(Result result, int id);
    }

    @NonNull
    ArrayList<Result> results;
    RecyclerViewClickListener clickListener;
    RecyclerViewLongClickListener longClickListener;

    public RVAdapter(@NonNull ArrayList<Result> results) {
        this.results = results;
    }


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        clickListener = MainActivity.getInstance();
        longClickListener = MainActivity.getInstance();
        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.get().load(results.get(position).getMedia().get(0).getMediaMetadata().get(2).getUrl()).into(holder.image);
        holder.title.setText(results.get(position).getTitle());
        holder.description.setText(results.get(position).getAbstract());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv;
        TextView title;
        TextView description;
        ImageView image;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.rv_page_fragment);
            title = itemView.findViewById(R.id.tv_title_item);
            description = itemView.findViewById(R.id.tv_description_item);
            image = itemView.findViewById(R.id.iv_item);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    longClickListener.onLongClick(results.get(getLayoutPosition()),getLayoutPosition());
                    return true;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int p = getLayoutPosition();
                    clickListener.onClick(results.get(getLayoutPosition()));
                }
            });
        }
    }
}
