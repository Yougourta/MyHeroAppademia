package androidtest.keecker.myheroappademia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import androidtest.keecker.myheroappademia.api.HeroApiAccess;
import androidtest.keecker.myheroappademia.viewmodel.HeroAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HeroApiAccess apiAccess = new HeroApiAccess(MainActivity.this);
        RecyclerView heroRecycler = findViewById(R.id.heroRecylerView);
        HeroAdapter heroAdapter = new HeroAdapter(apiAccess.getHeroes(), MainActivity.this);
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
