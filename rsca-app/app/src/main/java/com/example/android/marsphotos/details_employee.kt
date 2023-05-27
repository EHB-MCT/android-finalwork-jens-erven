package com.example.android.marsphotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import com.bumptech.glide.Glide

class details_employee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_employee)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        val employeeNameTextView = findViewById<TextView>(R.id.employee_name_textview)
        val employeeCategoryTextView = findViewById<TextView>(R.id.employee_category_textview)
        val employeeBirthdateTextView = findViewById<TextView>(R.id.employee_birthdate_textview)
        val employeeNationalityTextView = findViewById<TextView>(R.id.employee_nationality_textview)
        val employeeStartdateTextView = findViewById<TextView>(R.id.employee_startdate_textview)
        val employeeShirtnumberTextView = findViewById<TextView>(R.id.employee_shirtnumber_textview)



        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("image")
        val birth_date = intent.getStringExtra("birth_date")
        val nationality = intent.getStringExtra("nationality")
        val start_date = intent.getStringExtra("start_date")
        val category = intent.getStringExtra("category")
        val shirthumber = intent.getStringExtra("shirt_number")


        employeeNameTextView.text = "$name"
        employeeCategoryTextView.text = "$category"
        employeeBirthdateTextView.text = "$birth_date"
        employeeNationalityTextView.text = "$nationality"
        employeeStartdateTextView.text = "$start_date"


        if (shirthumber != null){
            employeeShirtnumberTextView.text= "$shirthumber"
        }else{
            employeeShirtnumberTextView.visibility = View.INVISIBLE
        }



        Glide.with(this)
            .load(image)
            .into(findViewById(R.id.employee_image))
    }

}