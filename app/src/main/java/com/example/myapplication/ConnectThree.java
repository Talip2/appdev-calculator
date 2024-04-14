package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectThree extends AppCompatActivity implements ConnecThreeFrag.currPlayerListiner{
    TextView txtCurrPlayer;

    Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_connect_three);


        txtCurrPlayer = (TextView) findViewById(R.id.txtCurrPlayer);
        btnReset =  (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("State", 1);
//                    ConnecThreeFrag fragment = ConnecThreeFrag.newInstance(null, null);
//                    fragment.setArguments(bundle);
//
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragConnectThree, fragment).commit();

                Fragment currFrag = getSupportFragmentManager().findFragmentById(R.id.fragConnectThree);
                if(currFrag instanceof ConnecThreeFrag){
                    ((ConnecThreeFrag)currFrag).resetGame();
                }


            }
        });

    }

    @Override
    public void sendPlayerTurn(int color, String player) {
        txtCurrPlayer.setText(player);
        txtCurrPlayer.setTextColor(getResources().getColor(color));
    }


}