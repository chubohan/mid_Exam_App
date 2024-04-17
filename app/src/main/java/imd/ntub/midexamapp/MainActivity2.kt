package imd.ntub.midexamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import imd.ntub.midexamapp.databinding.ActivityMain2Binding
import imd.ntub.midexamapp.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main2)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener {
            val food= when (binding.radioGroup.checkedRadioButtonId) {
                binding.rdbNuts.id -> {"花栗鼠佐堅果醬$941210"}
                binding.rdbTrue.id -> {"true飯$2500"}
                binding.rdbChicken.id -> {"雞腿便當/\$120"}
                else->{"你沒点"}
            }
            val drink= when (binding.radioGroup2.checkedRadioButtonId) {
                binding.rdbOrange.id -> {"澄汁汗$87"}
                binding.rdbDinter.id -> {"現榨柳丁特調$78"}
                else->{"你沒点"}
            }
            val rat=binding.ckbRat.isChecked
            val marry=binding.chkmarry.isChecked
            intent.putExtra("food",food)
            intent.putExtra("drink",drink)
            intent.putExtra("rat",rat)
            intent.putExtra("marry",marry)
            setResult(RESULT_OK,intent)

            AlertDialog.Builder(this)
                .setTitle("你要確認ㄟ")
                .setMessage("就點這樣?")
                .setNegativeButton("否"){dialog,which->

                }.setPositiveButton("是"){
                    dialog,which->
                    finish()
                }.show()


        }


    }
}