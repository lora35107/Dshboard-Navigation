package com.example.lorasqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var Name :EditText
    private lateinit var Email :EditText
    private lateinit var Id :EditText
    private lateinit var ViewButton :EditText
    private lateinit var SaveButton :EditText
    private lateinit var DeleteButton :EditText
    private lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        Name= findViewById(R.id.edt_name)
        Email =  findViewById(R.id.edt_email)
        Id = findViewById(R.id.edt_id)
        ViewButton =  findViewById(R.id.btn_view)
        SaveButton = findViewById(R.id.btn_save)
        DeleteButton = findViewById(R.id.btn_delete)

        //Creating our database
        db =openOrCreateDatabase("LoraDB",Context.MODE_PRIVATE,null)

        //Creating our table
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")


        SaveButton.setOnClickListener {
            var jina_edt = Name.text.toString().trim()
            var arafa_edt = Email.text.toString().trim()
            var kitambulisho_edt = Id.text.toString().trim()

         //Validate your edit texts
        if (jina_edt.isEmpty()||arafa_edt.isEmpty()||kitambulisho_edt.isEmpty())
            Toast.makeText(this, "Cannot submit an empty form", Toast.LENGTH_SHORT).show()
            else{
                //Insert data
                db.execSQL("INSERT INTO users VALUES('\"+jina_edt+\"' , '\"+arafa_edt+\"' , '\"+kitambulisho_edt+\"')")
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
            }
        }


















        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}