package com.example.password_manager_test_final.activities
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.*
import com.example.password_manager_test_final.R
import com.example.password_manager_test_final.adapters.PasswordAdapter
import com.example.password_manager_test_final.models.Password

class PasswordsActivity : AppCompatActivity() {

    companion object {
        lateinit var dbHandler : DBHandler
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passwords)
        viewPasswords()
    }

    //Set all passwords from database in the RecycleView
    private fun viewPasswords(){
        val passwordsList : ArrayList<Password> = dbHandler.getPasswords(this)
        val adapter = PasswordAdapter(this, passwordsList)
        val rv : RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv.adapter = adapter
    }

    override fun onResume() {
        viewPasswords()
        super.onResume()
    }

}
