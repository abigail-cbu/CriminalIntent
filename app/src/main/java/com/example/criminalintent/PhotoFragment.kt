package com.example.criminalintent

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment

private const val ARG_PHOTO = "photo"
private const val TAG = "PhotoFragment"

class PhotoFragment : DialogFragment() {

    private lateinit var photoView: ImageView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(R.layout.fragment_photo_view, container, false)

        photoView = view.findViewById(R.id.crime_photo) as ImageView

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated")

        val bitmap = arguments?.getParcelable(ARG_PHOTO) as Bitmap?
        if (bitmap != null) {
            Log.d(TAG, "has bitmap" )
        }

        photoView.setImageBitmap(bitmap)
    }

    companion object {
        fun newInstance(bitmap: Bitmap): DialogFragment {
            Log.d(TAG, "newInstance made")

            val args = Bundle().apply {
                 putParcelable(ARG_PHOTO, bitmap)
            }
            return DialogFragment().apply {
                arguments = args
            }
        }
    }
}