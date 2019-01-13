package androidtest.keecker.myheroappademia.api;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import androidtest.keecker.myheroappademia.MainActivity;
import androidtest.keecker.myheroappademia.data.Biography;
import androidtest.keecker.myheroappademia.data.Hero;

/** Acces to Hero API using Volley**/
public class HeroApiAccess {

    private final String API_KEY = "2321140144771513";
    private Context context;
    private String urlRequest = "";
    private List<Hero> heroes = new ArrayList();


    public HeroApiAccess(final Context context){
        this.context = context;
        requestData("batman");
        requestData("supergirl");
        requestData("spider-man");
        requestData("hulk");
    }

    private void requestData(String hero){
        RequestQueue queue = Volley.newRequestQueue(context);
        urlRequest = "https://superheroapi.com/api.php/"+API_KEY+"/search/"+hero;
        StringRequest request = new StringRequest(Request.Method.GET, urlRequest, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JsonParser parser = new JsonParser();
                JsonArray resultsJsonObject = parser.parse(s).getAsJsonObject().get("results").getAsJsonArray();
                for (int i=0; i<resultsJsonObject.size(); i++){
                    JsonObject jsonObject = resultsJsonObject.get(i).getAsJsonObject();
                    Hero hero = getHero(jsonObject);
                    heroes.add(hero);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(context, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }

    private Hero getHero(JsonObject jsonObject){
        Hero hero = new Hero();
        hero.setId(jsonObject.get("id").toString());
        hero.setName(jsonObject.get("name").toString());
        hero.setWork(jsonObject.get("work").getAsJsonObject().get("base").toString());
        hero.setImage(jsonObject.get("image").toString());

        JsonObject biographyJsonObject = jsonObject.get("biography").getAsJsonObject();
        Biography biography = getBiography(biographyJsonObject);
        hero.setBiography(biography);
        return hero;
    }

    private Biography getBiography(JsonObject jsonObject){
        Biography biography = new Biography();
        List<String> aliases = new ArrayList();
        biography.setFullName(jsonObject.get("full-name").toString());
        biography.setPublisher(jsonObject.get("publisher").toString());
        JsonArray aliasesJsonOjbect = jsonObject.get("aliases").getAsJsonArray();
        for (int i=0; i<aliasesJsonOjbect.size(); i++){
            aliases.add(aliasesJsonOjbect.get(i).toString());
        }
        biography.setAliase(aliases);
        return biography;
    }

    public List<Hero> getHeroes(){
        return  heroes;
    }
}