package test.practice.android_aarchitecture.a_observable.observer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_view_observable.*
import test.practice.R
import test.practice.android_aarchitecture.a_observable.action.SubjectDataAction
import test.practice.android_aarchitecture.a_observable.datarepo.DataRepository
import test.practice.android_aarchitecture.a_observable.observable.FakeObservable

class FragmentView : AppCompatActivity(), RepositoryObserver
{
    private lateinit var dataRepository : SubjectDataAction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_view_observable)

        //init repositroy
        dataRepository = DataRepository("Myrepo", 1).getInstance()
        //register observers
        //ObserverOne(dataRepository)
        dataRepository.registerObserver(this)

        //start observable and update data
        FakeObservable(dataRepository = dataRepository as DataRepository).start()
    }

    override fun setDataChange(data: String) {
        // do ui changes
        runOnUiThread(Runnable {
            textView.text = data
        })
    }

}