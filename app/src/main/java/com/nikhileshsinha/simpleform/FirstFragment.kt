package com.nikhileshsinha.simpleform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.nikhileshsinha.simpleform.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
        binding.btnClear.setOnClickListener {
            //Toast.makeText(activity, "Clear button was pressed", Toast.LENGTH_LONG).show()
            clearForm()
        }

        binding.btnSave.setOnClickListener {
            //Toast.makeText(activity, "Save button was pressed", Toast.LENGTH_LONG).show()
            handelForm()
        }

    }

    private fun clearForm() {
        binding.rdBtnFemale.clearFocus()
        binding.rdBtnMale.clearFocus()

        binding.txt1.setText("");
        binding.txt2.setText("");
        binding.txt3.setText("");

        binding.check1.clearFocus()
        binding.check2.clearFocus()


    }

    private fun handelForm(){
        var gender = when(binding.radioGroup1.checkedRadioButtonId){
            R.id.rdBtnFemale -> "female"
            R.id.rdBtnMale -> "male"
            else -> "not conformed"
        }
        val fname = binding.txt1.text.toString();
        val lname = binding.txt2.text.toString();
        val cname = binding.txt3.text.toString();

        val isCollegeComplete = binding.check1.isChecked
        val isHappy = binding.check2.isChecked

        val bundle = bundleOf(
            "fname" to fname,
            "lname" to lname,
            "gender" to gender,
            "cname" to cname,
            "college" to isCollegeComplete,
            "happy" to isHappy
            )

        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}