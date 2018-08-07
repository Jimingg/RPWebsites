package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spncate;
    Spinner spnsub;
    Button btngo;
    ArrayList<String> alcategory;
    ArrayAdapter<String> aacategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spncate = findViewById(R.id.spinnerCategory);
        spnsub = findViewById(R.id.spinnerSubCategory);
        btngo = findViewById(R.id.buttonGo);
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos1 = spncate.getSelectedItemPosition();
                int pos2 = spnsub.getSelectedItemPosition();
                String [][] sites ={
                        {"https://www.rp.edu.sg/",
                                "https://www.rp.edu.sg/student-life",
                                },
                        {"https://www.rp.edu.sg/soi/full-time-diplomas/details/r47/" ,
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12/"},

                } ;
                String URL = sites[pos1][pos2];
                Intent intent = new Intent(getBaseContext(),MainWebpage.class);
                intent.putExtra("URL", URL+"");
                startActivity(intent);
                /*
                Intent intent = new Intent(getBaseContext(),MainWebpage.class);
                if (pos1 == 0 && pos2==0){
                    String URL = "https://www.rp.edu.sg/";
                    intent.putExtra("URL", URL+"");
                }else if (pos1 == 0 && pos2==1){
                    String URL = "https://www.rp.edu.sg/student-life";
                    intent.putExtra("URL", URL+"");
                }else if(pos1 == 1 && pos2==0){
                    String URL = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    intent.putExtra("URL", URL+"");
                }else {
                    String URL = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    intent.putExtra("URL", URL+"");
                }

                startActivity(intent);
                */
            }

        });
        alcategory = new ArrayList<>();
        aacategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alcategory);

        String[] strcategory = getResources().getStringArray(R.array.RP_sub_category);
        alcategory.addAll(Arrays.asList(strcategory));
        spnsub.setAdapter(aacategory);

        spncate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        alcategory.clear();
                        String[] strcategory = getResources().getStringArray(R.array.RP_sub_category);
                        alcategory.addAll(Arrays.asList(strcategory));
                        aacategory.notifyDataSetChanged();
                        break;
                    case 1:
                        alcategory.clear();
                        String[] strcategory1 = getResources().getStringArray(R.array.SOI_sub_category);
                        alcategory.addAll(Arrays.asList(strcategory1));
                        aacategory.notifyDataSetChanged();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
