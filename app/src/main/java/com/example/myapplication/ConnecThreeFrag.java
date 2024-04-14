package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConnecThreeFrag#newInstance} factory method to
 * create an instance of this fragment.
 */

public class ConnecThreeFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

     Button[][] board = new Button[5][5];

    int col1 = 4;
    int col2 = 4;
    int col3 = 4;
    int col4 = 4;
    int col5 = 4;

    int row1 = 0;
    int row2 = 1;
    int row3 = 2;
    int row4 = 3;
    int row5 = 4;

    private String tempPlayerHolder = null;
    private String currPlayer = "Black";
    private enum Columns{
        COL1,
        COL2,
        COL3,
        COL4,
        COL5
    }
    int message;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConnecThreeFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConnecThreeFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static ConnecThreeFrag newInstance(String param1, String param2) {
        ConnecThreeFrag fragment = new ConnecThreeFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connec_three, container, false);
        Toast.makeText(getActivity(), "Deo D. Talip, Batch 1 - Connect 3", Toast.LENGTH_SHORT).show();
//        Bundle bundle = getArguments();
//        if(bundle != null){
//             message = bundle.getInt("State");
//            Log.d("ConnecThreeFrag", "Received message value: " + message);
//        }
    
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for(int i = 0; i < 5; i++){

            for(int j = 0; j < 5; j++){

                int btnRowID = getResources().getIdentifier("btnR" + (i+1) + "C" + (j+1), "id", requireContext().getPackageName());
                board[i][j] = (Button) view.findViewById(btnRowID);
            }
        }

        board[0][0].setOnClickListener(drop);
        board[0][1].setOnClickListener(drop);
        board[0][2].setOnClickListener(drop);
        board[0][3].setOnClickListener(drop);
        board[0][4].setOnClickListener(drop);

//        if(message == 1){
//            resetGame();
//        }
    }



    currPlayerListiner pListiner;

    public interface currPlayerListiner{
        void sendPlayerTurn(int color, String player);
    }


    View.OnClickListener drop = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Button btnClicked = (Button) view;
            Columns col = getColumns(btnClicked);
            Integer color = null;
            if(currPlayer.equals("Black")){
                pListiner.sendPlayerTurn(R.color.red, "Red's turn");
                color = R.color.black;
                tempPlayerHolder = currPlayer;
                currPlayer = "Red";
            }else if(currPlayer.equals("Red")) {
                pListiner.sendPlayerTurn(R.color.black, "Black's turn");
                color = R.color.red;
                tempPlayerHolder = currPlayer;
                currPlayer = "Black";
            }



            switch (col){
                case COL1:
                    board[col1][row1].setBackgroundColor(getResources().getColor(color));
                    board[col1][row1].setTextColor(getResources().getColor(R.color.transparent));
                    board[col1][row1].setText(tempPlayerHolder);
                    col1--;
                    if(col1 == -1){
                        board[0][row1].setClickable(false);
                    }
                    break;
                case COL2:
                    board[col2][row2].setBackgroundColor(getResources().getColor(color));
                    board[col2][row2].setTextColor(getResources().getColor(R.color.transparent));
                    board[col2][row2].setText(tempPlayerHolder);
                    col2--;
                    if(col2 == -1){
                        board[0][row2].setClickable(false);
                    }
                    break;
                case COL3:
                    board[col3][row3].setBackgroundColor(getResources().getColor(color));
                    board[col3][row3].setTextColor(getResources().getColor(R.color.transparent));
                    board[col3][row3].setText(tempPlayerHolder);
                    col3--;
                    if(col3 == -1){
                        board[0][row3].setClickable(false);
                    }
                    break;
                case COL4:
                    board[col4][row4].setBackgroundColor(getResources().getColor(color));
                    board[col4][row4].setTextColor(getResources().getColor(R.color.transparent));
                    board[col4][row4].setText(tempPlayerHolder);
                    col4--;
                    if(col4 == -1){
                        board[0][row4].setClickable(false);
                    }
                    break;
                case COL5:
                    board[col5][row5].setBackgroundColor(getResources().getColor(color));
                    board[col5][row5].setTextColor(getResources().getColor(R.color.transparent));
                    board[col5][row5].setText(tempPlayerHolder);
                    col5--;
                    if(col5 == -1){
                        board[0][row5].setClickable(false);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid index");
            }

            if(checker()){
                board[0][0].setClickable(false);
                board[0][1].setClickable(false);
                board[0][2].setClickable(false);
                board[0][3].setClickable(false);
                board[0][4].setClickable(false);
            }

        }
    };


    public Columns getColumns(Button button){
        for(int i = 0; i < 5; i++){
            if(board[0][i] == button){
                switch (i){
                    case 0:
                        return Columns.COL1;
                    case 1:
                        return Columns.COL2;
                    case 2:
                        return Columns.COL3;
                    case 3:
                        return Columns.COL4;
                    case 4:
                        return Columns.COL5;
                }
            }
        }
        return null;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        pListiner = (currPlayerListiner) context;
    }

    public void resetGame() {
        int i, j;
        for ( i = 0; i < 5; i++) {

            for ( j = 0; j < 5; j++) {
                board[i][j].setBackgroundColor(getResources().getColor(R.color.white));
                board[i][j].setText(null);
                board[0][j].setClickable(true);
            }
        }
        this.col1 = 4;
        this.col2 = 4;
        this.col3 = 4;
        this.col4 = 4;
        this.col5 = 4;
        currPlayer = "Black";
        pListiner.sendPlayerTurn(R.color.black, "Black's turn");
    }

    public boolean checker(){
        int color;
        String player;
        if(tempPlayerHolder.equals("Black")){
            player = "Black wins!";
            color = R.color.black;
        }else{
            player = "Red wins!";
            color = R.color.red;
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){

                //rows
                if(board[i][j].getText().equals(tempPlayerHolder) && board[i][j+1].getText().equals(tempPlayerHolder) && board[i][j+2].getText().equals(tempPlayerHolder)){
                    Toast.makeText(getActivity(), player, Toast.LENGTH_SHORT).show();
                    pListiner.sendPlayerTurn(color, player);
                    return true;
                }
                //cols
                 if(board[j][i].getText().equals(tempPlayerHolder) && board[j+1][i].getText().equals(tempPlayerHolder) && board[j+2][i].getText().equals(tempPlayerHolder)){
                    Toast.makeText(getActivity(), player, Toast.LENGTH_SHORT).show();
                    pListiner.sendPlayerTurn(color, player);
                    return true;
                }
                 if(i <= 2){
                     //diagonals - Upward diagonal
                     if(board[i][j].getText().equals(tempPlayerHolder) && board[i+1][j+1].getText().equals(tempPlayerHolder) && board[i+2][j+2].getText().equals(tempPlayerHolder)){
                         Toast.makeText(getActivity(), player, Toast.LENGTH_SHORT).show();
                         pListiner.sendPlayerTurn(color, player);
                         return true;
                     }
                     // Downward diagonal
                     if(board[i][4-j].getText().equals(tempPlayerHolder) && board[i+1][3-j].getText().equals(tempPlayerHolder) && board[i+2][2-j].getText().equals(tempPlayerHolder)){
                         Toast.makeText(getActivity(), player, Toast.LENGTH_SHORT).show();
                         pListiner.sendPlayerTurn(color, player);
                         return true;
                     }
                 }

            }
        }
        return false;
    }

}