package com.tare.progress

import android.app.AlertDialog
import android.content.Context
import android.widget.LinearLayout

import android.widget.ProgressBar

class Progress(private val context: Context) {
    companion object{
        private var builder: AlertDialog.Builder? = null
        private var progressDialog: AlertDialog? = null
    }

    fun initProgress(){
        if(progressDialog == null){
            progressDialog = getDialogProgressBar()?.create()
        }
    }

    fun showProgress(){
        progressDialog?.show()
    }

    fun hideProgress(){
        progressDialog?.hide()
    }

    private fun getDialogProgressBar(): AlertDialog.Builder? {
        if (builder == null) {
            builder = AlertDialog.Builder(context)
            builder!!.setTitle("Loading...")
            val progressBar = ProgressBar(context)
            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            progressBar.layoutParams = lp
            builder!!.setView(progressBar)
        }
        return builder
    }
}