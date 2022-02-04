package test.practice.android_spannable

import android.os.Bundle
import android.text.SpannableString
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.spannable_test.*
import test.practice.R

class NewLineSpannable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spannable_test)

        textSticky.text = getCenterSpannableText(this)
    }


    private fun getCenterSpannableText(newLineSpannable: NewLineSpannable): SpannableString {
        val currency = "Currency"
        val total = "Total"
        val delimiter = "\n"
        val finalStr = "$currency$delimiter$total"

        val currencyIndex = finalStr.indexOf(currency)
        val totalIndex = finalStr.indexOf(total)

        val s = SpannableString(finalStr)
        //s.setSpan(RelativeSizeSpan(1.4f), currencyIndex, currency.length, 0)
        //s.setSpan(ForegroundColorSpan(ContextCompat.getColor(newLineSpannable, R.color.colorAccent)), currencyIndex, currency.length, 0)

        //s.setSpan(RelativeSizeSpan(1.8f), totalIndex, totalIndex + total.length, 0)
        //s.setSpan(ForegroundColorSpan(ContextCompat.getColor(newLineSpannable, R.color.colorAccent)), totalIndex, totalIndex + total.length, 0)

        //s.setSpan(RelativeSizeSpan(5f), subtitleIndex, subtitleIndex + subtitle.length, 0)
        //s.setSpan(ForegroundColorSpan(ContextCompat.getColor(newLineSpannable, R.color.colorAccent)), subtitleIndex, subtitleIndex + subtitle.length, 0)

        //make the \n have bigger fonts
        //s.setSpan(RelativeSizeSpan(2.5f), currencyIndex + currency.length, currencyIndex + currency.length + delimiter.length, 0)
        //s.setSpan(RelativeSizeSpan(2.5f), totalIndex + total.length, totalIndex + total.length + delimiter.length, 0)

        return s
    }
}

