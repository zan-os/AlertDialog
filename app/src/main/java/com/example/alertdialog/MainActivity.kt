package com.example.alertdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.alertdialog.databinding.ActivityMainBinding
import com.example.alertdialog.databinding.DialogLayoutBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dialogBinding: DialogLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showDialogButton.setOnClickListener {
            showAlertDialog()
        }

        binding.showDialogActionButton.setOnClickListener {
            showAlertDialogWithAction()
        }

        binding.showCustomDialogButton.setOnClickListener {
            customAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val dialog = AlertDialog.Builder(this)

        dialog.setTitle("Cancelable Dialog")
        dialog.setMessage("Touch to dismiss")
        dialog.setCancelable(true)
        dialog.show()
    }

    private fun showAlertDialogWithAction() {
        val dialog = AlertDialog.Builder(this)

        dialog.setTitle("Dialog with button")
        dialog.setMessage("Dialog with 3 button")
        dialog.setIcon(R.mipmap.ic_launcher)
        dialog.setCancelable(false)

        dialog.setPositiveButton("Positive") { _, _ ->
            Toast.makeText(this, "Positive clicked", Toast.LENGTH_LONG).show()
        }

        dialog.setNegativeButton("Negative") { _, _ ->
            Toast.makeText(this, "Negative clicked", Toast.LENGTH_LONG).show()
        }

        dialog.setNeutralButton("Neutral") { _, _ ->
            Toast.makeText(this, "Neutral clicked", Toast.LENGTH_LONG).show()
        }
        dialog.show()
    }

    private fun customAlertDialog() {
        dialogBinding = DialogLayoutBinding.inflate(layoutInflater)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(dialogBinding.root)
        val dialog = dialogBuilder.create()

        dialogBinding.negativeButton.setOnClickListener {
            Toast.makeText(this, "Negative clicked", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        dialogBinding.positiveButton.setOnClickListener {
            Toast.makeText(this, "Positive clicked", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        dialog.setCancelable(false)
        dialog.show()
    }
}