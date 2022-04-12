package com.oder.lesson5.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.setFragmentResult
import com.oder.lesson5.R

class SenderFragment : Fragment(R.layout.sender_fragment) {

    companion object {
        const val MESSAGE_RESULT_KEY: String = "MESSAGE_RESULT_KEY"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.send_button).setOnClickListener {
            val text = view.findViewById<EditText>(R.id.message_edit_text).text
            val bundle = Bundle()
            bundle.putString(MESSAGE_RESULT_KEY, text.toString())
            setFragmentResult(MESSAGE_RESULT_KEY, bundle)
            replaceFragment()
        }
    }

    private fun replaceFragment() {
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<ReceiverFragment>(R.id.sender_container_view)
            addToBackStack(SenderFragment::javaClass.name)
        }
    }
}