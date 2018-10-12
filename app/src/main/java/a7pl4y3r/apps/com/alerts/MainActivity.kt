package a7pl4y3r.apps.com.alerts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ExampleDialog.ExampleDialogInterface {
    override fun exe(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    private fun openDialog(){

        val exampleDialog = ExampleDialog()
        exampleDialog.show(supportFragmentManager, "Tic")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { openDialog() }

    }
}
