package com.oder.lesson5.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.oder.lesson5.R
import com.oder.lesson5.viewmodel.MessageViewModel

class ReceiverFragment : Fragment(R.layout.receiver_fragment) {

    companion object {
        private const val MESSAGE_IS_READ = "All messages is read"
    }

    private val viewModel: MessageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.message_view_text)
        viewModel.getMessage().observe(viewLifecycleOwner) { message ->
            textView.text = message
        }
        parentFragmentManager.setFragmentResultListener(
            SenderFragment.MESSAGE_RESULT_KEY,
            this
        ) { key, result ->
            val message = result.getString(key)
            viewModel.setMessage(message)
        }

        view.findViewById<Button>(R.id.read_button).setOnClickListener {
            viewModel.setMessage(MESSAGE_IS_READ)
        }
    }
}