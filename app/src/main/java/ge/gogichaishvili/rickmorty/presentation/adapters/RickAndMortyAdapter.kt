package ge.gogichaishvili.rickmorty.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.gogichaishvili.rickmorty.R
import ge.gogichaishvili.rickmorty.databinding.LayoutItemBinding
import ge.gogichaishvili.rickmorty.local.data.entities.RickAndMortyModel

class RickAndMortyAdapter() : RecyclerView.Adapter<RickAndMortyAdapter.RickAndMortyViewHolder>() {

    private val itemsList = mutableListOf<RickAndMortyModel>()
    private lateinit var itemClickListener: (RickAndMortyModel) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
        val binding =
            LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RickAndMortyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        holder.bindData(itemsList[position])
    }

    fun setOnItemCLickListener(clickListener: (RickAndMortyModel) -> Unit) {
        itemClickListener = clickListener
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    fun setData(list: List<RickAndMortyModel>) {
        itemsList.clear()
        itemsList.addAll(list)
        notifyDataSetChanged()
    }

    fun updateAll(list: List<RickAndMortyModel>) {
        itemsList.clear()
        itemsList.addAll(list)
        notifyDataSetChanged()
    }

    inner class RickAndMortyViewHolder(private val binding: LayoutItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindData(item: RickAndMortyModel) {

            binding.ivAvatar.setImageURI(item.image)

            binding.tvName.text = item.name

            binding.tvAlive.text =
                "${item.status} - ${item.species}"

            if (item.status == "Alive") {
                binding.vStatus.setBackgroundResource(R.drawable.circle_green)
            } else {
                binding.vStatus.setBackgroundResource(R.drawable.circle_red)
            }

            binding.tvGender.text = item.gender
            if (item.gender == "Male") {
                binding.ivGender.setBackgroundResource(R.drawable.ic_male)
            } else {
                binding.ivGender.setBackgroundResource(R.drawable.ic_female)
            }

            binding.tvLastLocation.text = item.location

            binding.cardMain.setOnClickListener {
                itemClickListener.invoke(item)
            }
        }
    }

}



