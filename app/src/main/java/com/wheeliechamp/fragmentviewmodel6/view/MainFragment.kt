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
import com.wheeliechamp.fragmentviewmodel6.databinding.MainFragmentBinding
import com.wheeliechamp.fragmentviewmodel6.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val msgObserver = Observer<String> { newMsg ->
            message.setText(newMsg, TextView.BufferType.NORMAL)
        }
        viewModel.message.observe(viewLifecycleOwner, msgObserver)

        val sdMsgObserver = Observer<String> { newMsg ->
            sd_message.setText(newMsg, TextView.BufferType.NORMAL)
        }
        viewModel.share_data.value!!.share_message
            .observe(viewLifecycleOwner, sdMsgObserver)

        button1.setOnClickListener {
            viewModel.count()
            viewModel.message.value = "<< CHANGE by 1st [${viewModel.count.value}]>>"
            viewModel.share_data.value!!.count()
            viewModel.share_data.value!!.share_message.value =
                "<< CHANGE by 1st [${viewModel.share_data.value!!.share_count.value}] >>"
        }
    }
}
