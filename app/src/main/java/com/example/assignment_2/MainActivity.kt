package com.example.assignment_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var textViewResponse: TextView
    private lateinit var editTextGuess: EditText
    private lateinit var buttonGuess: Button
    private lateinit var editTextAddChemical: EditText
    private lateinit var buttonAddChemical: Button
    private lateinit var imageViewChemical: ImageView
    val mutableList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewResponse = findViewById(R.id.text_view_response)
        editTextGuess = findViewById(R.id.edit_text_guess)
        buttonGuess = findViewById(R.id.button_guess_id)
        editTextAddChemical = findViewById(R.id.edit_text_add_chemical)
        buttonAddChemical = findViewById(R.id.button_add_chemical)

        buttonAddChemical.setOnClickListener {
            if(mutableList.contains(editTextAddChemical.text.toString())){
                textViewResponse.setText("Chemical ${editTextAddChemical.text.toString()}  already exist")
            }else{
                textViewResponse.setText("Chemical ${editTextAddChemical.text.toString()} added successfully!")
                mutableList.add(editTextAddChemical.text.toString());
            }
        }

        buttonGuess.setOnClickListener {
            if(!mutableList.isEmpty()){
                val stringSelected = mutableList.random();
                if(stringSelected.equals(editTextGuess.text.toString())){
                    textViewResponse.setText("Congratulations! You guessed it right, The chemical was ${stringSelected}")
                }else{
                    textViewResponse.setText("Sorry Wrong guess! The correct guess was ${stringSelected}")
                }
            }else{
                textViewResponse.setText("Please save some chemicals before guessing")
            }

        }
    }
}