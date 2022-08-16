package my.tutorial.tutorial4part2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list =  findViewById(R.id.listView);
        String[] values = new String[] {
                "Supreme", "Seafood", "Italian",
                "Meat Lovers", "Ham and pineapple"};
        // use default layout simple_list_item_1
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        list.setAdapter(adapter);

        // use your custom layout
        CustomAdapter adapter2 = new CustomAdapter(this, values);
        list= (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter2);

        //uncomment line 35 to enable choosing multiple item from the list
        // list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


        list.setOnItemClickListener((parent, v, position, id) -> {
            //uncomment line 40 to highlight item choosed when CHOICE_MODE_MULTIPLE is on
            //       v.setBackgroundResource(R.drawable.ic_launcher_background);
            String item = (String) list.getAdapter().getItem(position);
            Toast.makeText(getApplicationContext(), item + " selected", Toast.LENGTH_LONG).show();
        });
    }
}