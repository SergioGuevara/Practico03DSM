package sv.edu.udb.practico03dsm.Activities

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase
import sv.edu.udb.practico03dsm.Adapter.RecursosAdapter
import sv.edu.udb.practico03dsm.Model.ModelRecursos
import android.net.Uri
import android.widget.Button
import sv.edu.udb.practico03dsm.R


class Recursos : AppCompatActivity(){
    private lateinit var mainAdapter: RecursosAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnEdit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val options = FirebaseRecyclerOptions.Builder<ModelRecursos>()
            .setQuery(
                FirebaseDatabase.getInstance().reference.child("recursos").child(""),
                ModelRecursos::class.java
            )
            .build()
        mainAdapter = RecursosAdapter(options)
        recyclerView.adapter = mainAdapter


    }


    override fun onStart() {
        super.onStart()
        mainAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        mainAdapter.stopListening()
    }



}