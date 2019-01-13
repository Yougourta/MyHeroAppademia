package androidtest.keecker.myheroappademia.view;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import androidtest.keecker.myheroappademia.R;
import androidtest.keecker.myheroappademia.api.HeroApiAccess;
import androidtest.keecker.myheroappademia.viewmodel.HeroAdapter;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HeroApiAccess apiAccess = new HeroApiAccess(this);

        RecyclerView heroRecycler = findViewById(R.id.heroRecylerView);
        HeroAdapter heroAdapter = new HeroAdapter(apiAccess.getHeroes(),this);
        apiAccess.setHeroAdapter(heroAdapter);
        heroRecycler.setAdapter(heroAdapter);
        heroRecycler.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        heroRecycler.setLayoutManager(llm);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(heroRecycler.getContext(),
                        llm.getOrientation());
        heroRecycler.addItemDecoration(dividerItemDecoration);
    }


}
