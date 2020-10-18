package com.example.madlevel4task2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.madlevel4task2.databinding.FragmentMatchBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: FragmentMatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
    }

    private fun updateUI() {
//        binding.setImageResource(R.drawable.dice1)
//        binding.imgDice.setImageResource(R.drawable.dice2)
    }

    private fun initViews() {
        updateUI()
//        binding.btnHigher.setOnClickListener {
//            onHigherClick()
//        }
//        binding.btnLower.setOnClickListener {
//            onLowerClick()
//        }
//        binding.btnEquals.setOnClickListener {
//            onEqualClick()
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_match_history -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}