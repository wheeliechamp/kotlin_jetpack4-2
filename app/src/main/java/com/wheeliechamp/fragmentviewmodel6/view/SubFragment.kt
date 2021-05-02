package com.wheeliechamp.fragmentviewmodel6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wheeliechamp.fragmentviewmodel6.R
import com.wheeliechamp.fragmentviewmodel6.databinding.FragmentSubBinding
import kotlinx.android.synthetic.main.fragment_sub.*
import com.wheeliechamp.fragmentviewmodel6.viewmodel.MainViewModel

class SubFragment : Fragment() {

    companion object {
        fun newInstance() = SubFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentSubBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val msgObserver2 = Observer<String> { newMsg ->
            message2.setText(newMsg, TextView.BufferType.NORMAL)
        }
        viewModel.message2.observe(viewLifecycleOwner, msgObserver2)


        val sdMsgObserver2 = Observer<String> { newMsg ->
            sd_message2.setText(newMsg, TextView.BufferType.NORMAL)
        }
        viewModel.share_data.value!!.share_message
            .observe(viewLifecycleOwner, sdMsgObserver2)

        button2.setOnClickListener {
            viewModel.count()
            viewModel.message2.value = "<< CHANGE by 2nd [${viewModel.count.value}]>>"
            viewModel.share_data.value!!.count()
            viewModel.share_data.value!!.share_message.value =
                "<< CHANGE by 2nd [${viewModel.share_data.value!!.share_count.value}] >>"
        }
    }
}