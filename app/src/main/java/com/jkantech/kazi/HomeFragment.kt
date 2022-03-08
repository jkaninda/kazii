package com.jkantech.kazi

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.jkantech.kazi.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private var qtyA=2
    private var f=0
    private var bSub=32
    private var qtyC=4
    private var qtyD=1
    private var qtyE=1
    private lateinit var viewModel: ViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel=ViewModelProvider(this).get(ViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.editQtyLiveData.observe(viewLifecycleOwner){

        }
        viewModel.fLiveData.observe(viewLifecycleOwner){
            f=it
            if (it!=null){
                val sub=it-bSub
                val dWDsub=it-qtyC
                binding.editBw.setText("$sub")
                binding.editCh.setText("$sub")
                binding.editDw.setText("$dWDsub")
                binding.editEw.setText("$it")
            }


        }
        binding.editF.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (s.isNotBlank()){
                    viewModel.fLiveData.value = s.toString().toInt()

                }

            }
        })
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      binding.button.setOnClickListener {
          when{
              binding.editQty.text.toString()==""-> showToast(requireContext(),"Please enter Quantity")

              binding.editF.text.toString()==""-> showToast(requireContext(),"Please enter F value")
              binding.editH.text.toString()==""-> showToast(requireContext(),"Please enter H value")
              binding.editW.text.toString()==""-> showToast(requireContext(),"Please enter W value")

              binding.editBh.text.toString()==""-> showToast(requireContext(),"Please enter BH value")

              binding.editCh.text.toString()==""-> showToast(requireContext(),"Please enter CH value")
              binding.editCw.text.toString()==""-> showToast(requireContext(),"Please enter CW value")
              binding.editDh.text.toString()==""-> showToast(requireContext(),"Please enter DH value")
              binding.editDw.text.toString()==""-> showToast(requireContext(),"Please enter DW value")

              binding.editEh.text.toString()==""-> showToast(requireContext(),"Please enter EH value")
              binding.editEw.text.toString()==""-> showToast(requireContext(),"Please enter EW value")
              else->process()


          }


      }


    }

    private fun process() {
        calculateH()
        calculateB()
        calculateC()
        calculateD()
        calculateE()

    }

    @SuppressLint("SetTextI18n")
    private fun calculateH(){
        binding.resultH.text="Result H : "+qtyA*binding.editQty.text.toString().toInt()+"X"+binding.editH.text.toString()+"X"+binding.editW.text.toString()
    }
    private fun calculateB(){
        val bw=f - 32
        binding.resultB.text="Result B : "+qtyA*binding.editQty.text.toString().toInt()+"X"+binding.editBh.text.toString()+"X"+bw
    }
    private fun calculateC(){
        binding.resultC.text="Result C : "+qtyC*binding.editQty.text.toString().toInt()+"X"+binding.editCh.text.toString()+"X"+binding.editCw.text.toString()
    }
    private fun calculateD(){
        binding.resultD.text="Result D : "+qtyD*binding.editQty.text.toString().toInt()+"X"+binding.editDh.text.toString()+"X"+binding.editDw.text.toString()
    }
    private fun calculateE(){
        binding.resultE.text="Result E : "+qtyE*binding.editQty.text.toString().toInt()+"X"+binding.editEh.text.toString()+"X"+binding.editEw.text.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}