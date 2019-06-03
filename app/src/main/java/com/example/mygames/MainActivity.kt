package com.example.mygames

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1
    private lateinit var partidosModel: PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerv)
        val adapter = AdapterPartidos(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)



        partidosModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        partidosModel.allPartidos.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.setPartidos(it) }
        })


        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            println("sending data ")
            val intent = Intent(this@MainActivity, AddPartidoActiviity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        if (requestCode == newWordActivityRequestCode && requestCode == Activity.RESULT_OK) {
            intent?.let { data ->
                println("making somwthing with the data")


                val partido =  intent.extras.getParcelable(AddPartidoActiviity.EXTRA_REPLY) as Partido
                partidosModel.insert(partido)

            }
        }
    }
}
