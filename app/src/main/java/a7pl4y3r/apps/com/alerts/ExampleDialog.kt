package a7pl4y3r.apps.com.alerts

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatDialogFragment
import android.widget.EditText

class ExampleDialog : AppCompatDialogFragment() {

    private lateinit var etString: EditText
    private lateinit var listener: ExampleDialogInterface

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        lateinit var dialog: AlertDialog
        val builder = AlertDialog.Builder(activity as Context)
        val inflater = activity!!.layoutInflater
        val view = inflater.inflate(R.layout.alert_layout, null)

        val dialogClickListener = DialogInterface.OnClickListener{_,which ->
            when(which){
                DialogInterface.BUTTON_POSITIVE -> {
                    val str = etString.text.toString()
                    listener.exe(str)
                }
                DialogInterface.BUTTON_NEGATIVE -> {}

            }
        }

        builder.setView(view)
            .setTitle("Dialog")
            .setPositiveButton("ok", dialogClickListener)
            .setNegativeButton("cancel", dialogClickListener)


        etString = view.findViewById(R.id.editText)

        return builder.create()
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        listener = context as ExampleDialogInterface
    }

    interface ExampleDialogInterface{

        fun exe(str: String)

    }

}