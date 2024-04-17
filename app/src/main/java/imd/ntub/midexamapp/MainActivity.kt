/*
11056005許智霖
11056013蔡耀德
11056028邱柏翰
*/
package imd.ntub.midexamapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import imd.ntub.midexamapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var food=""
    private var drink=""
    private var ischeckrat=false
    private var ischeckmarry=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
    //setContentView(R.layout.activity_main)
        setContentView(binding.root)


        var launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result->
            var total=0
            binding.txtDS.text=""
            if (result.resultCode== RESULT_OK){
                val data=result.data
                binding.txtFD.text=data?.getStringExtra("food")
                binding.txtDK.text=data?.getStringExtra("drink")
                //主餐
                if (data?.getStringExtra("food")=="花栗鼠佐堅果醬$941210"){
                    total+=941210
                }else if (data?.getStringExtra("food")=="true飯$2500"){
                    total+=2500
                }else if (data?.getStringExtra("food")=="雞腿便當/\$120"){
                    total+=120
                }
                //飲料
                if (data?.getStringExtra("drink")=="澄汁汗$87"){
                    total+=87
                }else if (data?.getStringExtra("drink")=="現榨柳丁特調$78"){
                    total+=78
                }

                //點心
                if (data?.getBooleanExtra("rat",false)==true){
                    binding.txtDS.text="薯條$15"
                    total+=15
                }
                if (data?.getBooleanExtra("marry",false)==true){
                    binding.txtDS.text="嫁虔$520"
                    total+=520
                }
                if ((data?.getBooleanExtra("rat",false)==true)&&(data?.getBooleanExtra("marry",false)==true)){
                    binding.txtDS.text="薯條$15+嫁虔$520"
                }

                binding.txtResult.text= "$"+total.toString().toInt().toString()

            }

        }

        binding.btnDotfood.setOnClickListener{
            val intent=Intent(this,MainActivity2::class.java)
                .apply {
                    putExtra("food",food)
                    putExtra("drink",drink)
                    putExtra("rat",ischeckrat)
                    putExtra("marry",ischeckmarry)
                }
            launcher.launch(intent)
        }
    }
}