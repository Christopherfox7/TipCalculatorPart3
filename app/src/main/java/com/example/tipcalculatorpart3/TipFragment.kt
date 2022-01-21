package com.example.tipcalculatorpart3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.tipcalculatorpart3.databinding.FragmentTipFragmentBinding


class TipFragmentFragment : Fragment() {
    var subtotal = 0
    var numOfGuest = 0
    var tipPercent = 0
    var finalTotal = 0

    private var _binding: FragmentTipFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTipFragmentBinding.inflate(inflater, container,false)
        val rootView = binding.root

        subtotal =100


        setUpRadioButtons()
        setUpTipSeekBar()
        setUpNumOfGuestsSpinner()


        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setUpRadioButtons(){
        val list1: List<View> = listOf(binding.buttonOne,binding.buttonTwo,binding.buttonThree,binding.buttonFour)
        for (eachButton in list1){
            eachButton.setOnClickListener{ view ->
                when(view.id){
                    R.id.button_one -> tipPercent = 10
                    R.id.button_two -> tipPercent = 15
                    R.id.button_three -> tipPercent = 18
                    R.id.button_four -> tipPercent = 25
                }
                binding.seek.progress= tipPercent
                setTipAndTotalTextViews()
            }
        }

    }

    fun setUpTipSeekBar(){
        binding.seek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                tipPercent= binding.seek.progress
                setTipAndTotalTextViews()
                setRadioButtonAsChecked()

            }
        })
    }
    fun setUpNumOfGuestsSpinner(){

        val guestArrayAdapter = ArrayAdapter.createFromResource(requireActivity(), R.array.guest_number, android.R.layout.simple_spinner_item)
        guestArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.guestSpinner.adapter = guestArrayAdapter
        binding.guestSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                numOfGuest = position+1
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }
    fun setRadioButtonAsChecked(){

        binding.radGroup.clearCheck()
        if(tipPercent == 10){
            binding.buttonOne.isChecked=true
        }
        if(tipPercent == 15){
            binding.buttonTwo.isChecked=true
        }
        if(tipPercent == 18){
            binding.buttonThree.isChecked=true
        }
        if(tipPercent == 25){
            binding.buttonFour.isChecked=true
        }
    }
    fun setTipAndTotalTextViews(){

        binding.tip.text= "${tipPercent}%"

        finalTotal =subtotal.times(tipPercent).div(100).plus(100)
        binding.total.text = "$${finalTotal}"
    }


}