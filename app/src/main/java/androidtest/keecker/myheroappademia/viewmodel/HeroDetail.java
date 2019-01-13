package androidtest.keecker.myheroappademia.viewmodel;

import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidtest.keecker.myheroappademia.R;
import androidtest.keecker.myheroappademia.data.Hero;
import androidtest.keecker.myheroappademia.view.HeroDetailActivity;

public class HeroDetail {

    private TextView name;
    private TextView work;
    private TextView biography;
    private ImageView image;

    public HeroDetail(HeroDetailActivity view){
        findViews(view);
    }

    private void findViews(HeroDetailActivity view){
        name = view.findViewById(R.id.nameDetail);
        work = view.findViewById(R.id.workDetail);
        biography = view.findViewById(R.id.biographyDetail);
        image = view.findViewById(R.id.imageDetail);
    }

    public void setView(Hero hero){
        Picasso.get()
                .load(hero.getImage())
                .resize(500, 500)
                .centerCrop()
                .into(image);
        name.setText("Name: "+hero.getName());
        work.setText("Work: "+hero.getWork());
        biography.setText("Biography: \n\n"+"Full-name: "+hero.getBiography().getFullName()
                +"\n"+
                "Publisher: "+hero.getBiography().getPublisher()
                +"\n"+
                "Aliases: "+hero.getBiography().getAliases().toString());
    }
}
