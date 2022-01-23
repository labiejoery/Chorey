package com.example.chorey.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chorey.data.Taak
import com.example.chorey.databinding.HomeItemBinding
import com.squareup.picasso.Picasso

class HomeAdapter(val clickListener: TaakClickListener, val viewModel: HomeViewModel) : RecyclerView.Adapter<HomeAdapter.CustomViewHolder>() {

    var taken = listOf<Taak>(
        Taak(1, "Titel eerste taak!", "Dit is de eerste taak zijn descriptie", 9, "https://hooopgallerydev.blob.core.windows.net/images/10/224e41ba-bb12-4a62-b9ec-e7a1120a1543.image/jpeg"),
        Taak(2, "Titel tweede taak", "Description van de tweede taak", 20, "https://hooopgallerydev.blob.core.windows.net/images/9/0777b1d2-85db-4a56-a29a-aa3721814b3a.png"),
        Taak(1, "Titel eerste taak!", "Dit is de eerste taak zijn descriptie", 9, "https://hooopgallerydev.blob.core.windows.net/images/10/224e41ba-bb12-4a62-b9ec-e7a1120a1543.image/jpeg"),
        Taak(2, "Titel tweede taak", "Description van de tweede taak", 20, "https://hooopgallerydev.blob.core.windows.net/images/9/0777b1d2-85db-4a56-a29a-aa3721814b3a.png"),
        Taak(1, "Titel eerste taak!", "Dit is de eerste taak zijn descriptie", 9, "https://hooopgallerydev.blob.core.windows.net/images/10/224e41ba-bb12-4a62-b9ec-e7a1120a1543.image/jpeg"),
        Taak(2, "Titel tweede taak", "Description van de tweede taak", 20, "https://hooopgallerydev.blob.core.windows.net/images/9/0777b1d2-85db-4a56-a29a-aa3721814b3a.png")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = taken[position]

            holder.bind(clickListener, item)
    }

    override fun getItemCount(): Int {
        return taken.size
    }


    class CustomViewHolder(val binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: TaakClickListener, item: Taak){

            binding.TaakCoinAmount.text = item.rewardAmount.toString()
            binding.TaakDescription.setText(item.description)
            binding.TaakTitle.text = item.title

            binding.clickListener = clickListener

            Picasso.get().load(item.displayImageString).into(binding.TaakImage)
        }
        companion object {
            fun from(parent: ViewGroup): CustomViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = HomeItemBinding.inflate(layoutInflater, parent, false)
                return CustomViewHolder(binding)
            }
        }
    }

    class TaakClickListener(val clickListener: (taakId:Int) -> Unit){
        fun onClick(taak: Taak) = clickListener(taak.id)
    }
}