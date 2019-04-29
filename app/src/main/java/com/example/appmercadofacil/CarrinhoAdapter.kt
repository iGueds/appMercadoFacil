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

class CarrinhoAdapter (
    val carrinho: List<Carrinho>,
    val onClick: (Carrinho) -> Unit): RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder>() {

    class CarrinhoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg : ImageView
        var cardProgress: ProgressBar
        var cardView: CardView

        init {
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardImg = view.findViewById<ImageView>(R.id.cardImg)
            cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
            cardView = view.findViewById<CardView>(R.id.card_carrinho)

        }

    }


    override fun getItemCount() = this.carrinho.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrinhoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_carrinho, parent, false)

        val holder = CarrinhoViewHolder(view)
        return holder
    }


    override fun onBindViewHolder(holder: CarrinhoViewHolder, position: Int) {
        val context = holder.itemView.context

        val carrinho = carrinho[position]


        holder.cardNome.text = carrinho.produto
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(carrinho.imagem).fit().into(holder.cardImg,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })


        // adiciona evento de clique
        holder.itemView.setOnClickListener {onClick(carrinho)}
    }
}