package com.example.paypalchallenge.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bragonya.daggerdemo.ui.mainlist.MainCountryListPagingAdapter
import com.example.paypalchallenge.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    var adapter = MainCountryListPagingAdapter { country ->
        Toast.makeText(activity, "You tap on ${country.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.updateCountryList().observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                adapter.submitData(it)
            }
        })
    }

    private fun setupRecyclerView(){
        countryListRecycler.adapter = adapter
    }

}