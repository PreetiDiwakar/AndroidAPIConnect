package com.wipro.testapp.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wipro.testapp.R
import com.wipro.testapp.adapter.FactsAdapter
import com.wipro.testapp.model.ResultsItem
import com.wipro.testapp.viewmodel.GetAllFactsViewModel

class FactsActivity : AppCompatActivity() {

    private var factsRecyclerView : RecyclerView? = null
    private var factsLayoutManager : LinearLayoutManager? = null
    private lateinit var factList : List<ResultsItem>
    private lateinit var viewModel : GetAllFactsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facts)
        initUi()
    }

    private fun initUi() {

        viewModel = ViewModelProvider(this).get(GetAllFactsViewModel::class.java)
        viewModel.initialize(application)
        viewModel.getAllFacts()

        val toolbarTitle = findViewById<TextView>(R.id.title_tv)

        factsLayoutManager  = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        factsRecyclerView = findViewById<RecyclerView>(R.id.factsRecyclerView)
        factsRecyclerView!!.layoutManager = factsLayoutManager
        viewModel.getFacts.observe(this, Observer {
            toolbarTitle.text = viewModel.title
            factList = it!!
            if (factList.isNotEmpty()){
                factsRecyclerView!!.adapter = FactsAdapter(this@FactsActivity,factList)
            }
        });

    }



}