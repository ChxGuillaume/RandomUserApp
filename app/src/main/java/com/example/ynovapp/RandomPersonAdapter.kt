package com.example.ynovapp

import android.content.Intent
import com.example.ynovapp.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ynovapp.model.RandomPerson
import kotlinx.android.synthetic.main.item_note.view.*


class RandomPersonAdapter : RecyclerView.Adapter<RandomPersonAdapter.ViewHolder>() {

    private val randomPersons: MutableList<RandomPerson> = mutableListOf()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.card_view
        val name = cardView.name
        val mail = cardView.mail
        val avatar = cardView.avatar
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {
        val viewItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)

        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val person = randomPersons[position]
        viewHolder.cardView.tag = position
        viewHolder.name.text = person.name.first + ' ' + person.name.last.toUpperCase()
        viewHolder.mail.text = person.email

        viewHolder.itemView.setOnClickListener {
            val intent = Intent(viewHolder.cardView.context, DetailsActivity::class.java)

            intent.putExtra("avatar", person.picture.large)
            intent.putExtra("lastName", person.name.last)
            intent.putExtra("firstName", person.name.first)
            intent.putExtra("email", person.email)

            viewHolder.cardView.context.startActivity(intent)
        }

        Glide.with(viewHolder.avatar.context)
            .load(person.picture.large)
            .into(viewHolder.avatar)
    }

    override fun getItemCount(): Int {
        return randomPersons.size
    }

    fun updateList(product: List<RandomPerson>) {
        randomPersons.clear()
        randomPersons.addAll(product)
        notifyDataSetChanged()
    }


}

