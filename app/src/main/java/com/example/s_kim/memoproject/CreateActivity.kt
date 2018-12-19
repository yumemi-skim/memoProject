package com.example.s_kim.memoproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        findViewById<Button>(R.id.save).setOnClickListener {
            val title = createTitle.editableText.toString()
            val message = createMessage.editableText.toString()

            if (title.isBlank() || message.isBlank()) {
                Toast.makeText(this, "Write your Text", Toast.LENGTH_SHORT).show()
                return@setOnClickListener  //
            }

            var titleSwitch = true
            findViewById<EditText>(R.id.createTitle).setOnClickListener {
                if (titleSwitch) {
                    it.hideKeyboard()
                    titleSwitch = false
                } else {
                    it.showKeyboard(it)
                    titleSwitch = true
                }
            }

            var messageSwitch = true
            findViewById<EditText>(R.id.createMessage).setOnClickListener {
                if (messageSwitch) {
                    it.hideKeyboard()
                    messageSwitch = false
                } else {
                    it.showKeyboard(it)
                    messageSwitch = true
                }
            }

            val creatIntent = Intent()  //인텐트 앞에 이동해 왔기 때문에 굳이 안에 안적어도 된다.
            creatIntent.putExtra("title", title)
            creatIntent.putExtra("message", message)
            setResult(Activity.RESULT_OK, creatIntent)
            finish()
        }


    }


    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    private fun View.showKeyboard(view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, 0)
    }


}