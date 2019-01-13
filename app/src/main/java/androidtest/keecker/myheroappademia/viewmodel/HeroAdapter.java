package androidtest.keecker.myheroappademia.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidtest.keecker.myheroappademia.R;
import androidtest.keecker.myheroappademia.data.Hero;
import androidtest.keecker.myheroappademia.view.HeroRowView;

public class HeroAdapter extends RecyclerView.Adapter<HeroRowView> {

    private Context context;
    private List<Hero> heroes;
    private int clickedPosition = RecyclerView.NO_POSITION;

    public HeroAdapter(List<Hero> heroes, Context context){
        this.heroes = heroes;
        this.context = context;
    }

    @NonNull
    @Override
    public HeroRowView onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View item = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.activity_main_rows, parent, false);
        return new HeroRowView(item);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroRowView holder, final int position) {
        holder.setView(heroes.get(position), context);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickedPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    //Handle clicks on list items
    public int getClickedPosition() {
        return clickedPosition;
    }
    private void setClickedPosition(int pos) {
        notifyItemChanged(clickedPosition);
        clickedPosition = pos;
        notifyItemChanged(clickedPosition);
    }
}
