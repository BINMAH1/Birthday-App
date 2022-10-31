package com.example.sum2nums
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.google.android.material.navigation.NavigationBarView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
        //global variable
        var flag : String = "sum"
        //here .. create a spinner items (options)
        val spinnerVal : Spinner = findViewById(R.id.spSelect)
        var options = arrayOf("Usual","Hijri")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )



        button.setOnClickListener{ view ->
            //code here
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            if(flag =="Usual")
                resultTV.text = ageB(x,y).toString();
            else
                resultTV.text = ageH(x,y).toString();
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}



@SuppressLint("SuspiciousIndentation")
public fun ageB(a: Int, b: Int): Int {
    var year:Int = a;
var month:Int = b;

if(year>2022)
    year =2021; // default value for non-logical values


  var age:Int = 2022 -year;

    if(month > 12)
month = 1;

    if(month < 11)
    age+=1;





return age;
}
public fun ageH(a: Int, b: Int): Int {


    var year:Int = a;
    var month:Int = b;

    if(year>1444)
        year = 1443; // default value for non-logical values


    if(month > 12)
        month = 1;

    var age:Int = 1444 -year;




    if(month < 4)
        age+=1;


    return age;
}
