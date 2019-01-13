package androidtest.keecker.myheroappademia.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidtest.keecker.myheroappademia.R;
import androidtest.keecker.myheroappademia.data.Hero;
import androidtest.keecker.myheroappademia.viewmodel.HeroDetail;

public class HeroDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);

        Intent intent = getIntent();
        Hero hero = (Hero) intent.getSerializableExtra("hero");
        HeroDetail viewModel = new HeroDetail(this);
        viewModel.setView(hero);
    }
}
