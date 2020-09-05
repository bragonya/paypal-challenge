package com.bragonya.daggerdemo.ui.mainlist

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paypalchallenge.R
import com.example.paypalchallenge.extension.inflate
import com.example.paypalchallenge.model.Country
import com.example.paypalchallenge.ui.main.CountryClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.country_holder.view.*

class MainCountryListPagingAdapter(
    private val click: CountryClickListener
) : PagingDataAdapter<Country, MainCountryListPagingAdapter.PokeListHolder>(POKEMON_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeListHolder {
        return PokeListHolder(
            parent.context.inflate(R.layout.country_holder, parent, false),
            click
        )
    }

    override fun onBindViewHolder(holder: PokeListHolder, position: Int) {
        val pokemon = getItem(position)
        if (pokemon != null)
            holder.bind(pokemon)
    }

    class PokeListHolder(
        private val view: View,
        private val click: CountryClickListener
    ) : RecyclerView.ViewHolder(view) {
        fun bind(country: Country) = view.apply {
            setOnClickListener { click.onClick(country) }
            countryName.text = country.name
            Picasso.with(view.context).load(country.image)
                .placeholder(view.context.getDrawable(R.drawable.earthl_animation))
                .into(countryImage)
        }
    }

    companion object {
        private val POKEMON_COMPARATOR = object : DiffUtil.ItemCallback<Country>() {
            override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean =
                oldItem.code == newItem.code

            override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean =
                oldItem == newItem
        }
    }
}