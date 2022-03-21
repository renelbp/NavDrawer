package com.example.navdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.navdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this,binding.drawerLayout, R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId){
                R.id.nav_home -> {
                    Toast.makeText(applicationContext,"Home",Toast.LENGTH_SHORT).show()
                    replaceFragment(HomeFragment(),it.title.toString())
                }
                R.id.nav_messege -> {
                    Toast.makeText(applicationContext,"Messege",Toast.LENGTH_SHORT).show()
                    replaceFragment(MessegeFragment(),it.title.toString())
                }
                R.id.nav_sync -> Toast.makeText(applicationContext,"Sync",Toast.LENGTH_SHORT).show()
                R.id.nav_trash -> Toast.makeText(applicationContext,"Trash",Toast.LENGTH_SHORT).show()
                R.id.nav_settings -> {
                    Toast.makeText(applicationContext,"Settings",Toast.LENGTH_SHORT).show()
                    replaceFragment(SettingsFragment(),it.title.toString())
                }
                R.id.nav_login -> Toast.makeText(applicationContext,"Login",Toast.LENGTH_SHORT).show()
                R.id.nav_share -> Toast.makeText(applicationContext,"Share",Toast.LENGTH_SHORT).show()
                R.id.nav_contact -> Toast.makeText(applicationContext,"Contact",Toast.LENGTH_SHORT).show()
            }
            true

        }
    }

    private fun replaceFragment(fragment:Fragment, title: String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        binding.drawerLayout.closeDrawers()
        setTitle(title)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}