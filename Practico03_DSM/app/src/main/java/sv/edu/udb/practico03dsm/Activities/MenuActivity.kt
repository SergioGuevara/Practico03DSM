package sv.edu.udb.practico03dsm.Activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import sv.edu.udb.practico03dsm.MainActivity
import sv.edu.udb.practico03dsm.R
import android.widget.Button
import android.content.Intent

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu) // Asegúrate que este es el nombre correcto del layout

        val btnOpcion1: Button = findViewById(R.id.btnopcion1)
        val btnOpcion2: Button = findViewById(R.id.btnopcion2)
        val btnOpcion3: Button = findViewById(R.id.btnopcion3)

        btnOpcion1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnOpcion2.setOnClickListener {
            val intent = Intent(this, ArticulosActivity::class.java)
            startActivity(intent)
        }

        btnOpcion3.setOnClickListener {
            val intent = Intent(this, RecursosActivity::class.java)
            startActivity(intent)
        }
    }
}