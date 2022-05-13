package ge.gogichaishvili.rickmorty.presentation.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.drawee.backends.pipeline.Fresco
import ge.gogichaishvili.rickmorty.databinding.ActivityMainBinding
import ge.gogichaishvili.rickmorty.presentation.adapters.RickAndMortyAdapter
import ge.gogichaishvili.rickmorty.presentation.viewmodels.RickAndMortyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<RickAndMortyViewModel>()

    private lateinit var itemsAdapter: RickAndMortyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Fresco.initialize(this)

        setUpRecyclerView()

        viewModel.getRickAndMortyListMutableLiveData().observe(this, Observer {
            itemsAdapter.updateAll(it)
        })

    }

    private fun setUpRecyclerView() {
        itemsAdapter = RickAndMortyAdapter().apply {
            setOnItemCLickListener {
              println(it.name)
            }
        }
        itemsAdapter.setData(mutableListOf())
        binding.rvRickMorty.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvRickMorty.adapter = itemsAdapter
    }

}