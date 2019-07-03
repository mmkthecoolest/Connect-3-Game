package com.example.musta.connect3;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int dim_size = 3;

    enum Color {
        NONE, RED, YELLOW;
    }

    enum Turn {
        RED, YELLOW;
    }


    private Color d_arr[][] = new Color[dim_size][dim_size];
    private int fill[] = new int[3];
    private Turn turn = Turn.RED;
    private Color winner = Color.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        int id = findIdByString("r1c1yellow");
//        System.out.println(id == R.id.r1c1yellow);

        for(int i = 0; i < dim_size; i++){
            for(int j = 0; j < dim_size; j++){
                ImageView imageViewRed = (ImageView) findViewById(findIdByString("r" + (i + 1) + "c" + (j + 1) + "red"));
                ImageView imageViewYellow = (ImageView) findViewById(findIdByString("r" + (i + 1) + "c" + (j + 1) + "yellow"));

                imageViewRed.setTranslationY(-1000f);
                imageViewYellow.setTranslationY(-1000f);
            }
        }

        TextView textView = (TextView) findViewById(R.id.status);
        textView.setText((CharSequence) "Red's turn");
    }

    private int findIdByString(String s){
        return this.getResources().getIdentifier(s, "id", this.getPackageName());
    }

    public void button1Action(View view){
//        System.out.println(fill[0]);
        TextView textView = (TextView) findViewById(R.id.status);
        if(fill[0] < 3 && this.winner == Color.NONE) {
            if (this.turn == Turn.RED) {
                ImageView imageView = (ImageView) findViewById(findIdByString("r" + (3 - fill[0]) + "c1" + "red"));
                imageView.animate().translationYBy(1000f).setDuration(500);
                this.turn = Turn.YELLOW;
                d_arr[0][fill[0]] = Color.RED;
                winCheck(Color.RED);
                textView.setText((CharSequence) "Yellow's turn");
            } else {
                ImageView imageView = (ImageView) findViewById(findIdByString("r" + (3 - fill[0]) + "c1" + "yellow"));
                imageView.animate().translationYBy(1000f).setDuration(500);
                this.turn = Turn.RED;
                d_arr[0][fill[0]] = Color.YELLOW;
                winCheck(Color.YELLOW);
                textView.setText((CharSequence) "Red's turn");
            }
        }
        fill[0] += 1;
        victorCheck();
    }

    public void button2Action(View view){
        TextView textView = (TextView) findViewById(R.id.status);
        if(fill[1] < 3 && this.winner == Color.NONE) {
            if (this.turn == Turn.RED) {
                ImageView imageView = (ImageView) findViewById(findIdByString("r" + (3 - fill[1]) + "c2" + "red"));
                imageView.animate().translationYBy(1000f).setDuration(500);
                this.turn = Turn.YELLOW;
                d_arr[1][fill[1]] = Color.RED;
                winCheck(Color.RED);
                textView.setText((CharSequence) "Yellow's turn");
            } else {
                ImageView imageView = (ImageView) findViewById(findIdByString("r" + (3 - fill[1]) + "c2" + "yellow"));
                imageView.animate().translationYBy(1000f).setDuration(500);
                this.turn = Turn.RED;
                d_arr[1][fill[1]] = Color.YELLOW;
                winCheck(Color.YELLOW);
                textView.setText((CharSequence) "Red's turn");
            }
        }
        fill[1] += 1;
        victorCheck();
    }

    public void button3Action(View view){
        TextView textView = (TextView) findViewById(R.id.status);
        if(fill[2] < 3 && this.winner == Color.NONE) {
            if (this.turn == Turn.RED) {
                ImageView imageView = (ImageView) findViewById(findIdByString("r" + (3 - fill[2]) + "c3" + "red"));
                imageView.animate().translationYBy(1000f).setDuration(500);
                this.turn = Turn.YELLOW;
                d_arr[2][fill[2]] = Color.RED;
                winCheck(Color.RED);
                textView.setText((CharSequence) "Yellow's turn");
            } else {
                ImageView imageView = (ImageView) findViewById(findIdByString("r" + (3 - fill[2]) + "c3" + "yellow"));
                imageView.animate().translationYBy(1000f).setDuration(500);
                this.turn = Turn.RED;
                d_arr[2][fill[2]] = Color.YELLOW;
                winCheck(Color.YELLOW);
                textView.setText((CharSequence) "Red's turn");
            }
        }
        fill[2] += 1;
        victorCheck();
    }

    private void winCheck(Color color){
        for(int i = 0; i < dim_size; i++){
            if(d_arr[i][0] == d_arr[i][1] && d_arr[i][1] == d_arr[i][2] && d_arr[i][0] == color){
                this.winner = color;
                return;
            }
        }

        for(int i = 0; i < dim_size; i++){
            if(d_arr[0][i] == d_arr[1][i] && d_arr[1][i] == d_arr[2][i] && d_arr[0][i] == color){
                this.winner = color;
                return;
            }
        }

        if (d_arr[0][0] == d_arr[1][1] && d_arr[1][1] == d_arr[2][2] && d_arr[0][0] == color){
            this.winner = color;
            return;
        }

        if (d_arr[2][0] == d_arr[1][1] && d_arr[1][1] == d_arr[0][2] && d_arr[1][1] == color){
            this.winner = color;
            return;
        }

    }

    private void victorCheck(){
        if (this.winner == Color.RED){
            TextView textView = (TextView) findViewById(R.id.status);
            textView.setText((CharSequence) "Red Wins!");
        } else if (this.winner == Color.YELLOW){
            TextView textView = (TextView) findViewById(R.id.status);
            textView.setText((CharSequence) "Yellow Wins!");
        }
    }

    public void reset(View view){
        for(int i = 0; i < dim_size; i++){
            for(int j = 0; j < dim_size; j++){
                d_arr[i][j] = Color.NONE;
            }
            fill[i] = 0;
        }

        this.turn = Turn.RED;
        this.winner = Color.NONE;

        for(int i = 0; i < dim_size; i++){
            for(int j = 0; j < dim_size; j++){
                ImageView imageViewRed = (ImageView) findViewById(findIdByString("r" + (i + 1) + "c" + (j + 1) + "red"));
                ImageView imageViewYellow = (ImageView) findViewById(findIdByString("r" + (i + 1) + "c" + (j + 1) + "yellow"));

                imageViewRed.setTranslationY(-1000f);
                imageViewYellow.setTranslationY(-1000f);
            }
        }

        TextView textView = (TextView) findViewById(R.id.status);
        textView.setText((CharSequence) "Red's turn");
    }


}
