package com.crafttalk.sampleChat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.crafttalk.chat.presentation.ChatPermissionListener
import com.crafttalk.chat.utils.R_PERMISSIONS
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment: Fragment(R.layout.fragment_chat) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chat_view.onCreate(this)
        chat_view.setOnPermissionListener(object : ChatPermissionListener {
            override fun requestedPermissions(permissions: Array<R_PERMISSIONS>, messages: Array<String>) {
                permissions.forEachIndexed { index, permission ->
                    showWarning(messages[index])
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        chat_view.onResume(this)
    }

    private fun showWarning(warningText: String) {
        Snackbar.make(chat_view, warningText, Snackbar.LENGTH_LONG).show()
    }

}