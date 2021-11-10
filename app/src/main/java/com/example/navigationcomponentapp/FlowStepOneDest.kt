package com.example.navigationcomponentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions

class FlowStepOneDest : Fragment() {

    val args : FlowStepOneDestArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flow_step_one_dest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textViewStepOne).setText(args.flowNumber.toString())

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }



        val button=view?.findViewById<Button>(R.id.flowStepOneButton)
        button?.setOnClickListener {
            view.findNavController().navigate(R.id.flowStepTwoDest,null,options)
        }


/*        view.findViewById<Button>(R.id.flowStepOneButton).setOnClickListener {
            val flowStepOneDestArgs=1
            val action = FlowStepOneDestDirections.nextAction()
            findNavController().navigate(action)
            view.findNavController().navigate(R.id.flowStepTwoDest,null)
        }*/
        }

}

