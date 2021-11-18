package com.example.simple_app_project

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_app_project.recycler_view.RecyclerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Information.newInstance] factory method to
 * create an instance of this fragment.
 */
class Information : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var images = mutableListOf<Int>()
    private var titleText = mutableListOf<String>()
    private var contextText = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_information, container, false)

        val informationHandler = Handler(Looper.getMainLooper())
        informationHandler.postDelayed({
            Log.d("Main", "Go back to Main page")
            findNavController().navigate(R.id.action_fragment_Information_to_fragment_Main)
        }, 5000L)

        val fragmentInformationTitle: TextView = view.findViewById(R.id.fragmentInformationTitle)
        fragmentInformationTitle.setOnClickListener {
            Log.d("Main", "Go back to Main Page without Handler Service")
            informationHandler.removeCallbacksAndMessages(null)
            findNavController().navigate(R.id.action_fragment_Information_to_fragment_Main)
        }

        val recyclerViewInformationPage: RecyclerView = view.findViewById(R.id.recyclerViewInformationPage)
        recyclerViewInformationPage.layoutManager = LinearLayoutManager(this.activity)
        recyclerViewInformationPage.adapter = RecyclerAdapter()

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_Information.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Information().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}