package test.practice.android_aaa_kotlin_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import test.practice.R
import test.practice.android_aaa_kotlin_app.model.MoviesData


/**
 * Created by parasmani.sharma on 16/11/2017.
 */
class RecyclerViewAdapter(private val context: Context, private val list: List<MoviesData>/*, private val l: IRecylerHolderClicks*/) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    interface IRecylerHolderClicks {
        fun onClickRecyclerItem(v: View?, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_movies, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txt.setText(list.get(position).title)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public val txt: TextView
        public val img: ImageView

        init {
            txt = itemView.findViewById<View>(R.id.txtName) as TextView
            img = itemView.findViewById<View>(R.id.img) as ImageView
        }
    }

}
