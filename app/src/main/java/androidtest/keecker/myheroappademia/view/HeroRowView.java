package androidtest.keecker.myheroappademia.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidtest.keecker.myheroappademia.R;
import androidtest.keecker.myheroappademia.data.Hero;

public class HeroRowView extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView id;
    private TextView name;

    public HeroRowView(View itemView) {
        super(itemView);
        findViews(itemView);
    }

    private void findViews(View v){
        image = v.findViewById(R.id.image);
        id = v.findViewById(R.id.id);
        name = v.findViewById(R.id.name);
    }

    public void setView(Hero hero, Context context){
        Glide.with(context)
                .load(hero.getImage())
                .into(image);
        id.setText(hero.getId());
        name.setText(hero.getName());
    }
}