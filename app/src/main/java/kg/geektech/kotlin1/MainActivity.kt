package kg.geektech.kotlin1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.kotlin1.databinding.ActivityMainBinding
import java.security.Key


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var resultLauncher: ActivityResultLauncher <Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerForActivity()
        setUpListener()
    }

    private fun setUpListener() {
        binding.buttonFirst.setOnClickListener{
            if (binding.editFirst.text.toString() == "") {
                Toast.makeText(this,"эдит текст не может быть пустым",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MainActivity2 ::class.java).apply {
                    putExtra(KEY,binding.editFirst.text.toString())
                }
                resultLauncher.launch(intent)
            }
        }
    }

    private fun registerForActivity() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK){
                binding.editFirst.setText(result.data?.getStringExtra(KEY))
            }
        }
    }
    companion object {
        const val KEY = "TEXT"
    }
}