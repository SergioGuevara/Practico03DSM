package sv.edu.udb.practico03dsm.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import android.widget.TextView
import sv.edu.udb.practico03dsm.R

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.FirebaseDatabase

import de.hdodenhof.circleimageview.CircleImageView
import sv.edu.udb.practico03dsm.Model.ModelRecursos
import android.content.Intent
import android.net.Uri

import androidx.core.content.ContextCompat.startActivity


class RecursosAdapter(options: FirebaseRecyclerOptions<ModelRecursos>) :
    FirebaseRecyclerAdapter<ModelRecursos, RecursosAdapter.MyViewHolder>(options) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: ModelRecursos) {
        holder.name.text = model.titulo

        holder.email.text = model.descripcion




        holder.btnEdit.setOnClickListener {
            val url = model.enlace // Reemplaza esto con tu URL
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            holder.itemView.context.startActivity(intent)
        }




        Glide.with(holder.img.context)
            .load(model.imagen)
            .placeholder(com.google.firebase.database.collection.R.drawable.common_google_signin_btn_icon_dark)
            .circleCrop()
            .error(com.google.firebase.database.collection.R.drawable.common_google_signin_btn_icon_dark)
            .into(holder.img)



    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        return MyViewHolder(view)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnEdit: Button = itemView.findViewById(R.id.btnEdit)
        val img: CircleImageView = itemView.findViewById(R.id.img1)
        val name: TextView = itemView.findViewById(R.id.nametext)

        val email: TextView = itemView.findViewById(R.id.emailtext)


    }



}
