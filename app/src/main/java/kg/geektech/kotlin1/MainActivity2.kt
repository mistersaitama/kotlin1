package kg.geektech.kotlin1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.geektech.kotlin1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
    }

    private fun setupListener() {
        binding.editSecond.setText(intent.getStringExtra(MainActivity.KEY))

        binding.buttonSecond.setOnClickListener {
            if (binding.editSecond.text.toString() == "") {
                Toast.makeText(this,"эдит текст не может быть пустым", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent (this, MainActivity::class.java).apply {
                    putExtra(MainActivity.KEY,binding.editSecond.text.toString())
                }

                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        }
    }
}