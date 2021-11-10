package com.example.navigationcomponentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

class HomeDest : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_dest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        val button=view?.findViewById<Button>(R.id.navigationToDestination)
        button?.setOnClickListener {
           view.findNavController().navigate(R.id.flowStepOneDest,null,options)
        }

        val button2=view?.findViewById<Button>(R.id.navigationWithAction)
        button2?.setOnClickListener{
                  val action = HomeDestDirections.actionHomeDestToFlowStepOneDest(5)
                  view.findNavController().navigate(action,options)

        }

    }


}

