package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.data.MyName
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //initializing the MyName object to be used for data binding
    private val myName: MyName =
        MyName("Alfredo Yap")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //initializing binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //this is binding the myName variable in the layout to the initialized myName object
        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    fun addNickname(view: View) {
        /*
//        val edittext = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
//        nicknameTextView.text = edittext.text
//        edittext.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE

         */
        binding.apply {
            //binding.nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()

            // Invalidate all binding expressions and request a new rebind to refresh
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        //This is for hiding keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
