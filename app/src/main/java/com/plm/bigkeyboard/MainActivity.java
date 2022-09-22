package com.plm.bigkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tview=findViewById(R.id.text);

        ViewGroup tableLayout = (ViewGroup) findViewById(R.id.tablelayout);

        int width=getWindowManager().getDefaultDisplay().getWidth();
        int height=getWindowManager().getDefaultDisplay().getHeight();
        int buttonWidth=width/11;
        int buttonHeigth=height/4;


        for(int i=0;i<tableLayout.getChildCount();i++){

            ViewGroup tableRow=(ViewGroup) tableLayout.getChildAt(i);

            for(int j=0;j<tableRow.getChildCount();j++){
                Object child=tableRow.getChildAt(j);

                if(child instanceof Button) {

                    final Button b = (Button) child;

                    b.setMinimumWidth(buttonWidth);
                    b.setWidth(buttonWidth);

                    b.setMinHeight(buttonHeigth);
                    b.setHeight(buttonHeigth);


                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String text=tview.getText().toString();
                            String label=b.getText().toString();

                            if(label.equals("<")){
                                if(text.length()>0) {
                                    tview.setText(text.substring(0, text.length() - 1));
                                }
                            }else if(label.equals("XX")){
                                tview.setText("");
                            }else
                                tview.setText(text+label);
                        }
                    });

                    Log.d("PABLO", b.getText().toString());
                }
            }
        }
    }


}