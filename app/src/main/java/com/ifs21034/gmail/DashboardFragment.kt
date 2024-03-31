package com.ifs21034.gmail

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21034.gmail.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private val dataMails = ArrayList<Mail>()
    private lateinit var binding: FragmentDashboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding
            .inflate(inflater, container, false)


        binding.rvMails.setHasFixedSize(false)
        dataMails.addAll(getListMails())
        showRecyclerList()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            svFragmentDashboard.setupWithSearchBar(sbFragmentDashboard)
            svFragmentDashboard
                .editText
                .setOnEditorActionListener { textView, actionId, event ->
                    sbFragmentDashboard.setText(svFragmentDashboard.text)
                    svFragmentDashboard.hide()

                    val message =
                        "Kamu mencari dengan keywords:\n${svFragmentDashboard.text}"

                    Toast.makeText(
                        requireContext(),
                        message,
                        Toast.LENGTH_LONG
                    ).show()
                    false

                }
        }

    }

    @SuppressLint("Recycle")
    private fun getListMails(): ArrayList<Mail> {
        val dataName =
            resources.getStringArray(R.array.mail_name)
        val dataIcon =
            resources.obtainTypedArray(R.array.mail_icon)
        val dataTitle =
            resources.getStringArray(R.array.mail_title)
        val dataMessage =
            resources.getStringArray(R.array.mail_message)
        val dataTime =
            resources.getStringArray(R.array.mail_time)

        val listMail = ArrayList<Mail>()
        for (i in dataName.indices) {
            val mail = Mail(dataName[i],
                dataIcon.getResourceId(i, -1), dataTitle[i],
                dataMessage[i], dataTime[i])
            listMail.add(mail)
        }
        return listMail
    }

    private fun showRecyclerList() {
        val context = requireContext()
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvMails.layoutManager =
                GridLayoutManager(context, 2)
        } else {
            binding.rvMails.layoutManager =
                LinearLayoutManager(context)
        }

        val listMailAdapter = ListMailAdapter(dataMails)
        binding.rvMails.adapter = listMailAdapter

    }

}