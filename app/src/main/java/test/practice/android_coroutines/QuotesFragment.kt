package test.practice.android_coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import test.practice.android_coroutines.ui.QuoteViewModel
import test.practice.android_coroutines.ui.QuotesAdapter
import test.practice.databinding.FragmentQuotesBinding


class QuotesFragment : Fragment() {


    private val quotesAdapter by lazy { QuotesAdapter() }
    private lateinit var binding: FragmentQuotesBinding
    private lateinit var viewModel: QuoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerviewQuotes.adapter = quotesAdapter

        viewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)

        viewModel.quotes.observe(viewLifecycleOwner, Observer {
            quotesAdapter.quotes = it
        })
    }

}
