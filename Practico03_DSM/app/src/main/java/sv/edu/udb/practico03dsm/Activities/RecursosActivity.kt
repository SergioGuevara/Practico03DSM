package sv.edu.udb.practico03dsm.Activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import sv.edu.udb.practico03dsm.Adapter.RecursosAdapter
import sv.edu.udb.practico03dsm.Model.ModelRecursos
import sv.edu.udb.practico03dsm.R

class RecursosActivity : AppCompatActivity() {
    private lateinit var mainAdapter: RecursosAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnEdit: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recursos)
        val btnOpcion1: Button = findViewById(R.id.menuregresar)


        btnOpcion1.setOnClickListener{

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)

        }
        recyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val options = FirebaseRecyclerOptions.Builder<ModelRecursos>()
            .setQuery(
                FirebaseDatabase.getInstance().reference.child("recursos").child("tutoriales"),
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