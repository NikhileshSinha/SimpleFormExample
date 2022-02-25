package com.nikhileshsinha.simpleform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nikhileshsinha.simpleform.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }*/

        var fname = arguments?.getString("fname")
        var lname = arguments?.getString("lname")
        var cname = arguments?.getString("cname")
        var isCollege = arguments?.getBoolean("college")
        var isHappy = arguments?.getBoolean("happy")
        var gender = arguments?.getString("gender")

        binding.txtFirst.setText(fname)
        binding.txtLast.setText(lname)
        binding.txtCollege.setText(cname)
        binding.txtClg.setText(if(isCollege == true){"Yes"} else{"false"})
        binding.txtHappy.setText(if(isHappy == true){"Yes"} else{"false"})
        binding.txtGender.setText(gender)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}