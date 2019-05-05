package com.example.appmercadofacil

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProdutoAdapter (
    val produto: List<Produto>,
    val onClick: (Produto) -> Unit): RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg : ImageView
        var cardProgress: ProgressBar
        var cardView: CardView

        init {
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardImg = view.findViewById<ImageView>(R.id.cardImg)
            cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
            cardView = view.findViewById<CardView>(R.id.card_produto)

        }

    }


    override fun getItemCount() = this.produto.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_produto, parent, false)

        val holder = ProdutoViewHolder(view)
        return holder
    }


    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val context = holder.itemView.context

        val produto = produto[position]


        holder.cardNome.text = produto.name
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(produto.image).fit().into(holder.cardImg,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })


        holder.itemView.setOnClickListener {onClick(produto)}
    }
}